package py.com.jtorres.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.jtorres.entidades.Proveedores;
import py.com.jtorres.modelos.ProveedoresModel;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "proveedoresBeans")
@RequestScoped
public class ProveedoresBeans {

    @EJB
    private ProveedoresModel proveedoresModel;
    
    List<Proveedores> listProveedores;
    
    public ProveedoresBeans() {
    }

    public List<Proveedores> getListProveedores() {
        listProveedores = proveedoresModel.listProveedores();
        return listProveedores;
    }
    
}
