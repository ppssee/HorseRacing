package com.kh.pse;

import java.util.Random;

public class HorseRandom { 	// 등급, 체력, 스피드
	
	public HorseRandom(){} 	 
	
	public String randGrade() { 
		
		Random rand = new Random();
		int a = rand.nextInt(100) + 1;  
		if(a > 0 && a <= 50) {    // 50% 하  
			return "하";
		}
		else if (a > 50 && a <= 80) {  // 30% 중
			return "중";
		}
		else {   // 20% 상
			return "상";
		}
		
	}
	
	public int randSpeed(String grade) {
		Random rand = new Random();
		int speed = 0;
		if(grade == "하") {	
			speed = rand.nextInt(35)+1; 	// 스피드값: 1~35     
			return speed;		
		}
		else if(grade == "중") {
			speed = rand.nextInt(40)+10;    // 스피드값: 10~49
			return speed;
		}
		else {
			speed = rand.nextInt(50)+20;    // 스피드값: 20~70
			return speed;
		}
	}
	
	
}
