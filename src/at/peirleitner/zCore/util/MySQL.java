package at.peirleitner.zCore.util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Nonnull;

import at.peirleitner.zCore.Core;

public class MySQL {

	private File credentials;
	private String pluginName;

	private String host;
	private String database;
	private int port;
	private String username;
	private String password;

	private Connection connection;

	public MySQL(@Nonnull File file, @Nonnull String pluginName, @Nonnull String host, @Nonnull String database,
			@Nonnull int port, @Nonnull String username, @Nonnull String password) {

		this.host = host;
		this.database = database;
		this.port = port;
		this.username = username;
		this.password = password;

		credentials = file;
		this.pluginName = pluginName;

		Core.log(LogLevel.DEBUG, pluginName, "Checking for MySQL File..");
		if (!credentials.exists()) {
			Core.log(LogLevel.WARN, pluginName, "MySQL File does not exist! Cancelled Connection attempt.");
			return;
		}

		this.connect();

	}

	public Connection getConnection() {
		return this.connection;
	}

	public boolean prepareStatement(@Nonnull String statement) {

		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(statement);
			stmt.execute();
			return true;
		} catch (SQLException e) {
			Core.log(LogLevel.ERROR, pluginName,
					"Error while attempting to execute PreparedStatement inside MySQL.class (Statement: " + statement
							+ "): " + e.getMessage());
			return false;
		}

	}

	public boolean isConnected() {
		try {
			return this.connection != null && !connection.isClosed() ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	private final void connect() {

		try {

			Core.log(LogLevel.INFO, pluginName, "Attempting to connect towards Database " + this.database + "..");

			this.connection = DriverManager.getConnection(
					"jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true", username, password);

			Core.log(LogLevel.INFO, pluginName, "Successfully connected to Database " + this.database + ".");

		} catch (SQLException e) {
			Core.log(LogLevel.ERROR, pluginName,
					"Could not connect to Database " + this.database + ": " + e.getMessage());
			return;
		}

	}

	public void close() {

		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
				Core.log(LogLevel.INFO, pluginName,
						"Successfully closed MySQL Database Connection (DB: " + this.database + ").");
			}
		} catch (SQLException e) {
			Core.log(LogLevel.ERROR, pluginName,
					"Could not close Database Connection (DB: " + this.database + "): " + e.getMessage());
			return;
		}

	}

}
