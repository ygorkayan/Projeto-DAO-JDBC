package model.entities;

import java.io.Serializable;

/**
 * Essa classe representa um departamento, ao pegar ou inserir Departamento do
 * bando de dados e essa classe que vai receber as informacao e trasforma em um
 * Objeto
 * 
 * @author Ygor Kayan
 *
 */

public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;

	public Department() {

	}

	public Department(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		Department other = (Department) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nome=" + nome + "]";
	}
}
