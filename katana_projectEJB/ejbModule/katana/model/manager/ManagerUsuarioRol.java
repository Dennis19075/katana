package katana.model.manager;


import katana.model.entities.UsuUsuarioRol;
import katana.model.entities.ProTalla;
import katana.model.entities.UsuRol;
import katana.model.entities.UsuUsuario;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



/**
 * Session Bean implementation class ManagerUsuario
 */
@Stateless
@LocalBean
public class ManagerUsuarioRol {
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public ManagerUsuarioRol() {
        
    }
    
    /**CRUD DE LA TALBLA usu_usuario_rol*/
    public List<UsuUsuarioRol> findAllUsuariosRol(){
    	String consulta="SELECT u FROM UsuUsuarioRol u";
    	Query q=em.createQuery(consulta, UsuUsuarioRol.class);
    	return q.getResultList();
    }
    
    public UsuUsuarioRol findUsuarioRolById(int id) {
    	return em.find(UsuUsuarioRol.class, id);
    }
    /*El metodo de insertar se ocupa dentro del metodo de insertarUsuario
     * los demas metodos se van a poder editar en su propia vista*/
    
    public void insertarUsuarioRol(UsuUsuario usuario, UsuRol rol) throws Exception {
    	UsuUsuarioRol aux=new UsuUsuarioRol();
    	
    	aux.setUsuUsuario(usuario);
    	aux.setUsuRol(rol);

        em.persist(aux);
    }
    public void eliminarUsuarioRol(UsuUsuarioRol usuarioRol) {
    	UsuUsuarioRol aux =findUsuarioRolById(usuarioRol.getIdUsuarioRol());
    	if(aux!=null)
    		em.remove(aux);
    }
    public void actualizarUsuarioRol(UsuUsuarioRol usuarioRol) throws Exception {
    	UsuUsuarioRol e=findUsuarioRolById(usuarioRol.getIdUsuarioRol());
    	if(e==null)
    		throw new Exception("No existe el usuarioRol especificado.");
    	e.setUsuRol(usuarioRol.getUsuRol());
    	em.merge(e);
    	
    }
    

   
}
