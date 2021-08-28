package com.D_Selon.AutoZombieSurvival.event.customEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class HumanDeathEvent extends Event {
	private static final HandlerList handlers = new HandlerList();

	private Player human;
	private String deathMessage;

	public HumanDeathEvent(Player human, String deathMessage) {
		this.human = human;
		this.deathMessage = deathMessage;
	}

	public Player getHuman() {
		return human;
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
