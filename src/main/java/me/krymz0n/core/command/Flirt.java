package me.krymz0n.core.command;

import me.krymz0n.core.Main;
import me.krymz0n.core.util.Color;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

import static org.bukkit.Bukkit.getServer;

public class Flirt implements CommandExecutor {

    private final Main plugin;

    public Flirt(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("flirt").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        Player p = (Player) sender;
        Random r = new Random();
        if (label.equalsIgnoreCase("flirt")) {
            if (p.hasPermission("flirt.use")) {
                if (sender instanceof Player) {
                    if (args.length == 1) {
                        Player target = getServer().getPlayer(args[0]);
                        p.sendMessage(Color.chat(plugin.getConfig().getString("Finish_Flirt").replace("<player>", target.getName())));
                        target.sendMessage(Color.chat(plugin.getConfig().getString("FLIRT")));
                        System.out.println(Color.chat(("&b" + p.getName() + " &dhas sent a flirt to &b" + target.getName())));

                    } else {
                        p.sendMessage(Color.chat(plugin.getConfig().getString("Flirt")));
                        System.out.println(Color.chat(("&b" + p.getName() + " &dhas sent a flirt to &bthemselves!")));
                    }
                } else {
                    p.sendMessage(Color.chat("&4This command can only be run by a player!"));
                    return true;
                }

            } else {
                p.sendMessage(Color.chat(plugin.getConfig().getString("Insufficient_Permissions_Message")));
                return true;
            }
        }
        return false;
    }
}

