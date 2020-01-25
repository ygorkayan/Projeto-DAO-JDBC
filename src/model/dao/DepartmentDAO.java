package model.dao;

import java.util.List;

import model.entities.Department;


/** 
 * Nessa interface, define oque eu preciso que tenha em uma classe Departamento que vai fazer o CRUD
 * no banco de dados
 * @author Ygor Kayan
 *
 */

public interface DepartmentDAO {
	
	void insert(Department obj);
	
	void update(Department obj);
	
	void deleteById(Integer id);
	
	Department findById(Integer id);
	
	List<Department> FindAll();

}
