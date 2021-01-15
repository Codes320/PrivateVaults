package net.codes;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DropCommand implements CommandExecutor {

    private Main manager;

    public DropCommand(Main manager) {
        this.manager = manager;
    }

    @Override public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = (Player) sender;
        ItemStack hand = player.getInventory().getItemInMainHand();

        if (!(manager.cache.containsKey(player.getUniqueId()))) {
            ItemsManager itmanager = new ItemsManager();
            manager.cache.put(player.getUniqueId(),itmanager);
        }
        ItemsManager itmanager = manager.cache.get(player.getUniqueId());

        if (!(sender instanceof Player)) {
            sender.sendMessage("This command is avaliable for players only!");
        } else if (hand == null) {
            player.sendMessage(ChatColor.RED + "You must be holding an item to use that command.");
        } else if (!player.hasPermission("dropstop.use")) {
            player.sendMessage(ChatColor.RED + "You don't have permission to use that command!");
        } else if (itmanager.getItems().contains(hand)) {
            player.sendMessage(ChatColor.GREEN + "Item has been removed from your locked list.");
            itmanager.getItems().remove(player.getInventory().getItemInMainHand());
        } else {
            player.sendMessage(ChatColor.GREEN + "Item has been locked in your inventory.");
            itmanager.getItems().add(player.getInventory().getItemInMainHand());
        }

        return false;
    }
}
