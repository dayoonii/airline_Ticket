package com.java.ex.DB;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class routeDAO {
	static String driver = "org.mariadb.jdbc.Driver"; 
	   static String url = "jdbc:mariadb://localhost:3307/airline_ticket";
	   static String uid = "root";
	   static String pwd = "1234";
	   
	   Connection con = null;
		 Statement stmt = null;
		 ResultSet rs = null;
		 PreparedStatement routepstmt = null;		 
		 String query = null;
		 
		 public routeDAO() {
			 try {
				 Class.forName(driver);
				} catch (Exception e) {
					e.printStackTrace(); 
			 }
			 
		 }
		 

		 
		 //selectItinerary 페이지 입력 
		 public ArrayList<routeDTO> routeSelect1(String depart, String arrive, String departdate) {
			 String query ="SELECT a.`index`, a.Flight_name, a.plane_id, a.depart,  a.arrive, a.departdate, a.departTime, a.arriveTime, a.totalTime FROM route a WHERE 1=1";
			 
			 if(!depart.equals("출발지")) {
				 query += " AND a.depart = ?";
			 }
			 if(!arrive.equals("도착지")) {
				 query += " AND a.arrive = ?";
			 }
			 query += " AND a.departdate = ?"; 
			 System.out.println(query);
				try {
					Class.forName(driver);
					con = DriverManager.getConnection(url, uid, pwd);
					routepstmt = con.prepareStatement(query);
					int i = 1;
					
					if(!depart.equals("출발지")) {
						routepstmt.setString(i++, depart);
					 }
					 if(!arrive.equals("도착지")) {
						 routepstmt.setString(i++, arrive);
					 }
					routepstmt.setString(i++, departdate);
					rs = routepstmt.executeQuery();
					
					ArrayList<routeDTO> dtos = new ArrayList<routeDTO>();
					while (rs.next()) {
						String Flight_name = rs.getString("Flight_name");
						String plane_id = rs.getString("plane_id");
						String depart1 = rs.getString("depart");
						String arrive1 = rs.getString("arrive");
						String departdate1 = rs.getString("departdate");
						String departTime = rs.getString("departTime");
						String arriveTime = rs.getString("arriveTime");
						String totalTime = rs.getString("totalTime");

						routeDTO dto = new routeDTO(Flight_name, depart1, arrive1, departdate1, departTime, arriveTime, totalTime);
						dtos.add(dto);
					}
					
					return dtos;
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
				return null;
			 
		 }

		
		 
		 
		 
		 
		 
		 
			
		 
		 
			 //update
			 public void routeUpdate(String Flight_name) {
				 String query1 = "update route set Flight_name=?;";
				 int result = 0;
				 
				 try {
					 Class.forName(driver);
					 con = DriverManager.getConnection(url, uid, pwd);
						
					
					routepstmt = con.prepareStatement(query1);
					routepstmt.setString(1, Flight_name);
					routepstmt.executeUpdate();
					
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
			 }
			 
			 
			 
			 
			 
			 
			 
			 
			 
		//select
		 public ArrayList<routeDTO> routeSelect() {
			 query = "select * from route";
			 ArrayList<routeDTO> dtos = new ArrayList<routeDTO>();
			 try {
				 con = DriverManager.getConnection(url, uid, pwd);
					stmt = con.createStatement();
					rs = stmt.executeQuery(query);
					
					while(rs.next()) {
						String Flight_name = rs.getString("Flight_name");
						String depart = rs.getString("depart");
						String arrive = rs.getString("arrive");
						String departdate = rs.getString("departdate");
						String departTime = rs.getString("departTime");
						String arriveTime = rs.getString("arrvieTime");
						String totalTime = rs.getString("totalTime");
						
						routeDTO dto = new routeDTO(Flight_name, depart, arrive, departdate, departTime, arriveTime, totalTime);
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
