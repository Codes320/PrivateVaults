package net.codes;

import org.bukkit.Material;

import java.util.HashSet;
import java.util.Set;

public class ItemsManager {

    private String playerUUID;

    private Set<Material> items;

    public ItemsManager (String playerData) {
        this.items = new HashSet<>();
        this.playerUUID = playerData;
    }

    public String getPlayerUUID() {
        return playerUUID;
    }

    public void setItems(Set<Material> items) {
        this.items = items;
    }

    public Set<Material> getItems() {
        return this.items;
    }

    public boolean checkIfBlocked(Material item) {
        if (this.items.contains(item)) return true;
        return false;
    }

}
