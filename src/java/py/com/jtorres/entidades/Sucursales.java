/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.jtorres.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author jonathan.torres
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Sucursales.findAll", query = "SELECT s FROM Sucursales s")
    , @NamedQuery(name = "Sucursales.findByCodSucursal", query = "SELECT s FROM Sucursales s WHERE s.codSucursal = :codSucursal")
    , @NamedQuery(name = "Sucursales.findByDescripcion", query = "SELECT s FROM Sucursales s WHERE s.descripcion = :descripcion")})
public class Sucursales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_sucursal")
    private Integer codSucursal;
    @Basic(optional = false)
    private String descripcion;
    private List<SaldosCliente> saldosClienteList;
    @OneToMany(mappedBy = "codSucursal")
    private List<ArticulosDeposito> articulosDepositoList;
    private List<ComprobantesCabecera> comprobantesCabeceraList;
    @OneToMany(mappedBy = "codSucursal")
    private List<ComprobantesSeries> comprobantesSeriesList;

    public Sucursales() {
    }

    public Sucursales(Integer codSucursal) {
        this.codSucursal = codSucursal;
    }

    public Sucursales(Integer codSucursal, String descripcion) {
        this.codSucursal = codSucursal;
        this.descripcion = descripcion;
    }

    public Integer getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(Integer codSucursal) {
        this.codSucursal = codSucursal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<SaldosCliente> getSaldosClienteList() {
        return saldosClienteList;
    }

    public void setSaldosClienteList(List<SaldosCliente> saldosClienteList) {
        this.saldosClienteList = saldosClienteList;
    }

    public List<ArticulosDeposito> getArticulosDepositoList() {
        return articulosDepositoList;
    }

    public void setArticulosDepositoList(List<ArticulosDeposito> articulosDepositoList) {
        this.articulosDepositoList = articulosDepositoList;
    }

    public List<ComprobantesCabecera> getComprobantesCabeceraList() {
        return comprobantesCabeceraList;
    }

    public void setComprobantesCabeceraList(List<ComprobantesCabecera> comprobantesCabeceraList) {
        this.comprobantesCabeceraList = comprobantesCabeceraList;
    }

    public List<ComprobantesSeries> getComprobantesSeriesList() {
        return comprobantesSeriesList;
    }

    public void setComprobantesSeriesList(List<ComprobantesSeries> comprobantesSeriesList) {
        this.comprobantesSeriesList = comprobantesSeriesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSucursal != null ? codSucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursales)) {
            return false;
        }
        Sucursales other = (Sucursales) object;
        if ((this.codSucursal == null && other.codSucursal != null) || (this.codSucursal != null && !this.codSucursal.equals(other.codSucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Sucursales[ codSucursal=" + codSucursal + " ]";
    }
    
}
