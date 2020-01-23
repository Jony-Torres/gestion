
package py.com.jtorres.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.jtorres.entidades.Marcas;
import py.com.jtorres.modelos.MarcasModel;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "marcasBeans")
@RequestScoped
public class MarcasBeans {

    @EJB
    private MarcasModel marcasModel;

    List<Marcas> listMarcas;
    public MarcasBeans() {
    }

    public List<Marcas> getListMarcas() {
        listMarcas = marcasModel.listMarcas();
        return listMarcas;
    }
    
}
