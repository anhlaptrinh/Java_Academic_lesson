package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConfig {
	public static Connection getConnection()  {
		Connection connection=null;
		try {
			//khai bao driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Dung driver mo ket noi toi co so du lieu
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/NewsDB", "root", "123456");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("MySQL connect error");
		}
		
		return connection;
	}
}
