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
import javax.persistence.Table;

/**
 *
 * @author jonathan.torres
 */
@Entity
@Table(name = "unidades_medidas")
@NamedQueries({
    @NamedQuery(name = "UnidadesMedidas.findAll", query = "SELECT u FROM UnidadesMedidas u")
    , @NamedQuery(name = "UnidadesMedidas.findByCodUniMedida", query = "SELECT u FROM UnidadesMedidas u WHERE u.codUniMedida = :codUniMedida")
    , @NamedQuery(name = "UnidadesMedidas.findByDescripcion", query = "SELECT u FROM UnidadesMedidas u WHERE u.descripcion = :descripcion")})
public class UnidadesMedidas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_uni_medida")
    private Integer codUniMedida;
    @Basic(optional = false)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codUniMed")
    private List<Articulos> articulosList;

    public UnidadesMedidas() {
    }

    public UnidadesMedidas(Integer codUniMedida) {
        this.codUniMedida = codUniMedida;
    }

    public UnidadesMedidas(Integer codUniMedida, String descripcion) {
        this.codUniMedida = codUniMedida;
        this.descripcion = descripcion;
    }

    public Integer getCodUniMedida() {
        return codUniMedida;
    }

    public void setCodUniMedida(Integer codUniMedida) {
        this.codUniMedida = codUniMedida;
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
        hash += (codUniMedida != null ? codUniMedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadesMedidas)) {
            return false;
        }
        UnidadesMedidas other = (UnidadesMedidas) object;
        if ((this.codUniMedida == null && other.codUniMedida != null) || (this.codUniMedida != null && !this.codUniMedida.equals(other.codUniMedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.UnidadesMedidas[ codUniMedida=" + codUniMedida + " ]";
    }
    
}
