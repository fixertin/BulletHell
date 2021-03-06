package com.fixertin.roguelikeGame.GFX;

import com.fixertin.roguelikeGame.entities.Entity;
import com.fixertin.roguelikeGame.main.Game;

public class GameCamera {
	private double xOffset, yOffset;
	private Game game;
	public GameCamera(Game game, double xOffset, double yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.game = game;
	}
	
	public void centerOnEntity(Entity e){
		xOffset = e.getX() - game.width / 2 + 16;
		yOffset = e.getY() - game.height / 2 + 16;
	}
	
	public void move(double xAmt, double yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
	}

	public double getxOffset() {
		return xOffset;
	}

	public void setxOffset(double xOffset) {
		this.xOffset = xOffset;
	}

	public double getyOffset() {
		return yOffset;
	}

	public void setyOffset(double yOffset) {
		this.yOffset = yOffset;
	}
}
