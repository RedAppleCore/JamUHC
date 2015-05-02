package com.jam2400.jamuhc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.ScoreboardManager;

import com.jam2400.jamuhc.listeners.player.PlayerJoin;
import com.jam2400.jamuhc.listeners.player.PlayerMove;
import com.jam2400.jamuhc.threads.Countdown;
import com.jam2400.jamuhc.utils.GameState;
import com.jam2400.jamuhc.handlers.Teams;

import com.jam2400.jamuhc.utils.ChatUtils;

public class JamUHC extends JavaPlugin {
	
	static Thread countdown = new Thread(new Countdown());
	
	public void registerListeners(){
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new PlayerJoin(this), this);
		pm.registerEvents(new PlayerMove(this), this);
	}
	@Override
	public void onEnable(){
		registerListeners();
		Bukkit.getServer().getLogger().info("JamUHC enabled.");
		GameState.setState(GameState.IN_LOBBY);
		
		Teams.prepareTeams();
	}
	
	@Override
	public void onDisable(){
		
	}

	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("team")) {
			Player p;
			if (sender instanceof Player) {
				p = (Player) sender;
			} else {
				return false;
			}
			
			if (!GameState.isState(GameState.IN_LOBBY)) {
				p.sendMessage(ChatUtils.error("This command is not available during game."));
				return false;
			}
			if (args.length == 0) {
				sender.sendMessage(ChatUtils.error("Specify a team"));
				// no args
			} else if (args.length == 1) {
				String team = args[0];
				Teams.changeTeam(p, team);
			}
			return true;
		}
		return false;
	}
	
}
