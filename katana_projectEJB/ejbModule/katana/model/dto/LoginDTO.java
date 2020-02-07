package katana.model.dto;

import java.util.List;

import katana.model.entities.PedPedido;
import katana.model.entities.ProProducto;

/**
 * DTO para el acceso al sistema.
 * @author mrea
 *
 */
public class LoginDTO {
	private String usuario; //este es el nombre
	private String codigoUsuario;
	private String tipoUsuario;
	private String rutaAcceso;
	private String apellido;
	private String correo; //este no se si va porque creo que codigoUsuario ya es el correo
	private String imagen;
	private List<PedPedido> pedidos;
	private List<ProProducto> productos;
	
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getRutaAcceso() {
		return rutaAcceso;
	}
	public void setRutaAcceso(String rutaAcceso) {
		this.rutaAcceso = rutaAcceso;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public List<PedPedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<PedPedido> pedidos) {
		this.pedidos = pedidos;
	}
	public List<ProProducto> getProductos() {
		return productos;
	}
	public void setProductos(List<ProProducto> productos) {
		this.productos = productos;
	}
	
	
	
	
}
