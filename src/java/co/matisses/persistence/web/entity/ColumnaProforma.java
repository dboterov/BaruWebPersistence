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
@Table(name = "COLUMNA_PROFORMA")
@NamedQueries({
    @NamedQuery(name = "ColumnaProforma.findAll", query = "SELECT c FROM ColumnaProforma c")})
public class ColumnaProforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idColumna")
    private Integer idColumna;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre1")
    private String nombre1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre1Ingles")
    private String nombre1Ingles;
    @Basic(optional = true)
    @Column(name = "nombre2")
    private String nombre2;
    @Basic(optional = true)
    @Column(name = "nombre2Ingles")
    private String nombre2Ingles;
    @Column(name = "permitirCrearItem")
    private Boolean permitirCrearItem;
    @Column(name = "requiereOperacion")
    private Boolean requiereOperacion;
    @Column(name = "tipoItem")
    private Boolean tipoItem;
    @Column(name = "tipoIdentificador")
    private Boolean tipoIdentificador;
    @Column(name = "decimalesVisibles")
    private Integer decimalesVisibles;
    @Basic(optional = true)
    @Column(name = "longitudOcupadaTabla")
    private String longitudOcupadaTabla;
    @Column(name = "tipoImagen")
    private Boolean tipoImagen;
    @Column(name = "obligatoria")
    private Boolean obligatoria;
    @Column(name = "incluirProforma")
    private Boolean incluirProforma;
    @Column(name = "modificable")
    private Boolean modificable;
    @Column(name = "modificableSiNuevo")
    private Boolean modificableSiNuevo;
    @Column(name = "tipoValorTotal")
    private Boolean tipoValorTotal;
    @Column(name = "tipoCantidad")
    private Boolean tipoCantidad;
    @Column(name = "tipoCBM")
    private Boolean tipoCBM;
    @Column(name = "tipoValorUnitario")
    private Boolean tipoValorUnitario;
    @Column(name = "tipoDescuento")
    private Boolean tipoDescuento;
    @Column(name = "tipoDescripcionItem")
    private Boolean tipoDescripcionItem;
    @OneToMany(mappedBy = "idColumna2")
    private List<DetalleOperacionColumna> detalleOperacionColumnaList;
    @OneToMany(mappedBy = "idColumna1")
    private List<DetalleOperacionColumna> detalleOperacionColumnaList1;
    @JoinColumn(name = "idTipoDato", referencedColumnName = "idTipoDato")
    @ManyToOne
    private TipoDato idTipoDato;
    @JoinColumn(name = "idOperacionColumna", referencedColumnName = "idOperacionColumnaProforma")
    @ManyToOne
    private OperacionColumnasProforma idOperacionColumna;

    public ColumnaProforma() {
    }

    public ColumnaProforma(Integer idColumna) {
        this.idColumna = idColumna;
    }

    public ColumnaProforma(Integer idColumna, String nombre1, String nombre1Ingles, String nombre2, String nombre2Ingles) {
        this.idColumna = idColumna;
        this.nombre1 = nombre1;
        this.nombre1Ingles = nombre1Ingles;
        this.nombre2 = nombre2;
        this.nombre2Ingles = nombre2Ingles;
    }

    public Integer getIdColumna() {
        return idColumna;
    }

    public void setIdColumna(Integer idColumna) {
        this.idColumna = idColumna;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre1Ingles() {
        return nombre1Ingles;
    }

    public void setNombre1Ingles(String nombre1Ingles) {
        this.nombre1Ingles = nombre1Ingles;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getNombre2Ingles() {
        return nombre2Ingles;
    }

    public void setNombre2Ingles(String nombre2Ingles) {
        this.nombre2Ingles = nombre2Ingles;
    }

    public Boolean getPermitirCrearItem() {
        return permitirCrearItem;
    }

    public void setPermitirCrearItem(Boolean permitirCrearItem) {
        this.permitirCrearItem = permitirCrearItem;
    }

    public Boolean getRequiereOperacion() {
        return requiereOperacion;
    }

    public void setRequiereOperacion(Boolean requiereOperacion) {
        this.requiereOperacion = requiereOperacion;
    }

    public Boolean getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(Boolean tipoItem) {
        this.tipoItem = tipoItem;
    }

    public Boolean getTipoIdentificador() {
        return tipoIdentificador;
    }

    public void setTipoIdentificador(Boolean tipoIdentificador) {
        this.tipoIdentificador = tipoIdentificador;
    }

    public Integer getDecimalesVisibles() {
        return decimalesVisibles;
    }

    public void setDecimalesVisibles(Integer decimalesVisibles) {
        this.decimalesVisibles = decimalesVisibles;
    }

    public List<DetalleOperacionColumna> getDetalleOperacionColumnaList() {
        return detalleOperacionColumnaList;
    }

    public void setDetalleOperacionColumnaList(List<DetalleOperacionColumna> detalleOperacionColumnaList) {
        this.detalleOperacionColumnaList = detalleOperacionColumnaList;
    }

    public List<DetalleOperacionColumna> getDetalleOperacionColumnaList1() {
        return detalleOperacionColumnaList1;
    }

    public void setDetalleOperacionColumnaList1(List<DetalleOperacionColumna> detalleOperacionColumnaList1) {
        this.detalleOperacionColumnaList1 = detalleOperacionColumnaList1;
    }

    public TipoDato getIdTipoDato() {
        return idTipoDato;
    }

    public void setIdTipoDato(TipoDato idTipoDato) {
        this.idTipoDato = idTipoDato;
    }

    public OperacionColumnasProforma getIdOperacionColumna() {
        return idOperacionColumna;
    }

    public void setIdOperacionColumna(OperacionColumnasProforma idOperacionColumna) {
        this.idOperacionColumna = idOperacionColumna;
    }

    public String getLongitudOcupadaTabla() {
        return longitudOcupadaTabla;
    }

    public void setLongitudOcupadaTabla(String longitudOcupadaTabla) {
        this.longitudOcupadaTabla = longitudOcupadaTabla;
    }

    public Boolean getTipoImagen() {
        return tipoImagen;
    }

    public void setTipoImagen(Boolean tipoImagen) {
        this.tipoImagen = tipoImagen;
    }

    public Boolean getObligatoria() {
        return obligatoria;
    }

    public void setObligatoria(Boolean obligatoria) {
        this.obligatoria = obligatoria;
    }

    public Boolean getIncluirProforma() {
        return incluirProforma;
    }

    public void setIncluirProforma(Boolean incluirProforma) {
        this.incluirProforma = incluirProforma;
    }

    public Boolean getModificable() {
        return modificable;
    }

    public void setModificable(Boolean modificable) {
        this.modificable = modificable;
    }

    public Boolean getModificableSiNuevo() {
        return modificableSiNuevo;
    }

    public void setModificableSiNuevo(Boolean modificableSiNuevo) {
        this.modificableSiNuevo = modificableSiNuevo;
    }

    public Boolean getTipoValorTotal() {
        return tipoValorTotal;
    }

    public void setTipoValorTotal(Boolean tipoValorTotal) {
        this.tipoValorTotal = tipoValorTotal;
    }

    public Boolean getTipoCantidad() {
        return tipoCantidad;
    }

    public void setTipoCantidad(Boolean tipoCantidad) {
        this.tipoCantidad = tipoCantidad;
    }

    public Boolean getTipoCBM() {
        return tipoCBM;
    }

    public void setTipoCBM(Boolean tipoCBM) {
        this.tipoCBM = tipoCBM;
    }

    public Boolean getTipoValorUnitario() {
        return tipoValorUnitario;
    }

    public void setTipoValorUnitario(Boolean tipoValorUnitario) {
        this.tipoValorUnitario = tipoValorUnitario;
    }

    public Boolean getTipoDescuento() {
        return tipoDescuento;
    }

    public void setTipoDescuento(Boolean tipoDescuento) {
        this.tipoDescuento = tipoDescuento;
    }

    public Boolean getTipoDescripcionItem() {
        return tipoDescripcionItem;
    }

    public void setTipoDescripcionItem(Boolean tipoDescripcionItem) {
        this.tipoDescripcionItem = tipoDescripcionItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColumna != null ? idColumna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ColumnaProforma)) {
            return false;
        }
        ColumnaProforma other = (ColumnaProforma) object;
        if ((this.idColumna == null && other.idColumna != null) || (this.idColumna != null && !this.idColumna.equals(other.idColumna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.ColumnaProforma[ idColumna=" + idColumna + " ]";
    }
}
