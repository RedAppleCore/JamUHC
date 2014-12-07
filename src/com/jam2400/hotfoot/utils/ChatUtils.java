package com.jam2400.hotfoot.utils;

import static org.bukkit.ChatColor.*;

import org.bukkit.Bukkit;
public class ChatUtils {
	public static void broadcast(String msg){
		Bukkit.broadcastMessage(tag() + msg);
	}
	
	private static String tag() {
		return YELLOW + "[" + RED + "HotFoot" + YELLOW + "]" + WHITE + " ";
	}
}
