package main.com.robsutar.sutarbase.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.sql.Time;

public class ServerConfig {
    private static File file;
    private static FileConfiguration customFile;
    private static String path = "SutarShotter";

    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("SutarBase").getDataFolder(),"serverconfig.yml");
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
        ServerConfig.setup();
        ServerConfig.setDeffauts();
        ServerConfig.get().options().copyDefaults(true);
        ServerConfig.save();
    }

    public static void onServerDisable(){
        ServerConfig.save();
    }

    public static void setDeffauts() {
    }

    public static void addTick(){
        if (get().get((path+".timer"))==null){
            get().set((path+".timer"), 1);
        }
        else
            get().set((path+".timer"), getTick()+1);
    }

    public static int getTick(){
        if (get().get((path+".timer"))==null){
            addTick();
        }
        return (int)get().get((path+".timer"));}
    @SuppressWarnings("deprecation")
    public static Time getTime(){
        addTick();
        int totalSecs,sec,min,hour;
        int timer = getTick();
        totalSecs = timer/20;
        sec = totalSecs % 60;
        min = (totalSecs % 3600) / 60;
        hour = totalSecs / 3600;
        String smh = hour+":"+min+":"+ sec;
        Time time = new Time(hour,min,sec);
        return time;
    }
}
