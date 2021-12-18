package afkkicker;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AfkKickerStartup extends JavaPlugin {

	public static String pluginVersion = "1.2";
	public static String pluginDate = "12/6/2021";
	public static String pluginAuthor = "Rusettsten / Benji Arrigo";
	
	@Override
	public void onEnable() {
		
		//Configuration registration
		Plugin plugin = this;
		plugin.saveDefaultConfig();
		
		//Command registration
		this.getCommand("afkkicker").setExecutor(new CommandAfkKicker());
		
		//Event Listening
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new EventCity(), this);
		
		getLogger().info("AFK Kicker " + pluginVersion + " ENABLED!");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("Afk Kicker " + pluginVersion + " DISABLED!");
	}

}
