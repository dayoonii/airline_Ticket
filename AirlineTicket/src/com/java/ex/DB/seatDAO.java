package com.java.ex.DB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class seatDAO {

	
	static String driver = "org.mariadb.jdbc.Driver"; 
	   static String url = "jdbc:mariadb://localhost:3307/airline_ticket";
	   static String uid = "root";
	   static String pwd = "1234";
	   
	   Connection con = null;
		 Statement stmt = null;
		 ResultSet rs = null;
		 PreparedStatement seatpstmt = null;		 
		 String query = null;
		 
		 public seatDAO() {
			 try {
				 Class.forName(driver);
				} catch (Exception e) {
					e.printStackTrace(); 
			 }
		 }
		 
		 
		 
		 
		 
		 
		 //select 
		 public ArrayList<seatDTO> seatSelect() {
			 query = "select * from seat";
			 ArrayList<seatDTO> dtos = new ArrayList<seatDTO>();
			 try {
				 con = DriverManager.getConnection(url, uid, pwd);
					stmt = con.createStatement();
					rs = stmt.executeQuery(query);
					
					while(rs.next()) {
						String seatLevel = rs.getString("seatLevel");
						String seatNum = rs.getString("seatNum");
						int seatPrice = rs.getInt("seatPrice");
			
						
						seatDTO dto = new seatDTO(seatLevel, seatNum, seatPrice);
						dtos.add(dto);
					}
		
			} catch (Exception e) {
				e.printStackTrace();
				
			} finally {
				try {
					if(rs != null)rs.close();
					if(stmt != null)stmt.close();
					if(con != null)con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			
			}
				return dtos;
		 }
}


