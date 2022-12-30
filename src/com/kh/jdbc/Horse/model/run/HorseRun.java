package com.kh.jdbc.Horse.model.run;

import com.kh.jdbc.Horse.model.view.HorseView;

public class HorseRun {

	public static void main(String[] args) {
		HorseView hView = new HorseView();
		
		Bye : 
		while(true) {
			int choice = hView.mainMenu();
			switch(choice) {
			case 0 :   // 경주마 선택 메뉴
				
				break;
			case 1 :   // 경주 메뉴
				
				break;
			case 2 :   // 휴식 메뉴
				
				break;
			case 3 :  // 경주마 뽑기 메뉴
				
				break;
			case 4 : 
				
				break Bye;
			default : 
				hView.printMessage("0~3 을 입력해주세요.");
				
				break;
			}
		}
	}
}
