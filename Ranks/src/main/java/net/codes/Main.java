package net.codes;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static FileManager fileManager;

    @Override
    public void onEnable() {

        new FileManager(this);

        Bukkit.getPluginManager().registerEvents(new RankListener(), this);
        getCommand("setrank").setExecutor(new RankCommand());
    }

    public static FileManager getFileManager() {
        return fileManager;
    }
}
