package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ProcesoCcyga;
import co.matisses.persistence.web.entity.ProcesoProductoCcyga;
import co.matisses.persistence.web.entity.ProductoCcyga;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author dbotero Modifica ygil 29-09-2016
 */
@Stateless
@LocalBean
public class ProductoCcygaFacade extends AbstractFacade<ProductoCcyga> {

    private static final Logger log = Logger.getLogger(ProductoCcygaFacade.class.getSimpleName());
    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoCcygaFacade() {
        super(ProductoCcyga.class);
    }

    public List<ProductoCcyga> consultarProductosCcygaReferencia(String referencia) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProductoCcyga> cq = cb.createQuery(ProductoCcyga.class);
        Root<ProductoCcyga> root = cq.from(ProductoCcyga.class);
        cq.where(cb.equal(root.get("referencia"), referencia));
        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public List<ProductoCcyga> consultarProductosPorProceso(Integer idProceso) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProductoCcyga> cq = cb.createQuery(ProductoCcyga.class);
        Root<ProcesoProductoCcyga> root = cq.from(ProcesoProductoCcyga.class);
        cq.select(root.<ProductoCcyga>get("idProducto"));
        cq.distinct(true);
        cq.where(cb.and(
                cb.equal(root.get("idProceso").get("idProceso"), idProceso),
                cb.equal(root.get("estado"), "PE")));
        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar los productos por proceso. ", e);
            return new ArrayList<>();
        }
    }

    private List<ProductoCcyga> procesarResultadoProductosActivos(String query) {
        try {
            List<ProductoCcyga> productos = new ArrayList<>();
            List<Object[]> resultados = em.createNativeQuery(query).getResultList();
            for (Object[] fila : resultados) {
                int columna = 0;
                Integer idProducto = (Integer) fila[columna++];
                String referencia = (String) fila[columna++];
                String descripcion = (String) fila[columna++];
                String refProveedor = (String) fila[columna++];
                String documento = (String) fila[columna++];
                String requerimiento = (String) fila[columna++];
                String estadoProducto = (String) fila[columna++];
                Boolean cliente = (Boolean) fila[columna++];
                Boolean demo = (Boolean) fila[columna++];
                Integer idProcesoProducto = (Integer) fila[columna++];
                Integer idProceso = (Integer) fila[columna++];
                String comentarioProceso = (String) fila[columna++];
                String estadoProceso = (String) fila[columna++];
                String nombreProceso = (String) fila[columna++];
                Boolean permiteSimultaneos = (Boolean) fila[columna++];

                ProductoCcyga entidadProducto = new ProductoCcyga(idProducto);
                if (productos.contains(entidadProducto)) {
                    entidadProducto = productos.get(productos.indexOf(entidadProducto));
                } else {
                    entidadProducto.setCliente(cliente);
                    entidadProducto.setDemo(demo);
                    entidadProducto.setDescripcion(descripcion);
                    entidadProducto.setDocumento(documento);
                    entidadProducto.setEstado(estadoProducto);
                    entidadProducto.setRefProveedor(refProveedor);
                    entidadProducto.setReferencia(referencia);
                    entidadProducto.setRequerimiento(requerimiento);

                    productos.add(entidadProducto);
                }

                ProcesoCcyga entidadProceso = new ProcesoCcyga(idProceso);
                entidadProceso.setNombre(nombreProceso);
                entidadProceso.setPermiteSimultaneos(permiteSimultaneos);

                ProcesoProductoCcyga entidadProcesoProducto = new ProcesoProductoCcyga(idProcesoProducto);
                entidadProcesoProducto.setComentarios(comentarioProceso);
                entidadProcesoProducto.setEstado(estadoProceso);
                entidadProcesoProducto.setIdProceso(entidadProceso);
                entidadProcesoProducto.setIdProducto(entidadProducto);

                entidadProducto.getProcesoProductoCcygaList().add(entidadProcesoProducto);
            }
            return productos;
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar los productos por proceso. ", e);
            return new ArrayList<>();
        }
    }

    public List<ProductoCcyga> consultarProductosActivosEmpleado(String codEmpleado) {
        StringBuilder sb = new StringBuilder();
        sb.append("select distinct prod.idProducto, prod.referencia, prod.descripcion, prod.refProveedor, prod.documento, prod.requerimiento, ");
        sb.append("prod.estado, prod.cliente, prod.demo, procesoProd.idProcesoProducto, procesoProd.idProceso, procesoProd.comentarios, ");
        sb.append("procesoProd.estado estadoProceso, proceso.nombre, proceso.permiteSimultaneos ");
        sb.append("from PRODUCTO_CCYGA prod ");
        sb.append("inner join PROCESO_PRODUCTO_CCYGA procesoProd on procesoProd.idProducto = prod.idProducto ");
        sb.append("inner join PROCESO_CCYGA proceso on proceso.idProceso = procesoProd.idProceso ");
        sb.append("inner join LABOR_CCYGA labor on labor.idProcesoProducto = procesoProd.idProcesoProducto ");
        sb.append("where  prod.estado = 'PE' ");
        sb.append("and    procesoProd.estado = 'PE' ");
        sb.append("and    labor.codRevisado = '");
        sb.append(codEmpleado);
        sb.append("' and    labor.horaFin is null");

        return procesarResultadoProductosActivos(sb.toString());
    }

    public List<ProductoCcyga> consultarProductosActivos(int pagina, int registrosPagina, String orderBy, String sortOrder, String parametroBusqueda, String filtro) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT * ");
        sb.append("FROM   (SELECT distinct prod.idProducto, ");
        sb.append("		  prod.referencia, ");
        sb.append("		  prod.descripcion, ");
        sb.append("		  prod.refProveedor, ");
        sb.append("		  prod.documento, ");
        sb.append("		  prod.requerimiento, ");
        sb.append("		  prod.estado, ");
        sb.append("		  prod.cliente, ");
        sb.append("		  prod.demo ");
        sb.append("	   FROM   PRODUCTO_CCYGA prod ");
        sb.append("	   INNER  JOIN PROCESO_PRODUCTO_CCYGA procesoProd ON procesoProd.idProducto = prod.idProducto ");
        sb.append("	   WHERE  prod.estado = 'PE' ");
        sb.append("	   AND    procesoProd.estado = 'PE' ");
        if (parametroBusqueda != null && !parametroBusqueda.isEmpty()) {
            sb.append("AND    (prod.referencia LIKE '%");
            sb.append(parametroBusqueda);
            sb.append("%' ");
            sb.append("OR     prod.descripcion LIKE '%");
            sb.append(parametroBusqueda);
            sb.append("%' ");
            sb.append("OR     prod.idProducto LIKE '%");
            sb.append(parametroBusqueda);
            sb.append("%')");
        }
        if (filtro != null && filtro.equals("clientes")) {
            sb.append("	   AND    prod.cliente = '1' ");
        } else if (filtro != null && filtro.equals("demostraciones")) {
            sb.append("	   AND    prod.demo = '1' ");
        } else if (filtro != null && filtro.equals("ventas")) {
            sb.append("	   AND    prod.cliente = '0' ");
            sb.append("	   AND    prod.demo = '0' ");
        }
        sb.append(") t ");
        sb.append("ORDER   BY ");
        sb.append(orderBy);
        sb.append(" ");
        sb.append(sortOrder);
        sb.append(" OFFSET ");
        sb.append(registrosPagina);
        sb.append(" * ( ");
        sb.append(pagina);
        sb.append(" - 1) ROW FETCH NEXT  ");
        sb.append(registrosPagina);
        sb.append(" ROWS ONLY");

        try {
            return em.createNativeQuery(sb.toString(), ProductoCcyga.class).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }

