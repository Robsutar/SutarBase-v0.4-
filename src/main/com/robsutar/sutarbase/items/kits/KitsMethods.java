package main.com.robsutar.sutarbase.items.kits;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import java.util.List;

public class KitsMethods {
    public static final Location getTargetBlock(Player player, int range) {
        BlockIterator iter = new BlockIterator(player, range);

        Block lastBlock = iter.next();

        while (iter.hasNext()) {

            lastBlock = iter.next();
            if (lastBlock.getType() == Material.AIR) {
                continue;
            }
            break;
        }
        Location loc = lastBlock.getLocation();
        return loc;
    }

    public static final Entity getLookingEntity(Player player, int range){

        BlockIterator iter = new BlockIterator(player, range);

        Block lastBlock = iter.next();
        Location loc = lastBlock.getLocation();
        Entity finalEntity = null;

        outerloop : while (iter.hasNext()) {
            lastBlock = iter.next();
            loc = lastBlock.getLocation();
            loc.getWorld().playEffect(loc, Effect.MOBSPAWNER_FLAMES,50,50);
            if (lastBlock.getType() == Material.AIR) {
                List<Entity> near = (List<Entity>) loc.getWorld().getNearbyEntities(loc, 1, 1, 1);
                for(Entity entity : near) {
                    if (entity instanceof LivingEntity){
                        if (entity!=player) {
                            loc.getWorld().playEffect(loc, Effect.END_GATEWAY_SPAWN,50,50);
                            finalEntity = entity;
                            break outerloop;
                        }
                    }
                }
                continue;
            }
            break;
        }
        loc = lastBlock.getLocation();
        return finalEntity;
    }
}
