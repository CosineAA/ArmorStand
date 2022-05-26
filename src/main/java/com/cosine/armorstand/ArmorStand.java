package com.cosine.armorstand;

import org.bukkit.plugin.java.JavaPlugin;

public final class ArmorStand extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("등").setExecutor(new Command());
        getCommand("오른손").setExecutor(new Command2());
        getCommand("왼손").setExecutor(new Command3());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
