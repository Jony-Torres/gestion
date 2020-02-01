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

/**
 *
 * @author jonathan.torres
 */
@Entity
@Table(name = "tipo_comprobantes")
@NamedQueries({
    @NamedQuery(name = "TipoComprobantes.findAll", query = "SELECT t FROM TipoComprobantes t")
    , @NamedQuery(name = "TipoComprobantes.findByCodTipoComp", query = "SELECT t FROM TipoComprobantes t WHERE t.codTipoComp = :codTipoComp")
    , @NamedQuery(name = "TipoComprobantes.findByAbreviacion", query = "SELECT t FROM TipoComprobantes t WHERE t.abreviacion = :abreviacion")
    , @NamedQuery(name = "TipoComprobantes.findByDescripcion", query = "SELECT t FROM TipoComprobantes t WHERE t.descripcion = :descripcion")})
public class TipoComprobantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tipo_comp")
    private Integer codTipoComp;
    @Basic(optional = false)
    private String abreviacion;
    @Basic(optional = false)
    private String descripcion;
    @OneToMany(mappedBy = "codTipoComp")
    private List<ComprobantesSeries> comprobantesSeriesList;

    public TipoComprobantes() {
    }

    public TipoComprobantes(Integer codTipoComp) {
        this.codTipoComp = codTipoComp;
    }

    public TipoComprobantes(Integer codTipoComp, String abreviacion, String descripcion) {
        this.codTipoComp = codTipoComp;
        this.abreviacion = abreviacion;
        this.descripcion = descripcion;
    }

    public Integer getCodTipoComp() {
        return codTipoComp;
    }

    public void setCodTipoComp(Integer codTipoComp) {
        this.codTipoComp = codTipoComp;
    }

    public String getAbreviacion() {
        return abreviacion;
    }

    public void setAbreviacion(String abreviacion) {
        this.abreviacion = abreviacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<ComprobantesSeries> getComprobantesSeriesList() {
        return comprobantesSeriesList;
    }

    public void setComprobantesSeriesList(List<ComprobantesSeries> comprobantesSeriesList) {
        this.comprobantesSeriesList = comprobantesSeriesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoComp != null ? codTipoComp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoComprobantes)) {
            return false;
        }
        TipoComprobantes other = (TipoComprobantes) object;
        if ((this.codTipoComp == null && other.codTipoComp != null) || (this.codTipoComp != null && !this.codTipoComp.equals(other.codTipoComp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoComprobantes[ codTipoComp=" + codTipoComp + " ]";
    }
    
}
