package katana.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the pro_personalizado database table.
 * 
 */
@Entity
@Table(name="pro_personalizado")
@NamedQuery(name="ProPersonalizado.findAll", query="SELECT p FROM ProPersonalizado p")
public class ProPersonalizado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_personalizado", unique=true, nullable=false)
	private Integer idPersonalizado;

	@Column(nullable=false, length=500)
	private String imagen1;

	@Column(length=500)
	private String imagen2;

	@Column(length=500)
	private String observacion;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal precio;

	//bi-directional many-to-one association to ProCamiseta
	@ManyToOne
	@JoinColumn(name="id_camiseta")
	private ProCamiseta proCamiseta;

	//bi-directional many-to-one association to ProLogo
	@ManyToOne
	@JoinColumn(name="id_logo")
	private ProLogo proLogo;

	//bi-directional many-to-one association to ProProducto
	@OneToMany(mappedBy="proPersonalizado")
	private List<ProProducto> proProductos;

	public ProPersonalizado() {
	}

	public Integer getIdPersonalizado() {
		return this.idPersonalizado;
	}

	public void setIdPersonalizado(Integer idPersonalizado) {
		this.idPersonalizado = idPersonalizado;
	}

	public String getImagen1() {
		return this.imagen1;
	}

	public void setImagen1(String imagen1) {
		this.imagen1 = imagen1;
	}

	public String getImagen2() {
		return this.imagen2;
	}

	public void setImagen2(String imagen2) {
		this.imagen2 = imagen2;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public ProCamiseta getProCamiseta() {
		return this.proCamiseta;
	}

	public void setProCamiseta(ProCamiseta proCamiseta) {
		this.proCamiseta = proCamiseta;
	}

	public ProLogo getProLogo() {
		return this.proLogo;
	}

	public void setProLogo(ProLogo proLogo) {
		this.proLogo = proLogo;
	}

	public List<ProProducto> getProProductos() {
		return this.proProductos;
	}

	public void setProProductos(List<ProProducto> proProductos) {
		this.proProductos = proProductos;
	}

	public ProProducto addProProducto(ProProducto proProducto) {
		getProProductos().add(proProducto);
		proProducto.setProPersonalizado(this);

		return proProducto;
	}

	public ProProducto removeProProducto(ProProducto proProducto) {
		getProProductos().remove(proProducto);
		proProducto.setProPersonalizado(null);

		return proProducto;
	}

}