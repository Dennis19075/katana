package katana.controller;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import katana.controller.JSFUtil;
import katana.model.entities.ProCamiseta;
import katana.model.entities.ProLogo;
import katana.model.entities.ProPersonalizado;
import katana.model.manager.ManagerCamiseta;
import katana.model.manager.ManagerLogo;
import katana.model.manager.ManagerPersonalizar;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BeanPersonalizar implements Serializable{
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerCamiseta managerCamiseta;
	private List<ProCamiseta> listaCamiseta;
	
	private ManagerLogo managerLogo;
	private List<ProLogo> listaLogos;
	
	private ManagerPersonalizar managerPersonalizar;
	private List<ProPersonalizado> listaPersonalizadas;
	
	private ProPersonalizado personalizada;
	/* private boolean panelColapsado_Camiseta; */
	private ProPersonalizado personalizadaSeleccionada;

	@PostConstruct
	public void inicializar() 
	{
		listaLogos = managerLogo.findAllLogo();
		listaPersonalizadas = managerPersonalizar.findAllPersonalizadas();
		listaCamiseta=managerCamiseta.findAllCamiseta();
		personalizada = new ProPersonalizado();
	    
	}
	
/*BEAN PARA pro_camiseta_personalizada*/
	
	/*public void actionListenerColapsarPanel_Camiseta() {
		panelColapsado_Camiseta=!panelColapsado_Camiseta;
	}*/
	public String actionListenerInsertarPersonalizada() {
		try {
			managerPersonalizar.insertarPersonalizada(personalizada);
			listaPersonalizadas=managerPersonalizar.findAllPersonalizadas();
			personalizada = new ProPersonalizado();
			JSFUtil.crearMensajeInfo("Se ha insertado tu Camiseta Personalizada");
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "/ventas/index.xhtml?faces-redirect=true";
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
		return "";
	}
	public void actionListenerSeleccionarPersonalizada(ProPersonalizado personalizada) {
		personalizadaSeleccionada=personalizada;
	}
	public void actionListenerActualizarPersonalizada() {
		try {
			managerPersonalizar.actualizarPersonalizada(personalizadaSeleccionada);
			listaPersonalizadas=managerPersonalizar.findAllPersonalizadas();
			JSFUtil.crearMensajeInfo("Datos actualizados");
		} catch (Exception e) {
			listaCamiseta=managerCamiseta.findAllCamiseta();
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerEliminarCamiseta(int id) {
		managerPersonalizar.eliminarPersonalizada(id);
		listaPersonalizadas=managerPersonalizar.findAllPersonalizadas();
		JSFUtil.crearMensajeInfo("Camiseta eliminada");
	}

	public List<ProCamiseta> getListaCamiseta() {
		return listaCamiseta;
	}

	public void setListaCamiseta(List<ProCamiseta> listaCamiseta) {
		this.listaCamiseta = listaCamiseta;
	}

	public List<ProLogo> getListaLogos() {
		return listaLogos;
	}

	public void setListaLogos(List<ProLogo> listaLogos) {
		this.listaLogos = listaLogos;
	}

	public List<ProPersonalizado> getListaPersonalizadas() {
		return listaPersonalizadas;
	}

	public void setListaPersonalizadas(List<ProPersonalizado> listaPersonalizadas) {
		this.listaPersonalizadas = listaPersonalizadas;
	}

	public ProPersonalizado getPersonalizada() {
		return personalizada;
	}

	public void setPersonalizada(ProPersonalizado personalizada) {
		this.personalizada = personalizada;
	}

	public ProPersonalizado getPersonalizadaSeleccionada() {
		return personalizadaSeleccionada;
	}

	public void setPersonalizadaSeleccionada(ProPersonalizado personalizadaSeleccionada) {
		this.personalizadaSeleccionada = personalizadaSeleccionada;
	}

}

	