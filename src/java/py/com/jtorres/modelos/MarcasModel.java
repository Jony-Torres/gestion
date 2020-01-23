
package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.Marcas;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class MarcasModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Marcas> listMarcas(){
        Query query = em.createNamedQuery("Marcas.findAll");
        return query.getResultList();
    }
}
