package main.com.robsutar.sutarbase.files;

import main.com.robsutar.sutarbase.SutarBase;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PlayerConfig {
    private static File file;
    private static FileConfiguration customFile;

    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("SutarBase").getDataFolder(),"playerconfig.yml");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e){ System.out.println(PlayerConfig.get()+"método: setup");e.printStackTrace();}
        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return customFile;
    }

    public static void save(){
        try {
            customFile.save(file);
        }catch (IOException e){ System.out.println(PlayerConfig.get()+"Não foi possível salvar: método: save");e.printStackTrace();}
    }

    public static void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public static void onServerEnable (){
        PlayerConfig.setup();
        PlayerConfig.setDeffauts();
        PlayerConfig.get().options().copyDefaults(true);
        PlayerConfig.save();
    }

    public static void onServerDisable(){
        PlayerConfig.save();
    }

    public static void setDeffauts() {
    }

    public static void setNick(Player player, String n){
        get().set((player.getUniqueId().toString()+".nick"), n);
    }

    public static String getNick(Player player){
        if (get().get((player.getUniqueId().toString()+".nick"))==null){
            setNick(player,player.getName());
        }
        return String.valueOf(get().get((player.getUniqueId().toString()+".nick")));}

    public static void setTimer(Player player){
        if (get().get((player.getUniqueId().toString()+".timer"))==null){
            get().set((player.getUniqueId().toString()+".timer"), 1);
        }
        else
            get().set((player.getUniqueId().toString()+".timer"), getTimer(player)+1);
    }

    public static int getTimer(Player player){
        if (get().get((player.getUniqueId().toString()+".timer"))==null){
            setTimer(player);
        }
        return (int)get().get((player.getUniqueId().toString()+".timer"));}

    public static void setPrefix(Player player, String args){
        get().set((player.getUniqueId().toString()+".preffix"), args);
    }

    public static String getPrefix(Player player){
        if (get().get((player.getUniqueId().toString()+".preffix"))==null){
            setPrefix(player, "");
        }
        return String.valueOf(get().get((player.getUniqueId().toString()+".preffix")));
    }
}
