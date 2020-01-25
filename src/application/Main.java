package application;

import java.util.List;
import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Seller;

public class Main {

	public static void main(String[] args) {
		
		SellerDAO sellerDao = DaoFactory.createSellerDao();
		
		
		
		
		
		List<Seller> lista = sellerDao.FindAll();
		
		lista.forEach(item -> System.out.println(item));
		

	}
}
