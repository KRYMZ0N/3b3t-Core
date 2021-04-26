package me.krymz0n.core.dupe.listener;

import me.krymz0n.core.Main;
import me.krymz0n.core.dupe.api.PDupeEvt;
import me.krymz0n.core.util.Color;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;

public class Interact implements Listener {
// not my original code, but I cleaned it up a bit, and I trust myself more than the original writer.
    private final Main plugin;

    public Interact(Main plugin) {
        this.plugin = plugin;
        FileConfiguration config = plugin.getConfig();
    }

    @EventHandler
    public void onVehicleEnter(PlayerInteractAtEntityEvent evt) {
        Player p = evt.getPlayer();
        if (evt.getRightClicked() instanceof Llama || evt.getRightClicked() instanceof Mule || evt.getRightClicked() instanceof Donkey) {
            if (p.getInventory().getItemInMainHand().getType() == Material.CHEST || (p.getInventory().getItemInOffHand().getType() == Material.CHEST)) {
                if (plugin.getConfig().getBoolean("Enable_Dupe")) {
                    if (p.hasPermission("core.dupe.use")) {
                        ChestedHorse entity = (ChestedHorse) evt.getRightClicked();
                        PDupeEvt dupeEvent = new PDupeEvt(evt.getPlayer(), entity.getLocation().getChunk());
                        Bukkit.getServer().getPluginManager().callEvent(dupeEvent);
                        if (!dupeEvent.isCancelled()) {
                            if (entity.getPassenger() == null) {
                                entity.setPassenger(evt.getPlayer());
                            }
                            evt.setCancelled(true);
                            for (ItemStack item : entity.getInventory().getContents()) {
                                if (item != null) {
                                    if (!(item.getType() == Material.SADDLE)) {
                                        entity.getWorld().dropItemNaturally(entity.getLocation(), item);
                                    }
                                }
                            }
                            entity.setCarryingChest(false);
                            p.sendMessage(Color.chat("&cChests on llamas, donkeys, mules, Etc is currently disabled, this is to facilitate the SalC1 TreeMC dupe"));
                        }
                    } else {
                        p.sendMessage(Color.chat(plugin.getConfig().getString("Insufficient_Permissions_Message")));
                    }
                }
            }
        }
    }
}
