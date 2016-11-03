package com.fixertin.roguelikeGame.entities.creatures;

import com.fixertin.roguelikeGame.main.Handler;

public abstract class Enemy extends Creature{

	public Enemy(Handler handler, double x, double y) {
		super(handler, x, y);
	}

}
