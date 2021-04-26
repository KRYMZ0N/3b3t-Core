package me.krymz0n.core.dupe.listener;

import me.krymz0n.core.dupe.api.PDupeEvt;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public class DupeEvt implements Listener {

    @EventHandler
    public void onDupe(PDupeEvt evt) {
        ArrayList<Entity> items = new ArrayList<>();
        Player p = evt.getPlayer();
        for (Entity e : p.getLocation().getNearbyEntities(60, 60, 60)) {
            if (e.getType() == EntityType.DROPPED_ITEM) {
                items.add(e);
            }
        }
        while (items.size() > 50) {
            items.get(items.size() - 1).remove();
            items.remove(items.size() -1);
        }
    }
}
