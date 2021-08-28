package com.D_Selon.AutoZombieSurvival.event.customEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ZombieDamagedEvent extends Event implements Cancellable {
	private static final HandlerList handlers = new HandlerList();

	private Player zombie;
	private Double damage;
	private boolean cancelled;

	public ZombieDamagedEvent(Player zombie, Double damage) {
		this.zombie = zombie;
		this.damage = damage;
	}

	public Player getZombie() {
		return zombie;
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
