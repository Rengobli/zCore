package at.peirleitner.zCore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.google.common.io.ByteStreams;

import at.peirleitner.zCore.util.LogLevel;
import at.peirleitner.zCore.util.RunMode;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

public class BungeeMain extends Plugin {

	private static BungeeMain instance;
	private File file;
	private Configuration conf;

	@Override
	public void onEnable() {

		instance = this;
		getProxy().registerChannel("zcore:core");

		if (!getDataFolder().exists()) {
			getDataFolder().mkdir();
		}

		Core.setInstance(new Core(), this.getDescription().getName(), RunMode.BUNGEE);
		this.loadConfig();
		this.saveConfig();

		// Commands

		// Listener

		super.onEnable();
	}
	
	public static BungeeMain getInstance() {
		return instance;
	}
	
	private final void loadConfig() {

		file = new File(getDataFolder(), "bungeeconfig.yml");
		if (!file.exists()) {
			try {
				file.createNewFile();
				try (InputStream is = getResourceAsStream("bungeeconfig.yml");
						OutputStream os = new FileOutputStream(file)) {
					ByteStreams.copy(is, os);
				}
			} catch (IOException ex) {
				Core.log(LogLevel.ERROR, this.getDescription().getName(),
						"Error while attempting to create Configuration File for BungeeCord: " + ex.getMessage());
				return;
			}
		}

		try {
			conf = net.md_5.bungee.config.ConfigurationProvider
					.getProvider(net.md_5.bungee.config.YamlConfiguration.class).load(file);
		} catch (IOException ex) {
			Core.log(LogLevel.ERROR, this.getDescription().getName(),
					"Error while attempting to load Configuration File for BungeeCord: " + ex.getMessage());
			return;
		}

	}

	public final void saveConfig() {
		try {
			net.md_5.bungee.config.ConfigurationProvider.getProvider(net.md_5.bungee.config.YamlConfiguration.class)
					.save(conf, file);
		} catch (IOException ex) {
			throw new RuntimeException("Error while saving configuration file", ex);
		}
	}

}
