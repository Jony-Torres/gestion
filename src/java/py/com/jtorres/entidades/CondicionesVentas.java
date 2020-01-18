/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.jtorres.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jonathan.torres
 */
@Entity
@Table(name = "condiciones_ventas")
@NamedQueries({
    @NamedQuery(name = "CondicionesVentas.findAll", query = "SELECT c FROM CondicionesVentas c")
    , @NamedQuery(name = "CondicionesVentas.findByCodCondicion", query = "SELECT c FROM CondicionesVentas c WHERE c.codCondicion = :codCondicion")
    , @NamedQuery(name = "CondicionesVentas.findByDescCondicion", query = "SELECT c FROM CondicionesVentas c WHERE c.descCondicion = :descCondicion")
    , @NamedQuery(name = "CondicionesVentas.findByNumeroCuota", query = "SELECT c FROM CondicionesVentas c WHERE c.numeroCuota = :numeroCuota")
    , @NamedQuery(name = "CondicionesVentas.findByDiaInicial", query = "SELECT c FROM CondicionesVentas c WHERE c.diaInicial = :diaInicial")
    , @NamedQuery(name = "CondicionesVentas.findByPlazo", query = "SELECT c FROM CondicionesVentas c WHERE c.plazo = :plazo")
    , @NamedQuery(name = "CondicionesVentas.findByEstado", query = "SELECT c FROM CondicionesVentas c WHERE c.estado = :estado")})
public class CondicionesVentas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_condicion")
    private Integer codCondicion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "desc_condicion")
    private String descCondicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_cuota")
    private int numeroCuota;
    @Column(name = "dia_inicial")
    private Integer diaInicial;
    private Integer plazo;
    @Size(max = 1)
    private String estado;
    @OneToMany(mappedBy = "codCondVenta")
    private List<Clientes> clientesList;

    public CondicionesVentas() {
    }

    public CondicionesVentas(Integer codCondicion) {
        this.codCondicion = codCondicion;
    }

    public CondicionesVentas(Integer codCondicion, String descCondicion, int numeroCuota) {
        this.codCondicion = codCondicion;
        this.descCondicion = descCondicion;
        this.numeroCuota = numeroCuota;
    }

    public Integer getCodCondicion() {
        return codCondicion;
    }

    public void setCodCondicion(Integer codCondicion) {
        this.codCondicion = codCondicion;
    }

    public String getDescCondicion() {
        return descCondicion;
    }

    public void setDescCondicion(String descCondicion) {
        this.descCondicion = descCondicion;
    }

    public int getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(int numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public Integer getDiaInicial() {
        return diaInicial;
    }

    public void setDiaInicial(Integer diaInicial) {
        this.diaInicial = diaInicial;
    }

    public Integer getPlazo() {
        return plazo;
    }

    public void setPlazo(Integer plazo) {
        this.plazo = plazo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCondicion != null ? codCondicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CondicionesVentas)) {
            return false;
        }
        CondicionesVentas other = (CondicionesVentas) object;
        if ((this.codCondicion == null && other.codCondicion != null) || (this.codCondicion != null && !this.codCondicion.equals(other.codCondicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.jtorres.entidades.CondicionesVentas[ codCondicion=" + codCondicion + " ]";
    }
    
}
