package afkkicker;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import com.earth2me.essentials.Essentials;

import net.ess3.api.IEssentials;
import net.ess3.api.IUser;
import net.ess3.api.events.AfkStatusChangeEvent;

public class EventCity implements Listener {

	/*
	 * This class handles Events that occur within Bukkit, Spigot, Paper, or even other plugins.
	 * 
	 * onPlayerAFK() and onPlayerJoin() both help implement an AFK kicker when the server is under high loads.
	 * 
	 * onPlayerBreak() implements a temporary ban if someone breaks a block while in spawnland.
	 * 
	 * 
	 */
	
	@EventHandler
	public void onPlayerAFK(AfkStatusChangeEvent e) {
		boolean eventType = e.getValue(); //true if person just went afk, false if they just went out of afk
		IUser player = e.getAffected(); //gets userID of person who just went had the afk event
		String playerName = player.getName(); //gets their name
		int serverPop = Bukkit.getOnlinePlayers().size(); //Gets # of people on the server
		if(serverPop >= 5 && eventType) { //If they're more than 5 people, it kicks someone who just went afk
			player.sendMessage("get cucked");
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kick " + playerName + " You went AFK when the server was experiencing high player count."); //person is kicked via command line
		}
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerLoginEvent e) {
		int serverPop = Bukkit.getOnlinePlayers().size(); //Get # of online players
		
		if(serverPop >= 5) { //If there's more than 5 people online
			for(Player all : Bukkit.getOnlinePlayers()) {
				IEssentials ess = (Essentials) Bukkit.getPluginManager().getPlugin("Essentials");
				IUser u = ess.getUser(all.getName()); //Get Essentials instance
				boolean afkStatus = u.isAfk();//Check if the player is AFK
				Player player = all.getPlayer();
				String playerName = player.getName();
				if(afkStatus) {
					player.sendMessage("get cucked");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kick " + playerName + " You went AFK when the server was experiencing high player count."); //person is kicked via command line
				}	
			}
		}
	}
	
	public EventCity() {
		
	}
}
