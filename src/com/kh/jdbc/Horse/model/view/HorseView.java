package com.kh.jdbc.Horse.model.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.kh.jdbc.Horse.model.vo.Horse;

public class HorseView {


	public Horse startMenu() { 		// 시작 메뉴
		Scanner sc = new Scanner(System.in);

		System.out.println("================== 경마 프로그램 ==================");
		System.out.println("기본 경주마를 생성합니다.");
		System.out.println("사용하실 경주마의 정보를 입력해주세요.");
		System.out.print("경주마의 이름 : ");
		String name = sc.next();
		Horse horse = new Horse(name);
		horse.setHorseGrade("하");
		horse.setHorseSpeed(25);

		return horse;
	};	

	public int mainMenu(Horse horse) { // 메인 메뉴
		Scanner sc = new Scanner(System.in);

		System.out.println("==================== 메인 메뉴 ====================");
		System.out.printf("이름: %-6s\t \n", horse.getHorseName());
		System.out.printf("체력: %3d | 스피드: %2d | 등급: %s | 재산: %d |  \n", horse.getHorseHp(), horse.getHorseSpeed(), horse.getHorseGrade(), horse.getHorseMoney());
		System.out.println();
		System.out.println("0. 경주마 선택");
		System.out.println("1. 경주마 삭제");
		System.out.println("2. 경주");
		System.out.println("3. 휴식");
		System.out.println("4. 뽑기");
		System.out.println("5. 종료");
		System.out.print("입력: ");
		int choice = sc.nextInt();
		return choice;
	}

	public Horse selectMenu(List<Horse> horse) { 	// 0. 선택
		Scanner sc = new Scanner(System.in);
		int i = 0;
		
		System.out.println("=================== 경주마 선택 ===================");
		for(Horse hOne : horse) {
			System.out.printf("%2d. 이름: %-6s\t| 스피드: %2d | 등급: %s\n", i, hOne.getHorseName(), hOne.getHorseSpeed(), hOne.getHorseGrade());
			i++;
		}
		System.out.println();
		System.out.print("입력: ");	
		int choice = sc.nextInt();
		return horse.get(choice);

	}
	
	public Horse deleteHorseMenu(List<Horse> horse) { 	// 0. 선택
		Scanner sc = new Scanner(System.in);

		System.out.println("=================== 삭제 할 경주마 선택 ===================");

		int i = 0;
		for(Horse hOne : horse) {
			System.out.printf("%2d. 이름: %-6s\t| 스피드: %2d | 등급: %s\n", i, hOne.getHorseName(), hOne.getHorseSpeed(), hOne.getHorseGrade());
			i++;
		}
		System.out.println();
		System.out.print("입력: ");	
		int choice = sc.nextInt();
		return horse.get(choice);

	}


	public Horse racingMenu(Horse horse) { 	//  2. 경주
		Random rand = new Random();

		try {
			if(horse.getHorseHp() >= 60) {		// 체력 60 이상만 경주 가능
				for(int i=0; i<20; i++) {
					clearScreen();
					System.out.println("===============1번 라인===============");
					while(true) {
						int random = rand.nextInt(100);
						if(horse.getHorseSpeed() > random) {	 // 랜덤숫자보다 스피드가 클 경우에만 한칸씩 이동 (구현못함)
							for(int j=0; j<=i; j++) {
								if(j==i) {
									System.out.print("●");
								}
								System.out.print("  ");
							}
							System.out.println();
							System.out.println("======================================");
							Thread.sleep(100); 
							break;
						} 
					}
				} // 경주 끝
				int decreaseHp = rand.nextInt(40);
				int increaseMoney = rand.nextInt(100);
				horse.setHorseHp(horse.getHorseHp()-decreaseHp);				// 종료 후 0~29 체력감소.
				horse.setHorseMoney(horse.getHorseMoney()+increaseMoney);		// 종료 후 0~99원 획득.
			} 
			else {
				System.out.println();
				System.out.println("체력 60 이상만 가능합니다.");
				System.out.println("휴식을 통해 체력을 회복하세요.");
				System.out.println("현재 체력: " + horse.getHorseHp());
				Thread.sleep(2000);
			}
		}
		catch(Exception e) {}

		return horse;
	}

	public Horse restMenu(Horse horse) {	// 3. 휴식

		if(horse.getHorseHp()<100) {
			try {
				for(int i=0; horse.getHorseHp() < 100; i++) {
					if(horse.getHorseHp() == i) {
						System.out.println("=================== 휴식 메뉴 ===================");
						System.out.println("휴식 중 ... 현재 체력 : " + horse.getHorseHp());
						horse.setHorseHp(horse.getHorseHp()+1);
						Thread.sleep(100); 
						clearScreen();
					}
				}
			}

			catch(Exception e) { }
			
		}
		return horse;
	}    


	public int gambleMenu(Horse horse) {		// 4. 뽑기

		System.out.println("=================== 경주마 뽑기 ===================");

		Scanner sc = new Scanner(System.in);
		System.out.println("100원을 사용해 경주마를 뽑으시겠습니까?");
		System.out.println("1. YES ");
		System.out.println("2. NO ");
		System.out.print("선택: ");
		int select = sc.nextInt();
		
		if( horse.getHorseMoney() >= 100 && select == 1) {
			return select;
		} else {
			System.out.println();
			System.out.println("금액이 부족합니다.");
			return select = 2;
		}
	}
	 

	public List<Horse> gambleMenuInsert(Horse horse) {
		List<Horse> hList = new ArrayList<Horse>();
		horse.setHorseMoney(horse.getHorseMoney()-100);
		hList.add(horse);
		Scanner sc = new Scanner(System.in);
		System.out.println("경주마 뽑기 완료.");
		System.out.print("이름 입력 : ");
		String name = sc.next();
		horse = new Horse(name);
		hList.add(horse);
		
		return hList;
	}
	
	public void gambleMenyNoMoney() {
		
	}

	public void printMessage(String msg) {
		System.out.println(msg);
	}

	public void displaySuccess(String message) {
		System.out.println("[서비스 성공] : " + message);
	}

	public void displayError(String message) {
		System.out.println("[서비스 실패] : " + message);
	}

	public void end() {
		System.out.println();
		System.out.println("프로그램 종료.");
	}

	public void clearScreen() {
		for (int i = 0; i < 80; i++)
			System.out.println("");  
	}
}
