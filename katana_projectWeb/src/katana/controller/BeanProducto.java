package katana.controller;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import katana.controller.JSFUtil;
import katana.model.entities.ProColor;
import katana.model.entities.ProTalla;
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
	private List<ProColor> listaColor;
	private List<ProTalla> listaTalla;
	private ProTipoProducto tipo_producto;
	private ProColor color;
	private ProTalla talla;
	private boolean panelColapsado;
	private boolean panelColapsado_Color;
	private boolean panelColapsado_Talla;
	private ProTipoProducto tipo_productoSeleccionado;
	private ProColor colorSeleccionado;
	private ProTalla tallaSeleccionada;
	@PostConstruct
	public void inicializar() 
	{
	    listaTipoProducto=managerProducto.findAllTipoProducto();
	    listaColor=managerProducto.findAllColor();
	    tipo_producto=new ProTipoProducto();
	    color=new ProColor();
	    talla=new ProTalla();
	    panelColapsado=true;
	    panelColapsado_Color=true;
	    panelColapsado_Talla=true;
	}
	
	/*BEAN PARA pro_tipo_producto*/
	
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
	public void actionListenerEliminarTipoProducto(int id) {
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
	
/*BEAN PARA pro_color*/
	
	public void actionListenerColapsarPanel_Color() {
		panelColapsado_Color=!panelColapsado_Color;
	}
	public void actionListenerInsertarColor() {
		try {
			managerProducto.insertarColor(color);
			listaColor=managerProducto.findAllColor();
			color=new ProColor();
			JSFUtil.crearMensajeInfo("Se ha insertado el Color");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerSeleccionarColor(ProColor Color) {
		colorSeleccionado=Color;
	}
	public void actionListenerActualizarColor() {
		try {
			managerProducto.actualizarColor(colorSeleccionado);
			listaColor=managerProducto.findAllColor();
			JSFUtil.crearMensajeInfo("Datos actualizados");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerEliminarColor(int id) {
		managerProducto.eliminarColor(id);
		listaColor=managerProducto.findAllColor();
		JSFUtil.crearMensajeInfo("Color eliminado");
	}

	public List<ProColor> getListaColor() {
		return listaColor;
	}

	public void setListaColor(List<ProColor> listaColor) {
		this.listaColor = listaColor;
	}

	public ProColor getColor() {
		return color;
	}

	public void setColor(ProColor color) {
		this.color = color;
	}

	public boolean isPanelColapsado_Color() {
		return panelColapsado_Color;
	}

	public void setPanelColapsado_Color(boolean panelColapsado_Color) {
		this.panelColapsado_Color = panelColapsado_Color;
	}

	public ProColor getColorSeleccionado() {
		return colorSeleccionado;
	}

	public void setColorSeleccionado(ProColor colorSeleccionado) {
		this.colorSeleccionado = colorSeleccionado;
	}
	
	
	
/*BEAN PARA pro_talla*/
	
	public void actionListenerColapsarPanel_Talla() {
		panelColapsado_Talla=!panelColapsado_Talla;
	}
	public void actionListenerInsertarTalla() {
		try {
			managerProducto.insertarTalla(talla);
			listaTalla=managerProducto.findAllTalla();
			talla = new  ProTalla();
			JSFUtil.crearMensajeInfo("Se ha insertado la talla.");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerSeleccionarTalla(ProTalla talla) {
		tallaSeleccionada=talla;
	}
	public void actionListenerActualizarTalla() {
		try {
			managerProducto.actualizarTalla(tallaSeleccionada);
			listaTalla=managerProducto.findAllTalla();
			JSFUtil.crearMensajeInfo("Datos actualizados.");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerEliminarTalla(int id) {
		managerProducto.eliminarTalla(id);
		listaTalla=managerProducto.findAllTalla();
		JSFUtil.crearMensajeInfo("Talla eliminada.");
	}

	public List<ProTalla> getListaTalla() {
		return listaTalla;
	}

	public void setListaTalla(List<ProTalla> listaTalla) {
		this.listaTalla = listaTalla;
	}

	public ProTalla getTalla() {
		return talla;
	}

	public void setTalla(ProTalla talla) {
		this.talla = talla;
	}


	public ProTalla getTallaSeleccionada() {
		return tallaSeleccionada;
	}

	public void setTallaSeleccionada(ProTalla tallaSeleccionada) {
		this.tallaSeleccionada = tallaSeleccionada;
	}

	public boolean isPanelColapsado_Talla() {
		return panelColapsado_Talla;
	}

	public void setPanelColapsado_Talla(boolean panelColapsado_Talla) {
		this.panelColapsado_Talla = panelColapsado_Talla;
	}

}
