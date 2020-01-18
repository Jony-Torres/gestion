
package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.Clientes;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class ClientesModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    public List<Clientes> listClientes(){
        Query query = em.createNamedQuery("Clientes.findAll");
        return query.getResultList();
    }
    public int insertarCliente(Clientes cliente) {
        try {
            em.persist(cliente);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    public Clientes obtenerCliente(String codigo){
        return em.find(Clientes.class,Integer.parseInt(codigo));
    }
    public int modificarCliente(Clientes cliente) {
        try {
            em.merge(cliente);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    public int eliminarCliente(String codigo) {
        try {
            Clientes cliente = em.find(Clientes.class, Integer.parseInt(codigo));
            if (cliente != null) {
                em.remove(cliente);
                em.flush();
                return 1;
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }
}
