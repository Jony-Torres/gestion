package py.com.jtorres.managed_beans;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import py.com.jtorres.entidades.ComprobDetPrb;
import py.com.jtorres.modelos.CompDetModel;
import py.com.jtorres.utils.JsfUtils;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "compDetBeans")
@ManagedBean
public class CompDetBeans {

    @EJB
    private CompDetModel compDetModel;

    private static List<ComprobDetPrb> listaCompDet = new ArrayList<>();
    private ComprobDetPrb mycomp;

    public CompDetBeans() {
        mycomp = new ComprobDetPrb();
    }

    public List<ComprobDetPrb> getListaCompDet() {
        return listaCompDet;
    }
    public String insertarCompDet() {
        for (ComprobDetPrb rpc : listaCompDet) {
            if (compDetModel.insertarCompDet(rpc) == 0) {
                JsfUtils.addErrorMessage("identificador", "Ya existe el codigo del comprobante");
                return null;
            }
            JsfUtils.addFlashMessage("exito", "Registro Exitoso");

        }
        listaCompDet = new ArrayList<>();
        return "/comprobantes_ventas/nuevoCompVenta?faces-redirect=true";
    }
    public void agregarComp() {
        listaCompDet.add(mycomp);
        mycomp = new ComprobDetPrb();
    }
    public void eliminarComp(ComprobDetPrb comp) {
        listaCompDet.remove(comp);
    }

    public ComprobDetPrb getMycomp() {
        return mycomp;
    }

    public void setMycomp(ComprobDetPrb mycomp) {
        this.mycomp = mycomp;
    }
}
