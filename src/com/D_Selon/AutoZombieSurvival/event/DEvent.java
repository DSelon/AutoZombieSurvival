package com.D_Selon.AutoZombieSurvival.event;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.D_Selon.AutoZombieSurvival.DMain;
import com.D_Selon.AutoZombieSurvival.controller.DController;
import com.D_Selon.AutoZombieSurvival.event.customEvent.HumanDamagedByZombieEvent;
import com.D_Selon.AutoZombieSurvival.event.customEvent.HumanDamagedEvent;
import com.D_Selon.AutoZombieSurvival.event.customEvent.HumanDeathByZombieEvent;
import com.D_Selon.AutoZombieSurvival.event.customEvent.HumanDeathEvent;
import com.D_Selon.AutoZombieSurvival.event.customEvent.ZombieDamagedByHumanEvent;
import com.D_Selon.AutoZombieSurvival.event.customEvent.ZombieDamagedEvent;
import com.D_Selon.AutoZombieSurvival.event.customEvent.ZombieDeathByHumanEvent;
import com.D_Selon.AutoZombieSurvival.event.customEvent.ZombieDeathEvent;

public class DEvent implements Listener {

	public static DMain plugin;

	public static void setPlugin(DMain mainPlugin) {
		plugin = mainPlugin;
	}

	@EventHandler
	public void PlayerQuitEvent(org.bukkit.event.player.PlayerQuitEvent event) {
		Player player = event.getPlayer();
		if (DController.getPlayerList().contains(player)) {
			if (DController.getGameProgress() == 2) {
				if (DController.getHumanList().contains(player)) {
					DController.getHumanList().remove(player);
					DController.getHumanTeam().removeEntry(player.getName());
				}
				DController.defaultConversion(player);
				DController.moveLobby(player);
			} else if (DController.getGameProgress() == 3) {
				if (DController.getHumanList().contains(player)) {
					if (DController.getHeroList().contains(player)) {
						DController.getHeroList().remove(player);
					}
					DController.getHumanList().remove(player);
					DController.getHumanTeam().removeEntry(player.getName());
				} else if (DController.getZombieList().contains(player)) {
					if (DController.getHostList().contains(player)) {
						DController.getHostList().remove(player);
					}
					DController.getZombieList().remove(player);
					DController.getZombieTeam().removeEntry(player.getName());
				}
				DController.defaultConversion(player);
				DController.moveLobby(player);
			}
			DController.getPlayerList().remove(player);
		}
	}

	@EventHandler
	public void PlayerDeathEvent(org.bukkit.event.entity.PlayerDeathEvent event) {
		String serverName = DController.getBorderColor() + "[ " + DController.getServerTitle() + " "
				+ DController.getBorderColor() + "]";

		Player player = event.getEntity();
		if (DController.getPlayerList().contains(player)) {
			if (DController.getGameProgress() == 2) {
				DController.humanConversion(player);
				DController.moveMap(player);
			} else if (DController.getGameProgress() == 3) {
				if (DController.getHumanList().contains(player)) {
					Player attacker;
					Player victim = player;
					if (player.getKiller() instanceof Player) {
						attacker = player.getKiller();

						Player human = victim;
						Player zombie = attacker;
						String deathMessage = serverName + " §c§l" + zombie.getName() + " §4§l--]=====- §9§l"
								+ human.getName();
						HumanDeathByZombieEvent customEvent = new HumanDeathByZombieEvent(human, zombie, deathMessage);
						Bukkit.getServer().getPluginManager().callEvent(customEvent);
						if (!customEvent.getDeathMessage().equals("")) {
							for (Player localPlayer : DController.getPlayerList()) {
								localPlayer.sendMessage(customEvent.getDeathMessage());
							}
						}
						DController.deathExecute(human);
						DController.killExecute(zombie);
					} else {
						Player human = victim;
						String deathMessage = serverName + " §4§lX §9§l" + human.getName();
						HumanDeathEvent customEvent = new HumanDeathEvent(human, deathMessage);
						Bukkit.getServer().getPluginManager().callEvent(customEvent);
						if (!customEvent.getDeathMessage().equals("")) {
							for (Player localPlayer : DController.getPlayerList()) {
								localPlayer.sendMessage(customEvent.getDeathMessage());
							}
						}
						DController.deathExecute(human);
					}

					if (DController.getHeroList().contains(player)) {
						DController.getHeroList().remove(player);
					}
					DController.getHumanList().remove(player);
					DController.getHumanTeam().removeEntry(player.getName());
					DController.getZombieList().add(player);
					DController.getZombieTeam().addEntry(player.getName());
				} else if (DController.getZombieList().contains(player)) {
					Player attacker;
					Player victim = player;
					if (player.getKiller() instanceof Player) {
						attacker = player.getKiller();

						Player zombie = victim;
						Player human = attacker;
						String deathMessage = serverName + " §9§l" + human.getName() + " §1§l┏√守━── §c§l"
								+ zombie.getName();
						ZombieDeathByHumanEvent customEvent = new ZombieDeathByHumanEvent(zombie, human, deathMessage);
						Bukkit.getServer().getPluginManager().callEvent(customEvent);
						if (!customEvent.getDeathMessage().equals("")) {
							for (Player localPlayer : DController.getPlayerList()) {
								localPlayer.sendMessage(customEvent.getDeathMessage());
							}
						}
						DController.deathExecute(zombie);
						DController.killExecute(human);
					} else {
						Player zombie = victim;
						String deathMessage = serverName + " §1§lX §c§l" + zombie.getName();
						ZombieDeathEvent customEvent = new ZombieDeathEvent(zombie, deathMessage);
						Bukkit.getServer().getPluginManager().callEvent(customEvent);
						if (!customEvent.getDeathMessage().equals("")) {
							for (Player localPlayer : DController.getPlayerList()) {
								localPlayer.sendMessage(customEvent.getDeathMessage());
							}
						}
						DController.deathExecute(zombie);
					}
				}
			}
		}
	}

