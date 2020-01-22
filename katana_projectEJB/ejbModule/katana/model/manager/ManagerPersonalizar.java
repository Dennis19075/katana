package katana.model.manager;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import katana.model.entities.ProCamiseta;
import katana.model.entities.ProEstilo;
import katana.model.entities.ProLogo;
import katana.model.entities.ProPersonalizado;



/**
 * Session Bean implementation class ManagerProducto
 */
@Stateless
@LocalBean
public class ManagerPersonalizar {
	@PersistenceContext
	private EntityManager em;


    /**
     * Default constructor. 
     */
    public ManagerPersonalizar() {
        // TODO Auto-generated constructor stub
    }
    
    /**CRUD DE LA TABLA pro_camiseta*/
    public List<ProPersonalizado> findAllPersonalizadas(){
    	String consulta="SELECT p FROM ProPersonalizado p";
    	Query q=em.createQuery(consulta, ProPersonalizado.class);
    	return q.getResultList();
    }
    
    public ProPersonalizado findPersonalizadaById(int id) {
    	return em.find(ProPersonalizado.class, id);
    }
    public void insertarPersonalizada(ProPersonalizado personalizada) throws Exception {
    	ProPersonalizado camiseta_personalizada =new ProPersonalizado();
    	camiseta_personalizada.setImagen1(personalizada.getImagen1());
    	camiseta_personalizada.setObservacion(personalizada.getObservacion());//ya voy a hacer un textArea para esto
    	camiseta_personalizada.setPrecio(BigDecimal.valueOf(5.0));//EL PRECIO MANDO $5 POR AHORA POR LO QUE ES NOT NULL

    	//aqui tambien deben insertarse la camiseta y el color que son dos tablas que se relacionan
    	
        em.persist(camiseta_personalizada);
    }
    public void eliminarPersonalizada(int id) {
    	ProPersonalizado camiseta_personalizada=findPersonalizadaById(id);
    	if(camiseta_personalizada!=null)
    		em.remove(camiseta_personalizada);
    }
    public void actualizarPersonalizada(ProPersonalizado personalizada) throws Exception {
    	ProPersonalizado camiseta_personalizada=findPersonalizadaById(personalizada.getIdPersonalizado());
    	if(camiseta_personalizada==null)
    		throw new Exception("No existe esta camiseta personalizada");
    	camiseta_personalizada.setImagen1(personalizada.getImagen1());
    	camiseta_personalizada.setObservacion(personalizada.getObservacion());//ya voy a hacer un textArea para esto
    	camiseta_personalizada.setPrecio(personalizada.getPrecio());//EL PRECIO MANDO $5 POR AHORA POR LO QUE ES NOT NULL
    	em.merge(camiseta_personalizada);
    	
    }

    
    
    
}
