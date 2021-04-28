package me.krymz0n.core.listener;

import me.krymz0n.core.Main;
import me.krymz0n.core.util.Color;
import me.krymz0n.core.util.Prefix;
import org.bukkit.Material;
import org.bukkit.block.Container;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;


public class Book implements Listener {
    private Main plugin;

    public Book(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onPlayerInteractEvent(PlayerInteractEvent evt) {
        Player p = evt.getPlayer();
        if (plugin.getConfig().getBoolean("Remove_Dupe_Books")) {
            if (evt.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (evt.getClickedBlock() != null) {
                    if (evt.getClickedBlock().getState() instanceof Container) {
                        for (ItemStack chestItem : ((Container) evt.getClickedBlock().getState()).getInventory().getContents()) {
                            if (chestItem != null) {
                                if (chestItem.getType() == Material.WRITTEN_BOOK) {
                                    BookMeta book = (BookMeta) chestItem.getItemMeta();
                                    if (book != null) {
                                        if (isDupeBook(book)) {
                                            ((Container) evt.getClickedBlock().getState()).getInventory().remove(chestItem);
                                            System.out.println(Color.chat(Prefix.p + "&dRemoved a Dupe Book"));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean isDupeBook(BookMeta book) {
        for (int size =45; book.getPageCount() > size; size++) {
                return true;
        }
            return false;
    }
}
