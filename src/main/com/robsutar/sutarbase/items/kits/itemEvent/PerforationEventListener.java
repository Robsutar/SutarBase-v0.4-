package main.com.robsutar.sutarbase.items.kits.itemEvent;

import main.com.robsutar.sutarbase.items.kits.KitItemsManager;
import main.com.robsutar.sutarbase.items.kits.KitsMethods;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

import java.util.List;

public class PerforationEventListener implements Listener {
    @EventHandler
    public static void onEvent(PerforationEvent e){
        Player u = e.getUser();
        Entity t = e.getTarget();
        if (t!=null) {
            t.setVelocity(new Vector(0, 2, 0));
            BlockIterator iter = new BlockIterator(u, 2);
            Block lastBlock = iter.next();
            while (iter.hasNext()){
                lastBlock = iter.next();
            }
            u.setVelocity(new Vector(
                    lastBlock.getLocation().getX()/u.getLocation().getX(),
                    lastBlock.getLocation().getY()/u.getLocation().getY(),
                    lastBlock.getLocation().getZ()/u.getLocation().getZ()));
        }
    }
    @EventHandler
    public static void onItemUsed(PlayerInteractEvent e){
        if (e.getItem().getItemMeta().equals(KitItemsManager.perforation.getItemMeta())) {
            e.setCancelled(true);
            if (e.getAction()== Action.RIGHT_CLICK_AIR) {
                Player u = e.getPlayer();
                PerforationEvent event = new PerforationEvent(u);
                onEvent(event);
            }
        }
    }
}
