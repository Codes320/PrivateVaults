package net.codes;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class DropListener implements Listener {

    private ItemsManager manager;
    private Main main;

    public DropListener() {
        this.manager = manager;
        this.main = main;
    }


    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        ItemStack hand = player.getItemInHand();

        if (manager.getItems().contains(hand)) {
            e.setCancelled(true);

            return;
        }




    }

}
