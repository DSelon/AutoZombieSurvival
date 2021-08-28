package com.D_Selon.AutoZombieSurvival.controller;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import com.D_Selon.AutoZombieSurvival.DMain;
import com.D_Selon.AutoZombieSurvival.event.customEvent.TimerEvent;
import com.D_Selon.AutoZombieSurvival.file.DConfig;
import com.D_Selon.AutoZombieSurvival.file.DFile;

import io.papermc.lib.PaperLib;

public class DController {

	public static DMain plugin;

	public static void setPlugin(DMain mainPlugin) {
		plugin = mainPlugin;
	}

	private static String serverTitle;
	private static String borderColor;
	private static Boolean autoProgress;
	private static Boolean defaultSetting;
	private static int restTime;
	private static int readyTime;
	private static int roundTime;
	private static int roundCount;
	private static int heroCount_Start;
	private static int heroCount_Gap;
	private static int hostCount_Start;
	private static int hostCount_Gap;
	private static boolean setHead;
	private static boolean fixedHelmet;
	private static boolean fixedChestplate;
	private static boolean fixedLeggings;
	private static boolean fixedBoots;
	private static boolean fixedFoodLevel;
	private static boolean fixedDurability;

	private static String defaultCommand;
	private static String heroCommand;
	private static String hostCommand;
	private static String humanCommand;
	private static String zombieCommand;
	private static String winCommand;
	private static String loseCommand;
	private static String killCommand;
	private static String deathCommand;
	private static Location lobbyLocation;
	private static ArrayList<String> mapNameList;
	private static ArrayList<Location> mapLocationList;

	private static boolean automatic = false;
	private static int gameProgress = 0;
	private static int restTask;
	private static int readyTask;
	private static int roundTask;
	private static int nowRound = 0;
	private static int mapNumber = 0;
	private static String mapName = "";
	private static List<String> mapArray = new ArrayList<String>();
	private static List<Player> playerList = new ArrayList<Player>();
	private static List<Player> heroList = new ArrayList<Player>();
	private static List<Player> hostList = new ArrayList<Player>();
	private static List<Player> humanList = new ArrayList<Player>();
	private static List<Player> zombieList = new ArrayList<Player>();
	private static ScoreboardManager manager = Bukkit.getScoreboardManager();
	private static Scoreboard board = manager.getMainScoreboard();
	private static Team humanTeam;
	private static Team zombieTeam;

	public static String getServerTitle() {
		return serverTitle;
	}

	public static void setServerTitle(String serverTitle) {
		DController.serverTitle = serverTitle;
	}

	public static String getBorderColor() {
		return borderColor;
	}

	public static void setBorderColor(String borderColor) {
		DController.borderColor = borderColor;
	}

	public static Boolean getAutoProgress() {
		return autoProgress;
	}

	public static void setAutoProgress(Boolean autoProgress) {
		DController.autoProgress = autoProgress;
	}

	public static Boolean getDefaultSetting() {
		return defaultSetting;
	}

	public static void setDefaultSetting(Boolean defaultSetting) {
		DController.defaultSetting = defaultSetting;
	}

	public static int getRestTime() {
		return restTime;
	}

	public static void setRestTime(int restTime) {
		DController.restTime = restTime;
	}

	public static int getReadyTime() {
		return readyTime;
	}

	public static void setReadyTime(int readyTime) {
		DController.readyTime = readyTime;
	}

	public static int getRoundTime() {
		return roundTime;
	}

	public static void setRoundTime(int roundTime) {
		DController.roundTime = roundTime;
	}

	public static int getRoundCount() {
		return roundCount;
	}

	public static void setRoundCount(int roundCount) {
		DController.roundCount = roundCount;
	}

	public static int getHeroCount_Start() {
		return heroCount_Start;
	}

	public static void setHeroCount_Start(int heroCount_Start) {
		DController.heroCount_Start = heroCount_Start;
	}

	public static int getHeroCount_Gap() {
		return heroCount_Gap;
	}

	public static void setHeroCount_Gap(int heroCount_Gap) {
		DController.heroCount_Gap = heroCount_Gap;
	}

	public static int getHostCount_Start() {
		return hostCount_Start;
	}

	public static void setHostCount_Start(int hostCount_Start) {
		DController.hostCount_Start = hostCount_Start;
	}

	public static int getHostCount_Gap() {
		return hostCount_Gap;
	}

