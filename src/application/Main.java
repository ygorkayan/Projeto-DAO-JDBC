package application;

import java.util.Date;

import model.entities.Vendedpr;
import model.entities.Vendedor;

public class Main {

	public static void main(String[] args) {
		
		Vendedpr obj = new Vendedpr(1, "Livro");
		
		
		Vendedor obj2 = new Vendedor(1, "Ygor", "ygorkayan..", new Date(), 3000.0, obj);
		System.out.println(obj2);

	}
}
