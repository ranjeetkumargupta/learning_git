package com.wipro.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	
	private static final String uri="jdbc:oracle:thin:@localhost:9501/XE";
	private static final String username="system";
	private static final String pass="rps@123";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con =DriverManager.getConnection(uri,username,pass);
		return con;
		
	}

}
