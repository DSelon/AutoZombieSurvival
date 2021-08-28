package com.D_Selon.AutoZombieSurvival;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.D_Selon.AutoZombieSurvival.command.DCommand;
import com.D_Selon.AutoZombieSurvival.controller.DController;
import com.D_Selon.AutoZombieSurvival.event.DEvent;
import com.D_Selon.AutoZombieSurvival.file.DConfig;
import com.D_Selon.AutoZombieSurvival.file.DFile;

import io.papermc.lib.PaperLib;

public class DMain extends JavaPlugin {

	@Override
	public void onEnable() {

		DEvent.setPlugin(this);
		DEvent dEvent = new DEvent();
		this.getServer().getPluginManager().registerEvents(dEvent, this);

		DCommand.setPlugin(this);
		this.getCommand("AutoZombieSurvival").setExecutor(new DCommand());

		DConfig.setPlugin(this);
		DConfig.setVar();
		DConfig.createConfig();
		DConfig.loadConfig();
		DConfig.saveConfig();

		DFile.setPlugin(this);
		DFile.setVar();
		DFile.createFile();
		if (DFile.getFile().exists()) {
			DFile.loadFile();
		} else {
			DFile.saveFile();
		}

		DController.setPlugin(this);
		DController.loadVar();

		PaperLib.suggestPaper(this);

		PluginDescriptionFile pluginDescription = this.getDescription();
		getLogger().info("Enabled " + pluginDescription.getName() + " v" + pluginDescription.getVersion());

		if (DController.getAutoProgress()) {
			DController.gameStart();
		}

	}

	@Override
	public void onDisable() {

		DFile.saveFile();

		PluginDescriptionFile pluginDescription = this.getDescription();
		getLogger().info("Disabled " + pluginDescription.getName() + " v" + pluginDescription.getVersion());

	}

}
