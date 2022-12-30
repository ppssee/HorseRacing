package com.kh.jdbc.Horse.model.vo;

import java.util.Random;

public class Horse {

	private static int count = 1;
	private int horseId;
	private String horseName;
	private String horseGrade;
	private int horseHp = 100;
	private int horseSpeed = 0;
	private int horseMoney = 0;
	
	public Horse() {}
	
	public Horse(String horseName) {
		this.horseId = count;
		this.horseName = horseName;
		this.horseGrade = randGrade(); 
		this.horseSpeed = randSpeed(this.horseGrade);
		count ++;
	}


	public int getHorseId() {
		return horseId;
	}

	public void setHorseId(int horseId) {
		this.horseId = horseId;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public String getHorseGrade() {
		return horseGrade;
	}

	public void setHorseGrade(String horseGrade) {
		this.horseGrade = horseGrade;
	}

	public int getHorseHp() {
		return horseHp;
	}

	public void setHorseHp(int horseHp) {
		this.horseHp = horseHp;
	}

	public int getHorseSpeed() {
		return horseSpeed;
	}

	public void setHorseSpeed(int horseSpeed) {
		this.horseSpeed = horseSpeed;
	}

	public int getHorseMoney() {
		return horseMoney;
	}

	public void setHorseMoney(int horseMoney) {
		this.horseMoney = horseMoney;
	}

	@Override
	public String toString() {
		return "Horse [horseId=" + horseId + ", horseName=" + horseName + ", horseGrade=" + horseGrade + ", horseHp="
				+ horseHp + ", horseSpeed=" + horseSpeed + ", horseMoney=" + horseMoney + "]";
	}

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
