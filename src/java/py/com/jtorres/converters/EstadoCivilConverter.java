
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
import py.com.jtorres.entidades.EstadoCivil;
import py.com.jtorres.modelos.EstadoCivilModel;

/**
 *
 * @author jonathan.torres
 */
@FacesConverter(forClass = EstadoCivil.class)
public class EstadoCivilConverter implements Converter{

    EstadoCivilModel estadoCivilModel = lookupEstadoCivilModelBean();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return estadoCivilModel.obtenerEstadoCivil(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof EstadoCivil) {
            return ((EstadoCivil) value).getCodEstadoCivil();
        }
        return "";
    }

    private EstadoCivilModel lookupEstadoCivilModelBean() {
        try {
            Context c = new InitialContext();
            return (EstadoCivilModel) c.lookup("java:global/gestion/EstadoCivilModel!py.com.jtorres.modelos.EstadoCivilModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
