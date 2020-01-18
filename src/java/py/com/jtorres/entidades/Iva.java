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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author jonathan.torres
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Iva.findAll", query = "SELECT i FROM Iva i")
    , @NamedQuery(name = "Iva.findByCodIva", query = "SELECT i FROM Iva i WHERE i.codIva = :codIva")
    , @NamedQuery(name = "Iva.findByDescripcion", query = "SELECT i FROM Iva i WHERE i.descripcion = :descripcion")})
public class Iva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_iva")
    private Integer codIva;
    @Basic(optional = false)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codIva")
    private List<Articulos> articulosList;

    public Iva() {
    }

    public Iva(Integer codIva) {
        this.codIva = codIva;
    }

    public Iva(Integer codIva, String descripcion) {
        this.codIva = codIva;
        this.descripcion = descripcion;
    }

    public Integer getCodIva() {
        return codIva;
    }

    public void setCodIva(Integer codIva) {
        this.codIva = codIva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Articulos> getArticulosList() {
        return articulosList;
    }

    public void setArticulosList(List<Articulos> articulosList) {
        this.articulosList = articulosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codIva != null ? codIva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iva)) {
            return false;
        }
        Iva other = (Iva) object;
        if ((this.codIva == null && other.codIva != null) || (this.codIva != null && !this.codIva.equals(other.codIva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Iva[ codIva=" + codIva + " ]";
    }
    
}
