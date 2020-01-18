
package py.com.jtorres.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.jtorres.entidades.EstadoCivil;
import py.com.jtorres.modelos.EstadoCivilModel;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "estadoCivilBeans")
@RequestScoped
public class EstadoCivilBeans {

    @EJB
    private EstadoCivilModel estadoCivilModel;

    List<EstadoCivil> listaEstadoCivil;
    
    public EstadoCivilBeans() {
    }

    public List<EstadoCivil> getListaEstadoCivil() {
        listaEstadoCivil = estadoCivilModel.listarEstadoCivil();
        return listaEstadoCivil;
    }
    
}