	@EventHandler
	public void PlayerRespawnEvent(org.bukkit.event.player.PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		if (DController.getPlayerList().contains(player)) {
			if (DController.getGameProgress() == 1) {
				DController.respawnToLobby(event);
			} else if (DController.getGameProgress() == 2) {
				DController.respawnToMap(event);
				if (DController.getHumanList().contains(player)) {
					DController.humanConversion(player);
				}
			} else if (DController.getGameProgress() == 3) {
				DController.respawnToMap(event);
				if (DController.getHumanList().contains(player)) {
					if (DController.getHeroList().contains(player)) {
						DController.heroConversion(player);
					} else {
						DController.humanConversion(player);
					}
				} else if (DController.getZombieList().contains(player)) {
					if (DController.getHostList().contains(player)) {
						DController.hostConversion(player);
					} else {
						DController.zombieConversion(player);
					}
				}
			} else if (DController.getGameProgress() == 4) {
				DController.respawnToMap(event);
			}
		}
	}

	@EventHandler
	public void EntityDamageByEntityEvent(org.bukkit.event.entity.EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			Double damage = event.getDamage();
			if (DController.getPlayerList().contains(player)) {
				if (event.getDamager() instanceof Player) {
					Player attacker = (Player) event.getDamager();
					if (DController.getHumanList().contains(player)) {
						if (DController.getZombieList().contains(attacker)) {
							Player human = player;
							Player zombie = attacker;
							HumanDamagedByZombieEvent customEvent = new HumanDamagedByZombieEvent(human, zombie,
									damage);
							Bukkit.getServer().getPluginManager().callEvent(customEvent);
							if (customEvent.isCancelled()) {
								event.setCancelled(true);
							}
						}
					} else if (DController.getZombieList().contains(player)) {
						if (DController.getHumanList().contains(attacker)) {
							Player zombie = player;
							Player human = attacker;
							ZombieDamagedByHumanEvent customEvent = new ZombieDamagedByHumanEvent(zombie, human,
									damage);
							Bukkit.getServer().getPluginManager().callEvent(customEvent);
							if (customEvent.isCancelled()) {
								event.setCancelled(true);
							}
						}
					}
				} else {
					if (event.getDamager() instanceof Projectile) {
						if (DController.getPlayerList().contains(((Projectile) event.getDamager()).getShooter())) {
							Player shooter = (Player) ((Projectile) event.getDamager()).getShooter();
							if (DController.getHumanList().contains(player)) {
								if (DController.getZombieList().contains(shooter)) {
									Player human = player;
									Player zombie = shooter;
									HumanDamagedByZombieEvent customEvent = new HumanDamagedByZombieEvent(human, zombie,
											damage);
									Bukkit.getServer().getPluginManager().callEvent(customEvent);
									if (customEvent.isCancelled()) {
										event.setCancelled(true);
									}
								}
							} else if (DController.getZombieList().contains(player)) {
								if (DController.getHumanList().contains(shooter)) {
									Player zombie = player;
									Player human = shooter;
									ZombieDamagedByHumanEvent customEvent = new ZombieDamagedByHumanEvent(zombie, human,
											damage);
									Bukkit.getServer().getPluginManager().callEvent(customEvent);
									if (customEvent.isCancelled()) {
										event.setCancelled(true);
									}
								}
							}

						}
					} else {
						if (DController.getHumanList().contains(player)) {
							Player human = player;
							damage = damage;
							HumanDamagedEvent customEvent = new HumanDamagedEvent(human, damage);
							Bukkit.getServer().getPluginManager().callEvent(customEvent);
							if (customEvent.isCancelled()) {
								event.setCancelled(true);
							}
						} else if (DController.getZombieList().contains(player)) {
							Player zombie = player;
							damage = damage;
							ZombieDamagedEvent customEvent = new ZombieDamagedEvent(zombie, damage);
							Bukkit.getServer().getPluginManager().callEvent(customEvent);
							if (customEvent.isCancelled()) {
								event.setCancelled(true);
							}
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void InventoryClickEvent(org.bukkit.event.inventory.InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		if (DController.getPlayerList().contains(player)) {
			if (DController.getGameProgress() == 2 || DController.getGameProgress() == 3) {
				if (event.getSlot() == 39) {
					if (DController.isFixedHelmet()) {
						event.setCancelled(true);
					}
				} else if (event.getSlot() == 38) {
					if (DController.isFixedChestplate()) {
						event.setCancelled(true);
					}
				} else if (event.getSlot() == 37) {
					if (DController.isFixedLeggings()) {
						event.setCancelled(true);
					}
				} else if (event.getSlot() == 36) {
					if (DController.isFixedBoots()) {
						event.setCancelled(true);
					}
				}
			}
		}
	}

	@EventHandler
	public void InventoryCreativeEvent(org.bukkit.event.inventory.InventoryCreativeEvent event) {
		Player player = (Player) event.getWhoClicked();
		if (DController.getPlayerList().contains(player)) {
			if (DController.getGameProgress() == 2 || DController.getGameProgress() == 3) {
				if (event.getSlot() == 39) {
					if (DController.isFixedHelmet()) {
						event.setCancelled(true);
					}
				} else if (event.getSlot() == 38) {
					if (DController.isFixedChestplate()) {
						event.setCancelled(true);
					}
				} else if (event.getSlot() == 37) {
					if (DController.isFixedLeggings()) {
						event.setCancelled(true);
					}
				} else if (event.getSlot() == 36) {
					if (DController.isFixedBoots()) {
						event.setCancelled(true);
					}
				}
			}
		}
	}

	@EventHandler
	public void PlayerSwapHandItemsEvent(org.bukkit.event.player.PlayerSwapHandItemsEvent event) {
		Player player = event.getPlayer();
		if (DController.getPlayerList().contains(player)) {
			if (DController.getDefaultSetting()) {
				if (DController.getGameProgress() == 2) {
					event.setCancelled(true);
				} else if (DController.getGameProgress() == 3) {
					event.setCancelled(true);
				}
			}
		}
	}

	@EventHandler
	public void PlayerDropItemEvent(org.bukkit.event.player.PlayerDropItemEvent event) {
		Player player = event.getPlayer();
		if (DController.getPlayerList().contains(player)) {
			if (DController.getDefaultSetting()) {
				if (DController.getGameProgress() == 2) {
					event.setCancelled(true);
				} else if (DController.getGameProgress() == 3) {
					event.setCancelled(true);
				}
			}
		}
	}

	@EventHandler
	public void FoodLevelChangeEvent(org.bukkit.event.entity.FoodLevelChangeEvent event) {
		Player player = (Player) event.getEntity();
		if (DController.getPlayerList().contains(player)) {
			if (DController.getDefaultSetting()) {
				if (DController.getGameProgress() == 2 || DController.getGameProgress() == 3) {
					if (DController.isFixedFoodLevel()) {
						event.setCancelled(true);
					}
				}
			}
		}
	}

	@EventHandler
	public void PlayerItemDamageEvent(org.bukkit.event.player.PlayerItemDamageEvent event) {
		Player player = event.getPlayer();
		if (DController.getPlayerList().contains(player)) {
			if (DController.getDefaultSetting()) {
				if (DController.getGameProgress() == 2 || DController.getGameProgress() == 3) {
					if (DController.isFixedDurability()) {
						event.setCancelled(true);
					}
				}
			}
		}
	}

}
