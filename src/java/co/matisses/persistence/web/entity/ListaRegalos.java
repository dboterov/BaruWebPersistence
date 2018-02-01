package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author dbotero
 */
@Entity
@Table(name = "LISTA_REGALOS")
@NamedQueries({
    @NamedQuery(name = "ListaRegalos.findAll", query = "SELECT l FROM ListaRegalos l")})
public class ListaRegalos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLista")
    private Long idLista;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "cedulaCreador")
    private String cedulaCreador;
    @Basic(optional = false)
    @Column(name = "nombreCreador")
    private String nombreCreador;
    @Basic(optional = false)
    @Column(name = "apellidoCreador")
    private String apellidoCreador;
    @Basic(optional = true)
    @Column(name = "cedulaCocreador")
    private String cedulaCocreador;
    @Basic(optional = true)
    @Column(name = "nombreCocreador")
    private String nombreCocreador;
    @Basic(optional = true)
    @Column(name = "apellidoCocreador")
    private String apellidoCocreador;
    @Basic(optional = false)
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @Column(name = "fechaEvento")
    @Temporal(TemporalType.DATE)
    private Date fechaEvento;
    @JoinColumn(name = "idEstado", referencedColumnName = "idEstado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private EstadoListaRegalos estado;
    @JoinColumn(name = "idTipoEvento", referencedColumnName = "idTipoEvento")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoEvento tipoEvento;
    @Basic(optional = false)
    @Column(name = "listaPrivada")
    private Boolean listaPrivada;
    @Basic(optional = true)
    @Column(name = "rutaImagenPerfil")
    private String rutaImagenPerfil;
    @Basic(optional = true)
    @Column(name = "rutaImagenPortada")
    private String rutaImagenPortada;
    @Basic(optional = true)
    @Column(name = "mensajeBienvenida")
    private String mensajeBienvenida;
    @Basic(optional = true)
    @Column(name = "mensajeAgradecimiento")
    private String mensajeAgradecimiento;
    @Basic(optional = true)
    @Column(name = "invitados")
    private Integer invitados;
    @Basic(optional = true)
    @Column(name = "valorMinimoBono")
    private Integer valorMinimoBono;
    @Basic(optional = false)
    @Column(name = "aceptaBonos")
    private Boolean aceptaBonos;
    @Basic(optional = false)
    @Column(name = "notificacionInmediataCreador")
    private String notificacionInmediataCreador;
    @Basic(optional = false)
    @Column(name = "notificacionDiariaCreador")
    private String notificacionDiariaCreador;
    @Basic(optional = false)
    @Column(name = "notificacionSemanalCreador")
    private String notificacionSemanalCreador;
    @Basic(optional = false)
    @Column(name = "notificacionCambioCategoriaCreador")
    private String notificacionCambioCategoriaCreador;
    @Column(name = "notificacionInmediataCocreador")
    private String notificacionInmediataCocreador;
    @Column(name = "notificacionDiariaCocreador")
    private String notificacionDiariaCocreador;
    @Column(name = "notificacionSemanalCocreador")
    private String notificacionSemanalCocreador;
    @Column(name = "notificacionCambioCategoriaCocreador")
    private String notificacionCambioCategoriaCocreador;
    @Column(name = "permitirEntregaPersonal")
    private Boolean permitirEntregaPersonal;
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CategoriaListaRegalos categoria;
    @Column(name = "activa")
    private Boolean activa;

    public ListaRegalos() {
    }

    public ListaRegalos(Long idLista) {
        this.idLista = idLista;
    }

    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedulaCreador() {
        return cedulaCreador;
    }

    public void setCedulaCreador(String cedulaCreador) {
        this.cedulaCreador = cedulaCreador;
    }

    public String getCedulaCocreador() {
        return cedulaCocreador;
    }

    public void setCedulaCocreador(String cedulaCocreador) {
        this.cedulaCocreador = cedulaCocreador;
    }

    public String getApellidoCocreador() {
        return apellidoCocreador;
    }

    public void setApellidoCocreador(String apellidoCocreador) {
        this.apellidoCocreador = apellidoCocreador;
    }

    public String getApellidoCreador() {
        return apellidoCreador;
    }

    public void setApellidoCreador(String apellidoCreador) {
        this.apellidoCreador = apellidoCreador;
    }

    public String getNombreCocreador() {
        return nombreCocreador;
    }

    public void setNombreCocreador(String nombreCocreador) {
        this.nombreCocreador = nombreCocreador;
    }

    public String getNombreCreador() {
        return nombreCreador;
    }

    public void setNombreCreador(String nombreCreador) {
        this.nombreCreador = nombreCreador;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public EstadoListaRegalos getEstado() {
        return estado;
    }

    public void setEstado(EstadoListaRegalos estado) {
        this.estado = estado;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Boolean getListaPrivada() {
        return listaPrivada;
    }

    public void setListaPrivada(Boolean listaPrivada) {
        this.listaPrivada = listaPrivada;
    }

    public String getRutaImagenPerfil() {
        return rutaImagenPerfil;
    }

    public void setRutaImagenPerfil(String rutaImagenPerfil) {
        this.rutaImagenPerfil = rutaImagenPerfil;
    }

    public String getRutaImagenPortada() {
        return rutaImagenPortada;
    }

    public void setRutaImagenPortada(String rutaImagenPortada) {
        this.rutaImagenPortada = rutaImagenPortada;
    }

    public String getMensajeBienvenida() {
        return mensajeBienvenida;
    }

    public void setMensajeBienvenida(String mensajeBienvenida) {
        this.mensajeBienvenida = mensajeBienvenida;
    }

    public String getMensajeAgradecimiento() {
        return mensajeAgradecimiento;
    }

    public void setMensajeAgradecimiento(String mensajeAgradecimiento) {
        this.mensajeAgradecimiento = mensajeAgradecimiento;
    }

    public Integer getInvitados() {
        return invitados;
    }

    public void setInvitados(Integer invitados) {
        this.invitados = invitados;
    }

    public Integer getValorMinimoBono() {
        return valorMinimoBono;
    }

    public void setValorMinimoBono(Integer valorMinimoBono) {
        this.valorMinimoBono = valorMinimoBono;
    }

    public Boolean getAceptaBonos() {
        return aceptaBonos;
    }

    public void setAceptaBonos(Boolean aceptaBonos) {
        this.aceptaBonos = aceptaBonos;
    }

    public String getNotificacionCambioCategoriaCocreador() {
        return notificacionCambioCategoriaCocreador;
    }

    public void setNotificacionCambioCategoriaCocreador(String notificacionCambioCategoriaCocreador) {
        this.notificacionCambioCategoriaCocreador = notificacionCambioCategoriaCocreador;
    }

    public String getNotificacionCambioCategoriaCreador() {
        return notificacionCambioCategoriaCreador;
    }

    public void setNotificacionCambioCategoriaCreador(String notificacionCambioCategoriaCreador) {
        this.notificacionCambioCategoriaCreador = notificacionCambioCategoriaCreador;
    }

    public String getNotificacionDiariaCocreador() {
        return notificacionDiariaCocreador;
    }

    public void setNotificacionDiariaCocreador(String notificacionDiariaCocreador) {
        this.notificacionDiariaCocreador = notificacionDiariaCocreador;
    }

    public String getNotificacionDiariaCreador() {
        return notificacionDiariaCreador;
    }

    public void setNotificacionDiariaCreador(String notificacionDiariaCreador) {
        this.notificacionDiariaCreador = notificacionDiariaCreador;
    }

    public String getNotificacionInmediataCocreador() {
        return notificacionInmediataCocreador;
    }

    public void setNotificacionInmediataCocreador(String notificacionInmediataCocreador) {
        this.notificacionInmediataCocreador = notificacionInmediataCocreador;
    }

    public String getNotificacionInmediataCreador() {
        return notificacionInmediataCreador;
    }

    public void setNotificacionInmediataCreador(String notificacionInmediataCreador) {
        this.notificacionInmediataCreador = notificacionInmediataCreador;
    }

    public String getNotificacionSemanalCocreador() {
        return notificacionSemanalCocreador;
    }

    public void setNotificacionSemanalCocreador(String notificacionSemanalCocreador) {
        this.notificacionSemanalCocreador = notificacionSemanalCocreador;
    }

    public String getNotificacionSemanalCreador() {
        return notificacionSemanalCreador;
    }

    public void setNotificacionSemanalCreador(String notificacionSemanalCreador) {
        this.notificacionSemanalCreador = notificacionSemanalCreador;
    }

    public Boolean getPermitirEntregaPersonal() {
        return permitirEntregaPersonal;
    }

    public void setPermitirEntregaPersonal(Boolean permitirEntregaPersonal) {
        this.permitirEntregaPersonal = permitirEntregaPersonal;
    }

    public CategoriaListaRegalos getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaListaRegalos categoria) {
        this.categoria = categoria;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.idLista);
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
        final ListaRegalos other = (ListaRegalos) obj;
        return Objects.equals(this.idLista, other.idLista);
    }

    @Override
    public String toString() {
        return "ListaRegalos{" + "idLista=" + idLista + ", codigo=" + codigo + ", nombre=" + nombre + ", cedulaCreador=" + cedulaCreador + ", nombreCreador=" + nombreCreador + ", apellidoCreador=" + apellidoCreador + ", cedulaCocreador=" + cedulaCocreador + ", nombreCocreador=" + nombreCocreador + ", apellidoCocreador=" + apellidoCocreador + ", fechaCreacion=" + fechaCreacion + ", fechaEvento=" + fechaEvento + ", estado=" + estado + ", tipoEvento=" + tipoEvento + ", listaPrivada=" + listaPrivada + ", rutaImagenPerfil=" + rutaImagenPerfil + ", rutaImagenPortada=" + rutaImagenPortada + ", mensajeBienvenida=" + mensajeBienvenida + ", mensajeAgradecimiento=" + mensajeAgradecimiento + ", invitados=" + invitados + ", valorMinimoBono=" + valorMinimoBono + ", aceptaBonos=" + aceptaBonos + ", notificacionInmediataCreador=" + notificacionInmediataCreador + ", notificacionDiariaCreador=" + notificacionDiariaCreador + ", notificacionSemanalCreador=" + notificacionSemanalCreador + ", notificacionCambioCategoriaCreador=" + notificacionCambioCategoriaCreador + ", notificacionInmediataCocreador=" + notificacionInmediataCocreador + ", notificacionDiariaCocreador=" + notificacionDiariaCocreador + ", notificacionSemanalCocreador=" + notificacionSemanalCocreador + ", notificacionCambioCategoriaCocreador=" + notificacionCambioCategoriaCocreador + ", permitirEntregaPersonal=" + permitirEntregaPersonal + ", categoria=" + categoria + ", activa=" + activa + '}';
    }

}
