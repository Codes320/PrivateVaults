package com.codes;

import com.codes.commands.VaultCommand;
import com.codes.managers.StorageManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public final class Main extends JavaPlugin {


    private StorageManager storageManager;
    UUID playerUUID;
    int vaultNumber;

    @Override
    public void onEnable() {
        getCommand("pv").setExecutor(new VaultCommand(this));
        storageManager = new StorageManager(this);
        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void setPlayerUUID(UUID playerUUID) { this.playerUUID = playerUUID; }
    public void setVaultNumber(int vaultNumber) { this.vaultNumber = vaultNumber; }

    public UUID getPlayerUUID() { return playerUUID; }
    public StorageManager getStorageManager() { return storageManager; }
    public int getVaultNumber() { return vaultNumber; }
}
