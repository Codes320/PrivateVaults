package com.codes;

import com.codes.commands.VaultCommand;
import com.codes.managers.StorageManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

//    private VaultsManager vaultsManager;
//    private UserManager userManager;
    private StorageManager storageManager;

//    private HashMap<Integer, VaultsManager> cache;

    @Override
    public void onEnable() {
        getCommand("pv").setExecutor(new VaultCommand(this));
        storageManager = new StorageManager(this);
        this.saveDefaultConfig();
//        vaultsManager = new VaultsManager();
//        userManager = new UserManager();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

//    public VaultsManager getVaultsManager() { return this.vaultsManager; }
//    public UserManager getUserManager() { return userManager; }
    public VaultCommand getVaultCommand() { return getVaultCommand(); }
    public StorageManager getStorageManager() { return storageManager; }

    //    public HashMap<Integer, VaultsManager> getCache() { return this.cache; }
}
