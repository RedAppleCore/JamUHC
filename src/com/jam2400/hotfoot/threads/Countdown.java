package com.jam2400.hotfoot.threads;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import com.jam2400.hotfoot.HotFoot;
import com.jam2400.hotfoot.utils.ChatUtils;
import com.jam2400.hotfoot.utils.PlayerUtils;

public class Countdown implements Runnable {
	private static int timeToStart;
	
	public void run() {
		timeToStart = 60;
		while(true){
			timeToStart = 60;
			for(;timeToStart >= 0; timeToStart--){
				PlayerUtils.setAllLevel(timeToStart);
				if(timeToStart == 0){
					HotFoot.start();
					break;
				}
				
				if(timeToStart % 10 == 0 || timeToStart < 10){
					ChatUtils.broadcast("There are " + ChatColor.YELLOW + timeToStart 
							+ " seconds left until the start of the game.");
					// TODO sounds
				}
				
				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {
					e.printStackTrace();
					Bukkit.shutdown();
				}
			}
		}
	}
}
