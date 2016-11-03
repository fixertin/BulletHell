package com.fixertin.roguelikeGame.entities;

import java.awt.Graphics;

import com.fixertin.roguelikeGame.GFX.Assets;
import com.fixertin.roguelikeGame.entities.creatures.Enemy;
import com.fixertin.roguelikeGame.entities.creatures.EnemyTest;
import com.fixertin.roguelikeGame.main.Handler;

public class Bullet extends Entity{

	private EnemyTest shooter;
	private double angle;
	private double triangleVelX, triangleVelY;
	private boolean velXisNegative, velYisNegative;
	private int index;
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Bullet(Handler handler, double x, double y, double angle, EnemyTest shooter, int index) {
		super(handler, x, y);
		this.shooter = shooter;
		this.angle = angle;
		this.index = index;
		velXisNegative = checkVelX();
		velYisNegative = checkVelY();
		checkAngle();
		velx = getXSpeed();
		vely = getYSpeed();
	}
	
	private double getXSpeed(){
		double temp = Math.cos(Math.toRadians(angle));
		if(velXisNegative){
			return -temp;
		}else
			return temp;
		
	}
	private double getYSpeed(){
		double temp = Math.sin(Math.toRadians(angle));
		if(velYisNegative){
			return -temp;
		}else
			return temp;
	}
	private void checkAngle(){
		if((0<=angle) && (angle<=90)){
			return;
		}
		if((90<=angle) && (angle<=180)){
			angle = 180 - angle;
		}
		if((180<=angle) && (angle<=270)){
			angle = 90 - (270 - angle);
		}
		if((270<=angle) && (angle<=360)){
			angle = 360 - angle;
		}
	}
	
	private boolean checkVelX(){
		if((0<=angle) && (angle<=90)){
			return false;
		}
		if((90<=angle) && (angle<=180)){
			return true;
		}
		if((180<=angle) && (angle<=270)){
			return true;
		}
		if((270<=angle) && (angle<=360)){
			return false;
		}
		
		return false;
	}
	private boolean checkVelY(){
		if((0<=angle) && (angle<=90)){
			return false;
		}
		if((90<=angle) && (angle<=180)){
			return false;
		}
		if((180<=angle) && (angle<=270)){
			return true;
		}
		if((270<=angle) && (angle<=360)){
			return true;
		}
		
		return false;
	}
	
	public boolean isAtEdge(){
		if((x <= 0) || (x >= handler.getWidth()) || (y <= 0) || (y >= handler.getHeight())){
			return true;
		}
		else
			return false;
	}

	@Override
	public void tick() {
		if(!isAtEdge()){
			x += velx;
			y += vely;
		}
	}
	@Override
	public void render(Graphics g) {
		if(!isAtEdge()){
			g.drawImage(Assets.bullet, (int)x, (int)y, null);
		}
	}

}
