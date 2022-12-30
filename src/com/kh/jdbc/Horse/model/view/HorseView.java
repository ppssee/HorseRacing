package com.kh.jdbc.Horse.model.view;

import java.util.Scanner;

import com.kh.pse.Horse;

public class HorseView {
	

	public Horse startMenu() { 		// 시작 메뉴
		Scanner sc = new Scanner(System.in);
		System.out.println("================== 경마 프로그램 ==================");
		System.out.println("기본 경주마를 생성합니다.");
		System.out.println("사용하실 경주마의 정보를 입력해주세요.");
		System.out.print("경주마의 이름 : ");
		String name = sc.nextLine();
		Horse horse = new Horse(name);
		horse.setGrade("하");
		horse.setSpeed(25);

		return horse;
	};	

	public int mainMenu() { // 메인 메뉴
		Scanner sc = new Scanner(System.in);
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
}
