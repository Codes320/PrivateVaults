package net.codes;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class Main extends JavaPlugin {

    private File playerData;
    private YamlConfiguration modifyPlayerData;

    public static Map<UUID, ItemsManager> cache = new HashMap<>();

    private static Main myInstance;

    public static Main getInstance() {

        return myInstance;
    }



    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("lockitem").setExecutor(new DropCommand(this));
        getServer().getPluginManager().registerEvents(new DropListener(this), this);
        this.saveDefaultConfig();

        myInstance = this;

        }


    public YamlConfiguration getPlayerData() {
        return modifyPlayerData;
    }


    @Override
    public void onDisable() {

    }

    public Map<UUID, ItemsManager> getCache() {
        return cache;
    }
}