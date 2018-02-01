package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "DETALLE_CONTEO")
public class DetalleConteo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "referencia")
    private String referencia;
    @JoinColumn(name = "idConteo", referencedColumnName = "idConteo")
    @ManyToOne(optional = false)
    private ConteoTienda idConteo;

    public DetalleConteo() {
    }

    public DetalleConteo(Date fecha) {
        this.fecha = fecha;
    }

    public DetalleConteo(Date fecha, String usuario, String referencia, ConteoTienda idConteo) {
        this.fecha = fecha;
        this.usuario = usuario;
        this.referencia = referencia;
        this.idConteo = idConteo;
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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public ConteoTienda getIdConteo() {
        return idConteo;
    }

    public void setIdConteo(ConteoTienda idConteo) {
        this.idConteo = idConteo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleConteo)) {
            return false;
        }
        DetalleConteo other = (DetalleConteo) object;
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.DetalleConteo[ fecha=" + fecha + " ]";
    }
}
