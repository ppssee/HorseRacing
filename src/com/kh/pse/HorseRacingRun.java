package com.kh.pse;

public class HorseRacingRun {

	public static void main(String[] args) {
		
		HorseRacingFunction hrFunc = new HorseRacingFunction();
		hrFunc.startMenu();
		hrFunc.selectMenu();
		Bye :
		while(true) {
			
			int choice = hrFunc.mainMenu();
			
			switch(choice) {
			case 0 : hrFunc.selectMenu();  // 경주마 선택 메뉴
				break;
			case 1 : hrFunc.racingMenu();  // 경주 메뉴
				break;
			case 2 : hrFunc.restMenu();   // 휴식 메뉴
				break;
			case 3 : hrFunc.gambleMenu();  // 경주마 뽑기 메뉴
				break;
			case 4 : hrFunc.byeMessage();
				break Bye;
			default : 
				System.out.println("0~3 을 입력해주세요.");
				break;
			}  // switch문 종료
		}  // while문 종료

	}

}
