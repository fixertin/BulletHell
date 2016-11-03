package com.fixertin.roguelikeGame.entities.creatures;

import com.fixertin.roguelikeGame.entities.Entity;
import com.fixertin.roguelikeGame.main.Handler;

public abstract class Creature extends Entity{
	
	protected int health;
	protected double speed;

	public Creature(Handler handler, double x, double y) {
		super(handler, x, y);
		health = 100;
		speed = 7;
	}
	
	public void move(){
		x += velx;
		y += vely;
	}

}
