package py.com.jtorres.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.jtorres.entidades.Vendedores;
import py.com.jtorres.modelos.VendedoresModel;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "vendedoresBeans")
@RequestScoped
public class VendedoresBeans {

    @EJB
    private VendedoresModel vendedoresModel;

    List<Vendedores> listVendedores;
    public VendedoresBeans() {
    }

    public List<Vendedores> getListVendedores() {
        listVendedores = vendedoresModel.listVendedores();
        return listVendedores;
    }

    
    
}
