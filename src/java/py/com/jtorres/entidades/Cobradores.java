/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.jtorres.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

/**
 *
 * @author jonathan.torres
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Cobradores.findAll", query = "SELECT c FROM Cobradores c")
    , @NamedQuery(name = "Cobradores.findByCodCobrador", query = "SELECT c FROM Cobradores c WHERE c.codCobrador = :codCobrador")
    , @NamedQuery(name = "Cobradores.findByCodZona", query = "SELECT c FROM Cobradores c WHERE c.codZona = :codZona")
    , @NamedQuery(name = "Cobradores.findByPorcComision", query = "SELECT c FROM Cobradores c WHERE c.porcComision = :porcComision")
    , @NamedQuery(name = "Cobradores.findByEstado", query = "SELECT c FROM Cobradores c WHERE c.estado = :estado")})
public class Cobradores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_cobrador")
    private Integer codCobrador;
    @Column(name = "cod_zona")
    private Integer codZona;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porc_comision")
    private BigDecimal porcComision;
    @Size(max = 1)
    private String estado;
    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona")
    @ManyToOne(optional = false)
    private Personas codPersona;
    @OneToMany(mappedBy = "codCobrador")
    private List<Clientes> clientesList;

    public Cobradores() {
    }

    public Cobradores(Integer codCobrador) {
        this.codCobrador = codCobrador;
    }

    public Integer getCodCobrador() {
        return codCobrador;
    }

    public void setCodCobrador(Integer codCobrador) {
        this.codCobrador = codCobrador;
    }

    public Integer getCodZona() {
        return codZona;
    }

    public void setCodZona(Integer codZona) {
        this.codZona = codZona;
    }

    public BigDecimal getPorcComision() {
        return porcComision;
    }

    public void setPorcComision(BigDecimal porcComision) {
        this.porcComision = porcComision;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Personas getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Personas codPersona) {
        this.codPersona = codPersona;
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
        hash += (codCobrador != null ? codCobrador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cobradores)) {
            return false;
        }
        Cobradores other = (Cobradores) object;
        if ((this.codCobrador == null && other.codCobrador != null) || (this.codCobrador != null && !this.codCobrador.equals(other.codCobrador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.jtorres.entidades.Cobradores[ codCobrador=" + codCobrador + " ]";
    }
    
}
