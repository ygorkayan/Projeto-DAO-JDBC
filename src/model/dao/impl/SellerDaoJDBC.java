package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

/** 
 * Class responsavel por fazer a intera�ao com o banco de dados
 * � nela que � feito o CRUD
 * @author Ygor Kayan
 *
 */

public class SellerDaoJDBC implements SellerDAO  {
	
	private Connection con;

	public SellerDaoJDBC(Connection con) {
		this.con = con;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = con.prepareStatement(
					"SELECT seller. *, department.Name as DepName " 
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id " 
					+ "WHERE seller.Id = ?");
			st.setInt(1, id);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				Department dep = InstantiateDepartment(rs);	
				Seller obj = InstantiateSeller(rs, dep);
				return obj;
			}
			return null;
		} catch(SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.fecharStatement(st);
			DB.fecharResultSet(rs);
		}
	}

	@Override
	public List<Seller> FindAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = con.prepareStatement(
					"SELECT seller. *, department.Name as DepName " 
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id " 
					+ "ORDER BY Name");
			
			
			rs = st.executeQuery();
			
			List<Seller> lista = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();
			
			while(rs.next()) { 
				
				Department dep = map.get(rs.getInt("DepartmentId"));
				if(dep == null) {
					dep = InstantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
			
				Seller obj = InstantiateSeller(rs, dep);
				lista.add(obj);
			}
			
			return lista;
			
		} catch(SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.fecharStatement(st);
			DB.fecharResultSet(rs);
		}
	}
	
	@Override
	public List<Seller> FindByDepartment(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = con.prepareStatement(
					"SELECT seller. *, department.Name as DepName " 
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id " 
					+ "WHERE DepartmentID = ? "
					+ "ORDER BY Name");
			
			st.setInt(1, department.getId());
			
			rs = st.executeQuery();
			
			List<Seller> lista = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();
			
			while(rs.next()) { 
				
				Department dep = map.get(rs.getInt("DepartmentId"));
				if(dep == null) {
					dep = InstantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
			
				Seller obj = InstantiateSeller(rs, dep);
				lista.add(obj);
			}
			
			return lista;
			
		} catch(SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.fecharStatement(st);
			DB.fecharResultSet(rs);
		}
	}
	
	
	private Seller InstantiateSeller(ResultSet rs, Department dep) throws SQLException {
		Seller obj = new Seller();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setSalarioBase(rs.getDouble("BaseSalary"));
		obj.setAniversario(rs.getDate("BirthDate"));
		obj.setDepartamento(dep);
		return obj;
	}

	private Department InstantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setNome(rs.getString("DepName"));
		return dep;
		
	}


}
