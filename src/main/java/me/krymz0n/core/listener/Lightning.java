package me.krymz0n.core.listener;

import me.krymz0n.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.LightningStrike;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.LightningStrikeEvent;

public class Lightning implements Listener {

    private final Main plugin;

    public Lightning(Main plugin) {
        this.plugin=plugin;
        FileConfiguration config = plugin.getConfig();
    }
    @EventHandler
    public void onLightningStrike(LightningStrikeEvent evt) {
        if (plugin.getConfig().getBoolean("ThunderHackPatch")) {
            LightningStrike strike = evt.getLightning();
            World w = evt.getWorld();
            strike.setSilent(true);
            w.playSound(Thunder(), Sound.ENTITY_LIGHTNING_THUNDER, 1.0f, 1.0f);
        }
    }
    private Location Thunder() {
        return new Location(Bukkit.getServer().getWorld("world"), 0, 90, 0);
    }
}
