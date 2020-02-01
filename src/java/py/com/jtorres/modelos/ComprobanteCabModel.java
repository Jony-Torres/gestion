package py.com.jtorres.modelos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import py.com.jtorres.entidades.ComprobantesCabecera;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class ComprobanteCabModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    public int insertarComprobante(ComprobantesCabecera comprob) {
        try {
            em.persist(comprob);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
