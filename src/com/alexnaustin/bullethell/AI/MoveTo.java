package com.alexnaustin.bullethell.AI;

import java.awt.Rectangle;

import com.alexnaustin.bullethell.entities.Enemy;
import com.alexnaustin.bullethell.main.Handler;

public class MoveTo extends AI {
	final protected double destX;
	final protected double destY;
	final protected double distance;
	
	final private int unitX, unitY;
	
	protected double velx, vely;
	
	protected double angle;

	

	public MoveTo(Handler handler, double distance, Enemy e, double angle) {
		super(handler, e);
		this.angle = handler.checkAngle(angle);
		this.distance = distance;
		unitX = getXisNegative(angle);
		unitY = getYisNegative(angle);
		destX = (Math.cos(Math.toRadians(this.angle)) * distance*unitX)+ e.getX();
		destY = (Math.sin(Math.toRadians(this.angle)) * distance*unitY)+ e.getY();
		setValues();
	}
	
	private void setValues(){
		velx = handler.getXSpeed(angle, 7) * unitX;
		vely = handler.getYSpeed(angle, 7) * unitY;
		hitbox = new Rectangle();
		setBounds();
	}
	
	private int getXisNegative(double angle){
		if(handler.checkVelX(angle))
			return -1;
		else
			return 1;
	}
	private int getYisNegative(double angle){
		if(handler.checkVelY(angle))
			return -1;
		else
			return 1;
	}
	
	public void setBounds(){
		hitbox.setBounds((int)destX, (int)destY, 32, 32);
	}

	@Override
	public void reset() {
		start();
	}

	@Override
	public void tick() {
		setBounds();
		if(isRunning()){
			if(!isAtDestination())
				moveEnemy();
			else{
				e.setVelx(0);
				e.setVely(0);
			}
		}
	}
	
	private void moveEnemy(){
		if(isAtDestination()){
			e.setVelx(0);
			e.setVely(0);
			succeed();
		} else {
			e.setVelx(velx);
			e.setVely(vely);
		}
	}
	private boolean isAtDestination(){
		if(e.getHitbox().getBounds().intersects(hitbox)){
			return true;
		} else 
			return false;
		
	}

}
