package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.Monedas;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class MonedasModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    public List<Monedas> listMonedas(){
        Query query = em.createNamedQuery("Monedas.findAll");
        return query.getResultList();
    }
    public Monedas obtenerMoneda(String codigo){
        return em.find(Monedas.class,Integer.parseInt(codigo));
    }
}
