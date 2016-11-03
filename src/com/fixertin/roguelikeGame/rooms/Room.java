package com.fixertin.roguelikeGame.rooms;

import java.awt.Graphics;

public abstract class Room {
	protected int w, h, x, y, midpointX, midpointY;
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract void load(int[][] map, int w, int h);
	
	public static int MAX_SIZE;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
}
