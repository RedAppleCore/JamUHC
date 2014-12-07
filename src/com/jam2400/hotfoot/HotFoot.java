package com.jam2400.hotfoot;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class HotFoot extends JavaPlugin {
	
	public void registerListeners(){
		PluginManager pm;
		//pm.registerEvents(// TODO events, this);
	}
	@Override
	public void onEnable(){
		
	}
	
	@Override
	public void onDisable(){
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return false;
	}
}
