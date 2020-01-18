package py.com.jtorres.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.jtorres.entidades.Estados;
import py.com.jtorres.modelos.EstadosModel;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "estadosBeans")
@RequestScoped
public class EstadosBeans {

    @EJB
    private EstadosModel estadosModel;

    List<Estados> listEstados;
    public EstadosBeans() {
    }

    public List<Estados> getListEstados() {
        listEstados = estadosModel.listEstados();
        return listEstados;
    }
    
}
