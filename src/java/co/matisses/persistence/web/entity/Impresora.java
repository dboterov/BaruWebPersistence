package co.matisses.persistence.web.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "IMPRESORA")
@NamedQueries({
    @NamedQuery(name = "Impresora.findAll", query = "SELECT i FROM Impresora i")})
public class Impresora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idImpresora")
    private Integer idImpresora;
    @Basic(optional = false)
    @Column(name = "nombreImpresora")
    private String nombreImpresora;
    @Basic(optional = false)
    @Column(name = "sucursal")
    private String sucursal;
    @Basic(optional = false)
    @Column(name = "activo")
    private Boolean activo;
    @Basic(optional = false)
    @Column(name = "estadoEjecucion")
    private String estadoEjecucion;
    @Column(name = "codigoImpresion")
    private String codigoImpresion;
    @Column(name = "nombreImpresoraServidor")
    private String nombreImpresoraServidor;
    @Column(name = "tipo")
    private String tipo;

    public Impresora() {
    }

    public Impresora(Integer idImpresora) {
        this.idImpresora = idImpresora;
    }

    public Impresora(Integer idImpresora, String nombreImpresora, String sucursal, Boolean activo, String estadoEjecucion, String codigoImpresion, String nombreImpresoraServidor) {
        this.idImpresora = idImpresora;
        this.nombreImpresora = nombreImpresora;
        this.sucursal = sucursal;
        this.activo = activo;
        this.estadoEjecucion = estadoEjecucion;
        this.codigoImpresion = codigoImpresion;
        this.nombreImpresoraServidor = nombreImpresoraServidor;
    }

    public Impresora(Integer idImpresora, String nombreImpresora, String sucursal, Boolean activo, String estadoEjecucion, String codigoImpresion, String nombreImpresoraServidor, String tipo) {
        this.idImpresora = idImpresora;
        this.nombreImpresora = nombreImpresora;
        this.sucursal = sucursal;
        this.activo = activo;
        this.estadoEjecucion = estadoEjecucion;
        this.codigoImpresion = codigoImpresion;
        this.nombreImpresoraServidor = nombreImpresoraServidor;
        this.tipo = tipo;
    }

    public Integer getIdImpresora() {
        return idImpresora;
    }

    public void setIdImpresora(Integer idImpresora) {
        this.idImpresora = idImpresora;
    }

    public String getNombreImpresora() {
        return nombreImpresora;
    }

    public void setNombreImpresora(String nombreImpresora) {
        this.nombreImpresora = nombreImpresora;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getEstadoEjecucion() {
        return estadoEjecucion;
    }

    public void setEstadoEjecucion(String estadoEjecucion) {
        this.estadoEjecucion = estadoEjecucion;
    }

    public String getCodigoImpresion() {
        return codigoImpresion;
    }

    public void setCodigoImpresion(String codigoImpresion) {
        this.codigoImpresion = codigoImpresion;
    }

    public String getNombreImpresoraServidor() {
        return nombreImpresoraServidor;
    }

    public void setNombreImpresoraServidor(String nombreImpresoraServidor) {
        this.nombreImpresoraServidor = nombreImpresoraServidor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImpresora != null ? idImpresora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Impresora)) {
            return false;
        }
        Impresora other = (Impresora) object;
        if ((this.idImpresora == null && other.idImpresora != null) || (this.idImpresora != null && !this.idImpresora.equals(other.idImpresora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.Impresora[ idImpresora=" + idImpresora + " ]";
    }
}
