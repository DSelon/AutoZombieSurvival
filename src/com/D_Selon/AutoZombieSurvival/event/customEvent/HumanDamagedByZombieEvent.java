package com.D_Selon.AutoZombieSurvival.event.customEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public final class HumanDamagedByZombieEvent extends HumanDamagedEvent {
	private static final HandlerList handlers = new HandlerList();

	private Player zombie;

	public HumanDamagedByZombieEvent(Player human, Player zombie, Double damage) {
		super(human, damage);
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
