package py.com.jtorres.modelos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.jtorres.entidades.TipoDocumentos;

/**
 *
 * @author jonathan.torres
 */
@Stateless
public class TipoDocModel {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public List<TipoDocumentos> listarTipoDoc(){
        Query query = em.createNamedQuery("TipoDocumentos.findAll");
        return query.getResultList();
    }
    public TipoDocumentos obtenerTipoDoc(String codigo){
        return em.find(TipoDocumentos.class,codigo);
    }
}
