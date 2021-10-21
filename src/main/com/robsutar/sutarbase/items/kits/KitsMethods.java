package main.com.robsutar.sutarbase.items.kits;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.BoundingBox;

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
}
