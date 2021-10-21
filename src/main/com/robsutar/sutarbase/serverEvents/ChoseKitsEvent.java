package main.com.robsutar.sutarbase.serverEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ChoseKitsEvent extends Event {

    Player player;

    public ChoseKitsEvent(Player p){
        p = player;
    }

    public Player getPlayer() {
        return player;
    }

    private static final HandlerList handlers = new HandlerList();
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
