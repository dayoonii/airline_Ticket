package com.java.ex.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AllmemberDAO {
	static String driver = "org.mariadb.jdbc.Driver";
	static String url = "jdbc:mariadb://localhost:3307/airline_ticket";
	static String uid = "root";
	static String pwd = "1234";
	
	Connection con = null;
	 Statement stmt = null;
	 ResultSet rs = null;
	 PreparedStatement routepstmt = null;		 
	 String query = null;
	 
	 public AllmemberDAO() {
		 try {
			 Class.forName(driver);
			} catch (Exception e) {
				e.printStackTrace();
		 }

	 }
	 
	 
	 
	 
	 
	 //==================================================================================================================================
	 public ArrayList<AllmemberDTO> partSelect(String name, String ID) {
		 query = "SELECT pas.name, pas.ID, pas.HP, (SELECT COUNT(*) FROM payment c WHERE c.id = pas.ID) total_boarding, (SELECT SUM(c.total_price) FROM payment c WHERE c.id = pas.ID) total_price, pas.Mileage FROM passenger pas, payment pay WHERE pas.ID = pay.ID";
			if(name != null && !name.equals("")) {
				query += " AND pas.name = ?";
			}
			if(ID != null && !ID.equals("")) {
				query += " AND pas.ID = ?";
			}
			query += " GROUP BY pas.ID";

		 System.out.println(query);
		 ArrayList<AllmemberDTO> dtos = new ArrayList<AllmemberDTO>();
		 try {
			 
			con = DriverManager.getConnection(url, uid, pwd);
			routepstmt = con.prepareStatement(query);
			 
			 int i = 1;
				if(name != null && !name.equals("")) {
					routepstmt.setString(i++, name);
				}
				if(ID != null && !ID.equals("")) {
					routepstmt.setString(i++, ID);
				}
				
				rs = routepstmt.executeQuery();
				
				while(rs.next()) {
					String name1= rs.getString("name");
					String ID1 = rs.getString("ID");
					String HP = rs.getString("HP");
					int total_price = rs.getInt("total_price");
					String total_boarding = rs.getString("total_boarding");
					String Mileage = rs.getString("Mileage");
					
				    AllmemberDTO dto = new AllmemberDTO(name1, ID1, HP, total_boarding, total_price, Mileage);
				    dtos.add(dto);
				}
				 return dtos;
			
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
		 return null;
	 }	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public ArrayList<AllmemberDTO> allSelect() {
		 query = "SELECT pas.name, pas.ID, pas.HP, (SELECT COUNT(*) FROM payment c WHERE c.id = pas.ID) total_boarding, (SELECT SUM(c.total_price) FROM payment c WHERE c.id = pas.ID) total_price, pas.Mileage FROM passenger pas, payment pay WHERE pas.ID = pay.ID GROUP BY pas.ID";
		
		 ArrayList<AllmemberDTO> dtos = new ArrayList<AllmemberDTO>();
		 try {
			 con = DriverManager.getConnection(url, uid, pwd);
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);

				
				while (rs.next()) {
					String name1= rs.getString("name");
					String ID1 = rs.getString("ID");
					String HP = rs.getString("HP");
					int total_price = rs.getInt("total_price");
					String total_boarding = rs.getString("total_boarding");
					String Mileage = rs.getString("Mileage");
					
					AllmemberDTO dto = new AllmemberDTO(name1, ID1, HP, total_boarding, total_price, Mileage);
					dtos.add(dto);
				}
				
		 }catch (Exception e) {
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
			return dtos;
		
	 }
}
