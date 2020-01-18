package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.Cobradores;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class CobradoresModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Cobradores> listCobradores(){
        Query query = em.createNamedQuery("Cobradores.findAll");
        return query.getResultList();
    }
    public Cobradores obtenerCobrador(String codigo){
        return em.find(Cobradores.class, Integer.parseInt(codigo));
    }
}
