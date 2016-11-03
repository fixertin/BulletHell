package com.fixertin.roguelikeGame.entities.creatures;

import java.awt.Graphics;

import com.fixertin.roguelikeGame.GFX.Assets;
import com.fixertin.roguelikeGame.main.Handler;

public class Player extends Creature{
	
	public Player(Handler handler, double x, double y) {
		super(handler, x, y);
	}
	
	public void getInput(){
		velx = 0;
		vely = 0;
		if(handler.getKeyManager().up)
			vely = -speed;
		if(handler.getKeyManager().down)
			vely = speed;
		if(handler.getKeyManager().left)
			velx = -speed;
		if(handler.getKeyManager().right)
			velx = speed;
	}
	
	@Override
	public void tick() {
		getInput();
		move();
		handler.getCamera().centerOnEntity(this);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), null);
	}

}
