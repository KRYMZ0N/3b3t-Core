package me.krymz0n.core.command;

import me.krymz0n.core.Main;
import me.krymz0n.core.util.Color;
import me.krymz0n.core.util.Prefix;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class Coords implements CommandExecutor {
    private final Main plugin;

    public Coords(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("coords").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        Player p = (Player) sender;
        double x = p.getLocation().getX();
        double y = p.getLocation().getY();
        double z = p.getLocation().getZ();
        if (label.equalsIgnoreCase("coords")) {
            if (p.hasPermission("Coords.use") || p.isOp() || (!(sender instanceof Player))) {
                if (args.length == 1) {
                    Player target = getServer().getPlayer(args[0]);
                    p.sendMessage(Color.chat(Prefix.p + "&d" + target.getName() + "'s current coordinates are: &b" + x + ", " + y + ", " + z));

                } else {
                    p.sendMessage(Color.chat(plugin.getConfig().getString("&4Lacking arguments, try /coords <player>")));
                }
            } else {
                p.sendMessage(Color.chat(plugin.getConfig().getString("Insufficient_Permissions_Message")));
                return true;
            }
        }
        return false;
    }
}


