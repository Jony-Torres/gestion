
package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.TipoCliente;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class TipoClienteModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    public List<TipoCliente> listTipoCliente(){
        Query query = em.createNamedQuery("TipoCliente.findAll");
        return query.getResultList();
    }
    public TipoCliente obtenerTipoCliente(String codigo){
        return em.find(TipoCliente.class, Integer.parseInt(codigo));
    }
}
