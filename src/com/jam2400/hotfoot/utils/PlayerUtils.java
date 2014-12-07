package com.jam2400.hotfoot.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerUtils {
	public static void setAllLevel(int x){
		for(Player p : Bukkit.getOnlinePlayers()){
			p.setLevel(x);
		}
	}
}
