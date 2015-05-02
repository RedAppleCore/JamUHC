package com.jam2400.jamuhc.utils;

import static org.bukkit.ChatColor.*;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
public class ChatUtils {
	public static void broadcast(String msg){
		Bukkit.broadcastMessage(tag() + msg);
	}
	
	private static String tag() {
		return YELLOW + "[" + RED + "UHC" + YELLOW + "]" + WHITE + " ";
	}
	
	public static String error(String msg) {
		return ChatColor.RED + "Error: " + msg + ".";
	}
}
