package application;

import java.util.Date;
import java.util.List;
import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Main {

	public static void main(String[] args) {
		
		SellerDAO sellerDao = DaoFactory.createSellerDao();
		
		Seller newSeller = new Seller(
				null, "Ygor", "ygorkayan@gmail.com", 
				new Date(), 1000.0 , new Department(2, null));
		
		sellerDao.insert(newSeller);
		

	}
}
