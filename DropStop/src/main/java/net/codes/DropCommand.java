package net.codes;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DropCommand implements CommandExecutor {

    private ItemsManager manager;

    public DropCommand(ItemsManager manager) {
        this.manager = manager;
    }

    @Override public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = (Player) sender;

        if (!(sender instanceof Player)) {
            sender.sendMessage("This command is avaliable for players only!");
        } else if (player.getItemInHand().getType().equals(null)) {
            player.sendMessage(ChatColor.RED + "You must be holding an item to use that command.");
        } else if (!player.hasPermission("dropstop.use")) {
            player.sendMessage(ChatColor.RED + "You don't have permission to use that command!");
        } else if (manager.checkIfBlocked() == true) {
            player.sendMessage(ChatColor.GREEN + "Item has been removed from your locked list.");
            manager.getItems().remove(player.getItemInHand());
        } else {
            player.sendMessage(ChatColor.GREEN + "Item has been locked in your inventory.");
            manager.getItems().add(player.getItemInHand());
        }

        return false;
    }
}
