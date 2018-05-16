package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "[360_TRASLADO_DETALLE]")
public class TrasladoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTrasladoDetalle")
    private Integer idTrasladoDetalle;
    @Basic(optional = false)
    @Column(name = "referencia")
    private String referencia;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private Integer cantidad;
    @Basic(optional = true)
    @Column(name = "tipoDocumentoReferencia")
    private Integer tipoDocumentoReferencia;
    @Basic(optional = true)
    @Column(name = "documentoReferencia")
    private Integer documentoReferencia;
    @Basic(optional = false)
    @Column(name = "almacenOrigen")
    private String almacenOrigen;
    @Basic(optional = false)
    @Column(name = "almacenDestino")
    private String almacenDestino;
    @Basic(optional = false)
    @Column(name = "comentario")
    private String comentario;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @JoinColumn(name = "idTraslado", referencedColumnName = "idTraslado")
    @ManyToOne
    private Traslado idTraslado;

    public TrasladoDetalle() {
    }

    public TrasladoDetalle(Integer idTrasladoDetalle) {
        this.idTrasladoDetalle = idTrasladoDetalle;
    }

    public TrasladoDetalle(Integer idTrasladoDetalle, String referencia, Integer cantidad, Integer tipoDocumentoReferencia,
            Integer documentoReferencia, String almacenOrigen, String almacenDestino, String comentario, Date fecha, Traslado idTraslado) {
        this.idTrasladoDetalle = idTrasladoDetalle;
        this.referencia = referencia;
        this.cantidad = cantidad;
        this.tipoDocumentoReferencia = tipoDocumentoReferencia;
        this.documentoReferencia = documentoReferencia;
        this.almacenOrigen = almacenOrigen;
        this.almacenDestino = almacenDestino;
        this.comentario = comentario;
        this.fecha = fecha;
        this.idTraslado = idTraslado;
    }

    public Integer getIdTrasladoDetalle() {
        return idTrasladoDetalle;
    }

    public void setIdTrasladoDetalle(Integer idTrasladoDetalle) {
        this.idTrasladoDetalle = idTrasladoDetalle;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getTipoDocumentoReferencia() {
        return tipoDocumentoReferencia;
    }

    public void setTipoDocumentoReferencia(Integer tipoDocumentoReferencia) {
        this.tipoDocumentoReferencia = tipoDocumentoReferencia;
    }

    public Integer getDocumentoReferencia() {
        return documentoReferencia;
    }

    public void setDocumentoReferencia(Integer documentoReferencia) {
        this.documentoReferencia = documentoReferencia;
    }

    public String getAlmacenOrigen() {
        return almacenOrigen;
    }

    public void setAlmacenOrigen(String almacenOrigen) {
        this.almacenOrigen = almacenOrigen;
    }

    public String getAlmacenDestino() {
        return almacenDestino;
    }

    public void setAlmacenDestino(String almacenDestino) {
        this.almacenDestino = almacenDestino;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Traslado getIdTraslado() {
        return idTraslado;
    }

    public void setIdTraslado(Traslado idTraslado) {
        this.idTraslado = idTraslado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrasladoDetalle != null ? idTrasladoDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrasladoDetalle)) {
            return false;
        }
        TrasladoDetalle other = (TrasladoDetalle) object;
        if ((this.idTrasladoDetalle == null && other.idTrasladoDetalle != null) || (this.idTrasladoDetalle != null && !this.idTrasladoDetalle.equals(other.idTrasladoDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.TrasladoDetalle[ idTrasladoDetalle=" + idTrasladoDetalle + " ]";
    }
}
