package me.itsjbey.petsaver;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {

		Bukkit.getPluginManager().registerEvents(new EVENTS(), this);
		
	}
	
}
