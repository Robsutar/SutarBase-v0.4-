package main.com.robsutar.sutarbase.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class KitsConfig {
    private static File file;
    private static FileConfiguration customFile;

    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("SutarBase").getDataFolder(),"kitsconfig.yml");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e){ System.out.println("método: setup");e.printStackTrace();}
        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return customFile;
    }

    public static void save(){
        try {
            customFile.save(file);
        }catch (IOException e){ System.out.println("Não foi possível salvar: método: save");e.printStackTrace();}
    }

    public static void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public static void onServerEnable (){
        KitsConfig.setup();
        KitsConfig.setDeffauts();
        KitsConfig.get().options().copyDefaults(true);
        KitsConfig.save();
    }

    public static void onServerDisable(){
        KitsConfig.save();
    }

    public static void setDeffauts() {
        get().addDefault("Rain.lore","Atira flechas de água no inimigo causando dano e lentidão");
        get().addDefault("Flame.lore","Acerta o inimigo com uma bola flamejante por baixo do inimigo");
        get().addDefault("Perforation.lore","Atravessa o inimigo causando dano e jogando-o para cima");
    }
}
