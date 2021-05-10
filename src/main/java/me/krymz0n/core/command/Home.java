package me.krymz0n.core.command;

import me.krymz0n.core.Main;
import me.krymz0n.core.util.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.awt.*;

public class Home implements Listener {
    private final Main plugin;

    public Home(Main plugin) {
        this.plugin = plugin;
    }
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onCommandPreprocess(PlayerCommandPreprocessEvent evt) {
        Player p = evt.getPlayer();
        if (evt.getMessage().toLowerCase().startsWith("/home ") || evt.getMessage().equalsIgnoreCase("/home")) {
            System.out.println("test1");
            if (plugin.getConfig().getBoolean("75k_to_home")) {
                System.out.println("test2");
                Point p1 = new Point(p.getLocation().getBlockX(), p.getLocation().getBlockZ());
                Point p2 = new Point(0, 0);
                if (p1.distance(p2) < 75000) {
                    System.out.println("test3");
                    p.sendMessage(Color.chat("&cYou must be 75k blocks from spawn to use this command!"));
                    evt.setCancelled(true);
                }
            }
        }
    }
}
