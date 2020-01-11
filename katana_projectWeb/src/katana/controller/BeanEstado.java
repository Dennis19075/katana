package katana.controller;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import katana.controller.JSFUtil;
import katana.model.entities.PedEstado;
import katana.model.manager.ManagerEstado;
import katana.model.manager.ManagerPedido;
import katana.model.manager.ManagerProducto;

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
	private PedEstado estadoSeleccionado;
	@PostConstruct
	public void inicializar() 
	{
		listaEstado= managerEstado.findAllEstado();
	    estado =new PedEstado();
	    panelColapsado_Estado=true;
	    
	}
	
	/*BEAN PARA ped_estado*/
	
	public void actionListenerColapsarPanel() {
		panelColapsado_Estado=!panelColapsado_Estado;
	}
	public void actionListenerInsertarTipoProducto() {
		try {
			managerEstado.insertarEstado(estado);
			listaEstado=managerEstado.findAllEstado();
			estado=new PedEstado();
			JSFUtil.crearMensajeInfo("Se ha insertado un estado");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerSeleccionarEstado(PedEstado estado) {
		estadoSeleccionado=estado;
	}
	public void actionListenerActualizarTipoProducto() {
		try {
			managerEstado.actualizarEstado(estadoSeleccionado);
			listaEstado=managerEstado.findAllEstado();
			JSFUtil.crearMensajeInfo("Datos actualizados");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerEliminarEstado(int id) {
		managerEstado.eliminarEstado(id);
		listaEstado=managerEstado.findAllEstado();
		JSFUtil.crearMensajeInfo("Estado eliminado");
	}
	
}