//        StringBuilder sb = new StringBuilder();
//        sb.append("select prod.idProducto, prod.referencia, prod.descripcion, prod.refProveedor, prod.documento, prod.requerimiento, ");
//        sb.append("prod.estado, prod.cliente, prod.demo, procesoProd.idProcesoProducto, procesoProd.idProceso, procesoProd.comentarios, ");
//        sb.append("procesoProd.estado estadoProceso, proceso.nombre, proceso.permiteSimultaneos ");
//        sb.append("from PRODUCTO_CCYGA prod ");
//        sb.append("inner join PROCESO_PRODUCTO_CCYGA procesoProd on procesoProd.idProducto = prod.idProducto ");
//        sb.append("inner join PROCESO_CCYGA proceso on proceso.idProceso = procesoProd.idProceso ");
//        sb.append("where  prod.estado = 'PE' ");
//        sb.append("and    procesoProd.estado = 'PE' ");
//        return procesarResultadoProductosActivos(sb.toString());
    }

    public int consultarTotalRegistrosAbiertos(String parametroBusqueda, String filtro) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT COUNT(*) ");
        sb.append("FROM   (SELECT distinct prod.idProducto, ");
        sb.append("		  prod.referencia, ");
        sb.append("		  prod.descripcion, ");
        sb.append("		  prod.refProveedor, ");
        sb.append("		  prod.documento, ");
        sb.append("		  prod.requerimiento, ");
        sb.append("		  prod.estado, ");
        sb.append("		  prod.cliente, ");
        sb.append("		  prod.demo ");
        sb.append("	   FROM   PRODUCTO_CCYGA prod ");
        sb.append("	   INNER  JOIN PROCESO_PRODUCTO_CCYGA procesoProd ON procesoProd.idProducto = prod.idProducto ");
        sb.append("	   WHERE  prod.estado = 'PE' ");
        sb.append("	   AND    procesoProd.estado = 'PE' ");
        if (parametroBusqueda != null && !parametroBusqueda.isEmpty()) {
            sb.append("AND    (prod.referencia LIKE '%");
            sb.append(parametroBusqueda);
            sb.append("%' ");
            sb.append("OR     prod.descripcion LIKE '%");
            sb.append(parametroBusqueda);
            sb.append("%' ");
            sb.append("OR     prod.idProducto LIKE '%");
            sb.append(parametroBusqueda);
            sb.append("%')");
        }
        if (filtro != null && filtro.equals("clientes")) {
            sb.append("	   AND    prod.cliente = '1' ");
        } else if (filtro != null && filtro.equals("demostraciones")) {
            sb.append("	   AND    prod.demo = '1' ");
        } else if (filtro != null && filtro.equals("ventas")) {
            sb.append("	   AND    prod.cliente = '0' ");
            sb.append("	   AND    prod.demo = '0' ");
        }
        sb.append(") t ");

        try {
            return (Integer) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return 1;
        }
    }

    public List<Object[]> obtenerHistoricoProducto(String referencia, Integer idProducto) {
        StringBuilder sb = new StringBuilder();

        sb.append("select producto.referencia, producto.idProducto, proceso.idProceso, proceso.nombre, labor.fecha, labor.codRevisado, labor.horainicio, ");
        sb.append("labor.horaFin, labor.idLabor ");
        sb.append("from   PRODUCTO_CCYGA producto ");
        sb.append("inner join PROCESO_PRODUCTO_CCYGA procesoProducto on procesoProducto.idProducto = producto.idProducto ");
        sb.append("inner join PROCESO_CCYGA proceso on proceso.idProceso = procesoProducto.idProceso ");
        sb.append("inner join LABOR_CCYGA labor on labor.idProcesoProducto = procesoProducto.idProcesoProducto ");
        if (idProducto != null) {
            sb.append("where  producto.idProducto = ");
            sb.append(idProducto);
        } else {
            sb.append("where  producto.referencia = '");
            sb.append(referencia);
            sb.append("' ");
        }
        sb.append(" order by producto.idProducto, proceso.nombre, labor.fecha, labor.horainicio, labor.horaFin ");

        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al calcular el historico para el producto. ", e);
        }

        return null;
    }

    public void cerrarProducto(Integer idProducto) {
        StringBuilder sb = new StringBuilder();

        sb.append("UPDATE PRODUCTO_CCYGA ");
        sb.append("SET    estado = 'TE' ");
        sb.append("WHERE  idProducto = ");
        sb.append(idProducto);

        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
        }
    }
}
