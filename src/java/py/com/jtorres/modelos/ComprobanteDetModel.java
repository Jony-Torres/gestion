
package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.ComprobantesDetalle;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class ComprobanteDetModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    public List<ComprobantesDetalle> listComprob(){
        Query query = em.createNamedQuery("ComprobantesDetalle.findAll");
        return query.getResultList();
    }
    
}
