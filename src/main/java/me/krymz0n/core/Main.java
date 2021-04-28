package me.krymz0n.core;

import me.krymz0n.core.command.*;
import me.krymz0n.core.dupe.listener.DupeEvt;
import me.krymz0n.core.dupe.listener.Interact;
import me.krymz0n.core.listener.*;

import me.krymz0n.core.util.Color;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        System.out.println(Color.chat("&6Enabling 3b3t Core by KRYMZ0N!"));
        saveDefaultConfig();
        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(this, this);
        pm.registerEvents(new Roof(this), this);
        pm.registerEvents(new Join(this), this);
        pm.registerEvents(new Leave(this), this);
        pm.registerEvents(new Wither(this), this);
        pm.registerEvents(new Kill(this), this);
        pm.registerEvents(new Discord(this), this);
        pm.registerEvents(new Help(this), this);
        pm.registerEvents(new Lightning(this), this);
        pm.registerEvents(new Tps(this), this);
        pm.registerEvents(new Interact(this), this);
        pm.registerEvents(new DupeEvt(), this);
        pm.registerEvents(new Command(this), this);
        pm.registerEvents(new Book(this), this);
        //Other registrations
        new Flirt(this);
        getCommand("3b3t").setExecutor(new Command(this));
      }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
