package net.codes;

import org.apache.commons.lang.enums.EnumUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

public class RankCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = (Player) sender;

        if (player.isOp()) {
            if (args.length == 2) {
                if (Bukkit.getOfflinePlayer(args[0]).hasPlayedBefore()) {
                    if (EnumUtils.isValidEnum(Rank.class, args[1].toUpperCase(Locale.ROOT))) {
                        Main.getFileManager().setRank(Bukkit.getOfflinePlayer(args[0]).getUniqueId(), Rank.valueOf(args[1].toUpperCase(Locale.ROOT)));

                        player.sendMessage(ChatColor.GREEN + "You changed this rank!");

                        if (Bukkit.getOfflinePlayer(args[0]).isOnline()) {
                            Bukkit.getOfflinePlayer(args[0]).getPlayer().sendMessage(player.getName() + " just changed your rank to.");
                        }

                    }
                } else {
    player.sendMessage("They have never played before");

                }

            } else {
                System.out.println("Invalid Usage");
            }
        } else {
            player.sendMessage("No permission");
        }

        return false;
    }
}
