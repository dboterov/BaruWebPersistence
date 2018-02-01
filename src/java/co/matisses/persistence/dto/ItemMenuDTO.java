package co.matisses.persistence.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author dbotero
 */
public class ItemMenuDTO implements Comparable<ItemMenuDTO>{

    private Integer idItemMenu;
    private Integer idItemMenuPadre;
    private Integer orden;
    private String nombre;
    private String ruta;
    private String destino;
    private Boolean separadorAntes;
    private Boolean separadorDespues;
    private Boolean activo;
    private List<ItemMenuDTO> submenu;

    public ItemMenuDTO() {
        submenu = new ArrayList<>();
        separadorAntes = false;
        separadorDespues = false;
        activo = true;
    }

    public ItemMenuDTO(Integer idItemMenu) {
        this.idItemMenu = idItemMenu;
        submenu = new ArrayList<>();
        separadorAntes = false;
        separadorDespues = false;
        activo = true;
    }

    public ItemMenuDTO(Integer idItemMenu, Integer idItemMenuPadre, String nombre, String ruta, Boolean separadorAntes, Boolean separadorDespues, Boolean activo, Integer orden, String destino) {
        this.idItemMenu = idItemMenu;
        this.idItemMenuPadre = idItemMenuPadre;
        this.nombre = nombre;
        this.ruta = ruta;
        this.separadorAntes = separadorAntes;
        this.separadorDespues = separadorDespues;
        this.activo = activo;
        this.orden = orden;
        this.destino = destino;
        submenu = new ArrayList<>();
    }

    public Integer getIdItemMenu() {
        return idItemMenu;
    }

    public void setIdItemMenu(Integer idItemMenu) {
        this.idItemMenu = idItemMenu;
    }

    public Integer getIdItemMenuPadre() {
        return idItemMenuPadre;
    }

    public void setIdItemMenuPadre(Integer idItemMenuPadre) {
        this.idItemMenuPadre = idItemMenuPadre;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean esMenu() {
        return !submenu.isEmpty();
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public List<ItemMenuDTO> getSubmenu() {
        return submenu;
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

    public void agregarItemSubmenu(ItemMenuDTO item) {
        if (!submenu.contains(item)) {
            submenu.add(item);
        }
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.idItemMenu);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemMenuDTO other = (ItemMenuDTO) obj;
        if (!Objects.equals(this.idItemMenu, other.idItemMenu)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(ItemMenuDTO o) {
        return this.orden.compareTo(o.getOrden());
    }
}
