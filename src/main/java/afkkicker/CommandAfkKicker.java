package afkkicker;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandAfkKicker implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		sender.sendMessage("AFK Kicker plugin version " + AfkKickerStartup.pluginVersion + " from " + AfkKickerStartup.pluginDate + ". Created by " + AfkKickerStartup.pluginAuthor + ".");
		return true;
	}
	
	public CommandAfkKicker() {
		
	}
}
