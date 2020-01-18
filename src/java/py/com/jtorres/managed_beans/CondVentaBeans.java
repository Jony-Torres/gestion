
package py.com.jtorres.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.jtorres.entidades.CondicionesVentas;
import py.com.jtorres.modelos.CondVentaModel;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "condVentaBeans")
@RequestScoped
public class CondVentaBeans {

    @EJB
    private CondVentaModel condVentaModel;

    List<CondicionesVentas> listCondVentas;
    public CondVentaBeans() {
    }

    public List<CondicionesVentas> getListCondVentas() {
        listCondVentas = condVentaModel.listCondVentas();
        return listCondVentas;
    }
    
}
