
package py.com.jtorres.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.jtorres.entidades.TipoDocumentos;
import py.com.jtorres.modelos.TipoDocModel;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "tipoDocBeans")
@RequestScoped
public class TipoDocBeans {

    @EJB
    private TipoDocModel tipoDocModel;

    List<TipoDocumentos> listaTipoDoc;
    public TipoDocBeans() {
    }

    public List<TipoDocumentos> getListaTipoDoc() {
        listaTipoDoc = tipoDocModel.listarTipoDoc();
        return listaTipoDoc;
    }
    
}
