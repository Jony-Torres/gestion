package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.Articulos;
import py.com.jtorres.entidades.Clientes;

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
    public Articulos obtenerArticulo(String codigo){
        return em.find(Articulos.class,Integer.parseInt(codigo));
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
    public int modificarArticulo(Articulos articulo) {
        try {
            em.merge(articulo);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    public int eliminarArticulo(String codigo) {
        try {
            Articulos articulo = em.find(Articulos.class, Integer.parseInt(codigo));
            if (articulo != null) {
                em.remove(articulo);
                em.flush();
                return 1;
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }
}
