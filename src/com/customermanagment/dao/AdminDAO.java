package com.customermanagment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
	
	
	private static final String dburl = "jdbc:mysql://localhost:3306/Customer_Managment";
	private static final String dbUserName = "root";
	private static final String dbPassword = "1234";

	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	private static final String adminLoginQuery=" select * from Admin where userName=? && password=?";
	
	

	public static boolean getAdminLogin(String userName,String password) {
		 
		boolean b = false;
		conn=CustomerDAO.getDbConnection();
		
		try {
			ps=conn.prepareStatement(adminLoginQuery);
			
			ps.setString(1, userName);
			ps.setString(2, password);
				
		
			rs=ps.executeQuery();
			
			b=rs.next(); 
				
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return b;
	}
}
