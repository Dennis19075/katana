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
    
    public ProTipoProducto findTipoProductoById(int id) {
    	return em.find(ProTipoProducto.class, id);
    }
    public void insertarTipoProducto(ProTipoProducto tipo_producto) throws Exception {
        ProTipoProducto tipo=new ProTipoProducto();
        tipo.setNombre(tipo_producto.getNombre());
    	em.persist(tipo);
    }
    public void eliminarTipoProducto(int id) {
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
    	String consulta="select o from ProColor o";
    	Query q=em.createQuery(consulta, ProColor.class);
    	return q.getResultList();
    }
    
    public ProColor findColorById(int id) {
    	return em.find(ProColor.class, id);
    }
    public void insertarColor(ProColor color) throws Exception {
    	ProColor save_color=new ProColor();
    	save_color.setNombre(color.getNombre());
        em.persist(save_color);
    }
    public void eliminarColor(int id) {
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
