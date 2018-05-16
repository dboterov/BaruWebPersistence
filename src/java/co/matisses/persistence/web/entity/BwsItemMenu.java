package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "BWS_ITEM_MENU")
@NamedQueries({
    @NamedQuery(name = "BwsItemMenu.findAll", query = "SELECT b FROM BwsItemMenu b")})
public class BwsItemMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idItemMenu")
    private Integer idItemMenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 20)
    @Column(name = "nombreAlterno")
    private String nombreAlterno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esMenu")
    private boolean esMenu;
    @Size(max = 100)
    @Column(name = "ruta")
    private String ruta;
    @Column(name = "orden")
    private Integer orden;
    @Column(name = "separadorAntes")
    private Boolean separadorAntes;
    @Column(name = "separadorDespues")
    private Boolean separadorDespues;
    @Column(name = "activo")
    private Boolean activo;
    @Size(max = 10)
    @Column(name = "destino")
    private String destino;
    @JoinColumn(name = "idObjeto", referencedColumnName = "codigo")
    @ManyToOne
    private BwsObjeto idObjeto;
    @OneToMany(mappedBy = "idItemMenuPadre")
    private List<BwsItemMenu> bwsItemMenuList;
    @JoinColumn(name = "idItemMenuPadre", referencedColumnName = "idItemMenu")
    @ManyToOne
    private BwsItemMenu idItemMenuPadre;
    @JoinColumn(name = "idAccionObjeto", referencedColumnName = "idAccionObjeto")
    @ManyToOne
    private BwsAccionObjeto idAccionObjeto;

    public BwsItemMenu() {
    }

    public BwsItemMenu(Integer idItemMenu) {
        this.idItemMenu = idItemMenu;
    }

    public BwsItemMenu(Integer idItemMenu, String nombre, boolean esMenu) {
        this.idItemMenu = idItemMenu;
        this.nombre = nombre;
        this.esMenu = esMenu;
    }

    public Integer getIdItemMenu() {
        return idItemMenu;
    }

    public void setIdItemMenu(Integer idItemMenu) {
        this.idItemMenu = idItemMenu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreAlterno() {
        return nombreAlterno;
    }

    public void setNombreAlterno(String nombreAlterno) {
        this.nombreAlterno = nombreAlterno;
    }

    public boolean getEsMenu() {
        return esMenu;
    }

    public void setEsMenu(boolean esMenu) {
        this.esMenu = esMenu;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public BwsObjeto getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(BwsObjeto idObjeto) {
        this.idObjeto = idObjeto;
    }

    public List<BwsItemMenu> getBwsItemMenuList() {
        return bwsItemMenuList;
    }

    public void setBwsItemMenuList(List<BwsItemMenu> bwsItemMenuList) {
        this.bwsItemMenuList = bwsItemMenuList;
    }

    public BwsItemMenu getIdItemMenuPadre() {
        return idItemMenuPadre;
    }

    public void setIdItemMenuPadre(BwsItemMenu idItemMenuPadre) {
        this.idItemMenuPadre = idItemMenuPadre;
    }

    public BwsAccionObjeto getIdAccionObjeto() {
        return idAccionObjeto;
    }

    public void setIdAccionObjeto(BwsAccionObjeto idAccionObjeto) {
        this.idAccionObjeto = idAccionObjeto;
    }

    public Boolean getSeparadorAntes() {
        return separadorAntes;
    }

    public void setSeparadorAntes(Boolean separadorAntes) {
        this.separadorAntes = separadorAntes;
    }

    public Boolean getSeparadorDespues() {
        return separadorDespues;
    }

    public void setSeparadorDespues(Boolean separadorDespues) {
        this.separadorDespues = separadorDespues;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItemMenu != null ? idItemMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BwsItemMenu)) {
            return false;
        }
        BwsItemMenu other = (BwsItemMenu) object;
        if ((this.idItemMenu == null && other.idItemMenu != null) || (this.idItemMenu != null && !this.idItemMenu.equals(other.idItemMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.web.persistence.entity.BwsItemMenu[ idItemMenu=" + idItemMenu + " ]";
    }

}
