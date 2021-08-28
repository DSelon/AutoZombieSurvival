package com.D_Selon.AutoZombieSurvival.event.customEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class HumanDamagedEvent extends Event implements Cancellable {
	private static final HandlerList handlers = new HandlerList();

	private Player human;
	private Double damage;
	private boolean cancelled;

	public HumanDamagedEvent(Player human, Double damage) {
		this.human = human;
		this.damage = damage;
	}

	public Player getHuman() {
		return human;
	}

	public Double getDamage() {
		return damage;
	}

	public void setDamage(Double damage) {
		this.damage = damage;
	}

	@Override
	public boolean isCancelled() {
		return this.cancelled;
	}

	@Override
	public void setCancelled(boolean cancel) {
		this.cancelled = cancel;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
