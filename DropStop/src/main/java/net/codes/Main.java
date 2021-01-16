package net.codes;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class Main extends JavaPlugin {

    public static HashMap<UUID, ItemsManager> cache = new HashMap<>();


    @Override
    public void onEnable() {

        Bukkit.getPluginManager().registerEvents(new DropListener(this), this);
        getCommand("lockitem").setExecutor(new DropCommand(this));

    }



}