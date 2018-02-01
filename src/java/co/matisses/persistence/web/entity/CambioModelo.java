package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "CAMBIO_MODELO")
public class CambioModelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCambioModelo")
    private Integer idCambioModelo;
    @Basic(optional = false)
    @Column(name = "modeloAnterior")
    private String modeloAnterior;
    @Basic(optional = false)
    @Column(name = "modeloNuevo")
    private String modeloNuevo;
    @Basic(optional = false)
    @Column(name = "salida")
    private Integer salida;
    @Basic(optional = false)
    @Column(name = "entrada")
    private Integer entrada;
    @Basic(optional = false)
    @Column(name = "combinaciones")
    private Boolean combinaciones;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "token")
    private String token;

    public CambioModelo() {
    }

    public CambioModelo(Integer idCambioModelo) {
        this.idCambioModelo = idCambioModelo;
    }

    public CambioModelo(Integer idCambioModelo, String modeloAnterior, String modeloNuevo, Integer salida, Integer entrada, Boolean combinaciones, Date fecha, String usuario, String token) {
        this.idCambioModelo = idCambioModelo;
        this.modeloAnterior = modeloAnterior;
        this.modeloNuevo = modeloNuevo;
        this.salida = salida;
        this.entrada = entrada;
        this.combinaciones = combinaciones;
        this.fecha = fecha;
        this.usuario = usuario;
        this.token = token;
    }

    public Integer getIdCambioModelo() {
        return idCambioModelo;
    }

    public void setIdCambioModelo(Integer idCambioModelo) {
        this.idCambioModelo = idCambioModelo;
    }

    public String getModeloAnterior() {
        return modeloAnterior;
    }

    public void setModeloAnterior(String modeloAnterior) {
        this.modeloAnterior = modeloAnterior;
    }

    public String getModeloNuevo() {
        return modeloNuevo;
    }

    public void setModeloNuevo(String modeloNuevo) {
        this.modeloNuevo = modeloNuevo;
    }

    public Integer getSalida() {
        return salida;
    }

    public void setSalida(Integer salida) {
        this.salida = salida;
    }

    public Integer getEntrada() {
        return entrada;
    }

    public void setEntrada(Integer entrada) {
        this.entrada = entrada;
    }

    public Boolean getCombinaciones() {
        return combinaciones;
    }

    public void setCombinaciones(Boolean combinaciones) {
        this.combinaciones = combinaciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCambioModelo != null ? idCambioModelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CambioModelo)) {
            return false;
        }
        CambioModelo other = (CambioModelo) object;
        if ((this.idCambioModelo == null && other.idCambioModelo != null) || (this.idCambioModelo != null && !this.idCambioModelo.equals(other.idCambioModelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.CambioModelo[ idCambioModelo=" + idCambioModelo + " ]";
    }
}
