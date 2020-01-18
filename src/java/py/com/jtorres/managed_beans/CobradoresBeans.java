
package py.com.jtorres.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.jtorres.entidades.Cobradores;
import py.com.jtorres.modelos.CobradoresModel;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "cobradoresBeans")
@RequestScoped
public class CobradoresBeans {

    @EJB
    private CobradoresModel cobradoresModel;

    List<Cobradores> listCobradores;
    public CobradoresBeans() {
    }

    public List<Cobradores> getListCobradores() {
        listCobradores = cobradoresModel.listCobradores();
        return listCobradores;
    }
    
}
