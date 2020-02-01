/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.jtorres.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author jonathan.torres
 */
@Entity
@Table(name = "comprob_det_prb")
@NamedQueries({
    @NamedQuery(name = "ComprobDetPrb.findAll", query = "SELECT c FROM ComprobDetPrb c")
    , @NamedQuery(name = "ComprobDetPrb.findByIdentificador", query = "SELECT c FROM ComprobDetPrb c WHERE c.identificador = :identificador")
    , @NamedQuery(name = "ComprobDetPrb.findByCantidad", query = "SELECT c FROM ComprobDetPrb c WHERE c.cantidad = :cantidad")
    , @NamedQuery(name = "ComprobDetPrb.findByPrecio", query = "SELECT c FROM ComprobDetPrb c WHERE c.precio = :precio")})
public class ComprobDetPrb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer identificador;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name="cantidad")
    private Integer cantidad;
    @Column(name="precio")
    private Integer precio;
    @Column(name="COD_ARTICULO")
    private Integer codArticulo;
    public ComprobDetPrb() {
    }

    public ComprobDetPrb(Integer identificador) {
        this.identificador = identificador;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(Integer codArticulo) {
        this.codArticulo = codArticulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificador != null ? identificador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobDetPrb)) {
            return false;
        }
        ComprobDetPrb other = (ComprobDetPrb) object;
        if ((this.identificador == null && other.identificador != null) || (this.identificador != null && !this.identificador.equals(other.identificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ComprobDetPrb[ identificador=" + identificador + " ]";
    }
    
}
