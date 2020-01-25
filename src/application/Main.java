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
		
		Seller seller = sellerDao.findById(9);
		seller.setName("Ygor Kayan");
		sellerDao.update(seller);
		
		
		
		

	}
}
