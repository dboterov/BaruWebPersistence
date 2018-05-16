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
@Table(name = "VERSION_TRANSACCION_BANCARIA")
public class VersionTransaccionBancaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVersionTransaccionBancaria")
    private Integer idVersionTransaccionBancaria;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "nombreDocumento")
    private String nombreDocumento;
    @JoinColumn(name = "idTransaccionBancaria", referencedColumnName = "idTransaccionBancaria")
    @ManyToOne(optional = false)
    private TransaccionBancaria idTransaccionBancaria;
    @JoinColumn(name = "idProforma", referencedColumnName = "idProforma")
    @ManyToOne(optional = false)
    private ProformaInvoice idProforma;

    public VersionTransaccionBancaria() {
    }

    public VersionTransaccionBancaria(Integer idVersionTransaccionBancaria) {
        this.idVersionTransaccionBancaria = idVersionTransaccionBancaria;
    }

    public VersionTransaccionBancaria(Integer idVersionTransaccionBancaria, Date fecha, String usuario, String nombreDocumento, TransaccionBancaria idTransaccionBancaria, ProformaInvoice idProforma) {
        this.idVersionTransaccionBancaria = idVersionTransaccionBancaria;
        this.fecha = fecha;
        this.usuario = usuario;
        this.nombreDocumento = nombreDocumento;
        this.idTransaccionBancaria = idTransaccionBancaria;
        this.idProforma = idProforma;
    }

    public Integer getIdVersionTransaccionBancaria() {
        return idVersionTransaccionBancaria;
    }

    public void setIdVersionTransaccionBancaria(Integer idVersionTransaccionBancaria) {
        this.idVersionTransaccionBancaria = idVersionTransaccionBancaria;
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

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public TransaccionBancaria getIdTransaccionBancaria() {
        return idTransaccionBancaria;
    }

    public void setIdTransaccionBancaria(TransaccionBancaria idTransaccionBancaria) {
        this.idTransaccionBancaria = idTransaccionBancaria;
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
        hash += (idVersionTransaccionBancaria != null ? idVersionTransaccionBancaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VersionTransaccionBancaria)) {
            return false;
        }
        VersionTransaccionBancaria other = (VersionTransaccionBancaria) object;
        if ((this.idVersionTransaccionBancaria == null && other.idVersionTransaccionBancaria != null) || (this.idVersionTransaccionBancaria != null
                && !this.idVersionTransaccionBancaria.equals(other.idVersionTransaccionBancaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.VersionTransaccionBancaria[ idVersionTransaccionBancaria=" + idVersionTransaccionBancaria + " ]";
    }
}
