package me.krymz0n.core.command;

import me.krymz0n.core.Main;
import me.krymz0n.core.util.Color;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Tps implements Listener {

    private final Main plugin;

    public Tps(Main plugin) {
        this.plugin = plugin;
        FileConfiguration config = plugin.getConfig();
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onCommandPreprocess(PlayerCommandPreprocessEvent e) {
        double ticks = Bukkit.getServer().getTPS()[0];
        double TickRound = Math.round(ticks*100.0)/100.0;
        Player p = e.getPlayer();
        if (e.getMessage().equalsIgnoreCase("/ticks")) {
            p.sendMessage(Color.chat("&bThe Current TPS is: &d" + TickRound));
        }
    }
}

