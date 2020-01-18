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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jonathan.torres
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Estados.findAll", query = "SELECT e FROM Estados e")
    , @NamedQuery(name = "Estados.findByCodEstado", query = "SELECT e FROM Estados e WHERE e.codEstado = :codEstado")
    , @NamedQuery(name = "Estados.findByDescEstado", query = "SELECT e FROM Estados e WHERE e.descEstado = :descEstado")
    , @NamedQuery(name = "Estados.findByAbreviacion", query = "SELECT e FROM Estados e WHERE e.abreviacion = :abreviacion")
    , @NamedQuery(name = "Estados.findByTablaRef", query = "SELECT e FROM Estados e WHERE e.tablaRef = :tablaRef")})
public class Estados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_estado")
    private Integer codEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "desc_estado")
    private String descEstado;
    @Size(max = 20)
    private String abreviacion;
    @Size(max = 50)
    @Column(name = "tabla_ref")
    private String tablaRef;
    @OneToMany(mappedBy = "estado")
    private List<Clientes> clientesList;

    public Estados() {
    }

    public Estados(Integer codEstado) {
        this.codEstado = codEstado;
    }

    public Estados(Integer codEstado, String descEstado) {
        this.codEstado = codEstado;
        this.descEstado = descEstado;
    }

    public Integer getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(Integer codEstado) {
        this.codEstado = codEstado;
    }

    public String getDescEstado() {
        return descEstado;
    }

    public void setDescEstado(String descEstado) {
        this.descEstado = descEstado;
    }

    public String getAbreviacion() {
        return abreviacion;
    }

    public void setAbreviacion(String abreviacion) {
        this.abreviacion = abreviacion;
    }

    public String getTablaRef() {
        return tablaRef;
    }

    public void setTablaRef(String tablaRef) {
        this.tablaRef = tablaRef;
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
        hash += (codEstado != null ? codEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estados)) {
            return false;
        }
        Estados other = (Estados) object;
        if ((this.codEstado == null && other.codEstado != null) || (this.codEstado != null && !this.codEstado.equals(other.codEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.jtorres.entidades.Estados[ codEstado=" + codEstado + " ]";
    }
    
}
