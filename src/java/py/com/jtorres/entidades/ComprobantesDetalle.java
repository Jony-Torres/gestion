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
@Table(name = "comprobantes_detalle")
@NamedQueries({
    @NamedQuery(name = "ComprobantesDetalle.findAll", query = "SELECT c FROM ComprobantesDetalle c")
    , @NamedQuery(name = "ComprobantesDetalle.findByIdentificador", query = "SELECT c FROM ComprobantesDetalle c WHERE c.identificador = :identificador")
    , @NamedQuery(name = "ComprobantesDetalle.findByDescripcion", query = "SELECT c FROM ComprobantesDetalle c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "ComprobantesDetalle.findByCantidad", query = "SELECT c FROM ComprobantesDetalle c WHERE c.cantidad = :cantidad")
    , @NamedQuery(name = "ComprobantesDetalle.findByPrecioUnitario", query = "SELECT c FROM ComprobantesDetalle c WHERE c.precioUnitario = :precioUnitario")
    , @NamedQuery(name = "ComprobantesDetalle.findByDescuento", query = "SELECT c FROM ComprobantesDetalle c WHERE c.descuento = :descuento")
    , @NamedQuery(name = "ComprobantesDetalle.findByGravada10", query = "SELECT c FROM ComprobantesDetalle c WHERE c.gravada10 = :gravada10")
    , @NamedQuery(name = "ComprobantesDetalle.findByGravada5", query = "SELECT c FROM ComprobantesDetalle c WHERE c.gravada5 = :gravada5")
    , @NamedQuery(name = "ComprobantesDetalle.findByImporteTotal", query = "SELECT c FROM ComprobantesDetalle c WHERE c.importeTotal = :importeTotal")
    , @NamedQuery(name = "ComprobantesDetalle.findByTotalIva10", query = "SELECT c FROM ComprobantesDetalle c WHERE c.totalIva10 = :totalIva10")
    , @NamedQuery(name = "ComprobantesDetalle.findByTotalIva5", query = "SELECT c FROM ComprobantesDetalle c WHERE c.totalIva5 = :totalIva5")
    , @NamedQuery(name = "ComprobantesDetalle.findByPorcIva", query = "SELECT c FROM ComprobantesDetalle c WHERE c.porcIva = :porcIva")
    , @NamedQuery(name = "ComprobantesDetalle.findByPorcDescuento", query = "SELECT c FROM ComprobantesDetalle c WHERE c.porcDescuento = :porcDescuento")
    , @NamedQuery(name = "ComprobantesDetalle.findByNumeroCuota", query = "SELECT c FROM ComprobantesDetalle c WHERE c.numeroCuota = :numeroCuota")
    , @NamedQuery(name = "ComprobantesDetalle.findByPorcComision", query = "SELECT c FROM ComprobantesDetalle c WHERE c.porcComision = :porcComision")
    , @NamedQuery(name = "ComprobantesDetalle.findByMontoComision", query = "SELECT c FROM ComprobantesDetalle c WHERE c.montoComision = :montoComision")})
public class ComprobantesDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer identificador;
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal cantidad;
    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;
    private BigDecimal descuento;
    @Column(name = "gravada_10")
    private BigDecimal gravada10;
    @Column(name = "gravada_5")
    private BigDecimal gravada5;
    @Column(name = "importe_total")
    private BigDecimal importeTotal;
    @Column(name = "total_iva10")
    private BigDecimal totalIva10;
    @Column(name = "total_iva5")
    private BigDecimal totalIva5;
    @Column(name = "porc_iva")
    private BigDecimal porcIva;
    @Column(name = "porc_descuento")
    private BigDecimal porcDescuento;
    @Column(name = "numero_cuota")
    private Integer numeroCuota;
    @Column(name = "porc_comision")
    private BigDecimal porcComision;
    @Column(name = "monto_comision")
    private BigDecimal montoComision;
    @JoinColumn(name = "cod_articulo", referencedColumnName = "cod_articulo")
    @ManyToOne(optional = false)
    private Articulos codArticulo;
    @JoinColumn(name = "cod_comprob", referencedColumnName = "cod_compob")
    @ManyToOne(optional = false)
    private ComprobantesCabecera codComprob;
    @JoinColumn(name = "cod_iva", referencedColumnName = "cod_iva")
    @ManyToOne
    private Iva codIva;

    public ComprobantesDetalle() {
    }

    public ComprobantesDetalle(Integer identificador) {
        this.identificador = identificador;
    }

    /*public ComprobantesDetalle(BigDecimal cantidad,BigDecimal precioUnitario,String descripcion) {
        this.cantidad=cantidad;
        this.precioUnitario=precioUnitario;
        this.descripcion=descripcion;
    }*/

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getGravada10() {
        return gravada10;
    }

    public void setGravada10(BigDecimal gravada10) {
        this.gravada10 = gravada10;
    }

    public BigDecimal getGravada5() {
        return gravada5;
    }

    public void setGravada5(BigDecimal gravada5) {
        this.gravada5 = gravada5;
    }

    public BigDecimal getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(BigDecimal importeTotal) {
        this.importeTotal = importeTotal;
    }

    public BigDecimal getTotalIva10() {
        return totalIva10;
    }

    public void setTotalIva10(BigDecimal totalIva10) {
        this.totalIva10 = totalIva10;
    }

    public BigDecimal getTotalIva5() {
        return totalIva5;
    }

    public void setTotalIva5(BigDecimal totalIva5) {
        this.totalIva5 = totalIva5;
    }

    public BigDecimal getPorcIva() {
        return porcIva;
    }

    public void setPorcIva(BigDecimal porcIva) {
        this.porcIva = porcIva;
    }

    public BigDecimal getPorcDescuento() {
        return porcDescuento;
    }

    public void setPorcDescuento(BigDecimal porcDescuento) {
        this.porcDescuento = porcDescuento;
    }

    public Integer getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(Integer numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public BigDecimal getPorcComision() {
        return porcComision;
    }

    public void setPorcComision(BigDecimal porcComision) {
        this.porcComision = porcComision;
    }

    public BigDecimal getMontoComision() {
        return montoComision;
    }

    public void setMontoComision(BigDecimal montoComision) {
        this.montoComision = montoComision;
    }

    public Articulos getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(Articulos codArticulo) {
        this.codArticulo = codArticulo;
    }

    public ComprobantesCabecera getCodComprob() {
        return codComprob;
    }

    public void setCodComprob(ComprobantesCabecera codComprob) {
        this.codComprob = codComprob;
    }

    public Iva getCodIva() {
        return codIva;
    }

    public void setCodIva(Iva codIva) {
        this.codIva = codIva;
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
        if (!(object instanceof ComprobantesDetalle)) {
            return false;
        }
        ComprobantesDetalle other = (ComprobantesDetalle) object;
        if ((this.identificador == null && other.identificador != null) || (this.identificador != null && !this.identificador.equals(other.identificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ComprobantesDetalle[ identificador=" + identificador + " ]";
    }
    
}
