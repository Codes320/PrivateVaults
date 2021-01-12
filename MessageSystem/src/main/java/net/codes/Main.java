package net.codes;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private MessageManager manager;

    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("message").setExecutor(new MessageCommand(this));
        getCommand("reply").setExecutor(new ReplyCommand(this));

        manager = new MessageManager(this);

    }

    public MessageManager getMessageManager() {
        return manager;
    }

}
