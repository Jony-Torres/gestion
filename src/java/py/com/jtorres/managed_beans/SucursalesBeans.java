package py.com.jtorres.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.jtorres.entidades.Sucursales;
import py.com.jtorres.modelos.SucursalesModel;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "sucursalesBeans")
@RequestScoped
public class SucursalesBeans {

    @EJB
    private SucursalesModel sucursalesModel;
    private List<Sucursales> sucursalList;
    
    public SucursalesBeans() {
    }

    public List<Sucursales> getSucursalList() {
        sucursalList = sucursalesModel.listSucursales();
        return sucursalList;
    }
    
}
