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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jonathan.torres
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Personas.findAll", query = "SELECT p FROM Personas p")
    , @NamedQuery(name = "Personas.findByCodPersona", query = "SELECT p FROM Personas p WHERE p.codPersona = :codPersona")
    , @NamedQuery(name = "Personas.findByPrimerNombre", query = "SELECT p FROM Personas p WHERE p.primerNombre = :primerNombre")
    , @NamedQuery(name = "Personas.findBySegundoNombre", query = "SELECT p FROM Personas p WHERE p.segundoNombre = :segundoNombre")
    , @NamedQuery(name = "Personas.findByPrimerApellido", query = "SELECT p FROM Personas p WHERE p.primerApellido = :primerApellido")
    , @NamedQuery(name = "Personas.findBySegundoApellido", query = "SELECT p FROM Personas p WHERE p.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "Personas.findByNumeroDocumento", query = "SELECT p FROM Personas p WHERE p.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "Personas.findByFechaNacimiento", query = "SELECT p FROM Personas p WHERE p.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Personas.findByTelefono", query = "SELECT p FROM Personas p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Personas.findByCelular", query = "SELECT p FROM Personas p WHERE p.celular = :celular")
    , @NamedQuery(name = "Personas.findByDireccion", query = "SELECT p FROM Personas p WHERE p.direccion = :direccion")})
public class Personas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_persona")
    private Integer codPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Size(max = 50)
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Size(max = 50)
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Size(max = 30)
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 100)
    private String telefono;
    @Size(max = 100)
    private String celular;
    @Size(max = 1000)
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPersona")
    private List<Vendedores> vendedoresList;
    @JoinColumn(name = "cod_barrio", referencedColumnName = "cod_barrio")
    @ManyToOne
    private Barrios codBarrio;
    @JoinColumn(name = "cod_ciudad", referencedColumnName = "cod_ciudad")
    @ManyToOne
    private Ciudades codCiudad;
    @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento")
    @ManyToOne
    private Departamentos codDepartamento;
    @JoinColumn(name = "cod_estado_civil", referencedColumnName = "cod_estado_civil")
    @ManyToOne
    private EstadoCivil codEstadoCivil;
    @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais")
    @ManyToOne
    private Paises codPais;
    @JoinColumn(name = "cod_tipo_doc", referencedColumnName = "cod_tipo_doc")
    @ManyToOne(optional = false)
    private TipoDocumentos codTipoDoc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPersona")
    private List<Cobradores> cobradoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPersona")
    private List<Clientes> clientesList;

    public Personas() {
    }

    public Personas(Integer codPersona) {
        this.codPersona = codPersona;
    }

    public Personas(Integer codPersona, String primerNombre, String primerApellido) {
        this.codPersona = codPersona;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
    }

    public Integer getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Integer codPersona) {
        this.codPersona = codPersona;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Vendedores> getVendedoresList() {
        return vendedoresList;
    }

    public void setVendedoresList(List<Vendedores> vendedoresList) {
        this.vendedoresList = vendedoresList;
    }

    public Barrios getCodBarrio() {
        return codBarrio;
    }

    public void setCodBarrio(Barrios codBarrio) {
        this.codBarrio = codBarrio;
    }

    public Ciudades getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(Ciudades codCiudad) {
        this.codCiudad = codCiudad;
    }

    public Departamentos getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(Departamentos codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public EstadoCivil getCodEstadoCivil() {
        return codEstadoCivil;
    }

    public void setCodEstadoCivil(EstadoCivil codEstadoCivil) {
        this.codEstadoCivil = codEstadoCivil;
    }

    public Paises getCodPais() {
        return codPais;
    }

    public void setCodPais(Paises codPais) {
        this.codPais = codPais;
    }

    public TipoDocumentos getCodTipoDoc() {
        return codTipoDoc;
    }

    public void setCodTipoDoc(TipoDocumentos codTipoDoc) {
        this.codTipoDoc = codTipoDoc;
    }

    public List<Cobradores> getCobradoresList() {
        return cobradoresList;
    }

    public void setCobradoresList(List<Cobradores> cobradoresList) {
        this.cobradoresList = cobradoresList;
    }

    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPersona != null ? codPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personas)) {
            return false;
        }
        Personas other = (Personas) object;
        if ((this.codPersona == null && other.codPersona != null) || (this.codPersona != null && !this.codPersona.equals(other.codPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.jtorres.entidades.Personas[ codPersona=" + codPersona + " ]";
    }
    
}
