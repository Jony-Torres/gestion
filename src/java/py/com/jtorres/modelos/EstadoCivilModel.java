
package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.EstadoCivil;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class EstadoCivilModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<EstadoCivil> listarEstadoCivil(){
        Query query = em.createNamedQuery("EstadoCivil.findAll");
        return query.getResultList();
    }
    public EstadoCivil obtenerEstadoCivil(String codigo){
        return em.find(EstadoCivil.class, codigo);
    }
}
