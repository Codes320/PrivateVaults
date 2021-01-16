package net.codes;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class DropListener implements Listener {
    private Main main;

    public DropListener(Main max) {
        this.main = max;
    }


    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        ItemStack hand = e.getItemDrop().getItemStack();
        ItemsManager manager = Main.cache.get(player.getUniqueId());
        for (ItemStack item : manager.getItems()) {
            if (e.getItemDrop().getItemStack() == item) {
                player.getInventory().setItemInMainHand(e.getItemDrop().getItemStack());
                e.getItemDrop().remove();
                e.setCancelled(true);
                player.sendMessage("Event 1 Triggered");
                return;
            }
            if (e.getItemDrop().getItemStack().equals(item)) {
                player.getInventory().setItemInMainHand(e.getItemDrop().getItemStack());
                e.getItemDrop().remove();
                e.setCancelled(true);
                player.sendMessage("Event 2 Triggered");
                return;
            }
        }
    }
}