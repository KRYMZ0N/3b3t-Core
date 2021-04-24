package me.krymz0n.core.listener;

import me.krymz0n.core.Main;
import me.krymz0n.core.util.Color;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Leave implements Listener {
    private final Main plugin;

    public Leave(Main plugin) {
        this.plugin = plugin;
        FileConfiguration config = plugin.getConfig();
    }
    private void onPlayerQuit(PlayerQuitEvent evt) {
        Player p = evt.getPlayer();
        evt.setQuitMessage(Color.chat(plugin.getConfig().getString("Leave").replace("<player>", p.getName())));
    }
}
