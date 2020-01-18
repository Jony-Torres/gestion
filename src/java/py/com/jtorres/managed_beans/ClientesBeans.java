
package py.com.jtorres.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.jtorres.entidades.Clientes;
import py.com.jtorres.modelos.ClientesModel;
import py.com.jtorres.utils.JsfUtils;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "clientesBeans")
@RequestScoped
public class ClientesBeans {

    @EJB
    private ClientesModel clientesModel;

    private Clientes cliente = new Clientes();
    
    public ClientesBeans() {
    }
    public List<Clientes> getListaClientes (){
        return clientesModel.listClientes();
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
    public String insertarCliente(){
        if (clientesModel.insertarCliente(cliente) == 0) {
            JsfUtils.addErrorMessage("codPersona","Ya existe el codigo de la persona");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Registro Exitoso");
        return "/clientes/listaClientes?faces-redirect=true";
    }
    public String obtenerCliente() {
        String codigo = JsfUtils.getRequest().getParameter("codigo");
        cliente=clientesModel.obtenerCliente(codigo);
        return "/clientes/modificaCliente";
    }
    public String modificarCliente(){
        if (clientesModel.modificarCliente(cliente) == 0) {
            JsfUtils.addErrorMessage("codCliente","No se pudo modificar el Cliente");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Registro Exitoso");
        return "/clientes/listaClientes?faces-redirect=true";
    }
    public String eliminarCliente(){
        String codigo = JsfUtils.getRequest().getParameter("codigo");
        if (clientesModel.eliminarCliente(codigo) > 0) {
            JsfUtils.addFlashMessage("exito", "Registro Eliminado");
        }else{
            JsfUtils.addFlashMessage("fracaso", "Error al  Eliminar Registro");
        }
        return null;
    }
}
