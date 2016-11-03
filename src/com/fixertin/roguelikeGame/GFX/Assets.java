package com.fixertin.roguelikeGame.GFX;

import java.awt.image.BufferedImage;

public class Assets {
	public static BufferedImage stoneTile,wallTile,player,enemy,bullet;
	
	public static final int WIDTH = 32, HEIGHT = 32;
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet.png"));
		stoneTile = sheet.crop(0, 0, WIDTH, HEIGHT);
		wallTile = sheet.crop(1, 0, WIDTH, HEIGHT);
		player = sheet.crop(2, 0, WIDTH, HEIGHT);
		bullet = sheet.crop(3, 0, WIDTH, HEIGHT);
		enemy = sheet.crop(4, 0, WIDTH, HEIGHT);
	}
}
