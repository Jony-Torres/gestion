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
    @NamedQuery(name = "Vendedores.findAll", query = "SELECT v FROM Vendedores v")
    , @NamedQuery(name = "Vendedores.findByCodVendedor", query = "SELECT v FROM Vendedores v WHERE v.codVendedor = :codVendedor")
    , @NamedQuery(name = "Vendedores.findByCodZona", query = "SELECT v FROM Vendedores v WHERE v.codZona = :codZona")
    , @NamedQuery(name = "Vendedores.findByDescripcion", query = "SELECT v FROM Vendedores v WHERE v.descripcion = :descripcion")
    , @NamedQuery(name = "Vendedores.findByPorcComision", query = "SELECT v FROM Vendedores v WHERE v.porcComision = :porcComision")
    , @NamedQuery(name = "Vendedores.findByEstado", query = "SELECT v FROM Vendedores v WHERE v.estado = :estado")})
public class Vendedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_vendedor")
    private Integer codVendedor;
    @Column(name = "cod_zona")
    private Integer codZona;
    @Size(max = 100)
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porc_comision")
    private BigDecimal porcComision;
    @Size(max = 1)
    private String estado;
    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona")
    @ManyToOne(optional = false)
    private Personas codPersona;
    @OneToMany(mappedBy = "codVendedor")
    private List<Clientes> clientesList;

    public Vendedores() {
    }

    public Vendedores(Integer codVendedor) {
        this.codVendedor = codVendedor;
    }

    public Integer getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(Integer codVendedor) {
        this.codVendedor = codVendedor;
    }

    public Integer getCodZona() {
        return codZona;
    }

    public void setCodZona(Integer codZona) {
        this.codZona = codZona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (codVendedor != null ? codVendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedores)) {
            return false;
        }
        Vendedores other = (Vendedores) object;
        if ((this.codVendedor == null && other.codVendedor != null) || (this.codVendedor != null && !this.codVendedor.equals(other.codVendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.jtorres.entidades.Vendedores[ codVendedor=" + codVendedor + " ]";
    }
    
}
