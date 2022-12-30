package com.kh.pse;

import java.util.Random;
import java.util.Scanner;

public class HorseRacingFunction {

	Horse[] horse;
	Scanner sc;
	HorseMoney hm;
	Random rand;
	HorseRandom horseRand;

	public HorseRacingFunction() {
		horse = new Horse[20];
		sc = new Scanner(System.in);
		rand = new Random();
		horseRand = new HorseRandom();
		hm = HorseMoney.getinstance();
	};


	public void startMenu() { 		// 시작 메뉴
		
		System.out.println("================== 경마 프로그램 ==================");
		System.out.println("기본 경주마를 생성합니다.");
		System.out.println("사용하실 경주마의 정보를 입력해주세요.");
		System.out.print("경주마의 이름 : ");
		String name = sc.nextLine();
		horse[0] = new Horse();
		horse[0].setGrade("하");
		horse[0].setSpeed(horseRand.randSpeed(horse[0].getGrade()));
		horse[0].setName(name);



	};	

	public int mainMenu() { // 메인 메뉴
		clearScreen();
		System.out.println("==================== 메인 메뉴 ====================");
		System.out.printf("이름: %-6s\t \n", horse[hm.getState()].getName());
		System.out.printf("체력: %3d | 스피드: %2d | 등급: %s | 재산: %d |  \n", horse[hm.getState()].getHp(), horse[hm.getState()].getSpeed(), horse[hm.getState()].getGrade(), hm.getMoney());
		System.out.println();
		System.out.println("0. 선택");
		System.out.println("1. 경주");
		System.out.println("2. 휴식");
		System.out.println("3. 뽑기");
		System.out.println("4. 종료");
		System.out.print("입력: ");
		int choice = sc.nextInt();
		sc.nextLine();
		return choice;
	};		

	public void selectMenu() { 	// 0. 선택
		clearScreen();
		System.out.println("=================== 경주마 선택 ===================");
		for(int i = 0; i<horse.length; i++) {
			if(horse[i] != null) {
				System.out.printf("%2d. 이름: %-6s\t| 스피드: %2d | 등급: %s\n", i, horse[i].getName(), horse[i].getSpeed(), horse[i].getGrade());
				
			}
		}
		System.out.println();
		System.out.print("입력: ");	
		int choice = sc.nextInt();
		sc.nextLine();
		hm.setState(choice);
	};	

	public void racingMenu() { 	//  1. 경주
		clearScreen();
		try {
			if(horse[hm.getState()].getHp() >= 60) {		// 체력 60 이상만 경주 가능
				for(int i=0; i<20; i++) {
					clearScreen();
					System.out.println("===============1번 라인===============");
					while(true) {
						int random = rand.nextInt(100);
						
						if(horse[hm.getState()].getSpeed() > random) {	 // 랜덤숫자보다 스피드가 클 경우에만 한칸씩 이동 (구현못함)
							for(int j=0; j<=i; j++) {
								if(j==i) {
									
									System.out.print("●");
								}
								System.out.print("  ");
							}
							System.out.println();
							System.out.println("======================================");
							Thread.sleep(200); 
							break;
						} 
						
					}
				} // 경주 끝
				horse[hm.getState()].setHp(horse[hm.getState()].getHp() - rand.nextInt(30));	// 종료 후 0~29 체력감소.
				hm.setMoney(hm.getMoney() + rand.nextInt(100));		// 종료 후 0~99원 획득.
			} 
			else {
				clearScreen();
				System.out.println("체력 60 이상만 가능합니다.");
				System.out.println("휴식을 통해 체력을 회복하세요.");
				System.out.println("현재 체력: " + horse[hm.getState()].getHp());
				Thread.sleep(2000);
			}
		}
		catch(Exception e) {}
	}
	public void  restMenu() {	// 2. 휴식
		clearScreen();
		
		try {
			for(int i=0; horse[hm.getState()].getHp() < 100; i++) {
				if(horse[hm.getState()].getHp() == i) {
					System.out.println("=================== 휴식 메뉴 ===================");
					System.out.println("휴식 중 ... 현재 체력 : " + horse[hm.getState()].getHp());
					horse[hm.getState()].setHp(horse[hm.getState()].getHp()+1);
					Thread.sleep(200); 
					clearScreen();
				}
			}
		}
		catch(Exception e) { }
	};    

	public void  gambleMenu() {		// 3. 뽑기
		clearScreen();
		System.out.println("=================== 경주마 뽑기 ===================");
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("200원을 사용해 경주마를 뽑으시겠습니까?");
			System.out.println("1. YES ");
			System.out.println("2. NO ");
			System.out.print("선택: ");
			int select = sc.nextInt();
			sc.nextLine();

			switch(select) {
			case 1:
				if( hm.getMoney() >= 200) {
					for(int i = 0; i<horse.length; i++) {
						if(horse[i] == null) {
							horse[i] = new Horse();
							System.out.println();
							System.out.println("경주마 뽑기 완료.");
							System.out.print("경주마의 이름을 입력해주세요: ");
							horse[i].setName(sc.nextLine());
							break;
						}
					}
					hm.setMoney(hm.getMoney()-200);
				}
				else {
					System.out.println();
					System.out.println("금액이 부족합니다.");
					Thread.sleep(2000);
				}
				break;

			case 2:

				break;
			default :
				System.out.println("1번과 2번을 입력해주세요.");
				break;
			}
		}
		catch(Exception e) { }
	};	// 3. 뽑기
	
	public void byeMessage() {
		System.out.println();
		System.out.println("프로그램 종료.");
	}

	public void clearScreen() {
		for (int i = 0; i < 80; i++)
			System.out.println("");  
	}

}
