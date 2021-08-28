package com.D_Selon.AutoZombieSurvival.event.customEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class HumanDeathByZombieEvent extends HumanDeathEvent {
	private static final HandlerList handlers = new HandlerList();

	private Player zombie;

	public HumanDeathByZombieEvent(Player human, Player zombie, String deathMessage) {
		super(human, deathMessage);
		this.zombie = zombie;
	}

	public Player getZombie() {
		return zombie;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
