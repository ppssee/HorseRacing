package com.kh.jdbc.Horse.Controller;

import java.util.List;

import com.kh.jdbc.Horse.model.dao.HorseDAO;
import com.kh.jdbc.Horse.model.vo.Horse;

public class HorseContoller {
	
	
	public int registerMember(Horse horse) {    // 생성
		HorseDAO hDao = new HorseDAO();
		int result = hDao.inputHorse(horse);
		return result;
	}
	
	public List<Horse> printAll() {		// 전체출력
		HorseDAO hDao = new HorseDAO();
		List<Horse> hList = null;
		hList = hDao.selectAll();
		return hList;
	}
	 
	public int modifyHorse(Horse horse) {    // 경주 후 
		HorseDAO hDao = new HorseDAO();
		int result = hDao.updateHorse(horse);
		return result;
	}
	
	public int restHorse(Horse horse) {
		HorseDAO hDao = new HorseDAO();
		int result = hDao.restHorse(horse);
		return result;
	}
	
	public int deleteHorse(Horse horse) {
		HorseDAO hDao = new HorseDAO();
		int result = hDao.deleteHorse(horse);
		return result;
	}
}
