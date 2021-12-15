package com.java.ex.DB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

public class reserveDAO {
		static String driver = "org.mariadb.jdbc.Driver";
		static String url = "jdbc:mariadb://localhost:3307/airline_ticket";
		static String uid = "root";
		static String pwd = "1234";
		
		Connection con = null;
		 Statement stmt = null;
		 ResultSet rs = null;
		 PreparedStatement routepstmt = null;		 
		 String query = null;
		 
		 public reserveDAO() {
			 try {
				 Class.forName(driver);
				} catch (Exception e) {
					e.printStackTrace();
			 }
		 }
		 
		 
		

		 //Manager_tab1에서 사용 
		 //관리자페이지 (예약회원조회) - 정보 띄우기
		 public ArrayList<reserveDTO> reserveSelect(String reserve_Id, String names, String hp) {
			 String query ="	SELECT" + 
					"		pay.reserve_id," + 
					"		pas.name," + 
					"		rut.departdate," + 
					"		rut.departTime," + 
					"		rut.depart," + 
					"		rut.arrive," + 
					"		seat.seatLevel," + 
					"		'기내식' baggage," + 
					"		'초과수하물' meal" + 
					"	FROM" + 
					"		passenger pas," + 
					"		payment pay," + 
					"		route rut," + 
					"		seat" + 
					"	WHERE" + 
					"		pay.ID = pas.ID" + 
					"		AND pay.Flight_name = rut.Flight_name" + 
					"		AND pay.seatNum = seat.seatNum";
			System.out.println(query);
			if(reserve_Id != null && reserve_Id.equals("")) {
				query += "AND pay.reserve_id = ?";
			}
			if(names != null && names.equals("")) {
				query += "AND pas.name = ?";
			}
			if(hp != null && hp.equals("")) {
				query += "AND pas.HP = ?";
			}
			
			ArrayList<reserveDTO> dtos = new ArrayList<reserveDTO>();
			 try {
				 con = DriverManager.getConnection(url, uid, pwd);
				 routepstmt = con.prepareStatement(query);
				 int i = 1;
				if(reserve_Id != null && reserve_Id.equals("")) {
					routepstmt.setString(i++, reserve_Id);
				}
				if(names != null && names.equals("")) {
					routepstmt.setString(i++, names);
				}
				if(hp != null && hp.equals("")) {
					routepstmt.setString(i++, hp);
				}
				
					rs = routepstmt.executeQuery();
					
					
					while(rs.next()) {
						
						String reserve_id = rs.getString("reserve_id");
						String name = rs.getString("name");
						Date departdate = rs.getDate("departdate");
						Time departTime = rs.getTime("departTime");
						String depart = rs.getString("depart");
						String arrive = rs.getString("arrive");
						String seatLevel = rs.getString("seatLevel");
						String baggage = rs.getString("baggage");
						String meal = rs.getString("meal");
						if(names.equals(name)){
						reserveDTO dto = new reserveDTO(reserve_id, name, departdate, departTime, depart, arrive, seatLevel, baggage, meal);
								dtos.add(dto);		
						}
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
		 




