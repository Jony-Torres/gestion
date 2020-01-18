
package py.com.jtorres.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.jtorres.entidades.Paises;
import py.com.jtorres.modelos.PaisesModel;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "paisesBeans")
@RequestScoped
public class PaisesBeans {

    @EJB
    private PaisesModel paisesModel;

    List<Paises> listPaises;
    public PaisesBeans() {
    }

    public List<Paises> getListPaises() {
        listPaises = paisesModel.listPaises();
        return listPaises;
    }
    
}
