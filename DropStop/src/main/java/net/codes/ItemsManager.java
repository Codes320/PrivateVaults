package net.codes;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ItemsManager {
    private List<ItemStack> items;

    public void PlayerItems() {
        this.items = new ArrayList<>();
    }

    public List<ItemStack> getItems() {
        return this.items;
    }

    public boolean checkIfBlocked(ItemStack item) {
        if (this.items.contains(item)) return true;
        return false;
    }

}
