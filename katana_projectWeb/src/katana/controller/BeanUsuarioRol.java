package katana.controller;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import katana.controller.JSFUtil;
import katana.model.entities.UsuRol;
import katana.model.entities.UsuUsuario;
import katana.model.entities.UsuUsuarioRol;
import katana.model.manager.ManagerRol;
import katana.model.manager.ManagerUsuario;
import katana.model.manager.ManagerUsuarioRol;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BeanUsuarioRol implements Serializable{
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerUsuarioRol managerUsuarioRol;
	private ManagerRol managerRol;

	private List<UsuUsuarioRol> listaUsuarioRol;
	private List<UsuRol> listaRol;

	private UsuUsuarioRol usuarioRol;

	private boolean panelColapsado_usuariorol;

	private UsuUsuarioRol usuarioRolSeleccionado;
	@PostConstruct
	public void inicializar() 
	{
	    listaUsuarioRol=managerUsuarioRol.findAllUsuariosRol();
	    usuarioRol=new UsuUsuarioRol();
	    panelColapsado_usuariorol=true;
	    usuarioRolSeleccionado = new UsuUsuarioRol();
	    //listaRol = managerRol.findAllROl();
	}	
	
/*BEAN PARA usu_usuario*/
	
	public void actionListenerColapsarPanel_usuario() {
		panelColapsado_usuariorol=!panelColapsado_usuariorol;
	}
	public void actionListenerInsertarUsuarioRol(UsuUsuario usuario) {
		try {
			UsuRol auxRol = new UsuRol();
			auxRol.setIdRol(5);
			managerUsuarioRol.insertarUsuarioRol(usuario, auxRol);
			
			listaUsuarioRol=managerUsuarioRol.findAllUsuariosRol();
			usuarioRol = new UsuUsuarioRol();
			JSFUtil.crearMensajeInfo("Registro con exito.");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerSeleccionarUsuarioRol(UsuUsuarioRol usuarioRol) {
		usuarioRolSeleccionado=usuarioRol;
	}
	public void actionListenerActualizarUsuarioRol() {
		try {
			managerUsuarioRol.actualizarUsuarioRol(usuarioRolSeleccionado);
			listaUsuarioRol=managerUsuarioRol.findAllUsuariosRol();
			JSFUtil.crearMensajeInfo("Datos actualizados.");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerEliminarUsuarioRol(int id) {
		managerUsuarioRol.eliminarUsuarioRol(usuarioRolSeleccionado);
		listaUsuarioRol=managerUsuarioRol.findAllUsuariosRol();
		JSFUtil.crearMensajeInfo("UsuarioRol eliminado.");
	}

	public List<UsuUsuarioRol> getListaUsuarioRol() {
		return listaUsuarioRol;
	}

	public void setListaUsuarioRol(List<UsuUsuarioRol> listaUsuarioRol) {
		this.listaUsuarioRol = listaUsuarioRol;
	}

	public UsuUsuarioRol getUsuarioRol() {
		return usuarioRol;
	}

	public void setUsuarioRol(UsuUsuarioRol usuarioRol) {
		this.usuarioRol = usuarioRol;
	}

	public boolean isPanelColapsado_usuariorol() {
		return panelColapsado_usuariorol;
	}

	public void setPanelColapsado_usuariorol(boolean panelColapsado_usuariorol) {
		this.panelColapsado_usuariorol = panelColapsado_usuariorol;
	}

	public UsuUsuarioRol getUsuarioRolSeleccionado() {
		return usuarioRolSeleccionado;
	}

	public void setUsuarioRolSeleccionado(UsuUsuarioRol usuarioRolSeleccionado) {
		this.usuarioRolSeleccionado = usuarioRolSeleccionado;
	}
	
	
	

	

	
	

}
