package net.codes;

import com.google.gson.Gson;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class StorageAPI {

    public static void savePlayer(ItemsManager manager) {
        CompletableFuture.runAsync(new Runnable() {


            @Override
            public void run() {
                File playerFile = new File(Main.getInstance().getDataFolder().getPath() + File.separator +
                        "/players/" + manager.getPlayerUUID() + ".yml");
                if (!(playerFile.exists())) {
                    try {
                        playerFile.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                YamlConfiguration cfg = YamlConfiguration.loadConfiguration(playerFile);
                Gson gson = new Gson();

                try {
                    String objText = gson.toJson(manager);
                    cfg.set("data", objText);
                    cfg.save(playerFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        });
    }

    public static void loadPlayer(String playerName) {
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {

                File playerFile = new File(Main.getInstance().getDataFolder().getPath() + File.separator +
                        "/players/" + Bukkit.getPlayerExact(playerName).getUniqueId().toString() + ".yml");

                if (!(playerFile.exists())) {
                    try {
                        playerFile.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        String object = YamlConfiguration.loadConfiguration(playerFile).getString("data");
                        Gson gson = new Gson();

                        if (!(object.isEmpty())) {
                            ItemsManager manager = gson.fromJson(object, ItemsManager.class);
                            UUID player = Bukkit.getPlayerExact(playerName).getUniqueId();
                            Main.cache.put(player, manager);
                        } else {
                            ItemsManager manager = new ItemsManager(playerName);
                            UUID player = Bukkit.getPlayerExact(playerName).getUniqueId();
                            Main.cache.put(player, manager);
                            savePlayer(manager);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });


    }
        }