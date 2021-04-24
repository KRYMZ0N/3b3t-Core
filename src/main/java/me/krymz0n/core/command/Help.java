package me.krymz0n.core.command;

import me.krymz0n.core.Main;
import me.krymz0n.core.util.Color;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Help implements Listener {

    private final Main plugin;

    public Help(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onCommandPreprocess(PlayerCommandPreprocessEvent evt) {
        Player p = evt.getPlayer();
        FileConfiguration config = plugin.getConfig();
        if(evt.getMessage().equalsIgnoreCase("/help")) {
            config.getList("Help").forEach(b -> p.sendMessage(Color.chat((String) b)));
        }
    }
}

