package py.com.jtorres.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.jtorres.entidades.ArticulosDeposito;
import py.com.jtorres.modelos.ArticulosDepModel;
/**
 *
 * @author jonathan.torres
 */
@Named(value = "articulosDepBeans")
@RequestScoped
public class ArticulosDepBeans {

    @EJB
    private ArticulosDepModel articulosDepModel;
    private List<ArticulosDeposito> depositosList;
    
    public ArticulosDepBeans() {
    }

    public List<ArticulosDeposito> getDepositosList() {
        depositosList = articulosDepModel.listDepositos();
        return depositosList;
    }
    
}