	public static void setHostCount_Gap(int hostCount_Gap) {
		DController.hostCount_Gap = hostCount_Gap;
	}

	public static boolean isSetHead() {
		return setHead;
	}

	public static void setSetHead(boolean setHead) {
		DController.setHead = setHead;
	}

	public static boolean isFixedHelmet() {
		return fixedHelmet;
	}

	public static void setFixedHelmet(boolean fixedHelmet) {
		DController.fixedHelmet = fixedHelmet;
	}

	public static boolean isFixedChestplate() {
		return fixedChestplate;
	}

	public static void setFixedChestplate(boolean fixedChestplate) {
		DController.fixedChestplate = fixedChestplate;
	}

	public static boolean isFixedLeggings() {
		return fixedLeggings;
	}

	public static void setFixedLeggings(boolean fixedLeggings) {
		DController.fixedLeggings = fixedLeggings;
	}

	public static boolean isFixedBoots() {
		return fixedBoots;
	}

	public static void setFixedBoots(boolean fixedBoots) {
		DController.fixedBoots = fixedBoots;
	}

	public static boolean isFixedFoodLevel() {
		return fixedFoodLevel;
	}

	public static void setFixedFoodLevel(boolean fixedFoodLevel) {
		DController.fixedFoodLevel = fixedFoodLevel;
	}

	public static boolean isFixedDurability() {
		return fixedDurability;
	}

	public static void setFixedDurability(boolean fixedDurability) {
		DController.fixedDurability = fixedDurability;
	}

	public static String getDefaultCommand() {
		return defaultCommand;
	}

	public static void setDefaultCommand(String defaultCommand) {
		DController.defaultCommand = defaultCommand;
	}

	public static String getHeroCommand() {
		return heroCommand;
	}

	public static void setHeroCommand(String heroCommand) {
		DController.heroCommand = heroCommand;
	}

	public static String getHostCommand() {
		return hostCommand;
	}

	public static void setHostCommand(String hostCommand) {
		DController.hostCommand = hostCommand;
	}

	public static String getHumanCommand() {
		return humanCommand;
	}

	public static void setHumanCommand(String humanCommand) {
		DController.humanCommand = humanCommand;
	}

	public static String getZombieCommand() {
		return zombieCommand;
	}

	public static void setZombieCommand(String zombieCommand) {
		DController.zombieCommand = zombieCommand;
	}

	public static String getWinCommand() {
		return winCommand;
	}

	public static void setWinCommand(String winCommand) {
		DController.winCommand = winCommand;
	}

	public static String getLoseCommand() {
		return loseCommand;
	}

	public static void setLoseCommand(String loseCommand) {
		DController.loseCommand = loseCommand;
	}

	public static String getKillCommand() {
		return killCommand;
	}

	public static void setKillCommand(String killCommand) {
		DController.killCommand = killCommand;
	}

	public static String getDeathCommand() {
		return deathCommand;
	}

	public static void setDeathCommand(String deathCommand) {
		DController.deathCommand = deathCommand;
	}

	public static Location getLobbyLocation() {
		return lobbyLocation;
	}

	public static void setLobbyLocation(Location lobbyLocation) {
		DController.lobbyLocation = lobbyLocation;
	}

	public static ArrayList<String> getMapNameList() {
		return mapNameList;
	}

	public static void setMapNameList(ArrayList<String> mapNameList) {
		DController.mapNameList = mapNameList;
	}

	public static ArrayList<Location> getMapLocationList() {
		return mapLocationList;
	}

	public static void setMapLocationList(ArrayList<Location> mapLocationList) {
		DController.mapLocationList = mapLocationList;
	}

	public static boolean isAutomatic() {
		return automatic;
	}

	public static void setAutomatic(boolean automatic) {
		DController.automatic = automatic;
	}

	public static int getGameProgress() {
		return gameProgress;
	}

	public static void setGameProgress(int gameProgress) {
		DController.gameProgress = gameProgress;
	}

	public static int getRestTask() {
		return restTask;
	}

	public static void setRestTask(int restTask) {
		DController.restTask = restTask;
	}

	public static int getReadyTask() {
		return readyTask;
	}

	public static void setReadyTask(int readyTask) {
		DController.readyTask = readyTask;
	}

	public static int getRoundTask() {
		return roundTask;
	}

	public static void setRoundTask(int roundTask) {
		DController.roundTask = roundTask;
	}

