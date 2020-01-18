
package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.Personas;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class PersonasModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public List<Personas> listPersonas(){
        Query query = em.createNamedQuery("Personas.findAll");
        return query.getResultList();
    }
    public int insertarPersona(Personas persona) {
        try {
            em.persist(persona);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    public int modificarPersona(Personas persona) {
        try {
            em.merge(persona);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    public Personas obtenerPersona(String codigo){
        return em.find(Personas.class,Integer.parseInt(codigo));
    }
    public int eliminarPersona(String codigo) {
        try {
            Personas persona = em.find(Personas.class, Integer.parseInt(codigo));
            if (persona != null) {
                em.remove(persona);
                em.flush();
                return 1;
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }
}
