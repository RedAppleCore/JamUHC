package com.jam2400.hotfoot.utils;

import static org.bukkit.ChatColor.*;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
public class ChatUtils {
	public static void broadcast(String msg){
		for(Player p : Bukkit.getOnlinePlayers()){
			p.sendMessage(tag() + msg);
		}
	}
	
	private static String tag() {
		return YELLOW + "[" + RED + "HotFoot" + YELLOW + "]" + WHITE;
	}
}
