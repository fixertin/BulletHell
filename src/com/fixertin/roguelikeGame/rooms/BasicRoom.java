package com.fixertin.roguelikeGame.rooms;

import java.awt.Graphics;
import java.util.Random;

public class BasicRoom extends Room{
	public int[][] tiles;

	public BasicRoom(int x, int y) {
		w = getRandomInt(8, 10);
		h = getRandomInt(8, 10);
		this.x = x*13+1;
		this.y = y*13+1;
		midpointX = (x + (int)(w/2));
		midpointY = (y + (int) (h/2));
		//x = getRandomInt(1, 100-w);
		//y = getRandomInt(1, 100-h);
		MAX_SIZE = 13;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		
	}
	
	public void load(int[][] tiles, int maxW, int maxH){
		for(int xx=0; xx<maxW; xx++){
			for(int yy=0; yy<maxH; yy++){
				if((xx>=x && xx<=x+w)&&(yy>=y && yy<=y+w)){
					tiles[xx][yy] = 1;
				}			
			}
		}
	}
	
	public int getRandomInt(int min, int max) {
		Random rand = new Random(); 
		return rand.nextInt((max - min) + 1) + min;
	}

}
