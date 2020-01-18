/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import py.com.jtorres.entidades.Barrios;
import py.com.jtorres.modelos.BarriosModel;

/**
 *
 * @author jonathan.torres
 */
@FacesConverter(forClass = Barrios.class)
public class BarriosConverter implements Converter{

    BarriosModel barriosModel = lookupBarriosModelBean();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return barriosModel.obtenerBarrio(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Barrios) {
            return Integer.toString(((Barrios) value).getCodBarrio());
        }
        return "";
    }

    private BarriosModel lookupBarriosModelBean() {
        try {
            Context c = new InitialContext();
            return (BarriosModel) c.lookup("java:global/gestion/BarriosModel!py.com.jtorres.modelos.BarriosModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
