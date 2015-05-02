package com.jam2400.hotfoot.listeners.player;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import com.jam2400.hotfoot.JamUHC;
import com.jam2400.hotfoot.handlers.Game;
import com.jam2400.hotfoot.listeners.HFListener;
import com.jam2400.hotfoot.utils.ChatUtils;

public class PlayerJoin extends HFListener {

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
