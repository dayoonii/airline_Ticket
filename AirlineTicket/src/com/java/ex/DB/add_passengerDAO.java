package com.java.ex.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class add_passengerDAO {
	
	static String driver = "org.mariadb.jdbc.Driver";
	static String url = "jdbc:mariadb://localhost:3307/airline_ticket";
	static String uid = "root";
	static String pwd = "1234";

	Connection con = null;
	 Statement stmt = null;
	 ResultSet rs = null;
	 PreparedStatement pstmt = null;		 
	 String query = null;
	 
	 public add_passengerDAO() {
		 try {
			 Class.forName(driver);
			} catch (Exception e) {
				e.printStackTrace();
		 }
	 }
	 
	 public void Insertadd(String add_name, String add_birth, String add_hp, String add_email){
		 String query = "INSERT INTO add_passenger VALUES(?,?,?,?)";
		 
		 try {
			 Class.forName(driver);
				con = DriverManager.getConnection(url, uid, pwd);

				pstmt = con.prepareStatement(query);
				pstmt.setString(1, add_name);
				pstmt.setString(2, add_birth);
				pstmt.setString(3, add_hp);
				pstmt.setString(4, add_email);
				
				@SuppressWarnings("unused")
				int resultQuery = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		 
	 }

	 }
}
