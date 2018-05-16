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
@Table(name = "WIKI")
public class Wiki implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idWiki")
    private Integer idWiki;
    @Column(name = "idSolicitud")
    private Integer idSolicitud;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "texto")
    private String texto;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "visitas")
    private Integer visitas;

    public Wiki() {
    }

    public Wiki(Integer idWiki) {
        this.idWiki = idWiki;
    }

    public Wiki(Integer idWiki, Integer idSolicitud, String titulo, String texto, Date fecha, String usuario, Boolean activo, Integer visitas) {
        this.idWiki = idWiki;
        this.idSolicitud = idSolicitud;
        this.titulo = titulo;
        this.texto = texto;
        this.fecha = fecha;
        this.usuario = usuario;
        this.activo = activo;
        this.visitas = visitas;
    }

    public Integer getIdWiki() {
        return idWiki;
    }

    public void setIdWiki(Integer idWiki) {
        this.idWiki = idWiki;
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Integer getVisitas() {
        return visitas;
    }

    public void setVisitas(Integer visitas) {
        this.visitas = visitas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWiki != null ? idWiki.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wiki)) {
            return false;
        }
        Wiki other = (Wiki) object;
        if ((this.idWiki == null && other.idWiki != null) || (this.idWiki != null && !this.idWiki.equals(other.idWiki))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.Wiki[ idWiki=" + idWiki + " ]";
    }
}
