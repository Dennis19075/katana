package katana.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ped_estado database table.
 * 
 */
@Entity
@Table(name="ped_estado")
@NamedQuery(name="PedEstado.findAll", query="SELECT p FROM PedEstado p")
public class PedEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estado", unique=true, nullable=false, precision=10)
	private long idEstado;

	@Column(nullable=false, length=50)
	private String descripcion;

	//bi-directional many-to-one association to PedPedido
	@OneToMany(mappedBy="pedEstado")
	private List<PedPedido> pedPedidos;

	public PedEstado() {
	}

	public long getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(long idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<PedPedido> getPedPedidos() {
		return this.pedPedidos;
	}

	public void setPedPedidos(List<PedPedido> pedPedidos) {
		this.pedPedidos = pedPedidos;
	}

	public PedPedido addPedPedido(PedPedido pedPedido) {
		getPedPedidos().add(pedPedido);
		pedPedido.setPedEstado(this);

		return pedPedido;
	}

	public PedPedido removePedPedido(PedPedido pedPedido) {
		getPedPedidos().remove(pedPedido);
		pedPedido.setPedEstado(null);

		return pedPedido;
	}

}