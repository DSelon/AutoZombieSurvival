package com.D_Selon.AutoZombieSurvival.event.customEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class ZombieDeathByHumanEvent extends ZombieDeathEvent {
	private static final HandlerList handlers = new HandlerList();

	private Player human;

	public ZombieDeathByHumanEvent(Player zombie, Player human, String deathMessage) {
		super(zombie, deathMessage);
		this.human = human;
	}

	public Player getHuman() {
		return human;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
