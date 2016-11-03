package com.fixertin.roguelikeGame.states;

import java.awt.Graphics;

import com.fixertin.roguelikeGame.entities.creatures.EnemyTest;
import com.fixertin.roguelikeGame.entities.creatures.Player;
import com.fixertin.roguelikeGame.main.Game;
import com.fixertin.roguelikeGame.main.Handler;
import com.fixertin.roguelikeGame.worlds.World;

public class GameState extends State{
	public Player player;
	public World world;
	public EnemyTest enemy;
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler);
		handler.setWorld(world);
		player = new Player(handler, 400, 250);
		enemy = new EnemyTest(handler, 300, 150);
		handler.getCamera().move(player.getX(), player.getY());
	}
	
	@Override
	public void tick() {
		world.tick();
		player.tick();
		enemy.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
		enemy.render(g);
	}

}
