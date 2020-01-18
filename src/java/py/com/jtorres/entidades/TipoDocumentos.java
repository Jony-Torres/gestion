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
@Table(name = "tipo_documentos")
@NamedQueries({
    @NamedQuery(name = "TipoDocumentos.findAll", query = "SELECT t FROM TipoDocumentos t")
    , @NamedQuery(name = "TipoDocumentos.findByCodTipoDoc", query = "SELECT t FROM TipoDocumentos t WHERE t.codTipoDoc = :codTipoDoc")
    , @NamedQuery(name = "TipoDocumentos.findByDescTipoDoc", query = "SELECT t FROM TipoDocumentos t WHERE t.descTipoDoc = :descTipoDoc")})
public class TipoDocumentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_tipo_doc")
    private String codTipoDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "desc_tipo_doc")
    private String descTipoDoc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipoDoc")
    private List<Personas> personasList;

    public TipoDocumentos() {
    }

    public TipoDocumentos(String codTipoDoc) {
        this.codTipoDoc = codTipoDoc;
    }

    public TipoDocumentos(String codTipoDoc, String descTipoDoc) {
        this.codTipoDoc = codTipoDoc;
        this.descTipoDoc = descTipoDoc;
    }

    public String getCodTipoDoc() {
        return codTipoDoc;
    }

    public void setCodTipoDoc(String codTipoDoc) {
        this.codTipoDoc = codTipoDoc;
    }

    public String getDescTipoDoc() {
        return descTipoDoc;
    }

    public void setDescTipoDoc(String descTipoDoc) {
        this.descTipoDoc = descTipoDoc;
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
        hash += (codTipoDoc != null ? codTipoDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumentos)) {
            return false;
        }
        TipoDocumentos other = (TipoDocumentos) object;
        if ((this.codTipoDoc == null && other.codTipoDoc != null) || (this.codTipoDoc != null && !this.codTipoDoc.equals(other.codTipoDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.jtorres.entidades.TipoDocumentos[ codTipoDoc=" + codTipoDoc + " ]";
    }
    
}
