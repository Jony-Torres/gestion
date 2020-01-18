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
import py.com.jtorres.entidades.Departamentos;
import py.com.jtorres.modelos.DepartamentosModel;

/**
 *
 * @author jonathan.torres
 */
@FacesConverter(forClass = Departamentos.class)
public class DptosConverter implements Converter{

    DepartamentosModel departamentosModel = lookupDepartamentosModelBean();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return departamentosModel.obtenerDpto(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Departamentos) {
            return Integer.toString(((Departamentos) value).getCodDepartamento());
        }
        return "";
    }

    private DepartamentosModel lookupDepartamentosModelBean() {
        try {
            Context c = new InitialContext();
            return (DepartamentosModel) c.lookup("java:global/gestion/DepartamentosModel!py.com.jtorres.modelos.DepartamentosModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
