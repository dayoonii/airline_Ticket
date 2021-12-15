package com.java.ex.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PassengerDAO {
	static String driver = "org.mariadb.jdbc.Driver";
	static String url = "jdbc:mariadb://localhost:3307/airline_ticket";
	static String uid = "root";
	static String pwd = "1234";

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	String query = null;
	public int check = 0;
	String dbPw = null;

	public PassengerDAO() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 회원가입 정보 insert
	public void pInsert(String name, String id, String pw, String hp, String email, String address, String nation,
			String gender) {
		String query1 = "INSERT INTO `airline_ticket`.`passenger` (`name`, `ID`, `PW`, `HP`, `Email`, `Address`, `Nation`, `Gender`, `Mileage`) VALUES (?,?,?,?,?,?,?,?,0)";

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, pwd);

			pstmt = con.prepareStatement(query1);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setString(4, hp);
			pstmt.setString(5, email);
			pstmt.setString(6, address);
			pstmt.setString(7, nation);
			pstmt.setString(8, gender);
		System.out.println(query1);

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

	// Update
	public void pUpdate(String name, String pw, String hp, String email, String address, String id) {
		String query1 = "update passenger set NAME =?, PW=?,HP=?,Email=?,Address=? where ID = ? ";

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, pwd);

			pstmt = con.prepareStatement(query1);
			pstmt.setString(1, name);
			pstmt.setString(2, pw);
			pstmt.setString(3, hp);
			pstmt.setString(4, email);
			pstmt.setString(5, address);
			pstmt.setString(6, id);
			// pstmt.setString(7, nation);
			// pstmt.setString(8, gender);

			// rs=pstmt.executeQuery();
			rs = pstmt.executeQuery();
			// int resultQuery = pstmt.executeUpdate();

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

	// 아이디 찾기
	public String search_ID(String Name, String hp) {
		String searchIDquery = "select ID from passenger where NAME=? and HP=?";
		ResultSet rs = null;
		String search_id = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, pwd);
			pstmt = con.prepareStatement(searchIDquery);
			pstmt.setString(1, Name);
			pstmt.setString(2, hp);

			rs = pstmt.executeQuery();

			while (rs.next())
				search_id = rs.getString("ID");
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
		return search_id;
	}

	// 비밀번호 찾기
	public String search_PW(String ID, String Name, String hp) {
		String searchPWquery = "select PW from passenger where ID=? and NAME=?  and HP=?";
		ResultSet rs = null;
		String search_pw = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, pwd);
			pstmt = con.prepareStatement(searchPWquery);
			pstmt.setString(1, ID);
			pstmt.setString(2, Name);
			pstmt.setString(3, hp);

			rs = pstmt.executeQuery();

			while (rs.next())
				search_pw = rs.getString("PW");
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
		return search_pw;
	}

	// 로그인
	public int pLogin(String id, String pw) {
		String Loginquery = "select PW from passenger where ID =?";

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, pwd);
			pstmt = con.prepareStatement(Loginquery);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbPw = rs.getString("PW");

				if (dbPw.equals(pw))
					this.check = 1;
				else
					this.check = 0;
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
		return check;
	}

	//tab2에서 수정하기 버튼 눌러서 연결시킬려고 
	public PassengerDTO btnModify(String id, String name) {
		String btnModify = "SELECT * FROM passenger WHERE passenger.name=? OR passenger.ID=?";

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, pwd);
			pstmt = con.prepareStatement(btnModify);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String Name = rs.getString("name");
				String Id = rs.getString("ID");
				String pw = rs.getString("PW");
				String hp = rs.getString("HP");
				String email = rs.getString("Email");
				String address = rs.getString("Address");
				//String nation = rs.getString("Nation");
				//String gender = rs.getString("Gender");

				PassengerDTO dto = new PassengerDTO(name, id, pw, hp, email, address, null, null);
				return dto;
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
		return null;
	}
	
	
//삭제 
	
//	public PassengerDTO pDelete(String ID) {
//		String query2 = "DELETE FROM passenger WHERE passenger.ID = ?";
//		
//		
//		
//		
//	}
//	
//	
//	
//	
	
	
	
	
	
	
	
	

	// select 전체
	public ArrayList<PassengerDTO> pSelect() {
		query = "select * from passenger";
		ArrayList<PassengerDTO> dtos = new ArrayList<PassengerDTO>();
		try {
			con = DriverManager.getConnection(url, uid, pwd);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("ID");
				String pw = rs.getString("PW");
				String hp = rs.getString("HP");
				String email = rs.getString("Email");
				String address = rs.getString("Address");
				String nation = rs.getString("Nation");
				String gender = rs.getString("Gender");

				PassengerDTO dto = new PassengerDTO(name, id, pw, hp, email, address, nation, gender);
				dtos.add(dto);
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
		return dtos;
	}
}
