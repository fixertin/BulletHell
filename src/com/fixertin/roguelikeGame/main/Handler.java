package com.fixertin.roguelikeGame.main;

import com.fixertin.roguelikeGame.GFX.GameCamera;
import com.fixertin.roguelikeGame.input.KeyManager;
import com.fixertin.roguelikeGame.main.clock.Clock;
import com.fixertin.roguelikeGame.worlds.World;

public class Handler {
	private Game game;
	private World world;
	
	public Handler(Game game){
		this.game = game;
	}
	
	public int getWidth(){
		return game.width;
	}
	public int getHeight(){
		return game.height;
	}
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	public GameCamera getCamera(){
		return game.getCamera();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
}
