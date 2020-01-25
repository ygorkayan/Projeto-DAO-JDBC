package model.dao;

import java.util.List;

import model.entities.Seller;

/** 
 * Nessa interface, define oque eu preciso que tenha em uma classe Vendedor que vai fazer o CRUD
 * no banco de dados
 * @author Ygor Kayan
 *
 */

public interface SellerDAO {
	
	void insert(Seller obj);
	
	void update(Seller obj);
	
	void deleteById(Integer id);
	
	Seller findById(Integer id);
	
	List<Seller> FindAll();
	
}
