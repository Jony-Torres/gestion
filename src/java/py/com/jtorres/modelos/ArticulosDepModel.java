
package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.ArticulosDeposito;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class ArticulosDepModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    public List<ArticulosDeposito> listDepositos(){
        Query query = em.createNamedQuery("ArticulosDeposito.findAll");
        return query.getResultList();
    }
}
