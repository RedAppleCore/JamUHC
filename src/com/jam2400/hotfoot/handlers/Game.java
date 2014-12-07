package com.jam2400.hotfoot.handlers;

import org.bukkit.ChatColor;

import com.jam2400.hotfoot.utils.ChatUtils;

public class Game {
	
	private static boolean canStart = false;
	
	public static boolean canStart() {
		return canStart;
		
	}
	
	public static void setCanStart(boolean b){
		canStart = b;
	}
	
	public static void start(){
		ChatUtils.broadcast("The game is about to start!");
		// TODO teleport to arena
		ChatUtils.broadcast(ChatColor.GOLD + "As you run around on the sand, the supporting blocks" +
				" will dissapear and you shall meet a perilous demise!");
		ChatUtils.broadcast(ChatColor.AQUA + "Good luck players! The final survivor shall be the chosen winner!");
	}
	
	public static void stop() {
	}
}
