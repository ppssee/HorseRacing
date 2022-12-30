package com.kh.pse;

public class HorseMoney {

	private static HorseMoney hm;    // Money 싱글톤

	private static int money = 0;
	private static int state = 1;
		
	private HorseMoney() {}
	
	public static HorseMoney getinstance() {
		if(hm == null) {
			hm = new HorseMoney();
		}
		return hm;			
	}

	public static int getMoney() {
		return money;
	}

	public static void setMoney(int money) {
		HorseMoney.money = money;
	}

	public static int getState() {
		return state;
	}

	public static void setState(int state) {
		HorseMoney.state = state;
	}


}
