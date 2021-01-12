package net.codes;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class VaultCommand implements CommandExecutor {

    private Main main;

    public VaultCommand(Main main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        if(label.equals("pv")) {
            if(!(sender instanceof Player)) {
                System.out.println("No");
                return true;

            }
            Player player = (Player) sender;
            Inventory inv = Bukkit.createInventory(player, 54, player.getName() + "'s Vault");


            if (Main.menus.containsKey(player.getUniqueId().toString())) {

                inv.setContents(Main.menus.get(player.getUniqueId().toString()));
                player.openInventory(inv);
                return true;
            }
            return false;
        }

        return false;
    }
}
