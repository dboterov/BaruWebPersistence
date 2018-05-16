package co.matisses.persistence.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dbotero
 */
public class ObjetoDTO {

    private Integer codigo;
    private String nombre;
    private List<AccionDTO> acciones;

    public ObjetoDTO() {
        acciones = new ArrayList<>();
    }

    public ObjetoDTO(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        acciones = new ArrayList<>();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarAccion(AccionDTO accion) {
        acciones.add(accion);
    }

    public boolean puede(AccionDTO accion) {
        if (acciones.contains(accion)) {
            return true;
        }
        return false;
    }
}
