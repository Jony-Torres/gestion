
package py.com.jtorres.modelos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.Ciudades;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class CiudadesModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public List<Ciudades> listCiudades() {
        Query query = em.createNamedQuery("Ciudades.findAll");
        return query.getResultList();
    }
    public int insertarCiudad(Ciudades ciudad) {
        try {
            em.persist(ciudad);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    public int modificarCiudad(Ciudades ciudad) {
        try {
            em.merge(ciudad);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    public Ciudades obtenerCiudad(String codigo){
        return em.find(Ciudades.class,Integer.parseInt(codigo));
    }
    public int eliminarCiudad(String codigo) {
        try {
            Ciudades ciudad = em.find(Ciudades.class, Integer.parseInt(codigo));
            if (ciudad != null) {
                em.remove(ciudad);
                em.flush();
                return 1;
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }
}
