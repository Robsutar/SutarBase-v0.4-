package main.com.robsutar.sutarbase.api;

import main.com.robsutar.sutarbase.SutarBase;
import main.com.robsutar.sutarbase.files.PlayerConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerEvents implements Listener {
    @EventHandler
    public void onPlayerJoins(PlayerJoinEvent e){
        Player p = e.getPlayer();
        NickChanger.updateNick(p);
        PlayerConfig.setTimer(p);
        Bukkit.getScheduler ().runTaskLater (SutarBase.getPlugin(SutarBase.class), () ->
                onPlayerTick(p), 60);
    }
    @EventHandler
    public void onPlayerSendMessage(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        e.setFormat(NickChanger.getNickAndSuffix(p)+ChatColor.GOLD+": "+ ChatColor.GRAY + e.getMessage());
    }
    public void onPlayerTick (Player p){
        if (p!=null) {

            Bukkit.getScheduler().runTaskLater(SutarBase.getPlugin(SutarBase.class), () ->
                    onPlayerTick(p), 20);
        }
    }
}
