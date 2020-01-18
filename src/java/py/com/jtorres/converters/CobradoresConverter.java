
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
import py.com.jtorres.entidades.Cobradores;
import py.com.jtorres.modelos.CobradoresModel;

/**
 *
 * @author jonathan.torres
 */
@FacesConverter(forClass = Cobradores.class)
public class CobradoresConverter implements Converter{

    CobradoresModel cobradoresModel = lookupCobradoresModelBean();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return cobradoresModel.obtenerCobrador(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Cobradores) {
            return Integer.toString(((Cobradores) value).getCodCobrador());
        }
        return "";
    }

    private CobradoresModel lookupCobradoresModelBean() {
        try {
            Context c = new InitialContext();
            return (CobradoresModel) c.lookup("java:global/gestion/CobradoresModel!py.com.jtorres.modelos.CobradoresModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
