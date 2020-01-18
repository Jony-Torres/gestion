
package py.com.jtorres.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.jtorres.entidades.Personas;
import py.com.jtorres.modelos.PersonasModel;
import py.com.jtorres.utils.JsfUtils;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "personasBeans")
@RequestScoped
public class PersonasBeans {

    @EJB
    private PersonasModel personasModel;
    
    private Personas persona = new Personas();
    
    public PersonasBeans() {
        
    }
    public List<Personas> getListaPersonas() {
        return personasModel.listPersonas();
    }

    public Personas getPersona() {
        return persona;
    }

    public void setPersona(Personas persona) {
        this.persona = persona;
    }
    public String insertarPersona(){
        if (personasModel.insertarPersona(persona) == 0) {
            JsfUtils.addErrorMessage("codPersona","Ya existe el codigo de la persona");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Registro Exitoso");
        return "/personas/listaPersonas?faces-redirect=true";
    }
    public String modificarPersona(){
        if (personasModel.modificarPersona(persona) == 0) {
            JsfUtils.addErrorMessage("codPersona","No se pudo modificar la persona");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Registro Exitoso");
        return "/personas/listaPersonas?faces-redirect=true";
    }
    public String obtenerPersona() {
        String codigo = JsfUtils.getRequest().getParameter("codigo");
        persona=personasModel.obtenerPersona(codigo);
        return "/personas/modificaPersona";
    }
    public String eliminarPersona(){
        String codigo = JsfUtils.getRequest().getParameter("codigo");
        if (personasModel.eliminarPersona(codigo) > 0) {
            JsfUtils.addFlashMessage("exito", "Registro Eliminado");
        }else{
            JsfUtils.addFlashMessage("fracaso", "Error al  Eliminar Registro");
        }
        return null;
    }
}
