package db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	private static Connection conectar = null;
	
	public static Connection getConnection(){
		if(conectar == null) {
			try {
				Properties props = carregarPropiedades();
				String url = props.getProperty("dburl");
				conectar =  DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
			
		}
		
		return conectar;
	}
	
	public static void fecharConnection() {
		if(conectar!= null) {
			try {
				conectar.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
			
		}
	}
	
	
	public static void fecharStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void fecharResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	private static Properties carregarPropiedades() {
		
		try(FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
