/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.jtorres.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jonathan.torres
 */
@Entity
@Table(name = "comprobantes_series")
@NamedQueries({
    @NamedQuery(name = "ComprobantesSeries.findAll", query = "SELECT c FROM ComprobantesSeries c")
    , @NamedQuery(name = "ComprobantesSeries.findByCodCompSerie", query = "SELECT c FROM ComprobantesSeries c WHERE c.codCompSerie = :codCompSerie")
    , @NamedQuery(name = "ComprobantesSeries.findBySerieComprob", query = "SELECT c FROM ComprobantesSeries c WHERE c.serieComprob = :serieComprob")
    , @NamedQuery(name = "ComprobantesSeries.findByNumeroInicial", query = "SELECT c FROM ComprobantesSeries c WHERE c.numeroInicial = :numeroInicial")
    , @NamedQuery(name = "ComprobantesSeries.findByNumeroFinal", query = "SELECT c FROM ComprobantesSeries c WHERE c.numeroFinal = :numeroFinal")
    , @NamedQuery(name = "ComprobantesSeries.findBySerieTimbrado", query = "SELECT c FROM ComprobantesSeries c WHERE c.serieTimbrado = :serieTimbrado")
    , @NamedQuery(name = "ComprobantesSeries.findByNumeroTimbrado", query = "SELECT c FROM ComprobantesSeries c WHERE c.numeroTimbrado = :numeroTimbrado")
    , @NamedQuery(name = "ComprobantesSeries.findByFechaDesde", query = "SELECT c FROM ComprobantesSeries c WHERE c.fechaDesde = :fechaDesde")
    , @NamedQuery(name = "ComprobantesSeries.findByFechaHasta", query = "SELECT c FROM ComprobantesSeries c WHERE c.fechaHasta = :fechaHasta")})
public class ComprobantesSeries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_comp_serie")
    private Integer codCompSerie;
    @Column(name = "serie_comprob")
    private String serieComprob;
    @Column(name = "numero_inicial")
    private Integer numeroInicial;
    @Column(name = "numero_final")
    private Integer numeroFinal;
    @Column(name = "serie_timbrado")
    private String serieTimbrado;
    @Column(name = "numero_timbrado")
    private String numeroTimbrado;
    @Column(name = "fecha_desde")
    @Temporal(TemporalType.DATE)
    private Date fechaDesde;
    @Column(name = "fecha_hasta")
    @Temporal(TemporalType.DATE)
    private Date fechaHasta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCompSerie")
    private List<ComprobantesCabecera> comprobantesCabeceraList;
    @OneToMany(mappedBy = "codCompSerieRef")
    private List<ComprobantesCabecera> comprobantesCabeceraList1;
    @JoinColumn(name = "cod_sucursal", referencedColumnName = "cod_sucursal")
    @ManyToOne
    private Sucursales codSucursal;
    @JoinColumn(name = "cod_tipo_comp", referencedColumnName = "cod_tipo_comp")
    @ManyToOne
    private TipoComprobantes codTipoComp;
    @OneToMany(mappedBy = "codCompSerie")
    private List<ComprobantesUsuario> comprobantesUsuarioList;

    public ComprobantesSeries() {
    }

    public ComprobantesSeries(Integer codCompSerie) {
        this.codCompSerie = codCompSerie;
    }

    public Integer getCodCompSerie() {
        return codCompSerie;
    }

    public void setCodCompSerie(Integer codCompSerie) {
        this.codCompSerie = codCompSerie;
    }

    public String getSerieComprob() {
        return serieComprob;
    }

    public void setSerieComprob(String serieComprob) {
        this.serieComprob = serieComprob;
    }

    public Integer getNumeroInicial() {
        return numeroInicial;
    }

    public void setNumeroInicial(Integer numeroInicial) {
        this.numeroInicial = numeroInicial;
    }

    public Integer getNumeroFinal() {
        return numeroFinal;
    }

    public void setNumeroFinal(Integer numeroFinal) {
        this.numeroFinal = numeroFinal;
    }

    public String getSerieTimbrado() {
        return serieTimbrado;
    }

    public void setSerieTimbrado(String serieTimbrado) {
        this.serieTimbrado = serieTimbrado;
    }

    public String getNumeroTimbrado() {
        return numeroTimbrado;
    }

    public void setNumeroTimbrado(String numeroTimbrado) {
        this.numeroTimbrado = numeroTimbrado;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public List<ComprobantesCabecera> getComprobantesCabeceraList() {
        return comprobantesCabeceraList;
    }

    public void setComprobantesCabeceraList(List<ComprobantesCabecera> comprobantesCabeceraList) {
        this.comprobantesCabeceraList = comprobantesCabeceraList;
    }

    public List<ComprobantesCabecera> getComprobantesCabeceraList1() {
        return comprobantesCabeceraList1;
    }

    public void setComprobantesCabeceraList1(List<ComprobantesCabecera> comprobantesCabeceraList1) {
        this.comprobantesCabeceraList1 = comprobantesCabeceraList1;
    }

    public Sucursales getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(Sucursales codSucursal) {
        this.codSucursal = codSucursal;
    }

    public TipoComprobantes getCodTipoComp() {
        return codTipoComp;
    }

    public void setCodTipoComp(TipoComprobantes codTipoComp) {
        this.codTipoComp = codTipoComp;
    }

    public List<ComprobantesUsuario> getComprobantesUsuarioList() {
        return comprobantesUsuarioList;
    }

    public void setComprobantesUsuarioList(List<ComprobantesUsuario> comprobantesUsuarioList) {
        this.comprobantesUsuarioList = comprobantesUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCompSerie != null ? codCompSerie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobantesSeries)) {
            return false;
        }
        ComprobantesSeries other = (ComprobantesSeries) object;
        if ((this.codCompSerie == null && other.codCompSerie != null) || (this.codCompSerie != null && !this.codCompSerie.equals(other.codCompSerie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ComprobantesSeries[ codCompSerie=" + codCompSerie + " ]";
    }
    
}
