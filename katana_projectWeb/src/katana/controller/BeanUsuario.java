package katana.controller;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import katana.controller.JSFUtil;
import katana.model.entities.UsuUsuario;
import katana.model.manager.ManagerUsuario;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BeanUsuario implements Serializable{
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerUsuario managerUsuario;

	private List<UsuUsuario> listaUsuario;

	private UsuUsuario usuario;

	private boolean panelColapsado_usuario;

	private UsuUsuario usuarioSeleccionado;
	@PostConstruct
	public void inicializar() 
	{
	    listaUsuario=managerUsuario.findAllUsuarios();
	    usuario=new UsuUsuario();
	    panelColapsado_usuario=true;
	}	
	
/*BEAN PARA usu_usuario*/
	
	public void actionListenerColapsarPanel_usuario() {
		panelColapsado_usuario=!panelColapsado_usuario;
	}
	public void actionListenerInsertarUsuario() {
		try {
			managerUsuario.insertarUsuario(usuario);
			managerUsuario.insertarUsuarioRol(usuario, 5); //aqui le mando desde el xhtml el id por defecto
			listaUsuario=managerUsuario.findAllUsuarios();
			usuario = new UsuUsuario();
			JSFUtil.crearMensajeInfo("Se ha insertado el usuario.");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerSeleccionarUsuario(UsuUsuario usuario) {
		usuarioSeleccionado=usuario;
	}
	public void actionListenerActualizarUsuario() {
		try {
			managerUsuario.actualizarUsuario(usuario);
			listaUsuario=managerUsuario.findAllUsuarios();
			JSFUtil.crearMensajeInfo("Datos actualizados.");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerEliminarUsuario(String correo) {
		managerUsuario.eliminarUsuario(correo);
		listaUsuario=managerUsuario.findAllUsuarios();
		JSFUtil.crearMensajeInfo("Usuario eliminado.");
	}

	public List<UsuUsuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<UsuUsuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public UsuUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuUsuario usuario) {
		this.usuario = usuario;
	}

	public boolean isPanelColapsado_usuario() {
		return panelColapsado_usuario;
	}

	public void setPanelColapsado_usuario(boolean panelColapsado_usuario) {
		this.panelColapsado_usuario = panelColapsado_usuario;
	}

	public UsuUsuario getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(UsuUsuario usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}

	
	

}
