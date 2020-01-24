package model.dao;

import java.util.List;

import model.entities.Vendedor;

public interface VendedorDAO {
	
	void insert(Vendedor obj);
	
	void update(Vendedor obj);
	
	void deleteById(Integer id);
	
	Vendedor findById(Integer id);
	
	List<Vendedor> FindAll();
	
}
