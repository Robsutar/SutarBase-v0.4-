package main.com.robsutar.sutarbase.api;

import main.com.robsutar.sutarbase.SutarBase;
import main.com.robsutar.sutarbase.serverEvents.ChoseKitsEvent;
import main.com.robsutar.sutarbase.serverEvents.ServerTickEvent;
import main.com.robsutar.sutarbase.files.ServerConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

public class ServerEvents {
    @EventHandler
    public static void onServerTick(ServerTickEvent e){
        int WaitMessageTime = 5;
        ServerConfig.addTick();
        if ((ServerConfig.getTick()*20)%(3600*WaitMessageTime)==0){
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage(SutarBase.CONVERSATION+"Olá, o servidor está aberto por: "+ServerConfig.getTime()+" "+ ChatColor.RED+ServerConfig.getTick());
            }
        }
    }

    public static void serverTicable(){
        if (SutarBase.getProvidingPlugin(SutarBase.class).isEnabled()){
            ServerTickEvent tickEvents = new ServerTickEvent();
            onServerTick(tickEvents);
            Bukkit.getScheduler ().runTaskLater (SutarBase.getPlugin(SutarBase.class), ServerEvents::serverTicable, 1);
        }
    }

    @EventHandler
    public static void onPlayerChoseKit(ChoseKitsEvent e){
        Player p = e.getPlayer();
        ServerGuis.kitGui(p);
    }
}
