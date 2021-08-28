package com.D_Selon.AutoZombieSurvival.event.customEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ZombieDeathEvent extends Event {
	private static final HandlerList handlers = new HandlerList();

	private Player zombie;
	private String deathMessage;

	public ZombieDeathEvent(Player zombie, String deathMessage) {
		this.zombie = zombie;
		this.deathMessage = deathMessage;
	}

	public Player getZombie() {
		return zombie;
	}

	public String getDeathMessage() {
		return deathMessage;
	}

	public void setDeathMessage(String deathMessage) {
		this.deathMessage = deathMessage;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
