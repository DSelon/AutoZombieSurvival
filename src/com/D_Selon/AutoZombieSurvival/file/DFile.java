package com.D_Selon.AutoZombieSurvival.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import com.D_Selon.AutoZombieSurvival.DMain;
import com.D_Selon.AutoZombieSurvival.controller.DController;

public class DFile {

	private static DMain plugin;

	public static void setPlugin(DMain mainPlugin) {
		plugin = mainPlugin;
	}

	private static File file;
	private static YamlConfiguration yaml;

	public static void setVar() {
		file = new File(plugin.getDataFolder().getPath(), "data.yml");
		yaml = YamlConfiguration.loadConfiguration(file);
	}

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

	public static File getFile() {
		return file;
	}

	public static void setFile(File file) {
		DFile.file = file;
	}

	public static YamlConfiguration getYaml() {
		return yaml;
	}

	public static void setYaml(YamlConfiguration yaml) {
		DFile.yaml = yaml;
	}

	public static String getDefaultCommand() {
		return defaultCommand;
	}

	public static void setDefaultCommand(String defaultCommand) {
		DFile.defaultCommand = defaultCommand;
	}

	public static String getHeroCommand() {
		return heroCommand;
	}

	public static void setHeroCommand(String heroCommand) {
		DFile.heroCommand = heroCommand;
	}

	public static String getHostCommand() {
		return hostCommand;
	}

	public static void setHostCommand(String hostCommand) {
		DFile.hostCommand = hostCommand;
	}

	public static String getHumanCommand() {
		return humanCommand;
	}

	public static void setHumanCommand(String humanCommand) {
		DFile.humanCommand = humanCommand;
	}

	public static String getZombieCommand() {
		return zombieCommand;
	}

	public static void setZombieCommand(String zombieCommand) {
		DFile.zombieCommand = zombieCommand;
	}

	public static String getWinCommand() {
		return winCommand;
	}

	public static void setWinCommand(String winCommand) {
		DFile.winCommand = winCommand;
	}

	public static String getLoseCommand() {
		return loseCommand;
	}

	public static void setLoseCommand(String loseCommand) {
		DFile.loseCommand = loseCommand;
	}

	public static String getKillCommand() {
		return killCommand;
	}

	public static void setKillCommand(String killCommand) {
		DFile.killCommand = killCommand;
	}

	public static String getDeathCommand() {
		return deathCommand;
	}

	public static void setDeathCommand(String deathCommand) {
		DFile.deathCommand = deathCommand;
	}

	public static Location getLobbyLocation() {
		return lobbyLocation;
	}

	public static void setLobbyLocation(Location lobbyLocation) {
		DFile.lobbyLocation = lobbyLocation;
	}

	public static ArrayList<String> getMapNameList() {
		return mapNameList;
	}

	public static void setMapNameList(ArrayList<String> mapNameList) {
		DFile.mapNameList = mapNameList;
	}

	public static ArrayList<Location> getMapLocationList() {
		return mapLocationList;
	}

	public static void setMapLocationList(ArrayList<Location> mapLocationList) {
		DFile.mapLocationList = mapLocationList;
	}

	public static void createFile() {
		if (!file.exists() || !file.isFile()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			yaml.addDefault("DefaultCommand", "");
			yaml.addDefault("HeroCommand", "");
			yaml.addDefault("HostCommand", "");
			yaml.addDefault("HumanCommand", "");
			yaml.addDefault("ZombieCommand", "");
			yaml.addDefault("WinCommand", "");
			yaml.addDefault("LoseCommand", "");
			yaml.addDefault("KillCommand", "");
			yaml.addDefault("DeathCommand", "");
			yaml.addDefault("LobbyLocation",
					new Location(Bukkit.getWorld("world"), Double.parseDouble("0.5"), Double.parseDouble("65.0"),
							Double.parseDouble("0.5"), Float.parseFloat("0.0"), Float.parseFloat("0.0")));
			yaml.addDefault("MapNameList", new ArrayList<String>());
			yaml.addDefault("MapLocationList", new ArrayList<Location>());
			yaml.options().copyDefaults(true);
		}
	}

	public static void saveFile() {
		yaml.set("DefaultCommand", DController.getDefaultCommand());
		yaml.set("HeroCommand", DController.getHeroCommand());
		yaml.set("HostCommand", DController.getHostCommand());
		yaml.set("HumanCommand", DController.getHumanCommand());
		yaml.set("ZombieCommand", DController.getZombieCommand());
		yaml.set("WinCommand", DController.getWinCommand());
		yaml.set("LoseCommand", DController.getLoseCommand());
		yaml.set("KillCommand", DController.getKillCommand());
		yaml.set("DeathCommand", DController.getDeathCommand());
		yaml.set("LobbyLocation", DController.getLobbyLocation());
		yaml.set("MapNameList", DController.getMapNameList());
		yaml.set("MapLocationList", DController.getMapLocationList());
		try {
			yaml.save(file);
		} catch (IOException e) {
		}
	}

	public static void loadFile() {
		try {
			yaml.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
		defaultCommand = yaml.getString("DefaultCommand");
		heroCommand = yaml.getString("HeroCommand");
		hostCommand = yaml.getString("HostCommand");
		humanCommand = yaml.getString("HumanCommand");
		zombieCommand = yaml.getString("ZombieCommand");
		winCommand = yaml.getString("WinCommand");
		loseCommand = yaml.getString("LoseCommand");
		killCommand = yaml.getString("KillCommand");
		deathCommand = yaml.getString("DeathCommand");
		lobbyLocation = (Location) yaml.get("LobbyLocation");
		mapNameList = (ArrayList<String>)yaml.get("MapNameList");
		mapLocationList = (ArrayList<Location>)yaml.get("MapLocationList");
	}

}
