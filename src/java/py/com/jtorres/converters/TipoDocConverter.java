
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
import py.com.jtorres.entidades.TipoDocumentos;
import py.com.jtorres.modelos.TipoDocModel;

/**
 *
 * @author jonathan.torres
 */
@FacesConverter(forClass = TipoDocumentos.class)
public class TipoDocConverter implements Converter{

    TipoDocModel tipoDocModel = lookupTipoDocModelBean();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return tipoDocModel.obtenerTipoDoc(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof TipoDocumentos) {
            return ((TipoDocumentos) value).getCodTipoDoc();
        }
        return "";
    }

    private TipoDocModel lookupTipoDocModelBean() {
        try {
            Context c = new InitialContext();
            return (TipoDocModel) c.lookup("java:global/gestion/TipoDocModel!py.com.jtorres.modelos.TipoDocModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
