package com.fixertin.roguelikeGame.worlds;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import com.fixertin.roguelikeGame.entities.creatures.Player;
import com.fixertin.roguelikeGame.main.Game;
import com.fixertin.roguelikeGame.main.Handler;
import com.fixertin.roguelikeGame.rooms.BasicRoom;
import com.fixertin.roguelikeGame.rooms.Corridor;
import com.fixertin.roguelikeGame.rooms.Room;
import com.fixertin.roguelikeGame.tiles.Tile;

public class World {
	private Handler handler;
	
	public World(Handler handler){
		this.handler = handler;
		loadWorld();
		
	}
	

	
	private void loadWorld(){
	
	}
	
	public void tick(){
	
	}
	public void render(Graphics g){
		
	}
}
