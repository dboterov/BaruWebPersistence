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
@Table(name = "CONTEO_TIENDA")
public class ConteoTienda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idConteo")
    private Integer idConteo;
    @Basic(optional = false)
    @Column(name = "tienda")
    private String tienda;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "dotacion")
    private Boolean dotacion;
    @Column(name = "cliente")
    private Boolean cliente;
    @Column(name = "venta")
    private Boolean venta;
    @Column(name = "ubicacion")
    private String ubicacion;
    @Column(name = "casilla")
    private Boolean casilla;
    @Column(name = "pda")
    private Boolean pda;
    @Column(name = "usuarioFinaliza")
    private String usuarioFinaliza;
    @Column(name = "proveedor")
    private String proveedor;
    @JoinColumn(name = "idTipoConteo", referencedColumnName = "idTipoConteo")
    @ManyToOne(optional = false)
    private TipoConteo idTipoConteo;

    public ConteoTienda() {
    }

    public ConteoTienda(Integer idConteo) {
        this.idConteo = idConteo;
    }

    public ConteoTienda(Integer idConteo, String tienda, Date fecha, String estado, String usuario, Boolean dotacion, Boolean cliente,
            Boolean venta, String ubicacion, Boolean casilla, Boolean pda, String usuarioFinaliza, TipoConteo idTipoConteo) {
        this.idConteo = idConteo;
        this.tienda = tienda;
        this.fecha = fecha;
        this.estado = estado;
        this.usuario = usuario;
        this.dotacion = dotacion;
        this.cliente = cliente;
        this.venta = venta;
        this.ubicacion = ubicacion;
        this.casilla = casilla;
        this.pda = pda;
        this.usuarioFinaliza = usuarioFinaliza;
        this.idTipoConteo = idTipoConteo;
    }

    public Integer getIdConteo() {
        return idConteo;
    }

    public void setIdConteo(Integer idConteo) {
        this.idConteo = idConteo;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Boolean getDotacion() {
        return dotacion;
    }

    public void setDotacion(Boolean dotacion) {
        this.dotacion = dotacion;
    }

    public Boolean getCliente() {
        return cliente;
    }

    public void setCliente(Boolean cliente) {
        this.cliente = cliente;
    }

    public Boolean getVenta() {
        return venta;
    }

    public void setVenta(Boolean venta) {
        this.venta = venta;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Boolean getCasilla() {
        return casilla;
    }

    public void setCasilla(Boolean casilla) {
        this.casilla = casilla;
    }

    public Boolean getPda() {
        return pda;
    }

    public void setPda(Boolean pda) {
        this.pda = pda;
    }

    public String getUsuarioFinaliza() {
        return usuarioFinaliza;
    }

    public void setUsuarioFinaliza(String usuarioFinaliza) {
        this.usuarioFinaliza = usuarioFinaliza;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public TipoConteo getIdTipoConteo() {
        return idTipoConteo;
    }

    public void setIdTipoConteo(TipoConteo idTipoConteo) {
        this.idTipoConteo = idTipoConteo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConteo != null ? idConteo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConteoTienda)) {
            return false;
        }
        ConteoTienda other = (ConteoTienda) object;
        if ((this.idConteo == null && other.idConteo != null) || (this.idConteo != null && !this.idConteo.equals(other.idConteo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.ConteoTienda[ idConteo=" + idConteo + " ]";
    }
}
