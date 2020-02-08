
package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.Sucursales;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class SucursalesModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    public List<Sucursales> listSucursales(){
        Query query = em.createNamedQuery("Sucursales.findAll");
        return query.getResultList();
    }
}
