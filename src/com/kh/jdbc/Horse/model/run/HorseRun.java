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
		Horse createHorse = null;
		List<Horse> hList = null;
		int result = 0;
		
		
		Bye :
		while(true) {	// 첫 캐릭터 생성.
			horse = hView.startMenu();	
			result = hCon.registerMember(horse);
			if(result > 0) {
				hView.displaySuccess("생성 성공");
				break Bye;
			} else {
				hView.displayError("생성 Error");
			}
		}
		
		Bye : 
		while(true) {
			int choice = hView.mainMenu(horse);		// 메인 메뉴
			switch(choice) {
			case 0 :   // 경주마 선택 메뉴
				hList = hCon.printAll();
				if(!hList.isEmpty()) {
					horse = hView.selectMenu(hList);
				} else {
					hView.displayError("0.선택 Error");
				}
				break;
			case 1 :	// 경주마 삭제 메뉴
				hList = hCon.printAll();
				if(!hList.isEmpty() && (hList.size() > 1)) {
					horse = hView.selectMenu(hList);
					result = hCon.deleteHorse(horse);
					if(result > 0) {
						horse = hView.selectMenu(hList);
					} else {
						hView.displayError("삭제 Error");
					}
				} else {
					hView.displayError("경주마 2마리 이상 보유시 삭제 가능합니다.");
				}
				   
				break;
			case 2 :   // 경주 메뉴
				horse = hView.racingMenu(horse);
				result = hCon.modifyHorse(horse);
				if(result > 0) {
					hView.displaySuccess("경주 성공");
				}else {
					hView.displayError("경주 Error");
				}
				break;
			case 3 :   // 휴식 메뉴
				horse = hView.restMenu(horse);
				result = hCon.restHorse(horse);
				if(result > 0) {
					hView.displaySuccess("휴식 성공");
				}else {
					hView.displayError("휴식 Error");
				}
				break;
			case 4 :  // 경주마 뽑기 메뉴
				horse = hView.gambleMenu(horse);
				result = hCon.registerMember(horse);
				if(result > 0) {
					hView.displaySuccess("뽑기 성공");
				} else {
					hView.displayError("뽑기 Error");
				}
				break;
			
			case 5 :	 // 프로그램 종료.
				hView.end();
				
				break Bye;
			default : 
				hView.printMessage("0~3 을 입력해주세요.");
				
				break;
			}
		}
	}
}
