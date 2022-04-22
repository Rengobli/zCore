package at.peirleitner.zCore;

import org.bukkit.plugin.java.JavaPlugin;

import at.peirleitner.zCore.util.RunMode;

public class SpigotMain extends JavaPlugin {

	private static SpigotMain instance;

	@Override
	public void onEnable() {

		instance = this;
		this.loadConfig();

		Core.setInstance(new Core(), this.getDescription().getName(), RunMode.SPIGOT);

	}

	/**
	 * 
	 * @return Spigot Instance
	 * @since 1.0.0
	 * @author Markus Peirleitner (Rengobli)
	 */
	public static SpigotMain getInstance() {
		return instance;
	}

	/**
	 * Load the Configuration File
	 * 
	 * @since 1.0.0
	 * @author Markus Peirleitner (Rengobli)
	 */
	private final void loadConfig() {
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}

}
