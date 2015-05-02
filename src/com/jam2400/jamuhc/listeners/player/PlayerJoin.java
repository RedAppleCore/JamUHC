package com.jam2400.jamuhc.listeners.player;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import com.jam2400.jamuhc.JamUHC;
import com.jam2400.jamuhc.handlers.Game;
import com.jam2400.jamuhc.listeners.UHCListener;
import com.jam2400.jamuhc.utils.ChatUtils;

public class PlayerJoin extends UHCListener {

	public PlayerJoin(JamUHC pl) {
		super(pl);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		Game.setCanStart(true);
		
		e.setJoinMessage(null);
		ChatUtils.broadcast(ChatColor.YELLOW + e.getPlayer().getName() + ChatColor.GOLD + " joined." );
		
		p.setGameMode(GameMode.ADVENTURE);
		if(p.isOp()){
			p.setAllowFlight(true);
			p.setFlying(true);
		}
		
	}
}
