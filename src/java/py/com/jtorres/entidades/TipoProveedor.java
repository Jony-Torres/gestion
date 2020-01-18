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
@Table(name = "tipo_proveedor")
@NamedQueries({
    @NamedQuery(name = "TipoProveedor.findAll", query = "SELECT t FROM TipoProveedor t")
    , @NamedQuery(name = "TipoProveedor.findByCodTipoProv", query = "SELECT t FROM TipoProveedor t WHERE t.codTipoProv = :codTipoProv")
    , @NamedQuery(name = "TipoProveedor.findByDescripcion", query = "SELECT t FROM TipoProveedor t WHERE t.descripcion = :descripcion")})
public class TipoProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tipo_prov")
    private Integer codTipoProv;
    @Basic(optional = false)
    private String descripcion;
    @OneToMany(mappedBy = "codTipoProv")
    private List<Proveedores> proveedoresList;

    public TipoProveedor() {
    }

    public TipoProveedor(Integer codTipoProv) {
        this.codTipoProv = codTipoProv;
    }

    public TipoProveedor(Integer codTipoProv, String descripcion) {
        this.codTipoProv = codTipoProv;
        this.descripcion = descripcion;
    }

    public Integer getCodTipoProv() {
        return codTipoProv;
    }

    public void setCodTipoProv(Integer codTipoProv) {
        this.codTipoProv = codTipoProv;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Proveedores> getProveedoresList() {
        return proveedoresList;
    }

    public void setProveedoresList(List<Proveedores> proveedoresList) {
        this.proveedoresList = proveedoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoProv != null ? codTipoProv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProveedor)) {
            return false;
        }
        TipoProveedor other = (TipoProveedor) object;
        if ((this.codTipoProv == null && other.codTipoProv != null) || (this.codTipoProv != null && !this.codTipoProv.equals(other.codTipoProv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoProveedor[ codTipoProv=" + codTipoProv + " ]";
    }
    
}
