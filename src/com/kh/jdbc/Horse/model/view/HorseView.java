package com.kh.jdbc.Horse.model.view;

import java.util.List;
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
		clearScreen();
		System.out.println("==================== 메인 메뉴 ====================");
		System.out.printf("이름: %-6s\t \n", horse.getHorseName());
		System.out.printf("체력: %3d | 스피드: %2d | 등급: %s | 재산: %d |  \n", horse.getHorseHp(), horse.getHorseSpeed(), horse.getHorseGrade(), horse.getHorseMoney());
		System.out.println();
		System.out.println("0. 선택");
		System.out.println("1. 경주");
		System.out.println("2. 휴식");
		System.out.println("3. 뽑기");
		System.out.println("4. 종료");
		System.out.print("입력: ");
		int choice = sc.nextInt();
		return choice;
	}

	public Horse selectMenu(List<Horse> horse) { 	// 0. 선택
		Scanner sc = new Scanner(System.in);
		clearScreen();
		System.out.println("=================== 경주마 선택 ===================");
		
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

	public Horse gambleMenu(Horse horse) {		// 3. 뽑기
		clearScreen();
		System.out.println("=================== 경주마 뽑기 ===================");
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("200원을 사용해 경주마를 뽑으시겠습니까?");
			System.out.println("1. YES ");
			System.out.println("2. NO ");
			System.out.print("선택: ");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				if( horse.getHorseMoney() >= 200) {
					System.out.println("경주마 뽑기 완료.");
					System.out.print("이름 입력 : ");
					String name = sc.next();
					horse = new Horse(name);
					horse.setHorseMoney(horse.getHorseMoney()-200);
				} else {
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
		return horse;
	};	
	
	
	public void printMessage(String msg) {
		System.out.println(msg);
	}

	public void displaySuccess(String message) {
		System.out.println("[서비스 성공] : " + message);
	}

	public void displayError(String message) {
		System.out.println("[서비스 실패] : " + message);
	}
	
	public void clearScreen() {
		for (int i = 0; i < 80; i++)
			System.out.println("");  
	}

	public void end() {
		System.out.println();
		System.out.println("프로그램 종료.");
	}
}
