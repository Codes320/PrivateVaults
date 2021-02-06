package net.codes;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class StorageAPI {
    private File playerData;
    private YamlConfiguration modifyPlayerData;

    private Main main;
    public StorageAPI(Main main) { this.main = main; }



    public void initiateFiles() {
        this.playerData = new File(Bukkit.getServer().getPluginManager().getPlugin("ItemLocker").getDataFolder(), "data.yml");
        if (!playerData.exists()) {
            try {
                playerData.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        this.modifyPlayerData = YamlConfiguration.loadConfiguration(playerData);
    }

    public void saveItems() {
        for (Map.Entry<UUID, List<String>> entry : main.getCache().entrySet()) {
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
                    main.getCache().put(UUID.fromString(uuid), getModifyPlayerData().getStringList("data." + uuid));
                    Bukkit.getConsoleSender().sendMessage(UUID.fromString(uuid).toString());
                }
            }
        }

    public YamlConfiguration getModifyPlayerData() { return modifyPlayerData; }
    public File getPlayerData() { return playerData; }

}
