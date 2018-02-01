package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "AUTORIZACION_PAGO")
public class AutorizacionPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAutorizacionPago")
    private Integer idAutorizacionPago;
    @Basic(optional = false)
    @Column(name = "idCotizacion")
    private Integer idCotizacion;
    @Basic(optional = false)
    @Column(name = "cliente")
    private String cliente;
    @Basic(optional = false)
    @Column(name = "codAsesor")
    private Integer codAsesor;
    @Basic(optional = false)
    @Column(name = "usuarioSolicita")
    private String usuarioSolicita;
    @Basic(optional = false)
    @Column(name = "fechaSolicita")
    private Date fechaSolicita;
    @Basic(optional = false)
    @Column(name = "valorSolicitado")
    private BigDecimal valorSolicitado;
    @Basic(optional = false)
    @Column(name = "idCondicionPago")
    private Integer idCondicionPago;
    @Basic(optional = true)
    @Column(name = "comentario")
    private String comentario;
    @Basic(optional = false)
    @Column(name = "usuarioAprueba")
    private String usuarioAprueba;
    @Basic(optional = false)
    @Column(name = "correoAprueba")
    private String correoAprueba;
    @Basic(optional = true)
    @Column(name = "comentarioAprueba")
    private String comentarioAprueba;
    @Basic(optional = true)
    @Column(name = "respuesta")
    private Boolean respuesta;
    @Basic(optional = true)
    @Column(name = "fechaAprobacion")
    private Date fechaAprobacion;
    @Basic(optional = false)
    @Column(name = "token")
    private String token;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;

    public AutorizacionPago() {
    }

    public AutorizacionPago(Integer idAutorizacionPago, Integer idCotizacion, String usuarioSolicita, Date fechaSolicita, BigDecimal valorSolicitado, Integer idCondicionPago,
            String comentario, String usuarioAprueba, String correoAprueba, String comentarioAprueba, Boolean respuesta, Date fechaAprobacion, String token, String estado) {
        this.idAutorizacionPago = idAutorizacionPago;
        this.idCotizacion = idCotizacion;
        this.usuarioSolicita = usuarioSolicita;
        this.fechaSolicita = fechaSolicita;
        this.valorSolicitado = valorSolicitado;
        this.idCondicionPago = idCondicionPago;
        this.comentario = comentario;
        this.usuarioAprueba = usuarioAprueba;
        this.correoAprueba = correoAprueba;
        this.comentarioAprueba = comentarioAprueba;
        this.respuesta = respuesta;
        this.fechaAprobacion = fechaAprobacion;
        this.token = token;
        this.estado = estado;
    }

    public Integer getIdAutorizacionPago() {
        return idAutorizacionPago;
    }

    public void setIdAutorizacionPago(Integer idAutorizacionPago) {
        this.idAutorizacionPago = idAutorizacionPago;
    }

    public Integer getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(Integer idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Integer getCodAsesor() {
        return codAsesor;
    }

    public void setCodAsesor(Integer codAsesor) {
        this.codAsesor = codAsesor;
    }

    public String getUsuarioSolicita() {
        return usuarioSolicita;
    }

    public void setUsuarioSolicita(String usuarioSolicita) {
        this.usuarioSolicita = usuarioSolicita;
    }

    public Date getFechaSolicita() {
        return fechaSolicita;
    }

    public void setFechaSolicita(Date fechaSolicita) {
        this.fechaSolicita = fechaSolicita;
    }

    public BigDecimal getValorSolicitado() {
        return valorSolicitado;
    }

    public void setValorSolicitado(BigDecimal valorSolicitado) {
        this.valorSolicitado = valorSolicitado;
    }

    public Integer getIdCondicionPago() {
        return idCondicionPago;
    }

    public void setIdCondicionPago(Integer idCondicionPago) {
        this.idCondicionPago = idCondicionPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getUsuarioAprueba() {
        return usuarioAprueba;
    }

    public void setUsuarioAprueba(String usuarioAprueba) {
        this.usuarioAprueba = usuarioAprueba;
    }

    public String getCorreoAprueba() {
        return correoAprueba;
    }

    public void setCorreoAprueba(String correoAprueba) {
        this.correoAprueba = correoAprueba;
    }

    public String getComentarioAprueba() {
        return comentarioAprueba;
    }

    public void setComentarioAprueba(String comentarioAprueba) {
        this.comentarioAprueba = comentarioAprueba;
    }

    public Boolean getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Boolean respuesta) {
        this.respuesta = respuesta;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutorizacionPago != null ? idAutorizacionPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutorizacionPago)) {
            return false;
        }
        AutorizacionPago other = (AutorizacionPago) object;
        if ((this.idAutorizacionPago == null && other.idAutorizacionPago != null) || (this.idAutorizacionPago != null && !this.idAutorizacionPago.equals(other.idAutorizacionPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.AutorizacionPago[ idAutorizacionPago=" + idAutorizacionPago + " ]";
    }
}
