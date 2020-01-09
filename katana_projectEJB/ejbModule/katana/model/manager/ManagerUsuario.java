package katana.model.manager;
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
public class ManagerUsuario {
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public ManagerUsuario() {
        
    }
    
    /**CRUD DE LA TALBLA usu_usuario*/
    public List<UsuUsuario> findAllUsuarios(){
    	String consulta="select o from UsuUsuario o order by o.apellido";
    	Query q=em.createNamedQuery(consulta, UsuUsuario.class);
    	return q.getResultList();
    }
    
    public UsuUsuario findUsuarioByCorreo(String correo) {
    	return em.find(UsuUsuario.class, correo);
    }
    public void insertarUsuario(UsuUsuario usuario) throws Exception {
    	if(findUsuarioByCorreo(usuario.getCorreo())!=null)
    		throw new Exception("Ya existe el correo ingresado");
        em.persist(usuario);
    }
    public void eliminarUsuario(String correo) {
    	UsuUsuario usuario=findUsuarioByCorreo(correo);
    	if(usuario!=null)
    		em.remove(usuario);
    }
    public void actualizarUsuario(UsuUsuario usuario) throws Exception {
    	UsuUsuario e=findUsuarioByCorreo(usuario.getCorreo());
    	if(e==null)
    		throw new Exception("No existe el usuario con este correo");
    	e.setApellido(usuario.getApellido());
    	e.setNombre(usuario.getNombre());
    	e.setPassword(usuario.getPassword());
    	em.merge(e);
    	
    }
    
    /**CRUD DE LA TABLA usu_rol*/
    public List<UsuRol> findAllROl(){
    	String consulta="select o from UsuRol o order by o.id_rol";
    	Query q=em.createNamedQuery(consulta, UsuRol.class);
    	return q.getResultList();
    }
    
    public UsuRol findRolById(long id) {
    	return em.find(UsuRol.class, id);
    }
    public void insertarRol(UsuRol rol) throws Exception {
    	if(findRolById(rol.getIdRol())!=null)
    		throw new Exception("Ya existe ese rol");
        em.persist(rol);
    }
    public void eliminarRol(long id) {
    	UsuRol rol=findRolById(id);
    	if(rol!=null)
    		em.remove(rol);
    }
    public void actualizarRol(UsuRol rol) throws Exception {
    	UsuRol e=findRolById(rol.getIdRol());
    	if(e==null)
    		throw new Exception("No existe el rol especificado");
    	e.setNombre(rol.getNombre());
    	e.setDescripcion(rol.getDescripcion());
    	em.merge(e);
    	
    }

}