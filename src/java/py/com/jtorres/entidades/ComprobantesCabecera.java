/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.jtorres.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jonathan.torres
 */
@Entity
@Table(name = "comprobantes_cabecera")
@NamedQueries({
    @NamedQuery(name = "ComprobantesCabecera.findAll", query = "SELECT c FROM ComprobantesCabecera c")
    , @NamedQuery(name = "ComprobantesCabecera.findByCodCompob", query = "SELECT c FROM ComprobantesCabecera c WHERE c.codCompob = :codCompob")
    , @NamedQuery(name = "ComprobantesCabecera.findByNumeroComp", query = "SELECT c FROM ComprobantesCabecera c WHERE c.numeroComp = :numeroComp")
    , @NamedQuery(name = "ComprobantesCabecera.findByFechaComprob", query = "SELECT c FROM ComprobantesCabecera c WHERE c.fechaComprob = :fechaComprob")
    , @NamedQuery(name = "ComprobantesCabecera.findByNumeroCompRef", query = "SELECT c FROM ComprobantesCabecera c WHERE c.numeroCompRef = :numeroCompRef")
    , @NamedQuery(name = "ComprobantesCabecera.findByDescuento", query = "SELECT c FROM ComprobantesCabecera c WHERE c.descuento = :descuento")
    , @NamedQuery(name = "ComprobantesCabecera.findByTipCambio", query = "SELECT c FROM ComprobantesCabecera c WHERE c.tipCambio = :tipCambio")
    , @NamedQuery(name = "ComprobantesCabecera.findByTotalComprob", query = "SELECT c FROM ComprobantesCabecera c WHERE c.totalComprob = :totalComprob")
    , @NamedQuery(name = "ComprobantesCabecera.findByTotalGravada", query = "SELECT c FROM ComprobantesCabecera c WHERE c.totalGravada = :totalGravada")
    , @NamedQuery(name = "ComprobantesCabecera.findByTotalExenta", query = "SELECT c FROM ComprobantesCabecera c WHERE c.totalExenta = :totalExenta")
    , @NamedQuery(name = "ComprobantesCabecera.findByTotalIva", query = "SELECT c FROM ComprobantesCabecera c WHERE c.totalIva = :totalIva")
    , @NamedQuery(name = "ComprobantesCabecera.findByCodUsuario", query = "SELECT c FROM ComprobantesCabecera c WHERE c.codUsuario = :codUsuario")
    , @NamedQuery(name = "ComprobantesCabecera.findByComentario", query = "SELECT c FROM ComprobantesCabecera c WHERE c.comentario = :comentario")
    , @NamedQuery(name = "ComprobantesCabecera.findByMontoCuota", query = "SELECT c FROM ComprobantesCabecera c WHERE c.montoCuota = :montoCuota")
    , @NamedQuery(name = "ComprobantesCabecera.findByCobrado", query = "SELECT c FROM ComprobantesCabecera c WHERE c.cobrado = :cobrado")})
