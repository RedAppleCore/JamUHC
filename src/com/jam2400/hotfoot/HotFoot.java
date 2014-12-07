package com.jam2400.hotfoot;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.jam2400.hotfoot.threads.Countdown;
import com.jam2400.hotfoot.utils.GameState;

public class HotFoot extends JavaPlugin {
	
	public void registerListeners(){
		PluginManager pm;
		//pm.registerEvents(// TODO events, this);
	}
	@Override
	public void onEnable(){
		registerListeners();
		Bukkit.getServer().getLogger().info("HotFoot enabled.");
		GameState.setState(GameState.IN_LOBBY);
		new Thread(new Countdown()).start();
	}
	
	@Override
	public void onDisable(){
		
	}
	
	public static void start(){
		// TODO start method
	}
	
	public static void stop() {
		// TODO stop method
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return false;
	}
	public static boolean canStart() {
		return true;
	}
	
}
