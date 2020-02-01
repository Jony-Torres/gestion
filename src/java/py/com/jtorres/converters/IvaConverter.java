
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
import py.com.jtorres.entidades.Iva;
import py.com.jtorres.modelos.IvaModel;

/**
 *
 * @author jonathan.torres
 */
@FacesConverter(forClass = Iva.class)
public class IvaConverter implements Converter{

    IvaModel ivaModel = lookupIvaModelBean();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return ivaModel.obtenerIva(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Iva) {
            return Integer.toString(((Iva) value).getCodIva());
        }
        return "";
    }

    private IvaModel lookupIvaModelBean() {
        try {
            Context c = new InitialContext();
            return (IvaModel) c.lookup("java:global/gestion/IvaModel!py.com.jtorres.modelos.IvaModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
