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
import py.com.jtorres.entidades.Monedas;
import py.com.jtorres.modelos.MonedasModel;

/**
 *
 * @author jonathan.torres
 */
@FacesConverter(forClass = Monedas.class)
public class MonedasConverter implements Converter{

    MonedasModel monedasModel = lookupMonedasModelBean();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return monedasModel.obtenerMoneda(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Monedas) {
            return ((Monedas) value).getCodMoneda();
        }
        return "";
    }

    private MonedasModel lookupMonedasModelBean() {
        try {
            Context c = new InitialContext();
            return (MonedasModel) c.lookup("java:global/gestion/MonedasModel!py.com.jtorres.modelos.MonedasModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
