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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "CONTENEDOR_LINEA")
@NamedQueries({
    @NamedQuery(name = "ContenedorLinea.findAll", query = "SELECT c FROM ContenedorLinea c")})
public class ContenedorLinea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idContenedorLinea")
    private Integer idContenedorLinea;
    @Basic(optional = true)
    @Column(name = "cantidad")
    private Integer cantidad;
    @Basic(optional = true)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = true)
    @Size(min = 1, max = 20)
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "linea")
    private Integer linea;
    @JoinColumn(name = "idContenedorProforma", referencedColumnName = "idContenedorProforma")
    @ManyToOne
    private ContenedorProforma idContenedorProforma;
    @JoinColumn(name = "idDetalleProforma", referencedColumnName = "idDetalleProforma")
    @ManyToOne
    private DetalleProforma idDetalleProforma;

    public ContenedorLinea() {
    }

    public ContenedorLinea(Integer idContenedorLinea) {
        this.idContenedorLinea = idContenedorLinea;
    }

    public ContenedorLinea(Integer idContenedorLinea, Integer cantidad, Date fecha, String usuario, ContenedorProforma idContenedorProforma) {
        this.idContenedorLinea = idContenedorLinea;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.usuario = usuario;
        this.idContenedorProforma = idContenedorProforma;
    }

    public Integer getIdContenedorLinea() {
        return idContenedorLinea;
    }

    public void setIdContenedorLinea(Integer idContenedorLinea) {
        this.idContenedorLinea = idContenedorLinea;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
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

    public ContenedorProforma getIdContenedorProforma() {
        return idContenedorProforma;
    }

    public void setIdContenedorProforma(ContenedorProforma idContenedorProforma) {
        this.idContenedorProforma = idContenedorProforma;
    }

    public DetalleProforma getIdDetalleProforma() {
        return idDetalleProforma;
    }

    public void setIdDetalleProforma(DetalleProforma idDetalleProforma) {
        this.idDetalleProforma = idDetalleProforma;
    }

    public Integer getLinea() {
        return linea;
    }

    public void setLinea(Integer linea) {
        this.linea = linea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContenedorLinea != null ? idContenedorLinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContenedorLinea)) {
            return false;
        }
        ContenedorLinea other = (ContenedorLinea) object;
        if ((this.idContenedorLinea == null && other.idContenedorLinea != null) || (this.idContenedorLinea != null && !this.idContenedorLinea.equals(other.idContenedorLinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.ContenedorLinea[ idContenedorLinea=" + idContenedorLinea + " ]";
    }
}
