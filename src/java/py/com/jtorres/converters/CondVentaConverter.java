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
import py.com.jtorres.entidades.CondicionesVentas;
import py.com.jtorres.modelos.CondVentaModel;

/**
 *
 * @author jonathan.torres
 */
@FacesConverter(forClass = CondicionesVentas.class)
public class CondVentaConverter implements Converter{

    CondVentaModel condVentaModel = lookupCondVentaModelBean();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return condVentaModel.obtenerCondVenta(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof CondicionesVentas) {
            return Integer.toString(((CondicionesVentas) value).getCodCondicion());
        }
        return "";
    }

    private CondVentaModel lookupCondVentaModelBean() {
        try {
            Context c = new InitialContext();
            return (CondVentaModel) c.lookup("java:global/gestion/CondVentaModel!py.com.jtorres.modelos.CondVentaModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
