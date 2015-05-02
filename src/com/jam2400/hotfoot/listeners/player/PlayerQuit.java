package com.jam2400.hotfoot.listeners.player;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

import com.jam2400.hotfoot.JamUHC;
import com.jam2400.hotfoot.handlers.Game;
import com.jam2400.hotfoot.listeners.HFListener;
import com.jam2400.hotfoot.utils.ChatUtils;
import com.jam2400.hotfoot.utils.GameState;

public class PlayerQuit extends HFListener{

	public PlayerQuit(JamUHC pl) {
		super(pl);
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e){
		if(GameState.isState(GameState.IN_LOBBY))
			if(Bukkit.getOnlinePlayers().length - 1 >= 1){
				Game.setCanStart(false);
			}
		e.setQuitMessage(null);
		ChatUtils.broadcast(ChatColor.YELLOW + e.getPlayer().getName() + ChatColor.GOLD + " left." );
	}

}
