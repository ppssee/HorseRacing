package com.kh.jdbc.Horse.model.run;

import java.util.List;

import com.kh.jdbc.Horse.Controller.HorseContoller;
import com.kh.jdbc.Horse.model.view.HorseView;
import com.kh.jdbc.Horse.model.vo.Horse;

public class HorseRun {

	public static void main(String[] args) {
		HorseView hView = new HorseView();
		HorseContoller hCon = new HorseContoller();
		Horse horse = null;
		List<Horse> hList = null;
		int result = 0;
		
		
		Bye :
		while(true) {	// 첫 캐릭터 생성.
			horse = hView.startMenu();	
			result = hCon.registerMember(horse);
			if(result > 0) {
				// 성공
				break Bye;
			}
		}
		
		Bye : 
		while(true) {
			int choice = hView.mainMenu(horse);
			switch(choice) {
			case 0 :   // 경주마 선택 메뉴
				hList = hCon.printAll();
				if(!hList.isEmpty()) {
					horse = hView.selectMenu(hList);
				} else {
					hView.displayError("데이터가 존재하지 않습니다.");
				}
				break;
			case 1 :   // 경주 메뉴
				
				break;
			case 2 :   // 휴식 메뉴
				
				break;
			case 3 :  // 경주마 뽑기 메뉴
				
				break;
			case 4 :	 // 프로그램 종료.
				hView.end();
				
				break Bye;
			default : 
				hView.printMessage("0~3 을 입력해주세요.");
				
				break;
			}
		}
	}
}
