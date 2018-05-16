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
@Table(name = "IMPRESION_STICKER")
public class ImpresionSticker implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idImpresionSticker")
    private Integer idImpresionSticker;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "sucursal")
    private String sucursal;
    @Basic(optional = true)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idTipoSticker", referencedColumnName = "idTipoSticker")
    @ManyToOne(optional = false)
    private TipoSticker idTipoSticker;

    public ImpresionSticker() {
    }

    public ImpresionSticker(Integer idImpresionSticker) {
        this.idImpresionSticker = idImpresionSticker;
    }

    public ImpresionSticker(Integer idImpresionSticker, String usuario, Date fecha, String sucursal, String estado, TipoSticker idTipoSticker) {
        this.idImpresionSticker = idImpresionSticker;
        this.usuario = usuario;
        this.fecha = fecha;
        this.sucursal = sucursal;
        this.estado = estado;
        this.idTipoSticker = idTipoSticker;
    }

    public Integer getIdImpresionSticker() {
        return idImpresionSticker;
    }

    public void setIdImpresionSticker(Integer idImpresionSticker) {
        this.idImpresionSticker = idImpresionSticker;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TipoSticker getIdTipoSticker() {
        return idTipoSticker;
    }

    public void setIdTipoSticker(TipoSticker idTipoSticker) {
        this.idTipoSticker = idTipoSticker;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImpresionSticker != null ? idImpresionSticker.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImpresionSticker)) {
            return false;
        }
        ImpresionSticker other = (ImpresionSticker) object;
        if ((this.idImpresionSticker == null && other.idImpresionSticker != null) || (this.idImpresionSticker != null && !this.idImpresionSticker.equals(other.idImpresionSticker))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.ImpresionSticker[ idImpresionSticker=" + idImpresionSticker + " ]";
    }
}
