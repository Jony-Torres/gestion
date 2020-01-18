
package py.com.jtorres.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.jtorres.entidades.Monedas;
import py.com.jtorres.modelos.MonedasModel;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "monedasBeans")
@RequestScoped
public class MonedasBeans {

    @EJB
    private MonedasModel monedasModel;

    List<Monedas> listMonedas;
    public MonedasBeans() {
    }
    public List<Monedas> getListMonedas(){
        listMonedas = monedasModel.listMonedas();
        return listMonedas;
    }
}
