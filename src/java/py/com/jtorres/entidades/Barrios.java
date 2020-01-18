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
    @NamedQuery(name = "Barrios.findAll", query = "SELECT b FROM Barrios b")
    , @NamedQuery(name = "Barrios.findByCodBarrio", query = "SELECT b FROM Barrios b WHERE b.codBarrio = :codBarrio")
    , @NamedQuery(name = "Barrios.findByDescBarrio", query = "SELECT b FROM Barrios b WHERE b.descBarrio = :descBarrio")})
public class Barrios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_barrio")
    private Integer codBarrio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "desc_barrio")
    private String descBarrio;
    @JoinColumn(name = "cod_ciudad", referencedColumnName = "cod_ciudad")
    @ManyToOne(optional = false)
    private Ciudades codCiudad;
    @OneToMany(mappedBy = "codBarrio")
    private List<Personas> personasList;

    public Barrios() {
    }

    public Barrios(Integer codBarrio) {
        this.codBarrio = codBarrio;
    }

    public Barrios(Integer codBarrio, String descBarrio) {
        this.codBarrio = codBarrio;
        this.descBarrio = descBarrio;
    }

    public Integer getCodBarrio() {
        return codBarrio;
    }

    public void setCodBarrio(Integer codBarrio) {
        this.codBarrio = codBarrio;
    }

    public String getDescBarrio() {
        return descBarrio;
    }

    public void setDescBarrio(String descBarrio) {
        this.descBarrio = descBarrio;
    }

    public Ciudades getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(Ciudades codCiudad) {
        this.codCiudad = codCiudad;
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
        hash += (codBarrio != null ? codBarrio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barrios)) {
            return false;
        }
        Barrios other = (Barrios) object;
        if ((this.codBarrio == null && other.codBarrio != null) || (this.codBarrio != null && !this.codBarrio.equals(other.codBarrio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.jtorres.entidades.Barrios[ codBarrio=" + codBarrio + " ]";
    }
    
}
