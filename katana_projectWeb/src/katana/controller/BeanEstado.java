package katana.controller;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import katana.controller.JSFUtil;
import katana.model.entities.PedEstado;
import katana.model.manager.ManagerEstado;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BeanEstado implements Serializable{
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerEstado managerEstado;

	private List<PedEstado> listaEstado;

	private PedEstado estado;

	private boolean panelColapsado_Estado;

	private PedEstado estadoSeleccionada;
	@PostConstruct
	public void inicializar() 
	{
	    listaEstado=managerEstado.findAllEstado();
	    estado=new PedEstado();
	    panelColapsado_Estado=true;
	}	
	
/*BEAN PARA pro_talla*/
	
	public void actionListenerColapsarPanel_Estado() {
		panelColapsado_Estado=!panelColapsado_Estado;
	}
	public void actionListenerInsertarEstado() {
		try {
			managerEstado.insertarEstado(estado);
			listaEstado=managerEstado.findAllEstado();
			estado = new PedEstado();
			JSFUtil.crearMensajeInfo("Se ha insertado el estado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerSeleccionarEstado(PedEstado estado) {
		estadoSeleccionada=estado;
	}
	public void actionListenerActualizarEstado() {
		try {
			managerEstado.actualizarEstado(estadoSeleccionada);
			listaEstado=managerEstado.findAllEstado();
			JSFUtil.crearMensajeInfo("Datos actualizados.");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerEliminarEstado(int id) {
		managerEstado.eliminarEstado(id);
		listaEstado=managerEstado.findAllEstado();
		JSFUtil.crearMensajeInfo("Estado eliminada.");
	}

	public List<PedEstado> getListaEstado() {
		return listaEstado;
	}

	public void setListaEstado(List<PedEstado> listaEstado) {
		this.listaEstado = listaEstado;
	}

	public PedEstado getEstado() {
		return estado;
	}

	public void setEstado(PedEstado estado) {
		this.estado = estado;
	}

	public boolean isPanelColapsado_Estado() {
		return panelColapsado_Estado;
	}

	public void setPanelColapsado_Estado(boolean panelColapsado_Estado) {
		this.panelColapsado_Estado = panelColapsado_Estado;
	}

	public PedEstado getEstadoSeleccionada() {
		return estadoSeleccionada;
	}

	public void setEstadoSeleccionada(PedEstado estadoSeleccionada) {
		this.estadoSeleccionada = estadoSeleccionada;
	}

	

}
