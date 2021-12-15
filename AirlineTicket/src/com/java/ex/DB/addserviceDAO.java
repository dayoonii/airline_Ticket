package com.java.ex.DB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class addserviceDAO {
	
	static String driver = "org.mariadb.jdbc.Driver"; 
	   static String url = "jdbc:mariadb://localhost:3307/airline_ticket";
	   static String uid = "root";
	   static String pwd = "1234";
	   
	   Connection con = null;
		 Statement stmt = null;
		 ResultSet rs = null;
		 PreparedStatement seatpstmt = null;		 
		 String query = null;
		 
		 public addserviceDAO()
		 {
			 try {
				 Class.forName(driver);
				} catch (Exception e) {
					e.printStackTrace(); 
			 }
		 }
		 
		 
		 //select
		 public ArrayList<addserviceDTO> addSelect() {
			 query = "select * from addservice";
			 ArrayList<addserviceDTO> dtos = new ArrayList<addserviceDTO>();
			 try {
				 con = DriverManager.getConnection(url, uid, pwd);
					stmt = con.createStatement();
					rs = stmt.executeQuery(query);
					
					while(rs.next()) {
						String meal = rs.getString("meal");
						String baggage = rs.getString("baggage");
						int add_price = rs.getInt("add_price");
						String fare = rs.getString("fare");
			
						
						addserviceDTO dto = new addserviceDTO(meal, baggage, add_price,fare);
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

	


