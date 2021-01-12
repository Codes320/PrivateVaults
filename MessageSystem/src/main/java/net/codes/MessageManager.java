package net.codes;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class MessageManager {

    private Main main;

    public MessageManager(Main main) {
        this.main = main;
    }

    public HashMap<Player, Player> recentlyMessaged = new HashMap<>();

}
