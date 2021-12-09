package com.flynn.ninjaGold;

public class Gold {
	public int goldCount;
	
	public int getGold() {
		return this.goldCount;
	}
	
	public void setGold(int gold) {
		this.goldCount = gold;
	}
	
	public void addGold(int gold) {
		this.goldCount += gold;
	}
	
	public void subtractGold(int gold) {
		this.goldCount -= gold;
	}
}
