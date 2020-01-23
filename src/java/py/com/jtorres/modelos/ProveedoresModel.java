package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.Proveedores;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class ProveedoresModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    public List<Proveedores> listProveedores(){
        Query query = em.createNamedQuery("Proveedores.findAll");
        return query.getResultList();
    }
}
