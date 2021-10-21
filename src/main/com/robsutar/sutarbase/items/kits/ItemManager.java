package main.com.robsutar.sutarbase.items.kits;

import main.com.robsutar.sutarbase.files.KitsConfig;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    public static ItemStack rain = new ItemStack(Material.WARPED_HYPHAE);
    public static ItemStack flame = new ItemStack(Material.FIRE_CHARGE);

    public static void init(){
        createKit("Rain",ChatColor.BLUE,rain);
        createKit("Flame",ChatColor.GOLD,flame);
    }

    public static void createKit(String n, ChatColor c,ItemStack i){
        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(c+n);
        List<String> lore = new ArrayList<>();
        String[] lorePath = (KitsConfig.get().getString(n+".lore")).split(" ");
        String[] loreLines = new String[lorePath.length];
        int j=0;
        for (int k = 0; k <lorePath.length; k++) {
            loreLines[k]="";
            while (loreLines[k].length()<22){
                if (lorePath.length<=j){break;}
                loreLines[k]+=" "+lorePath[j];
                j++;
            }
            if (loreLines[k]==""){break;}
            lore.add(ChatColor.WHITE+loreLines[k]);
        }
        meta.setLore(lore);
        i.setItemMeta(meta);
    }
}
