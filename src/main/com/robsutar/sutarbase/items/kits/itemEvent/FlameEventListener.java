package main.com.robsutar.sutarbase.items.kits.itemEvent;

import main.com.robsutar.sutarbase.items.kits.ItemManager;
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

import java.util.List;

public class FlameEventListener implements Listener {
    @EventHandler
    public static void onEvent(FlameEvent e){
        Player p = e.getPlayer();
        World w = p.getWorld();
        Location l = p.getLocation();

        Location loc = KitsMethods.getTargetBlock(p,5);
        loc.getWorld().playEffect(loc, Effect.MOBSPAWNER_FLAMES,50,50);
        List<Entity> near = (List<Entity>) loc.getWorld().getNearbyEntities(loc, 1, 1, 1);
        for(Entity entity : near) {
            if(entity instanceof Player) {
                Player nearPlayer = (Player) entity;
                if (nearPlayer!=p) {
                    w.createExplosion(nearPlayer.getLocation(), 2, false,false,p);
                }
            } else if (entity instanceof LivingEntity){
                LivingEntity nearEntity = (LivingEntity) entity;
                w.createExplosion(nearEntity.getLocation(),2,false,false,p);
            }
        }
    }
    @EventHandler
    public static void onItemUsed(PlayerInteractEvent e){
        if (e.getItem().getItemMeta().equals(ItemManager.flame.getItemMeta())) {
            e.setCancelled(true);
            if (e.getAction()== Action.RIGHT_CLICK_AIR) {
                Player p = e.getPlayer();
                FlameEvent flameEvent = new FlameEvent(p);
                onEvent(flameEvent);
            }
        }
    }
}
