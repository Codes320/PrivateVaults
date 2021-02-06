package net.codes;


import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class Main extends JavaPlugin {

    private HashMap<UUID, List<String>> cache = new HashMap<>();
    private StorageAPI storage;

    

    public void onEnable() {
        getCommand("lockitem").setExecutor(new LockCommand(this));
        getServer().getPluginManager().registerEvents(new DropListener(this), (Plugin)this);
        StorageAPI storage = new StorageAPI(this);

        this.saveDefaultConfig();
        getStorageAPI().initiateFiles();


        if (!getStorageAPI().getModifyPlayerData().getConfigurationSection("data").getKeys(false).isEmpty()) {
            getStorageAPI().loadItems();
        }
    }

    public void onDisable() {
        if (!cache.isEmpty()) { getStorageAPI().saveItems(); }
    }

    public HashMap<UUID, List<String>> getCache() { return this.cache; }
    public StorageAPI getStorageAPI() { return storage; }







}


