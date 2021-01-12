package net.codes;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class Main extends JavaPlugin implements Listener {

    public static HashMap<Player, ItemStack[]> menus = new HashMap<>();

    @Override
    public void onEnable() {
        getCommand("pv").setExecutor(new VaultCommand(this));
        this.getServer().getPluginManager().registerEvents(this, this);
        this.saveDefaultConfig();

        if (this.getConfig().contains("data"))
            this.restoreInvs();
    }

    @Override
    public void onDisable() {
        if (!menus.isEmpty()) {
            this.saveInvs();
        }
    }

    public void saveInvs() {
        for (Map.entry<String, ItemStack))
    }

    public void restoreInvs() {

    }

    @EventHandler
    public void onGUIClose(InventoryCloseEvent e) {
        if (e.getView().getTitle().contains(e.getPlayer().getName() + "'s Vault"))  {
            menus.put(e.getPlayer().getUniqueId().toString(), e.getInventory().getContents());
        }
    }
}
