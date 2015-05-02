package com.jam2400.jamuhc.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class PlayerUtils {
	
	private static Location spawn = new Location(Bukkit.getWorld("world"), -587, 12, 1294);
	
	public static void setAllLevel(int x){
		for(Player p : Bukkit.getOnlinePlayers()){
			p.setLevel(x);
		}
	}
	
	public static void playAllClick(){
		for(Player p : Bukkit.getOnlinePlayers()){
			// TODO play click sound
		}
	}
	
	public static void tpToSpawn(Player p){
			p.teleport(spawn);
	}
}
