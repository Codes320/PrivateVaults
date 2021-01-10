package net.codes;

import org.bukkit.ChatColor;

public enum Rank {

    OWNER("Owner", ChatColor.RED),
    ADMIN("Admin", ChatColor.DARK_RED),
    MEMBER("Member", ChatColor.WHITE),
    GUEST("Guest", ChatColor.GRAY);

    private String name;
    private ChatColor color;

    private Rank(String name, ChatColor color) {
        this.name = name;
        this.color = color;

    }

    public String getName() { return name; }
    public ChatColor getColor() { return color; }

}
