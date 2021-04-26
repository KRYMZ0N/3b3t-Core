package me.krymz0n.core.command;

import me.krymz0n.core.Main;
import me.krymz0n.core.util.Color;
import me.krymz0n.core.util.Prefix;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Command implements CommandExecutor, Listener {
    private final Main plugin;

    public Command(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (args[0].toLowerCase().startsWith("reload")) {
            if (sender.isOp() || (!(sender instanceof Player))) {
                plugin.reloadConfig();
                sender.sendMessage(Color.chat(Prefix.p + "&dConfig Reloaded!"));
                return true;
            } else {
                sender.sendMessage(Color.chat(plugin.getConfig().getString("Insufficient_Permissions_Message")));
            }
        }
        if (args[0].toLowerCase().startsWith("ver")) {
            sender.sendMessage(Color.chat(Prefix.p + "&b " + plugin.getDescription().getVersion()));
        }
        return false;
    }
}

