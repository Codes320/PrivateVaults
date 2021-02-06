package net.codes;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import java.util.UUID;

public class DropListener implements Listener {

    private Main main;

    public DropListener(Main main) {
        this.main = main;
    }


    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {

        Player player = e.getPlayer();
        String hand = e.getItemDrop().getItemStack().getType().toString();
        UUID playerUUID = player.getUniqueId();
        String dropMessage = main.getConfig().getString("DropMessage");


        if (main.getCache().get(playerUUID).contains(hand)) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', dropMessage));
        }
    }
}
