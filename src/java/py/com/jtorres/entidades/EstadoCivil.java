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
@Table(name = "estado_civil")
@NamedQueries({
    @NamedQuery(name = "EstadoCivil.findAll", query = "SELECT e FROM EstadoCivil e")
    , @NamedQuery(name = "EstadoCivil.findByCodEstadoCivil", query = "SELECT e FROM EstadoCivil e WHERE e.codEstadoCivil = :codEstadoCivil")
    , @NamedQuery(name = "EstadoCivil.findByDescEstadoCivil", query = "SELECT e FROM EstadoCivil e WHERE e.descEstadoCivil = :descEstadoCivil")})
public class EstadoCivil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_estado_civil")
    private String codEstadoCivil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "desc_estado_civil")
    private String descEstadoCivil;
    @OneToMany(mappedBy = "codEstadoCivil")
    private List<Personas> personasList;

    public EstadoCivil() {
    }

    public EstadoCivil(String codEstadoCivil) {
        this.codEstadoCivil = codEstadoCivil;
    }

    public EstadoCivil(String codEstadoCivil, String descEstadoCivil) {
        this.codEstadoCivil = codEstadoCivil;
        this.descEstadoCivil = descEstadoCivil;
    }

    public String getCodEstadoCivil() {
        return codEstadoCivil;
    }

    public void setCodEstadoCivil(String codEstadoCivil) {
        this.codEstadoCivil = codEstadoCivil;
    }

    public String getDescEstadoCivil() {
        return descEstadoCivil;
    }

    public void setDescEstadoCivil(String descEstadoCivil) {
        this.descEstadoCivil = descEstadoCivil;
    }

    public List<Personas> getPersonasList() {
        return personasList;
    }

    public void setPersonasList(List<Personas> personasList) {
        this.personasList = personasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEstadoCivil != null ? codEstadoCivil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCivil)) {
            return false;
        }
        EstadoCivil other = (EstadoCivil) object;
        if ((this.codEstadoCivil == null && other.codEstadoCivil != null) || (this.codEstadoCivil != null && !this.codEstadoCivil.equals(other.codEstadoCivil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.jtorres.entidades.EstadoCivil[ codEstadoCivil=" + codEstadoCivil + " ]";
    }
    
}
