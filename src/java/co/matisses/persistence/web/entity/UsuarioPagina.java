package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mperdomo
 */
@Entity
@Table(name = "USUARIO_PAGINA")
public class UsuarioPagina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long usuarioId;
    @Basic(optional = false)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @Column(name = "contrasena")
    private String password;
    @Column(name = "es_lista")
    private Boolean esLista;
    @Basic(optional = false)
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "es_nuevo")
    private Boolean esNuevo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "idLista", referencedColumnName = "idLista")
    @OneToOne(optional = true)
    private ListaRegalos idListaRegalos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<ListaRegalos> listas;
    @Basic(optional = true)
    @Column(name = "es_decorador")
    private Boolean esDecorador;
    @Basic(optional = true)
    @Column(name = "es_planificador")
    private Boolean esPlanificador;
    @Column(name = "pendienteAprobacionDecorador")
    private Boolean pendienteAprobacionDecorador;
    @Column(name = "pendienteAprobacionPlanificador")
    private Boolean pendienteAprobacionPlanificador;
    @Basic(optional = true)
    @Column(name = "documento")
    private String documento;
    @Basic(optional = true)
    @Column(name = "aceptaTerminos")
    private Boolean aceptaTerminos;
    @Basic(optional = true)
    @Column(name = "suscripcionNotificaciones")
    private Boolean suscripcionNotificaciones;
    @Column(name = "es_admin")
    private Boolean esAdmin;

    public UsuarioPagina() {
    }

    public UsuarioPagina(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEsLista() {
        return esLista;
    }

    public void setEsLista(Boolean esLista) {
        this.esLista = esLista;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(Boolean esNuevo) {
        this.esNuevo = esNuevo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaRegalos getIdListaRegalos() {
        return idListaRegalos;
    }

    public void setIdListaRegalos(ListaRegalos idListaRegalos) {
        this.idListaRegalos = idListaRegalos;
    }

    public List<ListaRegalos> getListas() {
        return listas;
    }

    public void setListas(List<ListaRegalos> listas) {
        this.listas = listas;
    }

    public Boolean getEsDecorador() {
        return esDecorador;
    }

    public void setEsDecorador(Boolean esDecorador) {
        this.esDecorador = esDecorador;
    }

    public Boolean getEsPlanificador() {
        return esPlanificador;
    }

    public void setEsPlanificador(Boolean esPlanificador) {
        this.esPlanificador = esPlanificador;
    }

    public Boolean getPendienteAprobacionDecorador() {
        return pendienteAprobacionDecorador;
    }

    public void setPendienteAprobacionDecorador(Boolean pendienteAprobacionDecorador) {
        this.pendienteAprobacionDecorador = pendienteAprobacionDecorador;
    }

    public Boolean getPendienteAprobacionPlanificador() {
        return pendienteAprobacionPlanificador;
    }

    public void setPendienteAprobacionPlanificador(Boolean pendienteAprobacionPlanificador) {
        this.pendienteAprobacionPlanificador = pendienteAprobacionPlanificador;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Boolean getAceptaTerminos() {
        return aceptaTerminos;
    }

    public Boolean getSuscripcionNotificaciones() {
        return suscripcionNotificaciones;
    }

    public void setAceptaTerminos(Boolean aceptaTerminos) {
        this.aceptaTerminos = aceptaTerminos;
    }

    public void setSuscripcionNotificaciones(Boolean suscripcionNotificaciones) {
        this.suscripcionNotificaciones = suscripcionNotificaciones;
    }
    
    public void setEsAdmin(Boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public Boolean getEsAdmin() {
        return esAdmin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreUsuario != null ? nombreUsuario.hashCode() : 0);
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
        final UsuarioPagina other = (UsuarioPagina) obj;
        if (!Objects.equals(this.usuarioId, other.usuarioId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.web.persistence.entity.UsuarioPagina[ usuario=" + nombreUsuario + " ]";
    }
}