	public static int getNowRound() {
		return nowRound;
	}

	public static void setNowRound(int nowRound) {
		DController.nowRound = nowRound;
	}

	public static int getMapNumber() {
		return mapNumber;
	}

	public static void setMapNumber(int mapNumber) {
		DController.mapNumber = mapNumber;
	}

	public static String getMapName() {
		return mapName;
	}

	public static void setMapName(String mapName) {
		DController.mapName = mapName;
	}

	public static List<String> getMapArray() {
		return mapArray;
	}

	public static void setMapArray(List<String> mapArray) {
		DController.mapArray = mapArray;
	}

	public static List<Player> getPlayerList() {
		return playerList;
	}

	public static void setPlayerList(List<Player> playerList) {
		DController.playerList = playerList;
	}

	public static List<Player> getHeroList() {
		return heroList;
	}

	public static void setHeroList(List<Player> heroList) {
		DController.heroList = heroList;
	}

	public static List<Player> getHostList() {
		return hostList;
	}

	public static void setHostList(List<Player> hostList) {
		DController.hostList = hostList;
	}

	public static List<Player> getHumanList() {
		return humanList;
	}

	public static void setHumanList(List<Player> humanList) {
		DController.humanList = humanList;
	}

	public static List<Player> getZombieList() {
		return zombieList;
	}

	public static void setZombieList(List<Player> zombieList) {
		DController.zombieList = zombieList;
	}

	public static ScoreboardManager getManager() {
		return manager;
	}

	public static void setManager(ScoreboardManager manager) {
		DController.manager = manager;
	}

	public static Scoreboard getBoard() {
		return board;
	}

	public static void setBoard(Scoreboard board) {
		DController.board = board;
	}

	public static Team getHumanTeam() {
		return humanTeam;
	}

	public static void setHumanTeam(Team humanTeam) {
		DController.humanTeam = humanTeam;
	}

	public static Team getZombieTeam() {
		return zombieTeam;
	}

	public static void setZombieTeam(Team zombieTeam) {
		DController.zombieTeam = zombieTeam;
	}

	public static void loadVar() {
		serverTitle = DConfig.getServerTitle();
		borderColor = DConfig.getBorderColor();
		autoProgress = DConfig.getAutoProgress();
		defaultSetting = DConfig.getDefaultSetting();
		restTime = DConfig.getRestTime();
		readyTime = DConfig.getReadyTime();
		roundTime = DConfig.getRoundTime();
		roundCount = DConfig.getRoundCount();
		heroCount_Start = DConfig.getHeroCount_Start();
		heroCount_Gap = DConfig.getHeroCount_Gap();
		hostCount_Start = DConfig.getHostCount_Start();
		hostCount_Gap = DConfig.getHostCount_Gap();
		setHead = DConfig.isSetHead();
		fixedHelmet = DConfig.isFixedHelmet();
		fixedChestplate = DConfig.isFixedChestplate();
		fixedLeggings = DConfig.isFixedLeggings();
		fixedBoots = DConfig.isFixedBoots();
		fixedFoodLevel = DConfig.isFixedFoodLevel();
		fixedDurability = DConfig.isFixedDurability();

		defaultCommand = DFile.getDefaultCommand();
		heroCommand = DFile.getHeroCommand();
		hostCommand = DFile.getHostCommand();
		humanCommand = DFile.getHumanCommand();
		zombieCommand = DFile.getZombieCommand();
		winCommand = DFile.getWinCommand();
		loseCommand = DFile.getLoseCommand();
		killCommand = DFile.getKillCommand();
		deathCommand = DFile.getDeathCommand();
		lobbyLocation = DFile.getLobbyLocation();
		mapNameList = DFile.getMapNameList();
		mapLocationList = DFile.getMapLocationList();
	}

	public static boolean gameStart() {
		if (automatic) {
			return false;
		} else {
			automatic = true;
			restTask();
			return true;
		}
	}

	public static boolean gameStop() {
		if (automatic) {
			automatic = false;
			return true;
		} else {
			return false;
		}
	}

	public static void setLobby(Location location) {
		lobbyLocation = location;
	}

	public static void mapListInit() {
		mapNameList.clear();
		mapLocationList.clear();
	}

	public static boolean addMap(String mapName, Location mapLocation) {
		if (mapNameList.contains(mapName)) {
			return false;
		} else {
			mapNameList.add(mapName);
			mapLocationList.add(mapLocation);
			return true;
		}
	}

