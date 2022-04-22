package at.peirleitner.zCore;

import javax.annotation.Nonnull;

import org.bukkit.Bukkit;

import at.peirleitner.zCore.util.LogLevel;
import at.peirleitner.zCore.util.RunMode;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;

public class Core {

	private static Core instance;
	private static RunMode runMode;

	/**
	 * 
	 * @return Core Instance
	 * @since 1.0.0
	 * @author Markus Peirleitner (Rengobli)
	 */
	public static final Core getInstance() {
		return instance;
	}
	
	/**
	 * Set the Instance
	 * @param core - Core Instance
	 * @param pluginName - Name of the Plugin updating the Instance
	 * @param mode - RunMode
	 * @since 1.0.0
	 * @author Markus Peirleitner (Rengobli)
	 */
	public static void setInstance(@Nonnull Core core, @Nonnull String pluginName, @Nonnull RunMode mode) {
		instance = core;
		runMode = mode;
		log(LogLevel.INFO, pluginName, "Updated the Core Instance to RunMode " + mode.name());
	}
	
	/**
	 * 
	 * @return Current RunMode
	 * @since 1.0.0
	 * @author Markus Peirleitner (Rengobli)
	 */
	public static final RunMode getRunMode() {
		return runMode;
	}

	public static void log(@Nonnull LogLevel level, @Nonnull String pluginName, @Nonnull String message) {

		if (runMode == RunMode.SPIGOT) {
			Bukkit.getConsoleSender().sendMessage("[" + pluginName + "/" + level.name() + "]: " + message);
		} else if (runMode == RunMode.BUNGEE) {
			ProxyServer.getInstance().getConsole()
					.sendMessage(new TextComponent("[" + pluginName + "/" + level.name() + "]: " + message));
		}

	}

}
