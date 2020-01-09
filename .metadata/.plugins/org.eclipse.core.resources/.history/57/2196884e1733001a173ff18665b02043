package katana.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usu_usuario database table.
 * 
 */
@Entity
@Table(name="usu_usuario")
@NamedQuery(name="UsuUsuario.findAll", query="SELECT u FROM UsuUsuario u")
public class UsuUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario", unique=true, nullable=false)
	private Integer idUsuario;

	@Column(nullable=false, length=50)
	private String apellido;

	@Column(nullable=false, length=50)
	private String correo;

	@Column(nullable=false, length=50)
	private String nombre;

	@Column(nullable=false, length=50)
	private String password;

	//bi-directional many-to-one association to PedPedido
	@OneToMany(mappedBy="usuUsuario")
	private List<PedPedido> pedPedidos;

	//bi-directional many-to-one association to UsuUsuarioRol
	@OneToMany(mappedBy="usuUsuario")
	private List<UsuUsuarioRol> usuUsuarioRols;

	public UsuUsuario() {
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PedPedido> getPedPedidos() {
		return this.pedPedidos;
	}

	public void setPedPedidos(List<PedPedido> pedPedidos) {
		this.pedPedidos = pedPedidos;
	}

	public PedPedido addPedPedido(PedPedido pedPedido) {
		getPedPedidos().add(pedPedido);
		pedPedido.setUsuUsuario(this);

		return pedPedido;
	}

	public PedPedido removePedPedido(PedPedido pedPedido) {
		getPedPedidos().remove(pedPedido);
		pedPedido.setUsuUsuario(null);

		return pedPedido;
	}

	public List<UsuUsuarioRol> getUsuUsuarioRols() {
		return this.usuUsuarioRols;
	}

	public void setUsuUsuarioRols(List<UsuUsuarioRol> usuUsuarioRols) {
		this.usuUsuarioRols = usuUsuarioRols;
	}

	public UsuUsuarioRol addUsuUsuarioRol(UsuUsuarioRol usuUsuarioRol) {
		getUsuUsuarioRols().add(usuUsuarioRol);
		usuUsuarioRol.setUsuUsuario(this);

		return usuUsuarioRol;
	}

	public UsuUsuarioRol removeUsuUsuarioRol(UsuUsuarioRol usuUsuarioRol) {
		getUsuUsuarioRols().remove(usuUsuarioRol);
		usuUsuarioRol.setUsuUsuario(null);

		return usuUsuarioRol;
	}

}