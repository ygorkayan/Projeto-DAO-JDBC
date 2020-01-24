package model.dao;

import java.util.List;

import model.entities.Vendedpr;

public interface DerpatamentoDAO {
	
	void insert(Vendedpr obj);
	
	void update(Vendedpr obj);
	
	void deleteById(Integer id);
	
	Vendedpr findById(Integer id);
	
	List<Vendedpr> FindAll();

}
