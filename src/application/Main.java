package application;

import java.util.List;
import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Main {

	public static void main(String[] args) {
		
		SellerDAO sellerDao = DaoFactory.createSellerDao();
		
		
		Department department = new Department(2, null);
		List<Seller> lista = sellerDao.FindByDepartment(department);
		
		lista.forEach(item -> System.out.println(item));
		

	}
}
