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
import javax.validation.constraints.Size;

/**
 *
 * @author jonathan.torres
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")
    , @NamedQuery(name = "Clientes.findByCodCliente", query = "SELECT c FROM Clientes c WHERE c.codCliente = :codCliente")
    , @NamedQuery(name = "Clientes.findByLimiteCredito", query = "SELECT c FROM Clientes c WHERE c.limiteCredito = :limiteCredito")
    , @NamedQuery(name = "Clientes.findByComentario", query = "SELECT c FROM Clientes c WHERE c.comentario = :comentario")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_cliente")
    private Integer codCliente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "limite_credito")
    private BigDecimal limiteCredito;
    @Size(max = 1000)
    private String comentario;
    @JoinColumn(name = "cod_cobrador", referencedColumnName = "cod_cobrador")
    @ManyToOne
    private Cobradores codCobrador;
    @JoinColumn(name = "cod_cond_venta", referencedColumnName = "cod_condicion")
    @ManyToOne
    private CondicionesVentas codCondVenta;
    @JoinColumn(name = "estado", referencedColumnName = "cod_estado")
    @ManyToOne
    private Estados estado;
    @JoinColumn(name = "cod_moneda", referencedColumnName = "cod_moneda")
    @ManyToOne
    private Monedas codMoneda;
    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona")
    @ManyToOne(optional = false)
    private Personas codPersona;
    @JoinColumn(name = "cod_tip_cliente", referencedColumnName = "cod_tip_cliente")
    @ManyToOne
    private TipoCliente codTipCliente;
    @JoinColumn(name = "cod_vendedor", referencedColumnName = "cod_vendedor")
    @ManyToOne
    private Vendedores codVendedor;

    public Clientes() {
    }

    public Clientes(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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

    public Personas getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Personas codPersona) {
        this.codPersona = codPersona;
    }

    public TipoCliente getCodTipCliente() {
        return codTipCliente;
    }

    public void setCodTipCliente(TipoCliente codTipCliente) {
        this.codTipCliente = codTipCliente;
    }

    public Vendedores getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(Vendedores codVendedor) {
        this.codVendedor = codVendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCliente != null ? codCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.codCliente == null && other.codCliente != null) || (this.codCliente != null && !this.codCliente.equals(other.codCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.jtorres.entidades.Clientes[ codCliente=" + codCliente + " ]";
    }
    
}
