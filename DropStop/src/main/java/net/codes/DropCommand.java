package net.codes;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DropCommand implements CommandExecutor {

    private final Main core;

    public DropCommand(Main core) {
        this.core = core;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("lockitem")) {

            if(!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "You're not a player...");
                return true;
            }

            Player player = (Player) sender;

            if(!player.hasPermission("dropstop.use")) {
                sender.sendMessage(ChatColor.RED + "You don't have permission...");
                return true;
            }


            Material hand = player.getInventory().getItemInMainHand().getType();

            if (player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                player.sendMessage(ChatColor.RED + "You must be holding an item to use this command!");
                return true;
            }

            if(!core.getCache().containsKey(player.getUniqueId())) {
                core.getCache().put(player.getUniqueId(), new ItemsManager());
            }

            ItemsManager manager = core.getCache().get(player.getUniqueId());

            if(manager.checkIfBlocked(hand) == true) {
                manager.getItems().remove(hand);
                player.sendMessage(ChatColor.GREEN + "Item has been removed from your lock list!");
            } else {
                manager.getItems().add(hand);
                player.sendMessage(ChatColor.GREEN + "Item has been added to your lock list");
            }
        }

        return false;
    }
}


