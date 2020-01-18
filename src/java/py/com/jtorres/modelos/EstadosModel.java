package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.Estados;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class EstadosModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Estados> listEstados() {
        Query query = null;
        try {
            query = em.createNamedQuery("Estados.findByTablaRef");
            query.setParameter("tablaRef", "clientes.estado");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return query.getResultList();
    }

    public Estados obtenerEstado(String codigo) {
        return em.find(Estados.class, Integer.parseInt(codigo));
    }
}
