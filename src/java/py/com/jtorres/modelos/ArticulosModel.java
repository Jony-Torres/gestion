package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.Articulos;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class ArticulosModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Articulos> listArticulos(){
        Query query = em.createNamedQuery("Articulos.findAll");
        return query.getResultList();
    }
    public int insertarArticulo(Articulos articulo) {
        try {
            em.persist(articulo);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
