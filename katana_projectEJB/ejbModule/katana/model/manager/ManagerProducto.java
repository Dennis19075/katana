package katana.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import katana.model.entities.ProColor;
import katana.model.entities.ProTipoProducto;


/**
 * Session Bean implementation class ManagerProducto
 */
@Stateless
@LocalBean
public class ManagerProducto {
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public ManagerProducto() {
        // TODO Auto-generated constructor stub
    }
    
    /**CRUD DE LA TALBLA pro_tipo_producto*/
    public List<ProTipoProducto> findAllTipoProducto(){
    	String consulta="SELECT p FROM ProTipoProducto p";
    	Query q=em.createQuery(consulta, ProTipoProducto.class);
    	return q.getResultList();
    }
    
    public ProTipoProducto findTipoProductoById(Long id) {
    	return em.find(ProTipoProducto.class, id);
    }
    public void insertarTipoProducto(ProTipoProducto tipo_producto) throws Exception {
    	if(findTipoProductoById(tipo_producto.getIdTipoProducto())!=null)
    		throw new Exception("Ya existe este tipo de prodcto");
        em.persist(tipo_producto);
    }
    public void eliminarTipoProducto(long id) {
    	ProTipoProducto tipo_producto=findTipoProductoById(id);
    	if(tipo_producto!=null)
    		em.remove(tipo_producto);
    }
    public void actualizarTipoProducto(ProTipoProducto tipo_producto) throws Exception {
    	ProTipoProducto e=findTipoProductoById(tipo_producto.getIdTipoProducto());
    	if(e==null)
    		throw new Exception("No existe ese tipo de producto");
    	e.setNombre(tipo_producto.getNombre());
    	em.merge(e);
    	
    }
    
    /**CRUD DE LA TALBLA pro_color*/
    public List<ProColor> findAllColor(){
    	String consulta="select o from ProColor o order by o.id_color";
    	Query q=em.createQuery(consulta, ProColor.class);
    	return q.getResultList();
    }
    
    public ProColor findColorById(Long id) {
    	return em.find(ProColor.class, id);
    }
    public void insertarColor(ProColor color) throws Exception {
    	if(findTipoProductoById(color.getIdColor())!=null)
    		throw new Exception("Ya existe este color");
        em.persist(color);
    }
    public void eliminarColor(long id) {
    	ProColor color=findColorById(id);
    	if(color!=null)
    		em.remove(color);
    }
    public void actualizarColor(ProColor color) throws Exception {
    	ProColor e=findColorById(color.getIdColor());
    	if(e==null)
    		throw new Exception("No existe este color");
    	e.setNombre(color.getNombre());
    	em.merge(e);
    	
    }

}