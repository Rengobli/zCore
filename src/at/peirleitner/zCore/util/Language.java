package at.peirleitner.zCore.util;

import javax.annotation.Nonnull;

/**
 * This Class represents a Language.<br>
 * A {@link User} must have one Language associated to them
 * @since 1.0.0
 * @author Markus Peirleitner (Rengobli)
 * @see User
 */
public enum Language {

	ARABIC("?", "", ""),
	BOSNIAN("?", "", ""),
	BULGARIAN("?", "", ""),
	CHINESE_SIMPLIFIED("?", "", ""),
	CHINESE_TRADITIONAL("?", "", ""),
	CROATIAN("?", "", ""),
	CZECH("?", "", ""),
	DANISH("?", "", ""),
	DUTCH("?", "", ""),
	ENGLISH("English", "en_EN", ""),
	FRENCH("?", "fr_FR", ""),
	GERMAN("Deutsch", "de_DE", ""),
	GREEK("?", "", ""),
	HINDI("?", "", ""),
	INDONESIAN("?", "", ""),
	ITALIAN("?", "it_IT", ""),
	JAPANESE("?", "", ""),
	KOREAN("?", "", ""),
	NORWEGIAN("?", "", ""),
	POLISH("?", "", ""),
	PORTUGUESE("?", "", ""),
	ROMANIAN("?", "", ""),
	RUSSIAN("?", "", ""),
	SLOVAK("?", "", ""),
	SPANISH("?", "es_ES", ""),
	SWEDISH("?", "", ""),
	TURKISH("?", "", ""),
	UKRAINIAN("?", "", ""),
	VIETNAMESE("?", "", "");
	
	private String name;
	private String shortName;
	private String skullTexture;
	
	private Language(@Nonnull String name, @Nonnull String shortName, @Nonnull String skullTexture) {
		this.name = name;
		this.skullTexture = skullTexture;
	}

	/**
	 * 
	 * @return Native Name of the Language (ex.: English, Deutsch)
	 * @since 1.0.0
	 * @author Markus Peirleitner (Rengobli)
	 * @apiNote May return '?' on Languages where the Name could has not yet been verified
	 */
	public final String getName() {
		return this.name;
	}
	
	/**
	 * @return Short Name of the Language (ex.: en_EN, de_DE)
	 * @since 1.0.0
	 * @author Markus Peirleitner (Rengobli)
	 * @apiNote May return an empty String if no Short Name has yet been linked
	 * @apiNote This Core does <b>not</b> support multiple variants (ex.: en_US, en_UK)
	 */
	public final String getShortName() {
		return this.shortName;
	}
	
	/**
	 * 
	 * @return Texture for a Skull representing this Language
	 * @since 1.0.0
	 * @author Markus Peirleitner (Rengobli)
	 * @apiNote May return an empty String if no Texture has yet been linked
	 */
	public final String getSkullTexture() {
		return this.skullTexture;
	}

	
	

}
