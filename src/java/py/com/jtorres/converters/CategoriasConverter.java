
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
import py.com.jtorres.entidades.Categorias;
import py.com.jtorres.modelos.CategoriasModel;

/**
 *
 * @author jonathan.torres
 */
@FacesConverter(forClass = Categorias.class)
public class CategoriasConverter implements Converter{

    CategoriasModel categoriasModel = lookupCategoriasModelBean();
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       if (value == null || value.isEmpty()) {
            return null;
        }
        return categoriasModel.obtenerCategoria(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Categorias) {
            return Integer.toString(((Categorias) value).getCodCategoria());
        }
        return "";
    }

    private CategoriasModel lookupCategoriasModelBean() {
        try {
            Context c = new InitialContext();
            return (CategoriasModel) c.lookup("java:global/gestion/CategoriasModel!py.com.jtorres.modelos.CategoriasModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
