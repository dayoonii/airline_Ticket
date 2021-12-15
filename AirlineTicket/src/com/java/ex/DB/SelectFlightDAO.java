package com.java.ex.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectFlightDAO {

	static String driver = "org.mariadb.jdbc.Driver"; 
	   static String url = "jdbc:mariadb://localhost:3307/airline_ticket";
	   static String uid = "root";
	   static String pwd = "1234";
	   Connection con = null;
		 Statement stmt = null;
		 ResultSet rs = null;
		 PreparedStatement routepstmt = null;		 
		 String query = null;
		 
		 public SelectFlightDAO(){
			 try {
				 Class.forName(driver);
				} catch (Exception e) {
					e.printStackTrace(); 
				}
		 }
		 
		 public void FlightInsert1(String departTime, String arriveTime, String fare, String seatLevel) {
			 
		 }
	   
}
