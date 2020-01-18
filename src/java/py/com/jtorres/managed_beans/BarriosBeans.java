
package py.com.jtorres.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.jtorres.entidades.Barrios;
import py.com.jtorres.modelos.BarriosModel;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "barriosBeans")
@RequestScoped
public class BarriosBeans {

    @EJB
    private BarriosModel barriosModel;
    
    List<Barrios> listaBarrios;
    
    public BarriosBeans() {
    }

    public List<Barrios> getListaBarrios() {
        listaBarrios = barriosModel.listarBarrios();
        return listaBarrios;
    }
    
}
