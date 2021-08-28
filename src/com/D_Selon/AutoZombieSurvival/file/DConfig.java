package com.D_Selon.AutoZombieSurvival.file;

import java.io.File;

import com.D_Selon.AutoZombieSurvival.DMain;

public class DConfig {

	public static DMain plugin;

	public static void setPlugin(DMain mainPlugin) {
		plugin = mainPlugin;
	}

	private static File configFile;

	public static void setVar() {
		configFile = new File(plugin.getDataFolder(), "config.yml");
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

	public static String getServerTitle() {
		return serverTitle;
	}

	public static void setServerTitle(String serverTitle) {
		DConfig.serverTitle = serverTitle;
	}

	public static String getBorderColor() {
		return borderColor;
	}

	public static void setBorderColor(String borderColor) {
		DConfig.borderColor = borderColor;
	}

	public static Boolean getAutoProgress() {
		return autoProgress;
	}

	public static void setAutoProgress(Boolean autoProgress) {
		DConfig.autoProgress = autoProgress;
	}

	public static Boolean getDefaultSetting() {
		return defaultSetting;
	}

	public static void setDefaultSetting(Boolean defaultSetting) {
		DConfig.defaultSetting = defaultSetting;
	}

	public static int getRestTime() {
		return restTime;
	}

	public static void setRestTime(int restTime) {
		DConfig.restTime = restTime;
	}

	public static int getReadyTime() {
		return readyTime;
	}

	public static void setReadyTime(int readyTime) {
		DConfig.readyTime = readyTime;
	}

	public static int getRoundTime() {
		return roundTime;
	}

	public static void setRoundTime(int roundTime) {
		DConfig.roundTime = roundTime;
	}

	public static int getRoundCount() {
		return roundCount;
	}

	public static void setRoundCount(int roundCount) {
		DConfig.roundCount = roundCount;
	}

	public static int getHeroCount_Start() {
		return heroCount_Start;
	}

	public static void setHeroCount_Start(int heroCount_Start) {
		DConfig.heroCount_Start = heroCount_Start;
	}

	public static int getHeroCount_Gap() {
		return heroCount_Gap;
	}

	public static void setHeroCount_Gap(int heroCount_Gap) {
		DConfig.heroCount_Gap = heroCount_Gap;
	}

	public static int getHostCount_Start() {
		return hostCount_Start;
	}

	public static void setHostCount_Start(int hostCount_Start) {
		DConfig.hostCount_Start = hostCount_Start;
	}

	public static int getHostCount_Gap() {
		return hostCount_Gap;
	}

	public static void setHostCount_Gap(int hostCount_Gap) {
		DConfig.hostCount_Gap = hostCount_Gap;
	}

	public static boolean isSetHead() {
		return setHead;
	}

	public static void setSetHead(boolean setHead) {
		DConfig.setHead = setHead;
	}

	public static boolean isFixedHelmet() {
		return fixedHelmet;
	}

	public static void setFixedHelmet(boolean fixedHelmet) {
		DConfig.fixedHelmet = fixedHelmet;
	}

	public static boolean isFixedChestplate() {
		return fixedChestplate;
	}

	public static void setFixedChestplate(boolean fixedChestplate) {
		DConfig.fixedChestplate = fixedChestplate;
	}

	public static boolean isFixedLeggings() {
		return fixedLeggings;
	}

	public static void setFixedLeggings(boolean fixedLeggings) {
		DConfig.fixedLeggings = fixedLeggings;
	}

	public static boolean isFixedBoots() {
		return fixedBoots;
	}

	public static void setFixedBoots(boolean fixedBoots) {
		DConfig.fixedBoots = fixedBoots;
	}

	public static boolean isFixedFoodLevel() {
		return fixedFoodLevel;
	}

	public static void setFixedFoodLevel(boolean fixedFoodLevel) {
		DConfig.fixedFoodLevel = fixedFoodLevel;
	}

	public static boolean isFixedDurability() {
		return fixedDurability;
	}

	public static void setFixedDurability(boolean fixedDurability) {
		DConfig.fixedDurability = fixedDurability;
	}

	public static void createConfig() {
		if (configFile.length() == 0) {
			plugin.getConfig().options().copyDefaults(true);
			plugin.saveConfig();
		}
	}

	public static void saveConfig() {
		plugin.saveConfig();
	}

	public static void loadConfig() {
		plugin.reloadConfig();

		serverTitle = plugin.getConfig().getString("ServerTitle");
		borderColor = plugin.getConfig().getString("BorderColor");
		autoProgress = plugin.getConfig().getBoolean("AutoProgress");
		defaultSetting = plugin.getConfig().getBoolean("DefaultSetting");
		restTime = plugin.getConfig().getInt("RestTime");
		readyTime = plugin.getConfig().getInt("ReadyTime");
		roundTime = plugin.getConfig().getInt("RoundTime");
		roundCount = plugin.getConfig().getInt("RoundCount");
		heroCount_Start = plugin.getConfig().getInt("HeroCount.Start");
		heroCount_Gap = plugin.getConfig().getInt("HeroCount.Gap");
		hostCount_Start = plugin.getConfig().getInt("HostCount.Start");
		hostCount_Gap = plugin.getConfig().getInt("HostCount.Gap");
		setHead = plugin.getConfig().getBoolean("SetHead");
		fixedHelmet = plugin.getConfig().getBoolean("FixedHelmet");
		fixedChestplate = plugin.getConfig().getBoolean("FixedChestplate");
		fixedLeggings = plugin.getConfig().getBoolean("FixedLeggings");
		fixedBoots = plugin.getConfig().getBoolean("FixedBoots");
		fixedFoodLevel = plugin.getConfig().getBoolean("FixedFoodLevel");
		fixedDurability = plugin.getConfig().getBoolean("FixedDurability");
	}

}
