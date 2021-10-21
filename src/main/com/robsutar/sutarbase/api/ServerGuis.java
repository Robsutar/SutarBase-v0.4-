package main.com.robsutar.sutarbase.api;

import main.com.robsutar.sutarbase.SutarBase;
import main.com.robsutar.sutarbase.items.kits.KitItemsManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ServerGuis {
    public static void kitGui(Player player) {
        ItemStack diamond =  new ItemStack(Material.DIAMOND);
        ItemStack redstone =  new ItemStack(Material.REDSTONE);
        ItemStack air =  new ItemStack(Material.AIR);
        Inventory inv = Bukkit.createInventory(null, 27, SutarBase.CONVERSATION +"Kits");
        inv.setItem(0, KitItemsManager.rain);
        inv.setItem(1, KitItemsManager.flame);
        inv.setItem(2, KitItemsManager.perforation);
        player.openInventory(inv);
    }
}
