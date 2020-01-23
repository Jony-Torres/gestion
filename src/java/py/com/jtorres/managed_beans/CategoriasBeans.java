
package py.com.jtorres.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.jtorres.entidades.Categorias;
import py.com.jtorres.modelos.CategoriasModel;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "categoriasBeans")
@RequestScoped
public class CategoriasBeans {

    @EJB
    private CategoriasModel categoriasModel;
    
    List<Categorias> listCategorias;
    
    public CategoriasBeans() {
    }

    public List<Categorias> getListCategorias() {
        listCategorias = categoriasModel.listCategorias();
        return listCategorias;
    }
    
}
