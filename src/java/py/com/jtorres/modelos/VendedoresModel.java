package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.Vendedores;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class VendedoresModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Vendedores> listVendedores(){
        Query query = em.createNamedQuery("Vendedores.findAll");
        return query.getResultList();
    }
    public Vendedores obtenerVendedor(String codigo){
        return em.find(Vendedores.class, Integer.parseInt(codigo));
    }
}
