
package py.com.jtorres.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.jtorres.entidades.Departamentos;
import py.com.jtorres.modelos.DepartamentosModel;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "departamentosBeans")
@RequestScoped
public class DepartamentosBeans {

    @EJB
    private DepartamentosModel departamentosModel;

    List<Departamentos> listDptos;
    public DepartamentosBeans() {
    }
    public List<Departamentos> getListDptos() {
        listDptos = departamentosModel.listDptos();
        return listDptos;
    }
    
}
