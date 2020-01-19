package katana.model.manager;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import katana.model.dto.LoginDTO;
import katana.model.entities.UsuUsuario;
import katana.model.entities.UsuRol;

/**
 * Implementa la logica de manejo de usuarios y autenticacion
 */
@Stateless
@LocalBean
public class ManagerSeguridad {
	@EJB
	private ManagerDAO managerDAO;
    /**
     * Default constructor. 
     */
    public ManagerSeguridad() {
        
    }
    
    /**
	 * Metodo que le permite a un usuario acceder al sistema.
	 * @param codigoUsuario Identificador del usuario.
	 * @param clave Clave de acceso.
	 * @return Retorna el tipo de usuario. Puede tener dos valores:
	 * 			SP (supervisor) o VD (vendedor).
	 * @throws Exception Cuando no coincide la clave proporcionada o si ocurrio
	 * un error con la consulta a la base de datos.
	 */
	public LoginDTO accederSistema(String correoUsuario,String clave) throws Exception{
		UsuUsuario usuario=(UsuUsuario)managerDAO.findById(UsuUsuario.class, correoUsuario);
		
		UsuRol rol = (UsuRol)managerDAO.findById(UsuRol.class, correoUsuario);
		
		if(usuario==null)
			throw new Exception("Error en usuario y/o clave.");
		
		if(!usuario.getPassword().equals(clave))
			throw new Exception("Error en usuario y/o clave.");
		
		LoginDTO loginDTO=new LoginDTO();
		
		loginDTO.setUsuario(usuario.getNombre());
		loginDTO.setUsuario(usuario.getApellido());
		loginDTO.setUsuario(usuario.getCorreo());
		loginDTO.setUsuario(rol.getDescripcion());
		
		
		//dependiendo del tipo de usuario, configuramos la ruta de acceso a las pags web:
		if(rol.getDescripcion().equals("UsuarioFinal"))
			loginDTO.setRutaAcceso("/clientes/perfilUsuario.xhtml");
		else if(rol.getDescripcion().equals("Administrador") || rol.getDescripcion().equals("Duenio"))
			loginDTO.setRutaAcceso(""); //tiene que redirigir al menu que Ervin esta haciendo de admin
		//NO se si hacerle un menu al Duenio para si mismo diferente al de Admin
		return loginDTO;
	}
	
	public UsuUsuario findUsuarioById(String codigoUsuario) throws Exception {
		UsuUsuario usuario=(UsuUsuario)managerDAO.findById(UsuUsuario.class, codigoUsuario);
		return usuario;
	}

}
