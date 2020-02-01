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
import py.com.jtorres.entidades.Marcas;
import py.com.jtorres.modelos.MarcasModel;

/**
 *
 * @author jonathan.torres
 */
@FacesConverter(forClass = Marcas.class)
public class MarcasConverter implements Converter{

    MarcasModel marcasModel = lookupMarcasModelBean();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return marcasModel.obtenerMarca(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Marcas) {
            return Integer.toString(((Marcas) value).getCodMarca());
        }
        return "";
    }

    private MarcasModel lookupMarcasModelBean() {
        try {
            Context c = new InitialContext();
            return (MarcasModel) c.lookup("java:global/gestion/MarcasModel!py.com.jtorres.modelos.MarcasModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
