
package py.com.jtorres.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.jtorres.entidades.Articulos;
import py.com.jtorres.modelos.ArticulosModel;
import py.com.jtorres.utils.JsfUtils;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "articulosBeans")
@RequestScoped
public class ArticulosBeans {

    @EJB
    private ArticulosModel articulosModel;

    private Articulos articulo = new Articulos();
    List<Articulos> listArticulos;
    
    public ArticulosBeans() {
    }

    public List<Articulos> getListArticulos() {
        listArticulos = articulosModel.listArticulos();
        return listArticulos;
    }

    public Articulos getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulos articulo) {
        this.articulo = articulo;
    }
    public String insertarArticulo(){
        if (articulosModel.insertarArticulo(articulo) == 0) {
            JsfUtils.addErrorMessage("codArticulo","Ya existe el codigo del Articulo");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Registro Exitoso");
        return "/articulos/listaArticulos?faces-redirect=true";
    }
    public String modificarArticulo(){
        if (articulosModel.modificarArticulo(articulo) == 0) {
            JsfUtils.addErrorMessage("codArticulo","No se pudo modificar el Articulo");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Registro Exitoso");
        return "/articulos/listaArticulos?faces-redirect=true";
    }
    public String obtenerArticulo() {
        String codigo = JsfUtils.getRequest().getParameter("codigo");
        articulo=articulosModel.obtenerArticulo(codigo);
        return "/articulos/modificaArticulo";
    }
    public String eliminarArticulo(){
        String codigo = JsfUtils.getRequest().getParameter("codigo");
        if (articulosModel.eliminarArticulo(codigo) > 0) {
            JsfUtils.addFlashMessage("exito", "Registro Eliminado");
        }else{
            JsfUtils.addFlashMessage("fracaso", "Error al  Eliminar Registro");
        }
        return null;
    }
}
