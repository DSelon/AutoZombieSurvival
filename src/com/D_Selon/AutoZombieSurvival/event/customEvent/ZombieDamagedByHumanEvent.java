package com.D_Selon.AutoZombieSurvival.event.customEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public final class ZombieDamagedByHumanEvent extends ZombieDamagedEvent {
	private static final HandlerList handlers = new HandlerList();

	private Player human;

	public ZombieDamagedByHumanEvent(Player zombie, Player human, Double damage) {
		super(zombie, damage);
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