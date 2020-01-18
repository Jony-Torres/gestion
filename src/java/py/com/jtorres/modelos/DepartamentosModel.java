
package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.Departamentos;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class DepartamentosModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public List<Departamentos> listDptos() {
        Query query = em.createNamedQuery("Departamentos.findAll");
        return query.getResultList();
    }
    public Departamentos obtenerDpto(String codigo){
        return em.find(Departamentos.class, Integer.parseInt(codigo));
    }

}
