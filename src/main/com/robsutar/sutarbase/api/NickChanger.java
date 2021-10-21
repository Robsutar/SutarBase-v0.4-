package main.com.robsutar.sutarbase.api;

import main.com.robsutar.sutarbase.SutarBase;
import main.com.robsutar.sutarbase.files.PlayerConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.inventivetalent.nicknamer.api.NickNamerAPI;


public class NickChanger implements Listener {
        public static void updateNick(Player player){
        NickNamerAPI.getNickManager().setNick(player.getUniqueId(),getNickAndSuffix(player));
    }

    public static void ssetnick(String nick, Player player) {
        if (player!=null&&nick!=null) {
            PlayerConfig.setNick(player, nick);
            updateNick(player);
        }
    }

    public static void ssetprefix(String[] args,Player player) {
        Player prefixPlayer = Bukkit.getPlayer(args[0]);
        if(prefixPlayer == null) {
            player.sendMessage(ChatColor.RED + "Jogador Inexistente");
        } else {
            ChatColor prefixColor = ChatColor.getByChar(args[2]);
            String prefix = "";
            if(String.valueOf(prefixColor) == "null") {
                player.sendMessage(SutarBase.CONGRATULATIONS + "Colorize!");
                prefix = args[1] + " ";
            } else {
                prefix = ChatColor.getByChar(args[2]) + args[1] + " ";
            }
            player.sendMessage(SutarBase.CONVERSATION + "Jogador: " + SutarBase.WARNING + prefixPlayer.getName() + ChatColor.getByChar("a") + " prefixo: " + prefix);
            PlayerConfig.setPrefix(prefixPlayer, prefix);
            updateNick(player);
        }
    }

    public static String getNickAndSuffix(Player player){ return PlayerConfig.getPrefix(player) + SutarBase.NAMECOLOR + PlayerConfig.getNick(player);
    }
}
