package me.krymz0n.core.listener;

import me.krymz0n.core.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

public class Wither implements Listener {

    private final Main plugin;

    public Wither(Main plugin) {
        this.plugin=plugin;
        FileConfiguration config = plugin.getConfig();
    }

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent e) {
        if (plugin.getConfig().getBoolean("Disable_Withers")) {
            String entity = e.getEntity().toString();
            if (entity.equals("CraftWitherSkull")) {
                e.setCancelled(true);
            }
        }
    }
}
