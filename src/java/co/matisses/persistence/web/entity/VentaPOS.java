package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "VENTA_POS")
@NamedQueries({
    @NamedQuery(name = "VentaPOS.findAll", query = "SELECT v FROM VentaPOS v")})
@XmlRootElement
public class VentaPOS implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVentaPOS")
    private Long idVentaPOS;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = true)
    @Column(name = "nit")
    private String nit;
    @Basic(optional = false)
    @Column(name = "estacion")
    private String estacion;
    @Basic(optional = false)
    @Column(name = "almacen")
    private String almacen;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "idTurnoCaja")
    private Integer idTurnoCaja;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVenta")
    private List<DetalleVentaPOS> productos;

    public VentaPOS() {
        productos = new ArrayList<>();
    }

    public VentaPOS(Long idVentaPOS, Date fecha, String usuario, String nit, String estacion, String almacen, String estado, Integer idTurnoCaja) {
        this.idVentaPOS = idVentaPOS;
        this.fecha = fecha;
        this.usuario = usuario;
        this.nit = nit;
        this.estacion = estacion;
        this.almacen = almacen;
        this.estado = estado;
        this.idTurnoCaja = idTurnoCaja;
        productos = new ArrayList<>();
    }

    public Long getIdVentaPOS() {
        return idVentaPOS;
    }

    public void setIdVentaPOS(Long idVentaPOS) {
        this.idVentaPOS = idVentaPOS;
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdTurnoCaja() {
        return idTurnoCaja;
    }

    public void setIdTurnoCaja(Integer idTurnoCaja) {
        this.idTurnoCaja = idTurnoCaja;
    }

    public List<DetalleVentaPOS> getProductos() {
        return productos;
    }

    public void setProductos(List<DetalleVentaPOS> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "VentaPOS{" + "idVentaPOS=" + idVentaPOS + ", fecha=" + fecha + ", usuario=" + usuario + ", nit=" + nit + ", estacion=" + estacion + ", almacen=" + almacen + ", estado=" + estado + ", idTurnoCaja=" + idTurnoCaja + '}';
    }

}
