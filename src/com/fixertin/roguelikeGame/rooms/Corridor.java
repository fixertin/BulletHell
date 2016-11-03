package com.fixertin.roguelikeGame.rooms;

import java.awt.Graphics;

public class Corridor extends Room{
	public Room from, to;
	public int xFrom, yFrom, xTo, yTo;
	
	public Corridor(Room from, Room to, int chunk){
		
		if(chunk > 14){
			chunk = (chunk/14);
		}
		
		this.from = from;
		this.to = to;
		xFrom = from.midpointX;
		yFrom = from.midpointY;
		x=xFrom+13;
		y=yFrom+13;
		xTo = to.midpointX;
		yTo = to.midpointY;
		w = 13+(xTo - xFrom);
		h = 1;
		
		
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		
	}

	@Override
	public void load(int[][] map, int width, int height) {
		for(int xx=0; xx<width; xx++){
			for(int yy=0; yy<height; yy++){
				if((xx>=x && xx<=x+w)&&(yy>=y && yy<=y+h)){
					map[xx][yy] = 1;
				}			
			}
		}
		System.out.println(x + " " + y + " " + w + " " + h);
	}
}