	public static boolean removeMap(String mapName) {
		if (mapNameList.contains(mapName)) {
			int index = mapNameList.indexOf(mapName);
			mapNameList.remove(index);
			mapLocationList.remove(index);
			return true;
		} else {
			return false;
		}
	}

	public static void playerListInit() {
		if (gameProgress == 2) {
			for (Player player : playerList) {
				defaultConversion(player);
				moveLobby(player);
			}
			humanList.clear();
			humanTeam.unregister();
		} else if (gameProgress == 3) {
			for (Player player : playerList) {
				defaultConversion(player);
				moveLobby(player);
			}
			heroList.clear();
			hostList.clear();
			humanList.clear();
			zombieList.clear();
			humanTeam.unregister();
			zombieTeam.unregister();
		} else if (gameProgress == 4) {
			for (Player player : playerList) {
				moveLobby(player);
			}
		}
		playerList.clear();
	}

	public static boolean addPlayer(Player player) {
		if (playerList.contains(player)) {
			return false;
		} else {
			playerList.add(player);
			if (gameProgress == 2) {
				humanConversion(player);
				humanList.add(player);
				humanTeam.addEntry(player.getName());
				moveMap(player);
			} else if (gameProgress == 3) {
				zombieConversion(player);
				zombieList.add(player);
				zombieTeam.addEntry(player.getName());
				moveMap(player);
			}
			return true;
		}
	}

	public static boolean removePlayer(Player player) {
		if (playerList.contains(player)) {
			playerList.remove(player);
			if (gameProgress == 2) {
				defaultConversion(player);
				humanList.remove(player);
				humanTeam.removeEntry(player.getName());
				moveLobby(player);
			} else if (gameProgress == 3) {
				defaultConversion(player);
				if (humanList.contains(player)) {
					if (heroList.contains(player)) {
						heroList.remove(player);
					}
					humanList.remove(player);
				} else if (zombieList.contains(player)) {
					if (hostList.contains(player)) {
						hostList.remove(player);
					}
					zombieList.remove(player);
					zombieTeam.removeEntry(player.getName());
				}
				moveLobby(player);
			} else if (gameProgress == 4) {
				moveLobby(player);
			}
			return true;
		} else {
			return false;
		}
	}

	public static void moveLobby(Player player) {
		PaperLib.teleportAsync(player, lobbyLocation);
	}

	public static void moveMap(Player player) {
		PaperLib.teleportAsync(player, mapLocationList.get(mapNumber));
	}

	public static void respawnToLobby(org.bukkit.event.player.PlayerRespawnEvent event) {
		event.setRespawnLocation(lobbyLocation);
	}

	public static void respawnToMap(org.bukkit.event.player.PlayerRespawnEvent event) {
		event.setRespawnLocation(mapLocationList.get(mapNumber));
	}

