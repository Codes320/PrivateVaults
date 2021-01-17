package net.codes;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class Main extends JavaPlugin {

    private File playerData;
    private YamlConfiguration modifyPlayerData;

    private Map<UUID, ItemsManager> cache = new HashMap<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("lockitem").setExecutor(new DropCommand(this));
        getServer().getPluginManager().registerEvents(new DropListener(this), this);
        this.saveDefaultConfig();

        if (this.getConfig().contains("data")) {
            this.restoreLists();
        }

        initiateFiles();

    }

    public YamlConfiguration getPlayerData() {
        return modifyPlayerData;
    }

    public void saveLists() {
        for (Map.Entry<UUID, ItemsManager> entry : cache.entrySet()) {
            this.getPlayerData().set("data" + entry.getKey(), entry.getValue());
            try {
                this.getPlayerData().save(playerData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void restoreLists() {
        this.getPlayerData().getConfigurationSection("data").getKeys(false).forEach(key -> {
//I need help here
        });
    }

    public void initiateFiles() {
        playerData = new File(Bukkit.getServer().getPluginManager().getPlugin("DropStop").getDataFolder(), "playerdata.yml");
        if (!playerData.exists()) {
            try {
                playerData.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            modifyPlayerData = YamlConfiguration.loadConfiguration(playerData);
        }
    }

    @Override
    public void onDisable() {
        if (!cache.isEmpty()) {
            this.saveLists();
        }
    }

    public Map<UUID, ItemsManager> getCache() {
        return cache;
    }
}