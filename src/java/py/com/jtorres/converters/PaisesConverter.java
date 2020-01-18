
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
import py.com.jtorres.entidades.Paises;
import py.com.jtorres.modelos.PaisesModel;

/**
 *
 * @author jonathan.torres
 */
@FacesConverter(forClass = Paises.class)
public class PaisesConverter implements Converter{

    PaisesModel paisesModel = lookupPaisesModelBean();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return paisesModel.obtenerPais(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Paises) {
            return Integer.toString(((Paises) value).getCodPais());
        }
        return "";
    }

    private PaisesModel lookupPaisesModelBean() {
        try {
            Context c = new InitialContext();
            return (PaisesModel) c.lookup("java:global/gestion/PaisesModel!py.com.jtorres.modelos.PaisesModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
