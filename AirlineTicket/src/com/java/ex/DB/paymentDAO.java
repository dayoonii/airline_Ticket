package com.java.ex.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class paymentDAO {
	static String driver = "org.mariadb.jdbc.Driver";
	static String url = "jdbc:mariadb://localhost:3307/airline_ticket";
	static String uid = "root";
	static String pwd = "1234";
	
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	String query = null;

	public paymentDAO() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean payment(paymentDTO dto) {
		
		String query1 = "INSERT INTO PAYMENT (ID, NAME, FLIGHT_NAME, SEATNUM, TOTAL_PRICE) VALUES (?, ?, ?, ?, ?)";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, pwd);

			int i = 1;
			pstmt = con.prepareStatement(query1);
			pstmt.setString(i++, dto.getId());
			pstmt.setString(i++, dto.getName());
			pstmt.setString(i++, dto.getFlight_name());
			pstmt.setString(i++, dto.getSeatNum());
			pstmt.setInt(i++, dto.getTotal_price());

			int resultQuery = pstmt.executeUpdate();
			if(resultQuery > 0) {
				return true;
			} else {
				return false;
			}
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
		return false;
	}
}
