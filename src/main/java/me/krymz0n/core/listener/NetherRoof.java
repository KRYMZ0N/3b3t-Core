package me.krymz0n.core.listener;

import me.krymz0n.core.Main;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class NetherRoof implements Listener {
    private final Main plugin;

    public NetherRoof(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onTeleport(PlayerTeleportEvent evt) {
        Player p = evt.getPlayer();
        if (plugin.getConfig().getBoolean("Prevent_Nether_Roof")) {
            if (p.getWorld().getEnvironment().equals(World.Environment.NETHER)) {
                if (!p.hasPermission("PreventRoof.bypass")) {
                    if (evt.getFrom().getY() < 128 && evt.getTo().getY() >= 128) {
                        evt.getPlayer().teleport(evt.getFrom());
                    }
                }
            }
        }
    }
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent evt) {
        Player p = evt.getPlayer();
        if (plugin.getConfig().getBoolean("Prevent_Nether_Roof")) {
            if (p.getWorld().getEnvironment().equals(World.Environment.NETHER)) {
                if (!p.hasPermission("PreventRoof.bypass")) {
                    if (evt.getTo().getY() >= 128) {
                        evt.getPlayer().teleport(new Location(evt.getPlayer().getWorld(), evt.getPlayer().getLocation().getX(), 120, evt.getPlayer().getLocation().getZ()));
                }
            }
        }

            if (evt.getPlayer().isInsideVehicle()) {
                if (evt.getPlayer().getWorld().getEnvironment().equals(World.Environment.NETHER)) {
                    if (plugin.getConfig().getBoolean("Prevent_Nether_Roof")) {
                        if (evt.getPlayer().getLocation().getY() > 127) {
                            evt.getPlayer().leaveVehicle();
                        }
                    }
                }
            }

            if (evt.getPlayer().isGliding()) {
                if (evt.getPlayer().getWorld().getEnvironment().equals(World.Environment.NETHER)) {
                    if (plugin.getConfig().getBoolean("Prevent_Nether_Roof")) {
                        if (evt.getPlayer().getLocation().getY() > 127) {
                            evt.getPlayer().setGliding(false);
                        }
                    }
                }
            }
        }
    }
}

