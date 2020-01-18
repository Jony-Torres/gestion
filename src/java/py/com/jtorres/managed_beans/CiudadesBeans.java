
package py.com.jtorres.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import py.com.jtorres.entidades.Ciudades;
import py.com.jtorres.entidades.Departamentos;
import py.com.jtorres.modelos.CiudadesModel;
import py.com.jtorres.modelos.DepartamentosModel;
import py.com.jtorres.utils.JsfUtils;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "ciudadesBeans")
@RequestScoped
public class CiudadesBeans {

    @EJB
    private CiudadesModel ciudadesModel;
    
    @EJB
    private DepartamentosModel dptosModel;
    
    private Ciudades ciudad = new Ciudades();

    List<Ciudades> listCiudades;
    public CiudadesBeans() {
    }

    public List<Ciudades> getListCiudades() {
        listCiudades = ciudadesModel.listCiudades();
        return listCiudades;
    }
    public List<Departamentos> getListDptos(){
        return dptosModel.listDptos();
    }
    public Ciudades getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudades ciudad) {
        this.ciudad = ciudad;
    }
    public String insertarCiudad(){
        if (ciudadesModel.insertarCiudad(ciudad) == 0) {
            JsfUtils.addErrorMessage("codCiudad","Ya existe el codigo de la ciudad");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Registro Exitoso");
        return "/ciudades/listaCiudades?faces-redirect=true";
    }
    public String modificarCiudad(){
        if (ciudadesModel.modificarCiudad(ciudad) == 0) {
            JsfUtils.addErrorMessage("codCiudad","No se pudo modificar la ciudad");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Registro Exitoso");
        return "/ciudades/listaCiudades?faces-redirect=true";
    }
    public String obtenerCiudad() {
        String codigo = JsfUtils.getRequest().getParameter("codigo");
        ciudad=ciudadesModel.obtenerCiudad(codigo);
        return "/ciudades/modificaCiudad";
    }
    public String eliminarCiudad(){
        String codigo = JsfUtils.getRequest().getParameter("codigo");
        if (ciudadesModel.eliminarCiudad(codigo) > 0) {
            JsfUtils.addFlashMessage("exito", "Registro Eliminado");
        }else{
            JsfUtils.addFlashMessage("fracaso", "Error al  Eliminar Registro");
        }
        return null;
    }
}
