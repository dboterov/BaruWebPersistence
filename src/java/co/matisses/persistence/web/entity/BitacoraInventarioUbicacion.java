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

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "BITACORA_INVENTARIO_UBICACION")
@NamedQueries({
    @NamedQuery(name = "BitacoraInventarioUbicacion.findAll", query = "SELECT b FROM BitacoraInventarioUbicacion b")})
public class BitacoraInventarioUbicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBitacora")
    private Long idBitacora;
    @Basic(optional = false)
    @Column(name = "whsCode")
    private String whsCode;
    @Basic(optional = false)
    @Column(name = "binCode")
    private String binCode;
    @Basic(optional = false)
    @Column(name = "fechaCreacionConteo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacionConteo;
    @Basic(optional = false)
    @Column(name = "usuarioCreador")
    private String usuarioCreador;
    @Basic(optional = false)
    @Column(name = "fechaFinalizacionConteo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinalizacionConteo;
    @Basic(optional = false)
    @Column(name = "usuarioFinalizador")
    private String usuarioFinalizador;
    @Basic(optional = false)
    @Column(name = "referencias")
    private Integer referencias;
    @Basic(optional = false)
    @Column(name = "unidades")
    private Integer unidades;
    @Basic(optional = false)
    @Column(name = "diferencias")
    private Integer diferencias;

    public BitacoraInventarioUbicacion() {
    }

    public Long getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(Long idBitacora) {
        this.idBitacora = idBitacora;
    }

    public String getWhsCode() {
        return whsCode;
    }

    public void setWhsCode(String whsCode) {
        this.whsCode = whsCode;
    }

    public String getBinCode() {
        return binCode;
    }

    public void setBinCode(String binCode) {
        this.binCode = binCode;
    }

    public Date getFechaCreacionConteo() {
        return fechaCreacionConteo;
    }

    public void setFechaCreacionConteo(Date fechaCreacionConteo) {
        this.fechaCreacionConteo = fechaCreacionConteo;
    }

    public String getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(String usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public Date getFechaFinalizacionConteo() {
        return fechaFinalizacionConteo;
    }

    public void setFechaFinalizacionConteo(Date fechaFinalizacionConteo) {
        this.fechaFinalizacionConteo = fechaFinalizacionConteo;
    }

    public String getUsuarioFinalizador() {
        return usuarioFinalizador;
    }

    public void setUsuarioFinalizador(String usuarioFinalizador) {
        this.usuarioFinalizador = usuarioFinalizador;
    }

    public Integer getReferencias() {
        return referencias;
    }

    public void setReferencias(Integer referencias) {
        this.referencias = referencias;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Integer getDiferencias() {
        return diferencias;
    }

    public void setDiferencias(Integer diferencias) {
        this.diferencias = diferencias;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.idBitacora);
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
        final BitacoraInventarioUbicacion other = (BitacoraInventarioUbicacion) obj;
        return Objects.equals(this.idBitacora, other.idBitacora);
    }

    @Override
    public String toString() {
        return "BitacoraInventarioUbicacion{" + "idBitacora=" + idBitacora + ", whsCode=" + whsCode + ", binCode=" + binCode + ", fechaCreacionConteo=" + fechaCreacionConteo + ", usuarioCreador=" + usuarioCreador + ", fechaFinalizacionConteo=" + fechaFinalizacionConteo + ", usuarioFinalizador=" + usuarioFinalizador + ", referencias=" + referencias + ", unidades=" + unidades + ", diferencias=" + diferencias + '}';
    }

}
