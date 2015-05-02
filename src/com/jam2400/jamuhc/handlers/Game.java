package com.jam2400.jamuhc.handlers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import com.jam2400.jamuhc.utils.ChatUtils;
import com.jam2400.jamuhc.utils.GameState;

public class Game {
	
	private static boolean canStart = false;
	
	public static boolean canStart() {
		return canStart;
		
	}
	
	public static void setCanStart(boolean b){
		canStart = b;
	}
	
	public static void start(){
		ChatUtils.broadcast(ChatColor.GOLD + "The game is starting, good luck teams!");
		
		for (Player p : Bukkit.getOnlinePlayers()){
			p.setAllowFlight(false);
			p.setFlying(false);
			
			p.setGameMode(GameMode.SURVIVAL);
		}
		GameState.setState(GameState.IN_GAME);
	}
	
	public static void stop() {
	}
}
