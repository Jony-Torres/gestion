
package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.ComprobDetPrb;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class CompDetModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    public int insertarCompDet(ComprobDetPrb comp) {
        try {
            em.persist(comp);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    /*public List<ComprobDetPrb> listCompDet() {
        Query query = null;
        try {
            query = em.createNamedQuery("ComprobDetPrb.findByIdentificador");
            query.setParameter("identificador", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return query.getResultList();
    }*/
}
