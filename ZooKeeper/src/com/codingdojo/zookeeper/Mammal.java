package com.codingdojo.zookeeper;

public class Mammal {
	private int energy;
	
	public int getEnergy() {
		return this.energy;
	}

	public Mammal() {
		this.energy = 100;
	}
	
	public Mammal(int energy) {
		this.energy = energy;
	}
	
	public int displayEnergy() {
		return this.energy;
	}
	
	public void setEnergy(int number) {
		this.energy = number;
	}
}
