package com.fixertin.roguelikeGame.worlds;

public class Chunk {
	private int w, h;
	private boolean hasRoom;
	private int x, y;
	
	public Chunk(int w, int h, int x, int y){
		this.w = w;
		this.h = h;
		this.x = x;
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

	public boolean isHasRoom() {
		return hasRoom;
	}

	public void setHasRoom(boolean hasRoom) {
		this.hasRoom = hasRoom;
	}

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
}
