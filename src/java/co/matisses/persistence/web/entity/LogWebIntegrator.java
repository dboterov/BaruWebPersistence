package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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
 * @author dbotero
 */
@Entity
@Table(name = "LOG_WEB_INTEGRATOR")
public class LogWebIntegrator implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRegistro")
    private Integer idRegistro;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "idOperacion")
    private Long idOperacion;
    @Basic(optional = false)
    @Column(name = "objeto")
    private String objeto;
    @Basic(optional = false)
    @Column(name = "operacion")
    private String operacion;
    @Basic(optional = false)
    @Column(name = "datos")
    private String datos;
    @Basic(optional = false)
    @Column(name = "codigoRespuesta")
    private String codigoRespuesta;
    @Basic(optional = false)
    @Column(name = "detalleRespuesta")
    private String detalleRespuesta;
    @Basic(optional = false)
    @Column(name = "tiempoRespuesta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tiempoRespuesta;

    public LogWebIntegrator() {
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Long idOperacion) {
        this.idOperacion = idOperacion;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public String getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(String codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    public String getDetalleRespuesta() {
        return detalleRespuesta;
    }

    public void setDetalleRespuesta(String detalleRespuesta) {
        this.detalleRespuesta = detalleRespuesta;
    }

    public Date getTiempoRespuesta() {
        return tiempoRespuesta;
    }

    public void setTiempoRespuesta(Date tiempoRespuesta) {
        this.tiempoRespuesta = tiempoRespuesta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.idRegistro);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LogWebIntegrator other = (LogWebIntegrator) obj;
        if (!Objects.equals(this.idRegistro, other.idRegistro)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LogWebIntegrator{" + "idRegistro=" + idRegistro + ", fecha=" + fecha + ", idOperacion=" + idOperacion + ", objeto=" + objeto + ", operacion=" + operacion + ", datos=" + datos + ", codigoRespuesta=" + codigoRespuesta + ", detalleRespuesta=" + detalleRespuesta + ", tiempoRespuesta=" + tiempoRespuesta + '}';
    }

}
