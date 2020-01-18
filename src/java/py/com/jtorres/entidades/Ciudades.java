/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.jtorres.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jonathan.torres
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Ciudades.findAll", query = "SELECT c FROM Ciudades c")
    , @NamedQuery(name = "Ciudades.findByCodCiudad", query = "SELECT c FROM Ciudades c WHERE c.codCiudad = :codCiudad")
    , @NamedQuery(name = "Ciudades.findByDescCiudad", query = "SELECT c FROM Ciudades c WHERE c.descCiudad = :descCiudad")})
public class Ciudades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_ciudad")
    private Integer codCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "desc_ciudad")
    private String descCiudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCiudad")
    private List<Barrios> barriosList;
    @OneToMany(mappedBy = "codCiudad")
    private List<Personas> personasList;
    @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento")
    @ManyToOne(optional = false)
    private Departamentos codDepartamento;

    public Ciudades() {
    }

    public Ciudades(Integer codCiudad) {
        this.codCiudad = codCiudad;
    }

    public Ciudades(Integer codCiudad, String descCiudad) {
        this.codCiudad = codCiudad;
        this.descCiudad = descCiudad;
    }

    public Integer getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(Integer codCiudad) {
        this.codCiudad = codCiudad;
    }

    public String getDescCiudad() {
        return descCiudad;
    }

    public void setDescCiudad(String descCiudad) {
        this.descCiudad = descCiudad;
    }

    public List<Barrios> getBarriosList() {
        return barriosList;
    }

    public void setBarriosList(List<Barrios> barriosList) {
        this.barriosList = barriosList;
    }

    public List<Personas> getPersonasList() {
        return personasList;
    }

    public void setPersonasList(List<Personas> personasList) {
        this.personasList = personasList;
    }

    public Departamentos getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(Departamentos codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCiudad != null ? codCiudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudades)) {
            return false;
        }
        Ciudades other = (Ciudades) object;
        if ((this.codCiudad == null && other.codCiudad != null) || (this.codCiudad != null && !this.codCiudad.equals(other.codCiudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.jtorres.entidades.Ciudades[ codCiudad=" + codCiudad + " ]";
    }
    
}
