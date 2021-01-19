package net.codes;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class Main extends JavaPlugin {

    public static Map<UUID, ItemsManager> cache = new HashMap<>();

    private static Main myInstance;

    public static Main getInstance() {

        return myInstance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        myInstance = this;
        getCommand("lockitem").setExecutor(new DropCommand(this));
        getServer().getPluginManager().registerEvents(new DropListener(this), this);
        this.saveDefaultConfig();


        }

    @Override
    public void onDisable() {

    }

    public Map<UUID, ItemsManager> getCache() {
        return cache;
    }
}