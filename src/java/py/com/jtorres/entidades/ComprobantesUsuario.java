/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.jtorres.entidades;

import java.io.Serializable;
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
import javax.persistence.Table;

/**
 *
 * @author jonathan.torres
 */
@Entity
@Table(name = "comprobantes_usuario")
@NamedQueries({
    @NamedQuery(name = "ComprobantesUsuario.findAll", query = "SELECT c FROM ComprobantesUsuario c")
    , @NamedQuery(name = "ComprobantesUsuario.findByIdentificador", query = "SELECT c FROM ComprobantesUsuario c WHERE c.identificador = :identificador")
    , @NamedQuery(name = "ComprobantesUsuario.findByCodUsuario", query = "SELECT c FROM ComprobantesUsuario c WHERE c.codUsuario = :codUsuario")})
public class ComprobantesUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer identificador;
    @Column(name = "cod_usuario")
    private String codUsuario;
    @JoinColumn(name = "cod_comp_serie", referencedColumnName = "cod_comp_serie")
    @ManyToOne
    private ComprobantesSeries codCompSerie;
    @JoinColumn(name = "estado", referencedColumnName = "cod_estado")
    @ManyToOne
    private Estados estado;

    public ComprobantesUsuario() {
    }

    public ComprobantesUsuario(Integer identificador) {
        this.identificador = identificador;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public ComprobantesSeries getCodCompSerie() {
        return codCompSerie;
    }

    public void setCodCompSerie(ComprobantesSeries codCompSerie) {
        this.codCompSerie = codCompSerie;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificador != null ? identificador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobantesUsuario)) {
            return false;
        }
        ComprobantesUsuario other = (ComprobantesUsuario) object;
        if ((this.identificador == null && other.identificador != null) || (this.identificador != null && !this.identificador.equals(other.identificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ComprobantesUsuario[ identificador=" + identificador + " ]";
    }
    
}
