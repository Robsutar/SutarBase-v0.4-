package main.com.robsutar.sutarbase.items.kits.itemEvent;

import main.com.robsutar.sutarbase.items.kits.KitsMethods;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PerforationEvent extends Event {

    Player user;
    Entity target;

    public PerforationEvent(Player u){
        user = u;
        target = KitsMethods.getLookingEntity(u,7);
    }

    public Player getUser() {
        return user;
    }
    public Entity getTarget() {
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
