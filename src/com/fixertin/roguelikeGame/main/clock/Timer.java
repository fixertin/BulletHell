package com.fixertin.roguelikeGame.main.clock;

public class Timer extends Clock{
	public double limit, limitMS;
	public double difference, differenceSeconds;
	
	
	public Timer(double limit){
		this.limit = limit;
		limitMS = limit * 1000;
		startTime = System.currentTimeMillis();
	}
	
	@Override
	public void tick() {
		currentTime = System.currentTimeMillis();
		currentTimeSeconds = currentTime/1000;
		difference = currentTime - startTime;
	}
	
	public boolean hasReachedTime(){
		if(difference >= limitMS){
			return true;
		} else {
			return false;
		}
	}
	
	public void resetTimer(double limit){
		this.limit = limit;
		limitMS = limit * 1000;
		startTime = System.currentTimeMillis();
		difference = 0;
		differenceSeconds = 0;
	}

}
