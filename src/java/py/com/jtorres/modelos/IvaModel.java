
package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.Iva;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class IvaModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Iva> listIva(){
        Query query = em.createNamedQuery("Iva.findAll");
        return query.getResultList();
    }
}
