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
        Location loc= lastBlock.getLocation();

        while (iter.hasNext()) {

            lastBlock = iter.next();
            loc= lastBlock.getLocation();

            if (lastBlock.getType() == Material.AIR) {
                continue;
            }
            break;
        }
        loc = lastBlock.getLocation();
        return loc;
    }
}
