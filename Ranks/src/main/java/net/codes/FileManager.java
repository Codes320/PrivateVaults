package net.codes;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileManager {

    private File file;
    private YamlConfiguration config;

    public FileManager(Main main) {

        File file = new File(main.getDataFolder(), "player-data.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        config = YamlConfiguration.loadConfiguration(file);

    }

    public void setRank(Player player, Rank rank) {
        config.set(player.getUniqueId().toString(), rank.name());
    }

    public void setRank(UUID uuid, Rank rank) {
        config.set(uuid.toString(), rank.name());
    }
    public Rank getRank(Player player) {
        return Rank.valueOf(config.getString(player.getUniqueId().toString()));
    }

}

