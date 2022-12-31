package com.kh.jdbc.Horse.Controller;

import java.util.List;

import com.kh.jdbc.Horse.model.dao.HorseDAO;
import com.kh.jdbc.Horse.model.vo.Horse;

public class HorseContoller {
	
	
	public int registerMember(Horse horse) {    // 
		HorseDAO hDao = new HorseDAO();
		int result = hDao.inputHorse(horse);
		return result;
	}
	
	public List<Horse> printAll() {
		HorseDAO hDao = new HorseDAO();
		List<Horse> hList = null;
		hList = hDao.selectAll();
		return hList;
	}
}
