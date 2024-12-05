package crm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import crm.config.Mysqlconfig;
import crm.entity.EmployeeEntity;



public class EmployeeRepository {

	public EmployeeEntity getAccount(String email, String password){
		EmployeeEntity emp=null;
		String query="SELECT * FROM users WHERE email=? AND password= ?";
		Connection connection= Mysqlconfig.getConnection();
		try {
			PreparedStatement ps= connection.prepareStatement(query);
	        ps.setString(1, email);   
	        ps.setString(2, password);
	        ResultSet rs = ps.executeQuery();
	        if(rs.next()) {
	        	emp=new EmployeeEntity();
	        	emp.setId(rs.getInt("id"));
	        	emp.setEmail(rs.getString("email"));
	        	
	        }
	      
		} catch (Exception e) {
			System.out.println("findAll "+ e.getLocalizedMessage());
		}
		return emp;
		
	}
}
