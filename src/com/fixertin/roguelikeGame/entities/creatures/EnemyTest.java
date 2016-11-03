package com.fixertin.roguelikeGame.entities.creatures;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import com.fixertin.roguelikeGame.GFX.Assets;
import com.fixertin.roguelikeGame.entities.Bullet;
import com.fixertin.roguelikeGame.main.Handler;
import com.fixertin.roguelikeGame.main.clock.Timer;

public class EnemyTest extends Enemy {
	
	public LinkedList<Bullet> bullets = new LinkedList<Bullet>();
	private Timer timer;
	public int angle = 0;

	public EnemyTest(Handler handler, double x, double y) {
		super(handler, x, y);
		timer = new Timer(0.01);
	}

	@Override
	public void tick() {
		timer.tick();
		
		angle += 10;
		if(angle > 360){
			angle -= 360;
		}
		
		
		if(timer.hasReachedTime()){
			bullets.add(new Bullet(handler, x, y, angle, this, bullets.size()+1));	
			timer.resetTimer(0.01);
		}
		
		for(int i=0; i<bullets.size(); i++){
			bullets.get(i).tick();
		}
		
		for(int i=0; i<bullets.size(); i++){
			if(bullets.get(i).isAtEdge()){
				bullets.remove(i);
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.enemy, (int)x, (int)y, null);
		for(int i=0; i<bullets.size(); i++){
			bullets.get(i).render(g);
		}
	}

}
