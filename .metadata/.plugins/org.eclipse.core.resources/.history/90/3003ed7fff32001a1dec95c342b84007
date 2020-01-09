package katana.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the pro_logo database table.
 * 
 */
@Entity
@Table(name="pro_logo")
@NamedQuery(name="ProLogo.findAll", query="SELECT p FROM ProLogo p")
public class ProLogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_logo", unique=true, nullable=false, precision=10)
	private long idLogo;

	@Column(nullable=false, length=500)
	private String imagen;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal precio;

	//bi-directional many-to-one association to ProPersonalizado
	@OneToMany(mappedBy="proLogo")
	private List<ProPersonalizado> proPersonalizados;

	public ProLogo() {
	}

	public long getIdLogo() {
		return this.idLogo;
	}

	public void setIdLogo(long idLogo) {
		this.idLogo = idLogo;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<ProPersonalizado> getProPersonalizados() {
		return this.proPersonalizados;
	}

	public void setProPersonalizados(List<ProPersonalizado> proPersonalizados) {
		this.proPersonalizados = proPersonalizados;
	}

	public ProPersonalizado addProPersonalizado(ProPersonalizado proPersonalizado) {
		getProPersonalizados().add(proPersonalizado);
		proPersonalizado.setProLogo(this);

		return proPersonalizado;
	}

	public ProPersonalizado removeProPersonalizado(ProPersonalizado proPersonalizado) {
		getProPersonalizados().remove(proPersonalizado);
		proPersonalizado.setProLogo(null);

		return proPersonalizado;
	}

}