
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
import py.com.jtorres.entidades.Estados;
import py.com.jtorres.modelos.EstadosModel;

/**
 *
 * @author jonathan.torres
 */
@FacesConverter(forClass = Estados.class)
public class EstadosConverter implements Converter{

    EstadosModel estadosModel = lookupEstadosModelBean();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return estadosModel.obtenerEstado(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Estados) {
            return Integer.toString(((Estados) value).getCodEstado());
        }
        return "";
    }

    private EstadosModel lookupEstadosModelBean() {
        try {
            Context c = new InitialContext();
            return (EstadosModel) c.lookup("java:global/gestion/EstadosModel!py.com.jtorres.modelos.EstadosModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
