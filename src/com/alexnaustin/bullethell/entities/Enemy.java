package com.alexnaustin.bullethell.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.alexnaustin.bullethell.AI.MoveTo;
import com.alexnaustin.bullethell.GFX.Assets;
import com.alexnaustin.bullethell.clock.Timer;
import com.alexnaustin.bullethell.creatures.Bullet;
import com.alexnaustin.bullethell.main.Handler;

public class Enemy extends Creature{
	public Timer timer;
	public LinkedList<Bullet> bullets = new LinkedList<Bullet>();
	public LinkedList<MoveTo> movements = new LinkedList<MoveTo>();
	private int angle;
	private int holder = 1;
	private MoveTo command;

	public Enemy(Handler handler, double x, double y) {
		super(handler, x, y);
		hitbox = new Rectangle();
		init();
		
		command = new MoveTo(handler, 7, this, 270);
	}
	
	private void init(){
		timer = new Timer(0.01);
	}

	@Override
	public void tick() {
		timer.tick();
		setHitboxBounds();
		
		if(command.getState() == null){
			command.start();
		}
		
		command.tick();
		
		x += velx;
		y += vely;
		if(((angle >= 180)&&(holder == 1))||((angle <= 1)&&(holder == -1))){		
			holder = -holder;
			angle += 5*holder;
		}
		if(timer.hasReachedTime()){
			timer.reset(0.01);
			bullets.add(new Bullet(handler, x, y, (double) angle, this));
			angle += (10*holder);
		}
		for(int i=0; i<bullets.size(); i++)
			bullets.get(i).tick();
		for(int i=0; i<bullets.size(); i++){
			if(bullets.get(i).isAtEdge())
				bullets.remove(i);
		}
		
		
		
		//angle += 10;
		velx = 0;
		vely = 0;
	}
	
	public void moveInDirection(double angle){
		int unitx = 1;
		int unity = 1;
		double trueAngle = handler.checkAngle(angle);
		if(handler.checkVelX(angle)) unitx = -unitx;
		if(handler.checkVelY(angle))unity = -unity;
		velx = Math.cos(Math.toRadians(trueAngle)) * 7 * unitx;
		vely = Math.sin(Math.toRadians(trueAngle)) * 7 * unity;
	}

	@Override
	public void render(Graphics g) {
		for(int i=0; i<bullets.size(); i++)
			bullets.get(i).render(g);
		g.drawImage(Assets.enemy, (int)x, (int)y, null);
		
	}

	@Override
	public void setHitboxBounds() {
		hitbox.setBounds((int)x, (int)y, 32, 32);
	}

}
