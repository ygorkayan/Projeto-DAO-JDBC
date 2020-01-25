package model.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * Essa classe representa um vendedor, ao pegar Vendedor do bando de dados
 * é essa classe que vai receber as informaçao e trasforma em um Objeto
 * @author Ygor Kayan
 *
 */

public class Seller implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String email;
	private Date aniversario;
	private Double salarioBase;
	
	private Department departamento;
	
	public Seller() {
		
	}

	public Seller(Integer id, String name, String email, Date aniversario, Double salarioBase,
			Department departamento) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.aniversario = aniversario;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getAniversario() {
		return aniversario;
	}

	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Department getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Department departamento) {
		this.departamento = departamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", name=" + name + ", email=" + email + ", aniversario=" + aniversario
				+ ", salarioBase=" + salarioBase + ", departamento=" + departamento + "]";
	}
}
