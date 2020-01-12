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
    	String consulta="select o from UsuUsuario o";
    	Query q=em.createQuery(consulta, UsuUsuario.class);
    	return q.getResultList();
    }
    
    public UsuUsuario findUsuarioByCorreo(String correo) {
    	return em.find(UsuUsuario.class, correo);
    }
    public void insertarUsuario(UsuUsuario usuario) throws Exception {
    	if(findUsuarioByCorreo(usuario.getCorreo())!=null)
    		throw new Exception("Ya existe el correo ingresado");
    	UsuUsuario aux = new UsuUsuario();
    	aux.setNombre(usuario.getNombre());
    	aux.setApellido(usuario.getApellido());
    	aux.setCorreo(usuario.getCorreo());
    	aux.setPassword(usuario.getPassword());
        em.persist(aux);
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
    	/*el correo no se si tambien se puede actualizar o no*/
    	e.setNombre(usuario.getNombre());
    	e.setPassword(usuario.getPassword());
    	em.merge(e);
    	
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
    public void insertarUsuarioRol(UsuUsuario usuario, int id) throws Exception {
    	UsuUsuarioRol aux=new UsuUsuarioRol();
    	UsuRol rolAux = new UsuRol();
    	aux.setUsuUsuario(usuario);
    	rolAux.setIdRol(id); //aqui le cambio segun de que pagina venga los privilegios
    	aux.setUsuRol(rolAux); //aqui ya guarda el rol segun lo que yo puse
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
    	e.setUsuUsuario(usuarioRol.getUsuUsuario());
    	e.setUsuRol(usuarioRol.getUsuRol());
    	em.merge(e);
    	
    }
    
}
