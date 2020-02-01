
package py.com.jtorres.managed_beans;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.jtorres.entidades.ComprobantesCabecera;
import py.com.jtorres.modelos.ComprobanteCabModel;
import py.com.jtorres.utils.JsfUtils;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "comprobanteCabBeans")
@RequestScoped
public class ComprobanteCabBeans {

    @EJB
    private ComprobanteCabModel comprobanteCabModel;
    private ComprobantesCabecera comprobante = new ComprobantesCabecera();
    
    public ComprobanteCabBeans() {
    }

    public ComprobantesCabecera getComprobante() {
        return comprobante;
    }

    public void setComprobante(ComprobantesCabecera comprobante) {
        this.comprobante = comprobante;
    }
    public String insertarComprobante(){
        if (comprobanteCabModel.insertarComprobante(comprobante) == 0) {
            JsfUtils.addErrorMessage("codArticulo","Ya existe el codigo del Articulo");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Registro Exitoso");
        return "/articulos/listaArticulos?faces-redirect=true";
    }
}
