package py.com.jtorres.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.jtorres.entidades.Iva;
import py.com.jtorres.modelos.IvaModel;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "ivaBeans")
@RequestScoped
public class IvaBeans {

    @EJB
    private IvaModel ivaModel;

    List<Iva> listIva;
    public IvaBeans() {
    }

    public List<Iva> getListIva() {
        listIva = ivaModel.listIva();
        return listIva;
    }
    
}
