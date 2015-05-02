package com.jam2400.jamuhc.handlers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import com.jam2400.jamuhc.utils.ChatUtils;




public class Teams {
	static ScoreboardManager manager = Bukkit.getScoreboardManager();
	
	public static ScoreboardManager getManager() {
		return manager;
	}
	
	public static Scoreboard getBoard() {
		return manager.getMainScoreboard();
	}
	
	static Scoreboard board = manager.getMainScoreboard();
	
	 public enum TeamConfig {
		 red(ChatColor.RED + "", ChatColor.RED + "Red", "red"),
		 yellow(ChatColor.YELLOW + "", ChatColor.YELLOW + "Yellow", "yellow"),
		 green(ChatColor.GREEN + "", ChatColor.GREEN + "Green", "green"),
		 orange(ChatColor.GOLD + "", ChatColor.GOLD + "Orange", "orange"),
		 spectator(ChatColor.GRAY + "", ChatColor.GRAY + "Spectator", "spectator");
		 
		 public final String prefix;
		 public final String displayName;
		 public final String name;
		 
		 TeamConfig(String prefix, String displayName, String name) {
			 this.prefix = prefix;
			 this.displayName = displayName;
			 this.name = name;
		 }
	 }
	 
	 public static void prepareTeams() {
		 clearTeams();
		 for (TeamConfig team : TeamConfig.values()) {
			 Team UHCTeam = board.registerNewTeam(team.name);
			 UHCTeam.setPrefix(team.prefix);
			 UHCTeam.setDisplayName(team.displayName);
			 UHCTeam.setAllowFriendlyFire(false);
		 }
	 }
	 
	 public static void clearTeams() {
		 for (Team team : board.getTeams()) {
			 team.unregister();
		 }
	 }
	 
	 public static void onTeamChange(Player p) {
		 String team = getBoard().getPlayerTeam(p).getDisplayName();
		 ChatUtils.broadcast(p.getDisplayName() + " is now on the " + team + " team.");
		 
		 if (getBoard().getPlayerTeam(p).getName() == "spectator") {
			 p.setGameMode(GameMode.SPECTATOR);
		 } else {
			 p.setGameMode(GameMode.SURVIVAL);
		 }
		 
	 }
	 
	 public static void setSpectator(Player p) {
		 getBoard().getTeam("spectator").addPlayer(p);
		 onTeamChange(p);
	 }

	public static void changeTeam(Player p, String team) {
		boolean success = true;
		if (getBoard().getTeam(team).getSize() == 4) {
			p.sendMessage(ChatUtils.error("The team is full!"));
		} else {
			try{
				getBoard().getTeam(team).addPlayer(p);	
			}
			catch (IllegalStateException e) {
				success = false;
				p.sendMessage(ChatUtils.error("Invalid team."));
			}
			
		}
		if (success == true) {
			onTeamChange(p);
		}
		
	}
	
	
}
