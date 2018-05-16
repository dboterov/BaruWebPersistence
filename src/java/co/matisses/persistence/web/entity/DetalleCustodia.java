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
@Table(name = "DETALLE_CUSTODIA")
public class DetalleCustodia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleCustodia")
    private Integer idDetalleCustodia;
    @Basic(optional = false)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @Column(name = "contrasenaCustodia")
    private String contrasenaCustodia;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private Integer cantidad;
    @Basic(optional = false)
    @Column(name = "fechaEntrega")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrega;
    @Basic(optional = false)
    @Column(name = "activo")
    private Boolean activo;
    @Basic(optional = false)
    @Column(name = "fechaCambio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCambio;
    @Basic(optional = false)
    @Column(name = "comentario")
    private String comentario;
    @Basic(optional = false)
    @Column(name = "usuarioEntrega")
    private String usuarioEntrega;
    @Basic(optional = false)
    @Column(name = "cantidadBaja")
    private Integer cantidadBaja;
    @JoinColumn(name = "idCustodia", referencedColumnName = "idCustodia")
    @ManyToOne(optional = true)
    private Custodia idCustodia;

    public DetalleCustodia() {
    }

    public DetalleCustodia(Integer idDetalleCustodia) {
        this.idDetalleCustodia = idDetalleCustodia;
    }

    public DetalleCustodia(Integer idDetalleCustodia, String cedula, String contrasenaCustodia, Integer cantidad, Date fechaEntrega, Boolean activo, Date fechaCambio,
            String comentario, String usuarioEntrega, Integer cantidadBaja, Custodia idCustodia) {
        this.idDetalleCustodia = idDetalleCustodia;
        this.cedula = cedula;
        this.contrasenaCustodia = contrasenaCustodia;
        this.cantidad = cantidad;
        this.fechaEntrega = fechaEntrega;
        this.activo = activo;
        this.fechaCambio = fechaCambio;
        this.comentario = comentario;
        this.usuarioEntrega = usuarioEntrega;
        this.cantidadBaja = cantidadBaja;
        this.idCustodia = idCustodia;
    }

    public Integer getIdDetalleCustodia() {
        return idDetalleCustodia;
    }

    public void setIdDetalleCustodia(Integer idDetalleCustodia) {
        this.idDetalleCustodia = idDetalleCustodia;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContrasenaCustodia() {
        return contrasenaCustodia;
    }

    public void setContrasenaCustodia(String contrasenaCustodia) {
        this.contrasenaCustodia = contrasenaCustodia;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Date getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getUsuarioEntrega() {
        return usuarioEntrega;
    }

    public void setUsuarioEntrega(String usuarioEntrega) {
        this.usuarioEntrega = usuarioEntrega;
    }

    public Integer getCantidadBaja() {
        return cantidadBaja;
    }

    public void setCantidadBaja(Integer cantidadBaja) {
        this.cantidadBaja = cantidadBaja;
    }

    public Custodia getIdCustodia() {
        return idCustodia;
    }

    public void setIdCustodia(Custodia idCustodia) {
        this.idCustodia = idCustodia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleCustodia != null ? idDetalleCustodia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCustodia)) {
            return false;
        }
        DetalleCustodia other = (DetalleCustodia) object;
        if ((this.idDetalleCustodia == null && other.idDetalleCustodia != null) || (this.idDetalleCustodia != null && !this.idDetalleCustodia.equals(other.idDetalleCustodia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.DetalleCustodia[ idDetalleCustodia=" + idDetalleCustodia + " ]";
    }
}
