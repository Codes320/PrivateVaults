package com.codes.commands;

import com.codes.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class VaultCommand implements CommandExecutor {

    private Main main;

    public VaultCommand(Main main) {
        this.main = main;
    }

    UUID playerUUID;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {



        if (command.getName().equalsIgnoreCase("pv")) {

            if (!(sender instanceof Player)) {
                System.out.println(ChatColor.RED + "You must be a player to use that command!");
                return true;
            }

                Player player = (Player) sender;
                playerUUID = player.getUniqueId();

//                if (args.length == 1) {
//                    int i = Integer.parseInt(args[0]);
                    main.getStorageManager().initiateFiles();
                    player.sendMessage("UUID Generated");

                }

                if (args.length == 2) {

//                }

        }
            return false;
    }

    public UUID getPlayerUUID() { return playerUUID; }

}
