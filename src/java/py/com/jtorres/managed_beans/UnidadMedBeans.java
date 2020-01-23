
package py.com.jtorres.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.jtorres.entidades.UnidadesMedidas;
import py.com.jtorres.modelos.UnidadMedModel;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "unidadMedBeans")
@RequestScoped
public class UnidadMedBeans {

    @EJB
    private UnidadMedModel unidadMedModel;

    List<UnidadesMedidas> listUnidMedidas;
    public UnidadMedBeans() {
    }

    public List<UnidadesMedidas> getListUnidMedidas() {
        listUnidMedidas = unidadMedModel.listUnidMedidas();
        return listUnidMedidas;
    }
    
}
