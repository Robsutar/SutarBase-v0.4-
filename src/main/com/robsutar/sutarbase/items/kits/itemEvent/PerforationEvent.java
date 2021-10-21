package main.com.robsutar.sutarbase.items.kits.itemEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PerforationEvent extends Event {

    Player user;
    Player target;

    public PerforationEvent(Player u,Player t){
        user = u;target =t;
    }

    public Player getUser() {
        return user;
    }
    public Player getTarget() {
        return target;
    }

    private static final HandlerList handlers = new HandlerList();
    static public HandlerList getHandlerList() {
        return handlers;
    }
    public HandlerList getHandlers() {
        return handlers;
    }
}
