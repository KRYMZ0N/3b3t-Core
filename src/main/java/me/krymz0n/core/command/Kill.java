package me.krymz0n.core.command;

import me.krymz0n.core.Main;
import me.krymz0n.core.util.Color;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Kill implements Listener {

    private final Main plugin;

    public Kill(Main plugin) {
        this.plugin = plugin;
        FileConfiguration config = plugin.getConfig();
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onCommandPreprocess(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        if (e.getMessage().equalsIgnoreCase("/kill")) {
            if (p.hasPermission("kill.use")) {
                p.setHealth(0.0D);
            }else {
                p.sendMessage(Color.chat(plugin.getConfig().getString("Insufficient_Permissions")));
            }
        }
    }
}
