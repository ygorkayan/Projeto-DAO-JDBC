package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDAO;
import model.entities.Department;

/**
 * Class responsavel por fazer a interacao com o banco de dados e nela que e
 * feito o CRUD
 * 
 * @author Ygor Kayan
 *
 */

public class DepartmentDaoJDBC implements DepartmentDAO {

	private Connection con;

	public DepartmentDaoJDBC(Connection con) {
		this.con = con;
	}

	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		try {
			st = con.prepareStatement("INSERT INTO Department " + "(Name) " + "VALUES" + "(?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getNome());

			int linhas = st.executeUpdate();

			if (linhas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(1);
				}
				DB.fecharResultSet(rs);
			} else {
				throw new DbException("Deu ruim, nao salvou no banco de dados");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.fecharStatement(st);
		}

	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;
		try {
			st = con.prepareStatement("UPDATE department " + "SET Name = ? WHERE Id = ?");

			st.setString(1, obj.getNome());
			st.setInt(6, obj.getId());

			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.fecharStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = con.prepareStatement("DELETE FROM department WHERE Id = ?");
			st.setInt(1, id);
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.fecharStatement(st);

		}
	}

	@Override
	public Department findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> FindAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
