/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.jtorres.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jonathan.torres
 */
@Entity
@Table(name = "saldos_cliente")
@NamedQueries({
    @NamedQuery(name = "SaldosCliente.findAll", query = "SELECT s FROM SaldosCliente s")
    , @NamedQuery(name = "SaldosCliente.findByCodSaldo", query = "SELECT s FROM SaldosCliente s WHERE s.codSaldo = :codSaldo")
    , @NamedQuery(name = "SaldosCliente.findByNumeroComp", query = "SELECT s FROM SaldosCliente s WHERE s.numeroComp = :numeroComp")
    , @NamedQuery(name = "SaldosCliente.findByNumeroCuota", query = "SELECT s FROM SaldosCliente s WHERE s.numeroCuota = :numeroCuota")
    , @NamedQuery(name = "SaldosCliente.findByFechaVencimiento", query = "SELECT s FROM SaldosCliente s WHERE s.fechaVencimiento = :fechaVencimiento")
    , @NamedQuery(name = "SaldosCliente.findByMontoCuota", query = "SELECT s FROM SaldosCliente s WHERE s.montoCuota = :montoCuota")
    , @NamedQuery(name = "SaldosCliente.findByCodMoneda", query = "SELECT s FROM SaldosCliente s WHERE s.codMoneda = :codMoneda")
    , @NamedQuery(name = "SaldosCliente.findBySaldoCuota", query = "SELECT s FROM SaldosCliente s WHERE s.saldoCuota = :saldoCuota")
    , @NamedQuery(name = "SaldosCliente.findByCodUsuario", query = "SELECT s FROM SaldosCliente s WHERE s.codUsuario = :codUsuario")})
public class SaldosCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_saldo")
    private Integer codSaldo;
    @Basic(optional = false)
    @Column(name = "numero_comp")
    private int numeroComp;
    @Column(name = "numero_cuota")
    private Integer numeroCuota;
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto_cuota")
    private BigDecimal montoCuota;
    @Column(name = "cod_moneda")
    private Integer codMoneda;
    @Column(name = "saldo_cuota")
    private BigDecimal saldoCuota;
    @Column(name = "cod_usuario")
    private String codUsuario;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")
    @ManyToOne
    private Clientes codCliente;
    @JoinColumn(name = "cod_comp", referencedColumnName = "cod_compob")
    @ManyToOne(optional = false)
    private ComprobantesCabecera codComp;
    @JoinColumn(name = "cod_sucursal", referencedColumnName = "cod_sucursal")
    @ManyToOne
    private Sucursales codSucursal;

    public SaldosCliente() {
    }

    public SaldosCliente(Integer codSaldo) {
        this.codSaldo = codSaldo;
    }

    public SaldosCliente(Integer codSaldo, int numeroComp) {
        this.codSaldo = codSaldo;
        this.numeroComp = numeroComp;
    }

    public Integer getCodSaldo() {
        return codSaldo;
    }

    public void setCodSaldo(Integer codSaldo) {
        this.codSaldo = codSaldo;
    }

    public int getNumeroComp() {
        return numeroComp;
    }

    public void setNumeroComp(int numeroComp) {
        this.numeroComp = numeroComp;
    }

    public Integer getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(Integer numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public BigDecimal getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(BigDecimal montoCuota) {
        this.montoCuota = montoCuota;
    }

    public Integer getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(Integer codMoneda) {
        this.codMoneda = codMoneda;
    }

    public BigDecimal getSaldoCuota() {
        return saldoCuota;
    }

    public void setSaldoCuota(BigDecimal saldoCuota) {
        this.saldoCuota = saldoCuota;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Clientes getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Clientes codCliente) {
        this.codCliente = codCliente;
    }

    public ComprobantesCabecera getCodComp() {
        return codComp;
    }

    public void setCodComp(ComprobantesCabecera codComp) {
        this.codComp = codComp;
    }

    public Sucursales getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(Sucursales codSucursal) {
        this.codSucursal = codSucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSaldo != null ? codSaldo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaldosCliente)) {
            return false;
        }
        SaldosCliente other = (SaldosCliente) object;
        if ((this.codSaldo == null && other.codSaldo != null) || (this.codSaldo != null && !this.codSaldo.equals(other.codSaldo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.SaldosCliente[ codSaldo=" + codSaldo + " ]";
    }
    
}
