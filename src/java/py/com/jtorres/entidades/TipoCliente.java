/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.jtorres.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jonathan.torres
 */
@Entity
@Table(name = "tipo_cliente")
@NamedQueries({
    @NamedQuery(name = "TipoCliente.findAll", query = "SELECT t FROM TipoCliente t")
    , @NamedQuery(name = "TipoCliente.findByCodTipCliente", query = "SELECT t FROM TipoCliente t WHERE t.codTipCliente = :codTipCliente")
    , @NamedQuery(name = "TipoCliente.findByDescripcion", query = "SELECT t FROM TipoCliente t WHERE t.descripcion = :descripcion")})
public class TipoCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tip_cliente")
    private Integer codTipCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String descripcion;
    @OneToMany(mappedBy = "codTipCliente")
    private List<Clientes> clientesList;

    public TipoCliente() {
    }

    public TipoCliente(Integer codTipCliente) {
        this.codTipCliente = codTipCliente;
    }

    public TipoCliente(Integer codTipCliente, String descripcion) {
        this.codTipCliente = codTipCliente;
        this.descripcion = descripcion;
    }

    public Integer getCodTipCliente() {
        return codTipCliente;
    }

    public void setCodTipCliente(Integer codTipCliente) {
        this.codTipCliente = codTipCliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (codTipCliente != null ? codTipCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCliente)) {
            return false;
        }
        TipoCliente other = (TipoCliente) object;
        if ((this.codTipCliente == null && other.codTipCliente != null) || (this.codTipCliente != null && !this.codTipCliente.equals(other.codTipCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.jtorres.entidades.TipoCliente[ codTipCliente=" + codTipCliente + " ]";
    }
    
}
