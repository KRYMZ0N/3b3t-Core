package me.krymz0n.core.dupe.api;

import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public final class PDupeEvt extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    //stuff
    Player p;
    Chunk c;

    public Player getPlayer() {
        return p;
    }
    public Chunk getChunk() {
        return c;
    }
    private boolean cancelled;

    public PDupeEvt(Player p, Chunk c) {
        this.p = p;
        this.c = c;
    }
    public boolean isCancelled() {
        return cancelled;
    }
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
