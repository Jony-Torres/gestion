
package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.UnidadesMedidas;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class UnidadMedModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<UnidadesMedidas> listUnidMedidas(){
        Query query = em.createNamedQuery("UnidadesMedidas.findAll");
        return query.getResultList();
    }
    public UnidadesMedidas obtenerUnidMed(String codigo){
        return em.find(UnidadesMedidas.class,Integer.parseInt(codigo));
    }
}
