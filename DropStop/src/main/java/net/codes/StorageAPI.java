package net.codes;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class StorageAPI {

    private final Main core;

    private File playerData;
    private YamlConfiguration modifyPlayerData;

    public StorageAPI(Main core) {
        this.core = core;
    }

    public static void savePlayer() {

    }

    public static void loadPlayer() {


    }

}
