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

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "LINEA_IGNORADA_PROFORMA")
@NamedQueries({
    @NamedQuery(name = "LineaIgnoradaProforma.findAll", query = "SELECT l FROM LineaIgnoradaProforma l")})
public class LineaIgnoradaProforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idItemIgnorado")
    private Integer idItemIgnorado;
    @Basic(optional = false)
    @Column(name = "linea")
    private Integer linea;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "idProforma", referencedColumnName = "idProforma")
    @ManyToOne(optional = false)
    private ProformaInvoice idProforma;

    public LineaIgnoradaProforma() {
    }

    public LineaIgnoradaProforma(Integer idItemIgnorado) {
        this.idItemIgnorado = idItemIgnorado;
    }

    public LineaIgnoradaProforma(Integer idItemIgnorado, Integer linea, String usuario, Date fecha, ProformaInvoice idProforma) {
        this.idItemIgnorado = idItemIgnorado;
        this.linea = linea;
        this.usuario = usuario;
        this.fecha = fecha;
        this.idProforma = idProforma;
    }

    public Integer getIdItemIgnorado() {
        return idItemIgnorado;
    }

    public void setIdItemIgnorado(Integer idItemIgnorado) {
        this.idItemIgnorado = idItemIgnorado;
    }

    public Integer getLinea() {
        return linea;
    }

    public void setLinea(Integer linea) {
        this.linea = linea;
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

    public ProformaInvoice getIdProforma() {
        return idProforma;
    }

    public void setIdProforma(ProformaInvoice idProforma) {
        this.idProforma = idProforma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItemIgnorado != null ? idItemIgnorado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineaIgnoradaProforma)) {
            return false;
        }
        LineaIgnoradaProforma other = (LineaIgnoradaProforma) object;
        if ((this.idItemIgnorado == null && other.idItemIgnorado != null) || (this.idItemIgnorado != null && !this.idItemIgnorado.equals(other.idItemIgnorado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.LineaIgnoradaProforma[ idItemIgnorado=" + idItemIgnorado + " ]";
    }
}
