
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
import py.com.jtorres.entidades.Vendedores;
import py.com.jtorres.modelos.VendedoresModel;

/**
 *
 * @author jonathan.torres
 */
@FacesConverter(forClass = Vendedores.class)
public class VendedoresConverter implements Converter{

    VendedoresModel vendedoresModel = lookupVendedoresModelBean();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return vendedoresModel.obtenerVendedor(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Vendedores) {
            return Integer.toString(((Vendedores) value).getCodVendedor());
        }
        return "";
    }

    private VendedoresModel lookupVendedoresModelBean() {
        try {
            Context c = new InitialContext();
            return (VendedoresModel) c.lookup("java:global/gestion/VendedoresModel!py.com.jtorres.modelos.VendedoresModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
