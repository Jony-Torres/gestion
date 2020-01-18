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

/**
 *
 * @author jonathan.torres
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Articulos.findAll", query = "SELECT a FROM Articulos a")
    , @NamedQuery(name = "Articulos.findByCodArticulo", query = "SELECT a FROM Articulos a WHERE a.codArticulo = :codArticulo")
    , @NamedQuery(name = "Articulos.findByCodReferencia", query = "SELECT a FROM Articulos a WHERE a.codReferencia = :codReferencia")
    , @NamedQuery(name = "Articulos.findByNumeroLote", query = "SELECT a FROM Articulos a WHERE a.numeroLote = :numeroLote")
    , @NamedQuery(name = "Articulos.findByDescripcion", query = "SELECT a FROM Articulos a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Articulos.findByPrecioCompra", query = "SELECT a FROM Articulos a WHERE a.precioCompra = :precioCompra")
    , @NamedQuery(name = "Articulos.findByPrecioVenta", query = "SELECT a FROM Articulos a WHERE a.precioVenta = :precioVenta")
    , @NamedQuery(name = "Articulos.findByCantidadCtrl", query = "SELECT a FROM Articulos a WHERE a.cantidadCtrl = :cantidadCtrl")
    , @NamedQuery(name = "Articulos.findByStockCtrl", query = "SELECT a FROM Articulos a WHERE a.stockCtrl = :stockCtrl")})
public class Articulos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_articulo")
    private Integer codArticulo;
    @Column(name = "cod_referencia")
    private String codReferencia;
    @Column(name = "numero_lote")
    private String numeroLote;
    @Basic(optional = false)
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_compra")
    private BigDecimal precioCompra;
    @Column(name = "precio_venta")
    private BigDecimal precioVenta;
    @Column(name = "cantidad_ctrl")
    private Integer cantidadCtrl;
    @Column(name = "stock_ctrl")
    private Boolean stockCtrl;
    @JoinColumn(name = "cod_categoria", referencedColumnName = "cod_categoria")
    @ManyToOne
    private Categorias codCategoria;
    @JoinColumn(name = "estado", referencedColumnName = "cod_estado")
    @ManyToOne(optional = false)
    private Estados estado;
    @JoinColumn(name = "cod_iva", referencedColumnName = "cod_iva")
    @ManyToOne(optional = false)
    private Iva codIva;
    @JoinColumn(name = "cod_marca", referencedColumnName = "cod_marca")
    @ManyToOne
    private Marcas codMarca;
    @JoinColumn(name = "cod_proveedor", referencedColumnName = "cod_proveedor")
    @ManyToOne(optional = false)
    private Proveedores codProveedor;
    @JoinColumn(name = "cod_uni_med", referencedColumnName = "cod_uni_medida")
    @ManyToOne(optional = false)
    private UnidadesMedidas codUniMed;

    public Articulos() {
    }

    public Articulos(Integer codArticulo) {
        this.codArticulo = codArticulo;
    }

    public Articulos(Integer codArticulo, String descripcion) {
        this.codArticulo = codArticulo;
        this.descripcion = descripcion;
    }

    public Integer getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(Integer codArticulo) {
        this.codArticulo = codArticulo;
    }

    public String getCodReferencia() {
        return codReferencia;
    }

    public void setCodReferencia(String codReferencia) {
        this.codReferencia = codReferencia;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadCtrl() {
        return cantidadCtrl;
    }

    public void setCantidadCtrl(Integer cantidadCtrl) {
        this.cantidadCtrl = cantidadCtrl;
    }

    public Boolean getStockCtrl() {
        return stockCtrl;
    }

    public void setStockCtrl(Boolean stockCtrl) {
        this.stockCtrl = stockCtrl;
    }

    public Categorias getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(Categorias codCategoria) {
        this.codCategoria = codCategoria;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public Iva getCodIva() {
        return codIva;
    }

    public void setCodIva(Iva codIva) {
        this.codIva = codIva;
    }

    public Marcas getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(Marcas codMarca) {
        this.codMarca = codMarca;
    }

    public Proveedores getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(Proveedores codProveedor) {
        this.codProveedor = codProveedor;
    }

    public UnidadesMedidas getCodUniMed() {
        return codUniMed;
    }

    public void setCodUniMed(UnidadesMedidas codUniMed) {
        this.codUniMed = codUniMed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codArticulo != null ? codArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulos)) {
            return false;
        }
        Articulos other = (Articulos) object;
        if ((this.codArticulo == null && other.codArticulo != null) || (this.codArticulo != null && !this.codArticulo.equals(other.codArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Articulos[ codArticulo=" + codArticulo + " ]";
    }
    
}
