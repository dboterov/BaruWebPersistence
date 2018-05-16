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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "BWS_SESION_SAP")
@NamedQueries({
    @NamedQuery(name = "BwsSesionSAP.findAll", query = "SELECT b FROM BwsSesionSAP b")})
public class BwsSesionSAP implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario")
    private String usuario;
    @NotNull
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sesion_sap")
    private String idSesionSAP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private String estado;
    @Column(name = "id_sesion_bcs")
    private String idSesionBCS;

    public BwsSesionSAP() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdSesionSAP() {
        return idSesionSAP;
    }

    public void setIdSesionSAP(String idSesionSAP) {
        this.idSesionSAP = idSesionSAP;
    }

    public String getIdSesionBCS() {
        return idSesionBCS;
    }

    public void setIdSesionBCS(String idSesionBCS) {
        this.idSesionBCS = idSesionBCS;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final BwsSesionSAP other = (BwsSesionSAP) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "BwsSesionSAP{" + "id=" + id + ", usuario=" + usuario + ", fecha=" + fecha + ", idSesionSAP=" + idSesionSAP + ", estado=" + estado + '}';
    }

}
