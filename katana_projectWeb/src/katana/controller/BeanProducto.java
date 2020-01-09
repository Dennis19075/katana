package katana.controller;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import katana.controller.JSFUtil;
import katana.model.entities.ProTipoProducto;
import katana.model.manager.ManagerProducto;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BeanProducto implements Serializable{
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerProducto managerProducto;
	private List<ProTipoProducto> listaTipoProducto;
	private ProTipoProducto tipo_producto;
	private boolean panelColapsado;
	private ProTipoProducto tipo_productoSeleccionado;
	@PostConstruct
	public void inicializar() 
	{
	    listaTipoProducto=managerProducto.findAllTipoProducto();
	    tipo_producto=new ProTipoProducto();
	    panelColapsado=true;
	}
	public void actionListenerColapsarPanel() {
		panelColapsado=!panelColapsado;
	}
	public void actionListenerInsertarTipoProducto() {
		try {
			managerProducto.insertarTipoProducto(tipo_producto);
			listaTipoProducto=managerProducto.findAllTipoProducto();
			tipo_producto=new ProTipoProducto();
			JSFUtil.crearMensajeInfo("Se ha insertado el Tipo de Producto");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerSeleccionarTipoProducto(ProTipoProducto tipoProducto) {
		tipo_productoSeleccionado=tipoProducto;
	}
	public void actionListenerActualizarTipoProducto() {
		try {
			managerProducto.actualizarTipoProducto(tipo_productoSeleccionado);
			listaTipoProducto=managerProducto.findAllTipoProducto();
			JSFUtil.crearMensajeInfo("Datos actualizados");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerEliminarTipoProducto(Long id) {
		managerProducto.eliminarTipoProducto(id);
		listaTipoProducto=managerProducto.findAllTipoProducto();
		JSFUtil.crearMensajeInfo("Tipo de Producto eliminado");
	}
	public List<ProTipoProducto> getListaTipoProducto() {
		return listaTipoProducto;
	}
	public void setListaTipoProducto(List<ProTipoProducto> listaTipoProducto) {
		this.listaTipoProducto = listaTipoProducto;
	}
	public ProTipoProducto getTipo_producto() {
		return tipo_producto;
	}
	public void setTipo_producto(ProTipoProducto tipo_producto) {
		this.tipo_producto = tipo_producto;
	}
	public boolean isPanelColapsado() {
		return panelColapsado;
	}
	public void setPanelColapsado(boolean panelColapsado) {
		this.panelColapsado = panelColapsado;
	}
	public ProTipoProducto getTipo_productoSeleccionado() {
		return tipo_productoSeleccionado;
	}
	public void setTipo_productoSeleccionado(ProTipoProducto tipo_productoSeleccionado) {
		this.tipo_productoSeleccionado = tipo_productoSeleccionado;
	}
	
	

}