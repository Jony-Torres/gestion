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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jonathan.torres
 */
@Entity
@Table(name = "articulos_deposito")
@NamedQueries({
    @NamedQuery(name = "ArticulosDeposito.findAll", query = "SELECT a FROM ArticulosDeposito a")
    , @NamedQuery(name = "ArticulosDeposito.findByCodDeposito", query = "SELECT a FROM ArticulosDeposito a WHERE a.codDeposito = :codDeposito")
    , @NamedQuery(name = "ArticulosDeposito.findByDescripcion", query = "SELECT a FROM ArticulosDeposito a WHERE a.descripcion = :descripcion")})
public class ArticulosDeposito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_deposito")
    private Integer codDeposito;
    private String descripcion;
    @JoinColumn(name = "cod_sucursal", referencedColumnName = "cod_sucursal")
    @ManyToOne
    private Sucursales codSucursal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codDeposito")
    private List<ComprobantesCabecera> comprobantesCabeceraList;

    public ArticulosDeposito() {
    }

    public ArticulosDeposito(Integer codDeposito) {
        this.codDeposito = codDeposito;
    }

    public Integer getCodDeposito() {
        return codDeposito;
    }

    public void setCodDeposito(Integer codDeposito) {
        this.codDeposito = codDeposito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Sucursales getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(Sucursales codSucursal) {
        this.codSucursal = codSucursal;
    }

    public List<ComprobantesCabecera> getComprobantesCabeceraList() {
        return comprobantesCabeceraList;
    }

    public void setComprobantesCabeceraList(List<ComprobantesCabecera> comprobantesCabeceraList) {
        this.comprobantesCabeceraList = comprobantesCabeceraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDeposito != null ? codDeposito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticulosDeposito)) {
            return false;
        }
        ArticulosDeposito other = (ArticulosDeposito) object;
        if ((this.codDeposito == null && other.codDeposito != null) || (this.codDeposito != null && !this.codDeposito.equals(other.codDeposito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ArticulosDeposito[ codDeposito=" + codDeposito + " ]";
    }
    
}
