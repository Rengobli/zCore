package at.peirleitner.zCore.util;

import java.util.UUID;

import javax.annotation.Nonnull;

/**
 * This Class represents a User on the Server/Network.
 * @since 1.0.0
 * @author Markus Peirleitner (Rengobli)
 * @see Language
 */
public class User {

	private UUID uuid;
	private String lastKnownName;
	private Language language;

	public User(@Nonnull UUID uuid) {
		this.uuid = uuid;
	}

	/**
	 * 
	 * @return This Users UUID
	 * @since 1.0.0
	 * @author Markus Peirleitner (Rengobli)
	 */
	public UUID getUUID() {
		return uuid;
	}

	/**
	 * 
	 * @return Last known Name of the User
	 * @since 1.0.0
	 * @author Markus Peirleitner (Rengobli)
	 * @apiNote This may be updated on Server/Proxy disconnect
	 */
	public String getLastKnownName() {
		return lastKnownName;
	}

	/**
	 * Update the last known Name of the User
	 * @param lastKnownName - New Name
	 * @since 1.0.0
	 * @author Markus Peirleitner (Rengobli)
	 */
	public void setLastKnownName(String lastKnownName) {
		//TODO: Update last known name to Database
	}

	/**
	 * 
	 * @return Currently selected Language
	 * @since 1.0.0
	 * @author Markus Peirleitner (Rengobli)
	 * @see Language
	 */
	public Language getLanguage() {
		return language;
	}

	/**
	 * Update the selected Language of this User
	 * @param language - New Language
	 * @since 1.0.0
	 * @author Markus Peirleitner (Rengobli)
	 * @see Language
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}

}
