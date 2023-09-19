package com.codingdojo.zookeeper;
public class MammalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mammal animal = new Mammal();
		
		Gorilla gorilla = new Gorilla();
		
		gorilla.throwSomething();
		gorilla.throwSomething();
		gorilla.throwSomething();
		
		gorilla.eatBananas();
		gorilla.eatBananas();
		
		gorilla.climb();
		
		Bat bat = new Bat();
		
		bat.attackTown();
		bat.attackTown();
		bat.attackTown();
		
		bat.eatHumans();
		bat.eatHumans();
		
		bat.fly();
		bat.fly();
		
		
		System.out.println("The gorilla's energy: " + gorilla.displayEnergy());
		System.out.println("The bat's energy: " + bat.displayEnergy());
	}

}
