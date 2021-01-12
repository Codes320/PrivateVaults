package net.codes;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropListener implements Listener {

    private ItemsManager manager;

    public DropListener(ItemsManager manager) {
        this.manager = manager;

    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {


    }

}
