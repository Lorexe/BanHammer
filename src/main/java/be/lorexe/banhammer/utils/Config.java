package be.lorexe.banhammer.utils;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {
	public String onBan;
	public String onKick;
	public boolean canPlayerKick;

	public Config(File file) {
		Configuration config = new Configuration(file);
		config.load();

		this.onBan = config.get("messages", "ban", "The BanHammer has strike!").getString();
		this.onKick = config.get("messages", "kick", "The KickHammer has strike!").getString();

		this.canPlayerKick = config.get("settings", "canPlayerKick", false).getBoolean();

		config.save();
	}
}
