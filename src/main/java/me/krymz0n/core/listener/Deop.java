package me.krymz0n.core.listener;

import me.krymz0n.core.Main;
import me.krymz0n.core.util.Color;
import me.krymz0n.core.util.Prefix;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Deop implements Listener {
    private final Main plugin;

    public Deop(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent evt) {
        Player p = evt.getPlayer();
        if (plugin.getConfig().getBoolean("Deop_On_Leave")) {
            if (p.isOp()) {
                p.setOp(false);
                System.out.println(Color.chat(Prefix.p + "&dDeoped &b" + p.getName()));
            }
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent evt) {
        Player p = evt.getPlayer();
        if (plugin.getConfig().getBoolean("Deop_On_Leave")) {
            if (p.isOp()) {
                p.setOp(false);
                System.out.println(Color.chat(Prefix.p + "&dDeoped &b" + p.getName()));
            }
        }
    }

    @EventHandler
    public void onKick(PlayerKickEvent evt) {
        Player p = evt.getPlayer();
        if (plugin.getConfig().getBoolean("Deop_On_Leave")) {
            if (p.isOp()) {
                p.setOp(false);
                System.out.println(Color.chat(Prefix.p + "&dDeoped &b" + p.getName()));
            }
        }
    }
}
