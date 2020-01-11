package katana.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import katana.model.entities.PedEstado;
import katana.model.entities.PedIva;


/**
 * Session Bean implementation class ManagerProducto
 */
@Stateless
@LocalBean
public class ManagerEstado {
	@PersistenceContext
	private EntityManager em;


    /**
     * Default constructor. 
     */
    public ManagerEstado() {
        // TODO Auto-generated constructor stub
    }
    
    /**CRUD DE LA TALBLA pro_estado*/
    public List<PedEstado> findAllEstado(){
    	String consulta="SELECT p FROM PedEstado p";
    	Query q=em.createQuery(consulta, PedEstado.class);
    	return q.getResultList();
    }
    
    public PedEstado findEstadoById(int id) {
    	return em.find(PedEstado.class, id);
    }
    public void insertarEstado(PedEstado estado) throws Exception {
        PedEstado est=new PedEstado();
        est.setNombre(estado.getNombre());
        est.setDescripcion(est.getDescripcion());
        
    	em.persist(est);
    }
    public void eliminarEstado(int id) {
    	PedEstado est=findEstadoById(id);
    	if(est!=null)
    		em.remove(est);
    }
    public void actualizarEstado(PedEstado estado) throws Exception {
    	PedEstado est=findEstadoById(estado.getIdEstado());
    	if(est==null)
    		throw new Exception("No existe ese estado");
    	est.setNombre(estado.getNombre());
        est.setDescripcion(est.getDescripcion());
    	em.merge(est);
    	
    }
    
    
    
}
