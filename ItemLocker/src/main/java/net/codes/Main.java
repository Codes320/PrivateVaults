package net.codes;


import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class Main extends JavaPlugin {

    private HashMap<UUID, List<String>> cache = new HashMap<>();
    private File playerData;
    private YamlConfiguration modifyPlayerData;
    

    public void onEnable() {
        getCommand("lockitem").setExecutor(new LockCommand(this));
        getServer().getPluginManager().registerEvents(new DropListener(this), (Plugin)this);

        this.saveDefaultConfig();
        initiateFiles();


        if (!this.modifyPlayerData.getConfigurationSection("data").getKeys(false).isEmpty()) {
            loadItems();
        }
    }

    public void onDisable() {
        if (!cache.isEmpty()) {
            this.saveItems();
        }
    }

    public HashMap<UUID, List<String>> getCache() { return this.cache; }
    public YamlConfiguration getModifyPlayerData() { return modifyPlayerData; }
    public File getPlayerData() { return playerData; }

    public void initiateFiles() {
        playerData = new File(Bukkit.getServer().getPluginManager().getPlugin("ItemLocker").getDataFolder(), "data.yml");
        if (!playerData.exists()) {
            try {
                playerData.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        modifyPlayerData = YamlConfiguration.loadConfiguration(playerData);
    }

    public void saveItems() {
        for (Map.Entry<UUID, List<String>> entry : cache.entrySet()) {
            getModifyPlayerData().set("data." + entry.getKey(), entry.getValue());
            try {
                this.getModifyPlayerData().save(this.getPlayerData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void loadItems() {
        if (modifyPlayerData.getConfigurationSection("data") != null) {
        for (String uuid : getModifyPlayerData().getConfigurationSection("data").getKeys(false)) {
            cache.put(UUID.fromString(uuid), getModifyPlayerData().getStringList("data." + uuid));
            Bukkit.getConsoleSender().sendMessage(UUID.fromString(uuid).toString());
        }

        }

    }

}


