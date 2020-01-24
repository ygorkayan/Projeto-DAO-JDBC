package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Main {

	public static void main(String[] args) {
		
		Department obj = new Department(1, "Livro");
		
		
		Seller obj2 = new Seller(1, "Ygor", "ygorkayan..", new Date(), 3000.0, obj);
		System.out.println(obj2);

	}
}
