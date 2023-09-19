package com.codingdojo.zookeeper;

public class Gorilla extends Mammal {
	public void throwSomething(){
		this.setEnergy(this.getEnergy() - 5);
        System.out.println("The gorilla has thrown something.");
    }

    public void eatBananas(){
    	this.setEnergy(this.getEnergy() + 10);
        System.out.println("The gorilla has eaten a banana. They are happy.");
    }

    public void climb(){
    	this.setEnergy(this.getEnergy() - 10);
        System.out.println("The gorilla has climbed a tree.");
    }
}
