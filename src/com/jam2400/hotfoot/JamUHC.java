package com.jam2400.hotfoot;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.jam2400.hotfoot.listeners.player.PlayerJoin;
import com.jam2400.hotfoot.listeners.player.PlayerMove;
import com.jam2400.hotfoot.threads.Countdown;
import com.jam2400.hotfoot.utils.GameState;

public class JamUHC extends JavaPlugin {
	
	static Thread countdown = new Thread(new Countdown());
	
	public void registerListeners(){
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new PlayerJoin(this), this);
		pm.registerEvents(new PlayerMove(this), this);
	}
	@Override
	public void onEnable(){
		registerListeners();
		Bukkit.getServer().getLogger().info("HotFoot enabled.");
		GameState.setState(GameState.IN_LOBBY);
		countdown.start();
	}
	
	@Override
	public void onDisable(){
		
	}

	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return false;
	}
	
}
