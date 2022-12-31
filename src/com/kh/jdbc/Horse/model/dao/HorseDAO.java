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
	
	
	
	public int inputHorse(Horse horse) {
		
		int result = 0;
		String sql = "INSERT ALL INTO HORSE_TBL VALUES(?,?,?,?,?) INTO MONEY_TBL VALUES(?,?) SELECT * FROM DUAL";
	
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, horse.getHorseId());
			pstmt.setString(2, horse.getHorseName());
			pstmt.setString(3, horse.getHorseGrade());
			pstmt.setInt(4, horse.getHorseHp());
			pstmt.setInt(5, horse.getHorseSpeed());
			pstmt.setInt(6, horse.getHorseId());
			pstmt.setInt(7, horse.getHorseMoney());
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

	public List<Horse> selectAll() {
		List<Horse> hList = null;
		Horse horse = null;
	
		String sql = "SELECT * FROM HOTSE_TBL JOIN MONEY_TBL USING(HORSE_ID)";
		
		
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




}
