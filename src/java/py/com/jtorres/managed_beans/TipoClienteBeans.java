/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.jtorres.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.jtorres.entidades.TipoCliente;
import py.com.jtorres.modelos.TipoClienteModel;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "tipoClienteBeans")
@RequestScoped
public class TipoClienteBeans {

    @EJB
    private TipoClienteModel tipoClienteModel;

    List<TipoCliente> listTipoCliente;
    public TipoClienteBeans() {
    }
    public List<TipoCliente> getListTipoCliente(){
        listTipoCliente = tipoClienteModel.listTipoCliente();
        return listTipoCliente;
    }
}