	public static void defaultConversion(Player player) {
		if (!defaultCommand.equals("")) {
			if (player.isOp()) {
				Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
					Bukkit.dispatchCommand(player, defaultCommand);
				});
			} else {
				Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
					player.setOp(true);
					Bukkit.dispatchCommand(player, defaultCommand);
					player.setOp(false);
				});
			}
		}
		if (defaultSetting) {
			for (PotionEffect effect : player.getActivePotionEffects()) {
				player.removePotionEffect(effect.getType());
			}
			player.setFoodLevel(20);
			player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
			player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
			player.setExp(0);
			player.setLevel(0);
			for (int i = 0; i < 41; i++) {
				player.getInventory().setItem(i, new ItemStack(Material.AIR));
			}
		}
	}

	public static void heroConversion(Player player) {
		if (!heroCommand.equals("")) {
			if (player.isOp()) {
				Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
					Bukkit.dispatchCommand(player, heroCommand);
				});
			} else {
				Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
					player.setOp(true);
					Bukkit.dispatchCommand(player, heroCommand);
					player.setOp(false);
				});
			}
		}
		if (defaultSetting) {
			for (PotionEffect effect : player.getActivePotionEffects()) {
				player.removePotionEffect(effect.getType());
			}
			player.setFoodLevel(20);
			player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(24);
			player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
			player.setExp(0);
			player.setLevel(0);
			player.getInventory().setHelmet(new ItemStack(Material.AIR));
			player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
			player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
			player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
			player.getInventory().setItem(0, new ItemStack(Material.DIAMOND_SWORD));
			player.getInventory().setItem(1, new ItemStack(Material.BOW));
			player.getInventory().setItem(2, new ItemStack(Material.ARROW, 64));
			for (int i = 3; i < 36; i++) {
				player.getInventory().setItem(i, new ItemStack(Material.AIR));
			}
			player.getInventory().setItem(40, new ItemStack(Material.AIR));
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, roundTime * 20, 0));
		}
	}

	public static void hostConversion(Player player) {
		if (!hostCommand.equals("")) {
			if (player.isOp()) {
				Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
					Bukkit.dispatchCommand(player, hostCommand);
				});
			} else {
				Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
					player.setOp(true);
					Bukkit.dispatchCommand(player, hostCommand);
					player.setOp(false);
				});
			}
		}
		if (setHead) {
			player.getInventory().setHelmet(new ItemStack(Material.JACK_O_LANTERN));
		}
		if (defaultSetting) {
			for (PotionEffect effect : player.getActivePotionEffects()) {
				player.removePotionEffect(effect.getType());
			}
			player.setFoodLevel(20);
			player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40);
			player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
			player.setExp(0);
			player.setLevel(0);
			player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
			player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
			player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
			player.getInventory().setItem(0, new ItemStack(Material.DIAMOND_SWORD));
			for (int i = 1; i < 36; i++) {
				player.getInventory().setItem(i, new ItemStack(Material.AIR));
			}
			player.getInventory().setItem(40, new ItemStack(Material.AIR));
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, roundTime * 20, 0));
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, roundTime * 20, 1));
		}
	}

	public static void humanConversion(Player player) {
		if (!humanCommand.equals("")) {
			if (player.isOp()) {
				Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
					Bukkit.dispatchCommand(player, humanCommand);
				});
			} else {
				Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
					player.setOp(true);
					Bukkit.dispatchCommand(player, humanCommand);
					player.setOp(false);
				});
			}
		}
		if (defaultSetting) {
			for (PotionEffect effect : player.getActivePotionEffects()) {
				player.removePotionEffect(effect.getType());
			}
			player.setFoodLevel(20);
			player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
			player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
			player.setExp(0);
			player.setLevel(0);
			player.getInventory().setHelmet(new ItemStack(Material.AIR));
			player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
			player.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
			player.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
			player.getInventory().setItem(0, new ItemStack(Material.IRON_SWORD));
			player.getInventory().setItem(1, new ItemStack(Material.BOW));
			player.getInventory().setItem(2, new ItemStack(Material.ARROW, 32));
			for (int i = 3; i < 36; i++) {
				player.getInventory().setItem(i, new ItemStack(Material.AIR));
			}
			player.getInventory().setItem(40, new ItemStack(Material.AIR));
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, roundTime * 20, 0));
		}
	}

	public static void zombieConversion(Player player) {
		if (!zombieCommand.equals("")) {
			if (player.isOp()) {
				Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
					Bukkit.dispatchCommand(player, zombieCommand);
				});
			} else {
				Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
					player.setOp(true);
					Bukkit.dispatchCommand(player, zombieCommand);
					player.setOp(false);
				});
			}
		}
		if (setHead) {
			player.getInventory().setHelmet(new ItemStack(Material.JACK_O_LANTERN));
		}
		if (defaultSetting) {
			for (PotionEffect effect : player.getActivePotionEffects()) {
				player.removePotionEffect(effect.getType());
			}
			player.setFoodLevel(20);
			player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40);
			player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
			player.setExp(0);
			player.setLevel(0);
			player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
			player.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
			player.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
			player.getInventory().setItem(0, new ItemStack(Material.DIAMOND_SWORD));
			for (int i = 1; i < 36; i++) {
				player.getInventory().setItem(i, new ItemStack(Material.AIR));
			}
			player.getInventory().setItem(40, new ItemStack(Material.AIR));
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, roundTime * 20, 0));
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, roundTime * 20, 1));
		}
	}

	public static void winExecute(Player player) {
		if (!winCommand.equals("")) {
			if (player.isOp()) {
				Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
					Bukkit.dispatchCommand(player, winCommand);
				});
			} else {
				Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
					player.setOp(true);
					Bukkit.dispatchCommand(player, winCommand);
					player.setOp(false);
				});
			}
		}
	}

	public static void loseExecute(Player player) {
		if (!loseCommand.equals("")) {
			if (player.isOp()) {
				Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
					Bukkit.dispatchCommand(player, loseCommand);
				});
			} else {
				Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
					player.setOp(true);
					Bukkit.dispatchCommand(player, loseCommand);
					player.setOp(false);
				});
			}
		}
	}

	public static void killExecute(Player player) {
		if (!killCommand.equals("")) {
			if (player.isOp()) {
				Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
					Bukkit.dispatchCommand(player, killCommand);
				});
			} else {
				Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
					player.setOp(true);
					Bukkit.dispatchCommand(player, killCommand);
					player.setOp(false);
				});
			}
		}
	}

	public static void deathExecute(Player player) {
		if (!deathCommand.equals("")) {
			if (player.isOp()) {
				Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
					Bukkit.dispatchCommand(player, deathCommand);
				});
			} else {
				Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
					player.setOp(true);
					Bukkit.dispatchCommand(player, deathCommand);
					player.setOp(false);
				});
			}
		}
	}

	private static void restTask() {

		String serverName = borderColor + "[ " + serverTitle + " " + borderColor + "]";

		gameProgress = 1;

		restTask = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

			int timer = restTime + 1;

			@Override
			public void run() {

				// 강제 중지
				if (!automatic) {
					gameProgress = 0;
					Bukkit.getScheduler().cancelTask(restTask);
					return;
				}

				if (timer == 0) {

					// 인원 검사
					if (playerList.size() < 2) {
						for (Player player : playerList) {
							player.sendMessage(serverName + " §f§l플레이어 인원이 부족하여 타이머를 다시 되돌립니다.");
						}
						Bukkit.getScheduler().cancelTask(restTask);
						restTask();
						return;
					}

					// 맵 선정
					if (mapArray.size() >= mapNameList.size()) {
						mapArray.clear();
					}
					for (int i = 0; i < 1000; i++) {
						int r = (int) (Math.random() * mapNameList.size());
						if (mapArray.contains(mapNameList.get(r))) {
							continue;
						}
						mapNumber = r;
						mapName = mapNameList.get(r);
						mapArray.add(mapNameList.get(r));
					}

					Bukkit.getScheduler().cancelTask(restTask);
					readyTask();
					return;
				}

				// 타이머
				if (timer % 10 == 0 || timer <= 5) {
					int time = timer;
					String timerMessage = serverName + " §f§l게임 시작까지 §c§l" + time + "초 §f§l남았습니다.";
					TimerEvent customEvent = new TimerEvent(time, timerMessage);
					Bukkit.getServer().getPluginManager().callEvent(customEvent);
					if (!customEvent.getTimerMessage().equals("")) {
						for (Player player : playerList) {
							player.sendMessage(customEvent.getTimerMessage());
						}
					}
				} else {
					int time = timer;
					TimerEvent customEvent = new TimerEvent(time);
					Bukkit.getServer().getPluginManager().callEvent(customEvent);
				}

				timer--;

			}

		}, 0L, 20L);

	}

	private static void readyTask() {

		String serverName = borderColor + "[ " + serverTitle + " " + borderColor + "]";

		nowRound++;

		// 라운드 검사
		if (nowRound > roundCount) {

			// 로비 이동
			for (Player player : playerList) {
				moveLobby(player);
			}

			nowRound = 0;
			restTask();
			return;

		}

		readyTask = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

			int timer = readyTime + 1;

			@Override
			public void run() {

				// 강제 중지
				if (!automatic) {

					// 세팅 초기화
					for (Player player : playerList) {
						defaultConversion(player);
					}

					// 로비 이동
					for (Player player : playerList) {
						moveLobby(player);
					}

					humanList.clear();
					humanTeam.unregister();

					gameProgress = 0;
					nowRound = 0;
					Bukkit.getScheduler().cancelTask(readyTask);
					return;
				}

				if (timer == readyTime + 1) {

					gameProgress = 2;

					// 팀 설정
					if (board.getTeam("HumanTeam") != null) {
						humanTeam = board.getTeam("HumanTeam");
					} else {
						humanTeam = board.registerNewTeam("HumanTeam");
					}
					humanTeam.setAllowFriendlyFire(false);
					humanTeam.setCanSeeFriendlyInvisibles(true);
					humanTeam.setOption(Team.Option.COLLISION_RULE, Team.OptionStatus.ALWAYS);
					humanTeam.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.ALWAYS);
					if (board.getTeam("ZombieTeam") != null) {
						zombieTeam = board.getTeam("ZombieTeam");
					} else {
						zombieTeam = board.registerNewTeam("ZombieTeam");
					}
					zombieTeam.setAllowFriendlyFire(false);
					zombieTeam.setCanSeeFriendlyInvisibles(true);
					zombieTeam.setOption(Team.Option.COLLISION_RULE, Team.OptionStatus.ALWAYS);
					zombieTeam.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.ALWAYS);

					// 맵 이동
					for (Player player : playerList) {
						moveMap(player);
					}

					// 인간 설정
					for (Player player : playerList) {
						humanConversion(player);
						humanList.add(player);
						humanTeam.addEntry(player.getName());
					}

					for (Player player : playerList) {
						player.sendMessage(serverName + " §b§l◎§f§l----- ----- ----- ----- -----§b§l◎");
						player.sendMessage(serverName + "  §f§l게임이 §e§l시작§f§l되었습니다.");
						player.sendMessage(serverName + "  §f§l이번 라운드는 §7§l" + nowRound + "라운드 §f§l입니다.");
						player.sendMessage(serverName + "  §f§l맵은 §7§l" + mapName.replace("_", " ") + " §f§l입니다.");
						player.sendMessage(serverName + " §b§l◎§f§l----- ----- ----- ----- -----§b§l◎");
					}

				}

				if (timer == 0) {

					Bukkit.getScheduler().cancelTask(readyTask);
					roundTask();
					return;

				}

				// 타이머
				if (timer % 10 == 0 || timer <= 5) {
					int time = timer;
					String timerMessage = serverName + " §4§l숙주 §f§l출현까지 §c§l" + timer + "초 §f§l남았습니다.";
					TimerEvent customEvent = new TimerEvent(time, timerMessage);
					Bukkit.getServer().getPluginManager().callEvent(customEvent);
					if (!customEvent.getTimerMessage().equals("")) {
						for (Player player : playerList) {
							player.sendMessage(customEvent.getTimerMessage());
						}
					}
				} else {
					int time = timer;
					TimerEvent customEvent = new TimerEvent(time);
					Bukkit.getServer().getPluginManager().callEvent(customEvent);
				}

				timer--;

			}

		}, 0L, 20L);

	}

	private static void roundTask() {

		String serverName = borderColor + "[ " + serverTitle + " " + borderColor + "]";

		roundTask = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

			int timer = roundTime + 1;

			@Override
			public void run() {

				// 강제 중지
				if (!automatic) {

					// 세팅 초기화
					for (Player player : playerList) {
						defaultConversion(player);
					}

					// 로비 이동
					for (Player player : playerList) {
						moveLobby(player);
					}

					heroList.clear();
					hostList.clear();
					humanList.clear();
					zombieList.clear();
					humanTeam.unregister();
					zombieTeam.unregister();

					gameProgress = 0;
					nowRound = 0;
					Bukkit.getScheduler().cancelTask(roundTask);
					return;
				}

				if (timer == roundTime + 1) {

					gameProgress = 3;

					// 영웅 및 숙주 선정
					int heroC = 0;
					int hostC = 0;
					if (playerList.size() > 0) {
						if (playerList.size() < heroCount_Start) {
							heroC = 0;
						} else if (playerList.size() >= heroCount_Start) {
							heroC = (playerList.size() - heroCount_Start) / heroCount_Gap + 1;
						}
						if (playerList.size() < hostCount_Start) {
							hostC = 1;
						} else if (playerList.size() >= hostCount_Start) {
							hostC = (playerList.size() - hostCount_Start) / hostCount_Gap + 2;
						}
					}
					List<Integer> heroN = new ArrayList<Integer>();
					List<Integer> hostN = new ArrayList<Integer>();
					for (int n = 0, c = 0; n < heroC && c < 100; n++, c++) {
						int r = (int) (Math.random() * playerList.size());
						if (heroN.contains(r) || hostN.contains(r)) {
							n--;
							continue;
						}
						heroN.add(r);
					}
					for (int n = 0, c = 0; n < hostC && c < 100; n++, c++) {
						int r = (int) (Math.random() * playerList.size());
						if (heroN.contains(r) || hostN.contains(r)) {
							n--;
							continue;
						}
						hostN.add(r);
					}

					// 영웅 및 숙주 설정
					for (int n : heroN) {
						Player player = playerList.get(n);
						heroConversion(player);
						heroList.add(player);
					}
					for (int n : hostN) {
						Player player = playerList.get(n);
						humanList.remove(player);
						humanTeam.removeEntry(player.getName());
						hostConversion(player);
						hostList.add(player);
						zombieList.add(player);
						zombieTeam.addEntry(player.getName());
					}

					for (Player player : playerList) {
						player.sendMessage(serverName + " §4§l숙주§f§l가 출현하였습니다.§c§l");
					}

				}

				if (timer >= 0) {

					if (humanList.isEmpty()) {

						gameProgress = 4;

						// 좀비 승리
						for (Player player : playerList) {
							player.sendMessage(serverName + " §b§l◎§f§l----- ----- ----- ----- -----§b§l◎");
							player.sendMessage(serverName + "  §f§l게임이 §e§l종료§f§l되었습니다.");
							player.sendMessage(serverName + "  §f§l모든 인간이 감염되었습니다.");
							player.sendMessage(serverName + "  §c§l좀비 §f§l팀이 승리하였습니다.");
							player.sendMessage(serverName + " §b§l◎§f§l----- ----- ----- ----- -----§b§l◎");
						}
						for (Player player : playerList) {
							defaultConversion(player);
						}
						for (Player player : hostList) {
							winExecute(player);
						}
						for (Player player : zombieList) {
							if (hostList.contains(player)) {
								continue;
							}
							loseExecute(player);
						}
						for (Player player : humanList) {
							loseExecute(player);
						}
						heroList.clear();
						hostList.clear();
						humanList.clear();
						zombieList.clear();
						humanTeam.unregister();
						zombieTeam.unregister();

						timer = -5;

					} else if (zombieList.isEmpty() || timer == 0) {

						gameProgress = 4;

						// 인간 승리
						if (zombieList.isEmpty()) {
							for (Player player : playerList) {
								player.sendMessage(serverName + " §b§l◎§f§l----- ----- ----- ----- -----§b§l◎");
								player.sendMessage(serverName + "  §f§l게임이 §e§l종료§f§l되었습니다.");
								player.sendMessage(serverName + "  §f§l모든 좀비가 사라졌습니다.");
								player.sendMessage(serverName + "  §9§l인간 §f§l팀이 승리하였습니다.");
								player.sendMessage(serverName + " §b§l◎§f§l----- ----- ----- ----- -----§b§l◎");
							}
						} else if (timer == 0) {
							for (Player player : playerList) {
								player.sendMessage(serverName + " §b§l◎§f§l----- ----- ----- ----- -----§b§l◎");
								player.sendMessage(serverName + "  §f§l게임이 §e§l종료§f§l되었습니다.");
								player.sendMessage(serverName + "  §f§l일부 인간이 생존하는데 성공하였습니다.");
								player.sendMessage(serverName + "  §9§l인간 팀§f§l이 승리하였습니다.");
								player.sendMessage(serverName + " §b§l◎§f§l----- ----- ----- ----- -----§b§l◎");
							}
						}
						for (Player player : playerList) {
							defaultConversion(player);
						}
						for (Player player : humanList) {
							winExecute(player);
						}
						for (Player player : zombieList) {
							loseExecute(player);
						}
						heroList.clear();
						hostList.clear();
						humanList.clear();
						zombieList.clear();
						humanTeam.unregister();
						zombieTeam.unregister();

						timer = -5;

					}

				}

				if (timer == -10) {
					gameProgress = 0;
					Bukkit.getScheduler().cancelTask(roundTask);
					readyTask();
					return;
				}

				// 타이머
				if (timer % 60 == 0 || timer == 30 || timer == 10 || (timer <= 5 && timer > 0)) {
					int time = timer;
					String timerMessage = serverName + " §f§l라운드 종료까지 §c§l" + timer + "초 §f§l남았습니다.";
					TimerEvent customEvent = new TimerEvent(time, timerMessage);
					Bukkit.getServer().getPluginManager().callEvent(customEvent);
					if (!customEvent.getTimerMessage().equals("")) {
						for (Player player : playerList) {
							player.sendMessage(customEvent.getTimerMessage());
						}
					}
				} else {
					int time = timer;
					TimerEvent customEvent = new TimerEvent(time);
					Bukkit.getServer().getPluginManager().callEvent(customEvent);
				}

				timer--;

			}

		}, 0L, 20L);

	}

}
