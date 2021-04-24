package me.krymz0n.core.command;

import me.krymz0n.core.Main;
import me.krymz0n.core.util.Color;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Roof implements Listener {

    private final Main plugin;

    public Roof(Main plugin) {
        this.plugin = plugin;
        FileConfiguration config = plugin.getConfig();
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onCommandPreprocess(PlayerCommandPreprocessEvent e) {

        if (plugin.getConfig().getBoolean("Nether_Tp")) {

            if (e.getMessage().equalsIgnoreCase("/roof")) {
                Player p = e.getPlayer();

                if (p.hasPermission("roof.use")) {

                    if (p.getWorld().getEnvironment().equals(World.Environment.NETHER)) {
                        Location location = p.getLocation();

                        if (location.getBlockY() == 125) {
                            p.teleport(new Location(Bukkit.getWorld("world_nether"), location.getBlockX(), 128, location.getBlockZ()));
                            p.sendMessage(Color.chat(plugin.getConfig().getString("Tp_Complete_Message")));
                            System.out.println(Color.chat("&bTeleported &d" + p.getName() + " &bto nether roof!"));

                        } else {
                            p.sendMessage(Color.chat(plugin.getConfig().getString("Wrong_Y_Message")));
                        }

                    } else {
                        p.sendMessage(Color.chat(plugin.getConfig().getString("Wrong_World_Message")));
                    }

                } else {
                    p.sendMessage(Color.chat(plugin.getConfig().getString("Insufficient_Permissions_Message")));
                }
            }
        }
    }
}
