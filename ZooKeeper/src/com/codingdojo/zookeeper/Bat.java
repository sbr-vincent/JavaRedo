package com.codingdojo.zookeeper;

public class Bat extends Mammal {
	public Bat() {
		super(300);
	}
	
	public void fly() {
		this.setEnergy(this.getEnergy() - 50);
		
		System.out.println("The bat is flying!");
	}
	
	public void eatHumans() {
		this.setEnergy(this.getEnergy() + 25);
		System.out.println("The bat is eating a human!");
	}
	
	public void attackTown() {
		this.setEnergy(this.getEnergy() - 100);
		System.out.println("The bat is attacking the town!");
	}
}
