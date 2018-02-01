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
 * @author dbotero
 */
@Entity
@Table(name = "OPERACION_CAJA")
public class OperacionCaja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOperacionCaja")
    private Integer idOperacionCaja;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "valor")
    private Integer valor;
    @Basic(optional = true)
    @Column(name = "justificacion")
    private String justificacion;
    @Basic(optional = true)
    @Column(name = "idTurnoCaja")
    private Integer idTurno;
    @Basic(optional = true)
    @Column(name = "tipoDocumento")
    private String tipoDocumento;

    public OperacionCaja() {
    }

    public OperacionCaja(Integer idOperacionCaja) {
        this.idOperacionCaja = idOperacionCaja;
    }

    public OperacionCaja(Integer idOperacionCaja, Date fecha, String tipo, Integer valor, String justificacion, Integer idTurno) {
        this.idOperacionCaja = idOperacionCaja;
        this.fecha = fecha;
        this.tipo = tipo;
        this.valor = valor;
        this.justificacion = justificacion;
        this.idTurno = idTurno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public Integer getIdOperacionCaja() {
        return idOperacionCaja;
    }

    public void setIdOperacionCaja(Integer idOperacionCaja) {
        this.idOperacionCaja = idOperacionCaja;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "OperacionCaja{" + "idOperacionCaja=" + idOperacionCaja + ", fecha=" + fecha + ", tipo=" + tipo + ", valor=" + valor + ", justificacion=" + justificacion + ", idTurno=" + idTurno + ", tipoDocumento=" + tipoDocumento + '}';
    }
}
