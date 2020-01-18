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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jonathan.torres
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Monedas.findAll", query = "SELECT m FROM Monedas m")
    , @NamedQuery(name = "Monedas.findByCodMoneda", query = "SELECT m FROM Monedas m WHERE m.codMoneda = :codMoneda")
    , @NamedQuery(name = "Monedas.findByDescMoneda", query = "SELECT m FROM Monedas m WHERE m.descMoneda = :descMoneda")
    , @NamedQuery(name = "Monedas.findBySiglas", query = "SELECT m FROM Monedas m WHERE m.siglas = :siglas")
    , @NamedQuery(name = "Monedas.findByDecimales", query = "SELECT m FROM Monedas m WHERE m.decimales = :decimales")
    , @NamedQuery(name = "Monedas.findByTipoCambio", query = "SELECT m FROM Monedas m WHERE m.tipoCambio = :tipoCambio")
    , @NamedQuery(name = "Monedas.findByTipCambComp", query = "SELECT m FROM Monedas m WHERE m.tipCambComp = :tipCambComp")
    , @NamedQuery(name = "Monedas.findByEstado", query = "SELECT m FROM Monedas m WHERE m.estado = :estado")
    , @NamedQuery(name = "Monedas.findByRedondeo", query = "SELECT m FROM Monedas m WHERE m.redondeo = :redondeo")})
public class Monedas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_moneda")
    private String codMoneda;
    @Size(max = 100)
    @Column(name = "desc_moneda")
    private String descMoneda;
    @Size(max = 10)
    private String siglas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal decimales;
    @Column(name = "tipo_cambio")
    private BigDecimal tipoCambio;
    @Column(name = "tip_camb_comp")
    private BigDecimal tipCambComp;
    @Size(max = 5)
    private String estado;
    private Integer redondeo;
    @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais")
    @ManyToOne
    private Paises codPais;
    @OneToMany(mappedBy = "codMoneda")
    private List<Clientes> clientesList;

    public Monedas() {
    }

    public Monedas(String codMoneda) {
        this.codMoneda = codMoneda;
    }

    public String getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(String codMoneda) {
        this.codMoneda = codMoneda;
    }

    public String getDescMoneda() {
        return descMoneda;
    }

    public void setDescMoneda(String descMoneda) {
        this.descMoneda = descMoneda;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public BigDecimal getDecimales() {
        return decimales;
    }

    public void setDecimales(BigDecimal decimales) {
        this.decimales = decimales;
    }

    public BigDecimal getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(BigDecimal tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public BigDecimal getTipCambComp() {
        return tipCambComp;
    }

    public void setTipCambComp(BigDecimal tipCambComp) {
        this.tipCambComp = tipCambComp;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getRedondeo() {
        return redondeo;
    }

    public void setRedondeo(Integer redondeo) {
        this.redondeo = redondeo;
    }

    public Paises getCodPais() {
        return codPais;
    }

    public void setCodPais(Paises codPais) {
        this.codPais = codPais;
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
        hash += (codMoneda != null ? codMoneda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Monedas)) {
            return false;
        }
        Monedas other = (Monedas) object;
        if ((this.codMoneda == null && other.codMoneda != null) || (this.codMoneda != null && !this.codMoneda.equals(other.codMoneda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.jtorres.entidades.Monedas[ codMoneda=" + codMoneda + " ]";
    }
    
}
