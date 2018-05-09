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
@Table(name = "USUARIO_PAGINA_REDENCION")
public class UsuarioPaginaRedencion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRedencion")
    private Integer idRedencion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "monto")
    private BigDecimal monto;
    @Basic(optional = false)
    @Column(name = "modo")
    private String modo;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idUsuarioPagina", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UsuarioPagina idUsuarioPagina;

    public UsuarioPaginaRedencion() {
    }

    public UsuarioPaginaRedencion(Integer idRedencion) {
        this.idRedencion = idRedencion;
    }

    public UsuarioPaginaRedencion(Integer idRedencion, Date fecha, String tipo, BigDecimal monto, String modo, String estado, UsuarioPagina idUsuarioPagina) {
        this.idRedencion = idRedencion;
        this.fecha = fecha;
        this.tipo = tipo;
        this.monto = monto;
        this.modo = modo;
        this.estado = estado;
        this.idUsuarioPagina = idUsuarioPagina;
    }

    public Integer getIdRedencion() {
        return idRedencion;
    }

    public void setIdRedencion(Integer idRedencion) {
        this.idRedencion = idRedencion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public UsuarioPagina getIdUsuarioPagina() {
        return idUsuarioPagina;
    }

    public void setIdUsuarioPagina(UsuarioPagina idUsuarioPagina) {
        this.idUsuarioPagina = idUsuarioPagina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRedencion != null ? idRedencion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioPaginaRedencion)) {
            return false;
        }
        UsuarioPaginaRedencion other = (UsuarioPaginaRedencion) object;
        if ((this.idRedencion == null && other.idRedencion != null) || (this.idRedencion != null && !this.idRedencion.equals(other.idRedencion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.UsuarioPaginaRedencion[ idRedencion=" + idRedencion + " ]";
    }
}
