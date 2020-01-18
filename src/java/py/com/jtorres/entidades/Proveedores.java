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

/**
 *
 * @author jonathan.torres
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Proveedores.findAll", query = "SELECT p FROM Proveedores p")
    , @NamedQuery(name = "Proveedores.findByCodProveedor", query = "SELECT p FROM Proveedores p WHERE p.codProveedor = :codProveedor")
    , @NamedQuery(name = "Proveedores.findByRazonSocial", query = "SELECT p FROM Proveedores p WHERE p.razonSocial = :razonSocial")})
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_proveedor")
    private Integer codProveedor;
    @Column(name = "razon_social")
    private String razonSocial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProveedor")
    private List<Articulos> articulosList;
    @JoinColumn(name = "estado", referencedColumnName = "cod_estado")
    @ManyToOne
    private Estados estado;
    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona")
    @ManyToOne(optional = false)
    private Personas codPersona;
    @JoinColumn(name = "cod_tipo_prov", referencedColumnName = "cod_tipo_prov")
    @ManyToOne
    private TipoProveedor codTipoProv;

    public Proveedores() {
    }

    public Proveedores(Integer codProveedor) {
        this.codProveedor = codProveedor;
    }

    public Integer getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(Integer codProveedor) {
        this.codProveedor = codProveedor;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public List<Articulos> getArticulosList() {
        return articulosList;
    }

    public void setArticulosList(List<Articulos> articulosList) {
        this.articulosList = articulosList;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public Personas getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Personas codPersona) {
        this.codPersona = codPersona;
    }

    public TipoProveedor getCodTipoProv() {
        return codTipoProv;
    }

    public void setCodTipoProv(TipoProveedor codTipoProv) {
        this.codTipoProv = codTipoProv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProveedor != null ? codProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedores)) {
            return false;
        }
        Proveedores other = (Proveedores) object;
        if ((this.codProveedor == null && other.codProveedor != null) || (this.codProveedor != null && !this.codProveedor.equals(other.codProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Proveedores[ codProveedor=" + codProveedor + " ]";
    }
    
}
