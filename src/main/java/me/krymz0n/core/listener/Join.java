package me.krymz0n.core.listener;

import me.krymz0n.core.Main;
import me.krymz0n.core.util.Color;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    private final Main plugin;

    public Join(Main plugin) {
        this.plugin = plugin;
        FileConfiguration config = plugin.getConfig();
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    private void onPlayerJoin(PlayerJoinEvent evt) {
        Player p = evt.getPlayer();

        if (!p.hasPlayedBefore()) {
            evt.setJoinMessage(Color.chat(plugin.getConfig().getString("FirstJoin").replace("<player>", p.getName())));
        }else{
            evt.setJoinMessage(Color.chat(plugin.getConfig().getString("Join").replace("<player>", p.getName())));
        }
    }
}
