
package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.Paises;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class PaisesModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public List<Paises> listPaises(){
        Query query = em.createNamedQuery("Paises.findAll");
        return query.getResultList();
    }
    public Paises obtenerPais(String codigo){
        return em.find(Paises.class, Integer.parseInt(codigo));
    }
}
