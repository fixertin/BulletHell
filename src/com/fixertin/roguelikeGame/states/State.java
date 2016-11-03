package com.fixertin.roguelikeGame.states;

import java.awt.Graphics;

import com.fixertin.roguelikeGame.main.Game;
import com.fixertin.roguelikeGame.main.Handler;

public abstract class State {
	private static State currentState = null;
	protected Handler handler;
	
	public State(Handler handler){
		this.handler = handler;
	}
	
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
}
