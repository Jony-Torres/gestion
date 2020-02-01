
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
import py.com.jtorres.entidades.UnidadesMedidas;
import py.com.jtorres.modelos.UnidadMedModel;

/**
 *
 * @author jonathan.torres
 */
@FacesConverter(forClass = UnidadesMedidas.class)
public class UnidMedConverter implements Converter{

    UnidadMedModel unidadMedModel = lookupUnidadMedModelBean();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return unidadMedModel.obtenerUnidMed(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof UnidadesMedidas) {
            return Integer.toString(((UnidadesMedidas) value).getCodUniMedida());
        }
        return "";
    }

    private UnidadMedModel lookupUnidadMedModelBean() {
        try {
            Context c = new InitialContext();
            return (UnidadMedModel) c.lookup("java:global/gestion/UnidadMedModel!py.com.jtorres.modelos.UnidadMedModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
