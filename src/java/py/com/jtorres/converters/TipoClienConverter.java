
package py.com.jtorres.converters;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import py.com.jtorres.entidades.TipoCliente;
import py.com.jtorres.modelos.TipoClienteModel;

/**
 *
 * @author jonathan.torres
 */
@FacesConverter(forClass = TipoCliente.class)
public class TipoClienConverter implements Converter{

    TipoClienteModel tipoClienteModel = lookupTipoClienteModelBean();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return tipoClienteModel.obtenerTipoCliente(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof TipoCliente) {
            return Integer.toString(((TipoCliente) value).getCodTipCliente());
        }
        return "";
    }

    private TipoClienteModel lookupTipoClienteModelBean() {
        try {
            Context c = new InitialContext();
            return (TipoClienteModel) c.lookup("java:global/gestion/TipoClienteModel!py.com.jtorres.modelos.TipoClienteModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
