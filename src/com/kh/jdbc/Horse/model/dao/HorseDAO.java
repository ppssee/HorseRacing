package com.kh.jdbc.Horse.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.Horse.model.vo.Horse;

public class HorseDAO {

	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String USER = "student";
	private final String PASSWORD = "student";
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	
	
	public int createHorse(List<Horse> horse) {
		
		int result = 0;
		String sql = "UPDATE HORSE_TBL SET HORSE_MONEY = ? WHERE HORSE_ID = ?";
		String sql2 = "INSERT INTO HORSE_TBL VALUES(?,?,?,?,?,?)";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			
			pstmt.setInt(1, horse.get(0).getHorseMoney());
			pstmt.setInt(2, horse.get(0).getHorseId());
			
			pstmt2.setInt(1, horse.get(1).getHorseId());
			pstmt2.setString(2, horse.get(1).getHorseName());
			pstmt2.setString(3, horse.get(1).getHorseGrade());
			pstmt2.setInt(4, horse.get(1).getHorseHp());
			pstmt2.setInt(5, horse.get(1).getHorseSpeed());
			pstmt2.setInt(6, horse.get(1).getHorseMoney());
			
			pstmt.executeUpdate();
			result = pstmt2.executeUpdate();
			
			pstmt2.close();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}

	public List<Horse> selectAll() {
		List<Horse> hList = null;
		Horse horse = null;
	
		String sql = "SELECT * FROM HORSE_TBL ORDER BY HORSE_ID ASC";
		
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rset = pstmt.executeQuery();
			
			hList = new ArrayList<Horse>();
			while(rset.next()) {
				horse = new Horse();
				horse.setHorseId(rset.getInt("HORSE_ID"));
				horse.setHorseName(rset.getString("HORSE_NAME"));
				horse.setHorseGrade(rset.getString("HORSE_GRADE"));
				horse.setHorseHp(rset.getInt("HORSE_HP"));
				horse.setHorseSpeed(rset.getInt("HORSE_SPEED"));
				horse.setHorseMoney(rset.getInt("HORSE_MONEY"));
				hList.add(horse);
			}
			
			rset.close();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hList;
		
	}

	public int updateHorse(Horse horse) {
		
		String sql = "UPDATE HORSE_TBL SET HORSE_HP = ? , HORSE_MONEY = ? WHERE HORSE_ID = ?";
		int result = 0;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, horse.getHorseHp());
			pstmt.setInt(2, horse.getHorseMoney());
			pstmt.setInt(3, horse.getHorseId());
			result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int restHorse(Horse horse) {
		int result = 0;
		String sql = "UPDATE HORSE_TBL SET HORSE_HP = ? WHERE HORSE_ID = ?";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, horse.getHorseHp());
			pstmt.setInt(2, horse.getHorseId());
			result = pstmt.executeUpdate();
				
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public int deleteHorse(Horse horse) {
		int result = 0;
		String sql = "DELETE FROM HORSE_TBL WHERE HORSE_ID = ?";
		
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, horse.getHorseId());
			result = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public void allDeleteHorse() {
		int result = 0;
		String sql = "DELETE FROM HORSE_TBL";
		
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public int inputHorse(Horse horse) {

		int result = 0;
		String sql = "INSERT INTO HORSE_TBL VALUES(?,?,?,?,?,?)";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, horse.getHorseId());
			pstmt.setString(2, horse.getHorseName());
			pstmt.setString(3, horse.getHorseGrade());
			pstmt.setInt(4, horse.getHorseHp());
			pstmt.setInt(5, horse.getHorseSpeed());
			pstmt.setInt(6, horse.getHorseMoney());
			
			result = pstmt.executeUpdate();
			
			
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}

}
