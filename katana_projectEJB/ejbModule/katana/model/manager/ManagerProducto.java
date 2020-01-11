package katana.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import katana.model.entities.ProColor;
import katana.model.entities.ProTalla;
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
    
    
    
}
