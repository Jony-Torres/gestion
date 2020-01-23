
package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.Categorias;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class CategoriasModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Categorias> listCategorias(){
        Query query = em.createNamedQuery("Categorias.findAll");
        return query.getResultList();
    }
}
