package com.D_Selon.AutoZombieSurvival.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.D_Selon.AutoZombieSurvival.DMain;
import com.D_Selon.AutoZombieSurvival.controller.DController;
import com.D_Selon.AutoZombieSurvival.file.DConfig;
import com.D_Selon.AutoZombieSurvival.file.DFile;

public class DCommand implements CommandExecutor {

	public static DMain plugin;

	public static void setPlugin(DMain mainPlugin) {
		plugin = mainPlugin;
	}

	private String serverTitle;
	private String borderColor;
	private String serverName;
	private String pluginName;

	private void commandInfo(CommandSender sender) {
		sender.sendMessage("");
		sender.sendMessage(" " + pluginName);
		sender.sendMessage(" §f§l/AZS §f: §f플러그인의 명령어를 확인합니다.");
		sender.sendMessage(" §f§l/AZS reload §f: §f플러그인을 리로드합니다.");
		sender.sendMessage(" §f§l/AZS load §f: §f플러그인을 불러옵니다.");
		sender.sendMessage(" §f§l/AZS save §f: §f플러그인을 저장합니다.");
		sender.sendMessage("");
		sender.sendMessage(" §f§l/AZS gameStart §f: §f게임을 시작합니다.");
		sender.sendMessage(" §f§l/AZS gameStop §f: §f게임을 중지합니다.");
		sender.sendMessage("");
		sender.sendMessage(" §f§l/AZS setLobby §f: §f로비 위치를 설정합니다.");
		sender.sendMessage("");
		sender.sendMessage(" §f§l/AZS mapList §f: §f맵 목록을 확인합니다.");
		sender.sendMessage(" §f§l/AZS mapListInit §f: §f맵 목록을 초기화합니다.");
		sender.sendMessage(" §f§l/AZS addMap §e§l<mapName> §f: §f맵을 추가합니다.");
		sender.sendMessage(" §f§l/AZS removeMap §e§l<mapName> §f: §f맵을 제거합니다.");
		sender.sendMessage("");
		sender.sendMessage(" §f§l/AZS playerList §f: §f플레이어 목록을 확인합니다.");
		sender.sendMessage(" §f§l/AZS playerListInit §f: §f플레이어 목록을 초기화합니다.");
		sender.sendMessage(" §f§l/AZS addPlayer §e§l<playerName> §f: §f플레이어를 추가합니다.");
		sender.sendMessage(" §f§l/AZS removePlayer §e§l<playerName> §f: §f플레이어를 제거합니다.");
		sender.sendMessage("");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		serverTitle = DConfig.getServerTitle();
		borderColor = DConfig.getBorderColor();
		serverName = borderColor + "[ " + serverTitle + " " + borderColor + "]";
		pluginName = "§7§l[ §4§lAutoZS §7§l]";

		if (sender instanceof Player) {
			if (!sender.isOp()) {
				sender.sendMessage(pluginName + " §f권한이 없습니다!");
				return false;
			}
		}

		if (args.length == 0) {
			commandInfo(sender);
		} else if (args.length == 1) {
			if (args[0].equalsIgnoreCase("reload")) {
				Bukkit.getPluginManager().disablePlugin(plugin);
				Bukkit.getPluginManager().enablePlugin(plugin);
				sender.sendMessage(pluginName + " §f플러그인을 리로드하였습니다!");
			} else if (args[0].equalsIgnoreCase("load")) {
				DConfig.loadConfig();
				DFile.loadFile();
				DController.loadVar();
				sender.sendMessage(pluginName + " §f플러그인을 불러왔습니다!");
			} else if (args[0].equalsIgnoreCase("save")) {
				DConfig.saveConfig();
				DFile.saveFile();
				sender.sendMessage(pluginName + " §f플러그인을 저장했습니다!");
			} else if (args[0].equalsIgnoreCase("gameStart")) {
				if (DController.gameStart()) {
					sender.sendMessage(pluginName + " §f게임을 시작하였습니다.");
				} else {
					sender.sendMessage(pluginName + " §f이미 게임이 진행중입니다.");
				}
			} else if (args[0].equalsIgnoreCase("gameStop")) {
				if (DController.gameStop()) {
					sender.sendMessage(pluginName + " §f게임을 중지하였습니다.");
				} else {
					sender.sendMessage(pluginName + " §f이미 게임이 진행하고 있지 않습니다.");
				}
			} else if (args[0].equalsIgnoreCase("setLobby")) {
				if (sender instanceof Player) {
					Player player = (Player) sender;
					Location lobbyLocation = player.getLocation();
					DController.setLobby(lobbyLocation);
					sender.sendMessage(pluginName + " §f§l로비 위치를 설정하였습니다.");
				} else {
					sender.sendMessage(pluginName + " §f§l플레이어만 사용 가능한 명령어입니다!");
				}
			} else if (args[0].equalsIgnoreCase("mapList")) {
				sender.sendMessage(" §7§l[ §f§l맵 목록 §7§l]");
				ArrayList<String> mapNameList = DController.getMapNameList();
				ArrayList<Location> mapLocationList = DController.getMapLocationList();
				if (mapNameList.isEmpty() && mapLocationList.isEmpty()) {
					sender.sendMessage(" §f§l- §f[]");
				} else {
					Iterator nameItr = mapNameList.iterator();
					Iterator locationItr = mapLocationList.iterator();
					while (nameItr.hasNext() && locationItr.hasNext()) {
						sender.sendMessage(" §f§l- §7" + nameItr.next() + "§f, ");
						sender.sendMessage(" §f§l  §7" + locationItr.next());
					}
				}
			} else if (args[0].equalsIgnoreCase("mapListInit")) {
				DController.mapListInit();
				sender.sendMessage(pluginName + " §f§l맵 목록을 초기화하였습니다.");
			} else if (args[0].equalsIgnoreCase("addMap")) {
				sender.sendMessage(pluginName + " §c§l사용법: §f§l/AZS addMap §e§l<mapName>");
			} else if (args[0].equalsIgnoreCase("removeMap")) {
				sender.sendMessage(pluginName + " §c§l사용법: §f§l/AZS removeMap §e§l<mapName>");
			} else if (args[0].equalsIgnoreCase("playerList")) {
				sender.sendMessage(" §7§l[ §f§l플레이어 목록 §7§l]");
				List<Player> playerList = DController.getPlayerList();
				if (playerList.isEmpty()) {
					sender.sendMessage(" §f§l- §f[]");
				} else {
					for (Player player : playerList) {
						sender.sendMessage(" §f§l- §7" + player.getName());
					}
				}
			} else if (args[0].equalsIgnoreCase("playerListInit")) {
				DController.playerListInit();
				sender.sendMessage(pluginName + " §f§l게임에 참가하고 있는 플레이어 목록을 초기화하였습니다.");
			} else if (args[0].equalsIgnoreCase("addPlayer")) {
				sender.sendMessage(pluginName + " §c§l사용법: §f§l/AZS addPlayer §e§l<playerName>");
			} else if (args[0].equalsIgnoreCase("removePlayer")) {
				sender.sendMessage(pluginName + " §c§l사용법: §f§l/AZS removePlayer §e§l<playerName>");
			}
		} else if (args.length == 2) {
			if (args[0].equalsIgnoreCase("addMap")) {
				if (sender instanceof Player) {
					Player player = (Player) sender;
					Location mapLocation = player.getLocation();
					if (DController.addMap(args[1], mapLocation)) {
						sender.sendMessage(pluginName + " §6§l" + args[1] + " §f§l맵을 목록에 추가하였습니다.");
					} else {
						sender.sendMessage(pluginName + " §6§l" + args[1] + " §f§l맵은 이미 목록에 있습니다!");
					}
				} else {
					sender.sendMessage(pluginName + " §f§l플레이어만 사용 가능한 명령어입니다!");
				}
			} else if (args[0].equalsIgnoreCase("removeMap")) {
				if (DController.removeMap(args[1])) {
					sender.sendMessage(pluginName + " §6§l" + args[1] + " §f§l맵을 목록에서 제거하였습니다.");
				} else {
					sender.sendMessage(pluginName + " §6§l" + args[1] + " §f§l맵은 이미 목록에 없습니다!");
				}
			} else if (args[0].equalsIgnoreCase("addPlayer")) {
				Player player = Bukkit.getPlayer(args[1]);
				if (player == null) {
					sender.sendMessage(pluginName + " §6§l" + args[1] + " §f§l플레이어가 서버에 없습니다!");
				} else {
					if (DController.addPlayer(player)) {
						sender.sendMessage(pluginName + " §6§l" + args[1] + " §f§l플레이어를 게임에 추가하였습니다.");
					} else {
						sender.sendMessage(pluginName + " §6§l" + args[1] + " §f§l플레이어는 이미 게임에 참가하고 있습니다!");
					}
				}
			} else if (args[0].equalsIgnoreCase("removePlayer")) {
				Player player = Bukkit.getPlayer(args[1]);
				if (player == null) {
					sender.sendMessage(pluginName + " §6§l" + args[1] + " §f§l플레이어가 서버에 없습니다!");
				} else {
					if (DController.removePlayer(player)) {
						sender.sendMessage(pluginName + " §6§l" + args[1] + " §f§l플레이어를 게임에서 제거하였습니다.");
					} else {
						sender.sendMessage(pluginName + " §6§l" + args[1] + " §f§l플레이어는 이미 게임에 참가하고 있지 않습니다!");
					}
				}
			}
		}

		return false;
	}

}
