package com.fixertin.roguelikeGame.main.clock;

public abstract class Clock {
	protected double startTime;
	protected double currentTime, currentTimeSeconds;

	
	
	public abstract void tick();
	
	public double getCurrentTimeSeconds() {
		return currentTimeSeconds;
	}

	public void setCurrentTimeSeconds(double currentTimeSeconds) {
		this.currentTimeSeconds = currentTimeSeconds;
	}

	public double getStartTime() {
		return startTime;
	}

	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}

	public double getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(double currentTime) {
		this.currentTime = currentTime;
	}

}
