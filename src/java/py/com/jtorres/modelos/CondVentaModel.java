package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.CondicionesVentas;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class CondVentaModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    public List<CondicionesVentas> listCondVentas(){
        Query query = em.createNamedQuery("CondicionesVentas.findAll");
        return query.getResultList();
    }
    public CondicionesVentas obtenerCondVenta(String codigo){
        return em.find(CondicionesVentas.class, Integer.parseInt(codigo));
    }
}
