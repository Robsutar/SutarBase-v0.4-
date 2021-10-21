package main.com.robsutar.sutarbase.Timer;

import main.com.robsutar.sutarbase.SutarBase;
import main.com.robsutar.sutarbase.files.PlayerConfig;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerTimer implements Listener {
    @EventHandler
    public static void onPlayerMoves(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        PlayerConfig.setTimer(player);
        if (PlayerConfig.getTimer(player)%20==0){
            //ScoreboardPlayerEvents.createScoreboard(player);
        }
    }

    public static String getTimer(Player p){
        int totalSecs,sec,min,hour;
        int timer = PlayerConfig.getTimer(p);
        totalSecs = timer/20;
        sec = totalSecs % 60;
        min = (totalSecs % 3600) / 60;
        hour = totalSecs / 3600;
        String smh = hour+":"+min+":"+ sec;
        return " "+ChatColor.GOLD+smh;
    }
}
