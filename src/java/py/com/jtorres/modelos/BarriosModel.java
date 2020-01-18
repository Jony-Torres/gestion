
package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.Barrios;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class BarriosModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Barrios> listarBarrios(){
        Query query = em.createNamedQuery("Barrios.findAll");
        return query.getResultList();
    }
    public Barrios obtenerBarrio(String codigo){
        return em.find(Barrios.class, Integer.parseInt(codigo));
    }
}