public class ComprobantesCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_compob")
    private Integer codCompob;
    @Basic(optional = false)
    @Column(name = "numero_comp")
    private int numeroComp;
    @Basic(optional = false)
    @Column(name = "fecha_comprob")
    @Temporal(TemporalType.DATE)
    private Date fechaComprob;
    @Column(name = "numero_comp_ref")
    private Integer numeroCompRef;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal descuento;
    @Column(name = "tip_cambio")
    private BigDecimal tipCambio;
    @Column(name = "total_comprob")
    private BigDecimal totalComprob;
    @Column(name = "total_gravada")
    private BigDecimal totalGravada;
    @Column(name = "total_exenta")
    private BigDecimal totalExenta;
    @Column(name = "total_iva")
    private BigDecimal totalIva;
    @Column(name = "cod_usuario")
    private String codUsuario;
    private String comentario;
    @Column(name = "monto_cuota")
    private BigDecimal montoCuota;
    private Boolean cobrado;
    private List<SaldosCliente> saldosClienteList;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")
    @ManyToOne(optional = false)
    private Clientes codCliente;
    @JoinColumn(name = "cod_cobrador", referencedColumnName = "cod_cobrador")
    @ManyToOne
    private Cobradores codCobrador;
    @JoinColumn(name = "cod_cond_venta", referencedColumnName = "cod_condicion")
    @ManyToOne(optional = false)
    private CondicionesVentas codCondVenta;
    @JoinColumn(name = "cod_deposito", referencedColumnName = "cod_deposito")
    @ManyToOne(optional = false)
    private ArticulosDeposito codDeposito;
    @JoinColumn(name = "estado", referencedColumnName = "cod_estado")
    @ManyToOne
    private Estados estado;
    @JoinColumn(name = "cod_moneda", referencedColumnName = "cod_moneda")
    @ManyToOne
    private Monedas codMoneda;
    @JoinColumn(name = "cod_comp_serie", referencedColumnName = "cod_comp_serie")
    @ManyToOne(optional = false)
    private ComprobantesSeries codCompSerie;
    @JoinColumn(name = "cod_comp_serie_ref", referencedColumnName = "cod_comp_serie")
    @ManyToOne
    private ComprobantesSeries codCompSerieRef;
    @JoinColumn(name = "cod_sucursal", referencedColumnName = "cod_sucursal")
    @ManyToOne(optional = false)
    private Sucursales codSucursal;
    @JoinColumn(name = "cod_vendedor", referencedColumnName = "cod_vendedor")
    @ManyToOne
    private Vendedores codVendedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codComprob")
    private List<ComprobantesDetalle> comprobantesDetalleList;

    public ComprobantesCabecera() {
    }

    public ComprobantesCabecera(Integer codCompob) {
        this.codCompob = codCompob;
    }

    public ComprobantesCabecera(Integer codCompob, int numeroComp, Date fechaComprob) {
        this.codCompob = codCompob;
        this.numeroComp = numeroComp;
        this.fechaComprob = fechaComprob;
    }

    public Integer getCodCompob() {
        return codCompob;
    }

    public void setCodCompob(Integer codCompob) {
        this.codCompob = codCompob;
    }

    public int getNumeroComp() {
        return numeroComp;
    }

    public void setNumeroComp(int numeroComp) {
        this.numeroComp = numeroComp;
    }

    public Date getFechaComprob() {
        return fechaComprob;
    }

    public void setFechaComprob(Date fechaComprob) {
        this.fechaComprob = fechaComprob;
    }

    public Integer getNumeroCompRef() {
        return numeroCompRef;
    }

    public void setNumeroCompRef(Integer numeroCompRef) {
        this.numeroCompRef = numeroCompRef;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getTipCambio() {
        return tipCambio;
    }

    public void setTipCambio(BigDecimal tipCambio) {
        this.tipCambio = tipCambio;
    }

    public BigDecimal getTotalComprob() {
        return totalComprob;
    }

    public void setTotalComprob(BigDecimal totalComprob) {
        this.totalComprob = totalComprob;
    }

    public BigDecimal getTotalGravada() {
        return totalGravada;
    }

    public void setTotalGravada(BigDecimal totalGravada) {
        this.totalGravada = totalGravada;
    }

    public BigDecimal getTotalExenta() {
        return totalExenta;
    }

    public void setTotalExenta(BigDecimal totalExenta) {
        this.totalExenta = totalExenta;
    }

    public BigDecimal getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(BigDecimal totalIva) {
        this.totalIva = totalIva;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public BigDecimal getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(BigDecimal montoCuota) {
        this.montoCuota = montoCuota;
    }

    public Boolean getCobrado() {
        return cobrado;
    }

    public void setCobrado(Boolean cobrado) {
        this.cobrado = cobrado;
    }
    public List<SaldosCliente> getSaldosClienteList() {
        return saldosClienteList;
    }

    public void setSaldosClienteList(List<SaldosCliente> saldosClienteList) {
        this.saldosClienteList = saldosClienteList;
    }

    public Clientes getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Clientes codCliente) {
        this.codCliente = codCliente;
    }

    public Cobradores getCodCobrador() {
        return codCobrador;
    }

    public void setCodCobrador(Cobradores codCobrador) {
        this.codCobrador = codCobrador;
    }

    public CondicionesVentas getCodCondVenta() {
        return codCondVenta;
    }

    public void setCodCondVenta(CondicionesVentas codCondVenta) {
        this.codCondVenta = codCondVenta;
    }

    public ArticulosDeposito getCodDeposito() {
        return codDeposito;
    }

    public void setCodDeposito(ArticulosDeposito codDeposito) {
        this.codDeposito = codDeposito;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public Monedas getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(Monedas codMoneda) {
        this.codMoneda = codMoneda;
    }

    public ComprobantesSeries getCodCompSerie() {
        return codCompSerie;
    }

    public void setCodCompSerie(ComprobantesSeries codCompSerie) {
        this.codCompSerie = codCompSerie;
    }

    public ComprobantesSeries getCodCompSerieRef() {
        return codCompSerieRef;
    }

    public void setCodCompSerieRef(ComprobantesSeries codCompSerieRef) {
        this.codCompSerieRef = codCompSerieRef;
    }

    public Sucursales getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(Sucursales codSucursal) {
        this.codSucursal = codSucursal;
    }

    public Vendedores getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(Vendedores codVendedor) {
        this.codVendedor = codVendedor;
    }

    public List<ComprobantesDetalle> getComprobantesDetalleList() {
        return comprobantesDetalleList;
    }

    public void setComprobantesDetalleList(List<ComprobantesDetalle> comprobantesDetalleList) {
        this.comprobantesDetalleList = comprobantesDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCompob != null ? codCompob.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobantesCabecera)) {
            return false;
        }
        ComprobantesCabecera other = (ComprobantesCabecera) object;
        if ((this.codCompob == null && other.codCompob != null) || (this.codCompob != null && !this.codCompob.equals(other.codCompob))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ComprobantesCabecera[ codCompob=" + codCompob + " ]";
    }
    
}
