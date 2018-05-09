package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "LLAMADA_SOLUCION")
public class LlamadaSolucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idLlamadaSolucion")
    private Long idLlamadaSolucion;
    @Basic(optional = false)
    @Column(name = "docEntry")
    private Integer docEntry;
    @Column(name = "itemCode")
    private String itemCode;
    @Column(name = "estado")
    private Integer estado;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "propietario")
    private String propietario;
    @Column(name = "solucion")
    private String solucion;
    @Column(name = "sintoma")
    private String sintoma;
    @Column(name = "causa")
    private String causa;
    @Column(name = "comentarios")
    private String comentarios;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public LlamadaSolucion() {
    }

    public LlamadaSolucion(Long idLlamadaSolucion) {
        this.idLlamadaSolucion = idLlamadaSolucion;
    }

    public LlamadaSolucion(Long idLlamadaSolucion, Integer docEntry, String itemCode, Integer estado, Integer numero, String propietario, String solucion,
            String sintoma, String causa, String comentarios, Date fecha) {
        this.idLlamadaSolucion = idLlamadaSolucion;
        this.docEntry = docEntry;
        this.itemCode = itemCode;
        this.estado = estado;
        this.numero = numero;
        this.propietario = propietario;
        this.solucion = solucion;
        this.sintoma = sintoma;
        this.causa = causa;
        this.comentarios = comentarios;
        this.fecha = fecha;
    }

    public Long getIdLlamadaSolucion() {
        return idLlamadaSolucion;
    }

    public void setIdLlamadaSolucion(Long idLlamadaSolucion) {
        this.idLlamadaSolucion = idLlamadaSolucion;
    }

    public Integer getDocEntry() {
        return docEntry;
    }

    public void setDocEntry(Integer docEntry) {
        this.docEntry = docEntry;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLlamadaSolucion != null ? idLlamadaSolucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LlamadaSolucion)) {
            return false;
        }
        LlamadaSolucion other = (LlamadaSolucion) object;
        if ((this.idLlamadaSolucion == null && other.idLlamadaSolucion != null) || (this.idLlamadaSolucion != null && !this.idLlamadaSolucion.equals(other.idLlamadaSolucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.GarantiaSolucion[ idLlamadaSolucion = " + idLlamadaSolucion + " ]";
    }
}
