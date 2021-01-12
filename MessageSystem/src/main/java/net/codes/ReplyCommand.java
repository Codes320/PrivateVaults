package net.codes;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReplyCommand implements CommandExecutor {

    private Main main;

    public ReplyCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = (Player) sender;

        if (main.getMessageManager().recentlyMessaged.containsKey(player)) {
            if (main.getMessageManager().recentlyMessaged.get(player) != null) {
                Player target = main.getMessageManager().recentlyMessaged.get(player);

                StringBuilder message = new StringBuilder();
                for (int i=1; i < args.length; i++) {
                    message.append(args[i]).append(" ");
                }



                player.sendMessage(ChatColor.GREEN + "-> " + target.getName() + ChatColor.GRAY + " " + message.toString());
                target.sendMessage(ChatColor.GREEN + "<- " + player.getName() + ChatColor.GRAY + "" + message.toString());

            }
        } else {
        }

        return false;
    }
}
