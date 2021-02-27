package com.codes.managers;

import com.codes.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class StorageManager {

    private File dataFile;
    private YamlConfiguration modifyDataFile;

    private Main main;

    public StorageManager(Main main) {
        this.main = main;
    }


    public void initiateFiles() {
        this.dataFile = new File(Bukkit.getServer().getPluginManager().getPlugin("PrivateVaults").getDataFolder(), main.getPlayerUUID().toString() + ".yml");

        if (!dataFile.exists()) {
            try {
                dataFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        this.modifyDataFile = YamlConfiguration.loadConfiguration(dataFile);
    }

    public void saveItems() {


    }

    public void loadItems() {

        String vaultNumber = String.valueOf(main.getVaultNumber());
        this.dataFile = new File(Bukkit.getServer().getPluginManager().getPlugin("PrivateVaults").getDataFolder(), main.getPlayerUUID().toString() + ".yml");

        if (this.modifyDataFile.getConfigurationSection(vaultNumber) != null) {


        } else {

        }

    }

    public YamlConfiguration getModifyDataFile() { return modifyDataFile; }
}
