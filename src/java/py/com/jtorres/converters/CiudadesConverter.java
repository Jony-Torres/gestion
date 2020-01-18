
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
import py.com.jtorres.entidades.Ciudades;
import py.com.jtorres.modelos.CiudadesModel;

/**
 *
 * @author jonathan.torres
 */
@FacesConverter(forClass = Ciudades.class)
public class CiudadesConverter implements Converter{

    CiudadesModel ciudadesModel = lookupCiudadesModelBean();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return ciudadesModel.obtenerCiudad(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Ciudades) {
            return Integer.toString(((Ciudades) value).getCodCiudad());
        }
        return "";
    }

    private CiudadesModel lookupCiudadesModelBean() {
        try {
            Context c = new InitialContext();
            return (CiudadesModel) c.lookup("java:global/gestion/CiudadesModel!py.com.jtorres.modelos.CiudadesModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
