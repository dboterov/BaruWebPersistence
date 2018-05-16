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
@Table(name = "ANTICIPO_CUENTA")
@NamedQueries({
    @NamedQuery(name = "AnticipoCuenta.findAll", query = "SELECT a FROM AnticipoCuenta a")})
public class AnticipoCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAnticipoCuenta")
    private Integer idAnticipoCuenta;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "fechaGiro")
    @Temporal(TemporalType.DATE)
    private Date fechaGiro;
    @Basic(optional = false)
    @Column(name = "valor")
    private Double valor;
    @Basic(optional = false)
    @Size(min = 1, max = 200)
    @Column(name = "comentario")
    private String comentario;
    @Basic(optional = false)
    @Size(min = 1, max = 20)
    @Column(name = "usuario")
    private String usuario;
    @JoinColumn(name = "codProveedor", referencedColumnName = "codProveedor")
    @ManyToOne
    private DatosProveedor codProveedor;
    @JoinColumn(name = "idTipoMoneda", referencedColumnName = "idTipoMoneda")
    @ManyToOne
    private TipoMoneda idTipoMoneda;
    @JoinColumn(name = "idCuentaBancaria", referencedColumnName = "idCuentaBancaria")
    @ManyToOne
    private CuentaBancariaProveedor idCuentaBancaria;
    @JoinColumn(name = "idProforma", referencedColumnName = "idProforma")
    @ManyToOne
    private ProformaInvoice idProforma;

    public AnticipoCuenta() {
    }

    public AnticipoCuenta(Integer idAnticipoCuenta) {
        this.idAnticipoCuenta = idAnticipoCuenta;
    }

    public AnticipoCuenta(Integer idAnticipoCuenta, Date fecha, Double valor, String comentario, String usuario, DatosProveedor codProveedor) {
        this.idAnticipoCuenta = idAnticipoCuenta;
        this.fecha = fecha;
        this.valor = valor;
        this.comentario = comentario;
        this.usuario = usuario;
        this.codProveedor = codProveedor;
    }

    public Integer getIdAnticipoCuenta() {
        return idAnticipoCuenta;
    }

    public void setIdAnticipoCuenta(Integer idAnticipoCuenta) {
        this.idAnticipoCuenta = idAnticipoCuenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaGiro() {
        return fechaGiro;
    }

    public void setFechaGiro(Date fechaGiro) {
        this.fechaGiro = fechaGiro;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public DatosProveedor getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(DatosProveedor codProveedor) {
        this.codProveedor = codProveedor;
    }

    public TipoMoneda getIdTipoMoneda() {
        return idTipoMoneda;
    }

    public void setIdTipoMoneda(TipoMoneda idTipoMoneda) {
        this.idTipoMoneda = idTipoMoneda;
    }

    public CuentaBancariaProveedor getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public void setIdCuentaBancaria(CuentaBancariaProveedor idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
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
        hash += (idAnticipoCuenta != null ? idAnticipoCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnticipoCuenta)) {
            return false;
        }
        AnticipoCuenta other = (AnticipoCuenta) object;
        if ((this.idAnticipoCuenta == null && other.idAnticipoCuenta != null) || (this.idAnticipoCuenta != null && !this.idAnticipoCuenta.equals(other.idAnticipoCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.AnticipoCuenta[ idAnticipoCuenta=" + idAnticipoCuenta + " ]";
    }

}
