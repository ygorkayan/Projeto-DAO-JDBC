package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class Main {

	public static void main(String[] args) {

		DepartmentDAO dd = DaoFactory.createDepartmentDao();
		dd.insert(new Department(null, "TI"));

	}
}
