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
@Table(name = "TIPO_STICKER")
@NamedQueries({
    @NamedQuery(name = "TipoSticker.findAll", query = "SELECT t FROM TipoSticker t")})
public class TipoSticker implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoSticker")
    private Integer idTipoSticker;
    @Basic(optional = false)
    @Column(name = "nombreSticker")
    private String nombreSticker;
    @Basic(optional = false)
    @Column(name = "activo")
    private Boolean activo;
    @Basic(optional = false)
    @Column(name = "tipoAlmacen")
    private String tipoAlmacen;
    @Basic(optional = false)
    @Column(name = "columnas")
    private Integer columnas;
    @Basic(optional = false)
    @Column(name = "idTipoEtiqueta")
    private Integer idTipoEtiqueta;

    public TipoSticker() {
    }

    public TipoSticker(Integer idTipoSticker) {
        this.idTipoSticker = idTipoSticker;
    }

    public TipoSticker(Integer idTipoSticker, String nombreSticker, Boolean activo, String tipoAlmacen, Integer columnas, Integer idTipoEtiqueta) {
        this.idTipoSticker = idTipoSticker;
        this.nombreSticker = nombreSticker;
        this.activo = activo;
        this.tipoAlmacen = tipoAlmacen;
        this.columnas = columnas;
        this.idTipoEtiqueta = idTipoEtiqueta;
    }

    public Integer getIdTipoSticker() {
        return idTipoSticker;
    }

    public void setIdTipoSticker(Integer idTipoSticker) {
        this.idTipoSticker = idTipoSticker;
    }

    public String getNombreSticker() {
        return nombreSticker;
    }

    public void setNombreSticker(String nombreSticker) {
        this.nombreSticker = nombreSticker;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getTipoAlmacen() {
        return tipoAlmacen;
    }

    public void setTipoAlmacen(String tipoAlmacen) {
        this.tipoAlmacen = tipoAlmacen;
    }

    public Integer getColumnas() {
        return columnas;
    }

    public void setColumnas(Integer columnas) {
        this.columnas = columnas;
    }

    public Integer getIdTipoEtiqueta() {
        return idTipoEtiqueta;
    }

    public void setIdTipoEtiqueta(Integer idTipoEtiqueta) {
        this.idTipoEtiqueta = idTipoEtiqueta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoSticker != null ? idTipoSticker.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoSticker)) {
            return false;
        }
        TipoSticker other = (TipoSticker) object;
        if ((this.idTipoSticker == null && other.idTipoSticker != null) || (this.idTipoSticker != null && !this.idTipoSticker.equals(other.idTipoSticker))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.TipoSticker[ idTipoSticker=" + idTipoSticker + " ]";
    }
}
