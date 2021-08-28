package com.D_Selon.AutoZombieSurvival.event.customEvent;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class TimerEvent extends Event {
	private static final HandlerList handlers = new HandlerList();

	private int time;
	private String timerMessage;

	public TimerEvent(int time) {
		this.time = time;
		this.timerMessage = "";
	}

	public TimerEvent(int time, String timerMessage) {
		this.time = time;
		this.timerMessage = timerMessage;
	}

	public int getTime() {
		return time;
	}

	public String getTimerMessage() {
		return timerMessage;
	}

	public void setTimerMessage(String timerMessage) {
		this.timerMessage = timerMessage;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
