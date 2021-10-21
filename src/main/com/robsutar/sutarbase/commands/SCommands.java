package main.com.robsutar.sutarbase.commands;

import main.com.robsutar.sutarbase.SutarBase;
import main.com.robsutar.sutarbase.api.NickChanger;
import main.com.robsutar.sutarbase.api.ServerGuis;
import main.com.robsutar.sutarbase.files.KitsConfig;
import main.com.robsutar.sutarbase.files.PlayerConfig;
import main.com.robsutar.sutarbase.files.ServerConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SCommands implements CommandExecutor {
    private String commandError = SutarBase.WARNING + "O comando doi diditado incorretamente!" + SutarBase.CONVERSATION + " Siga o exemplo: " + ChatColor.BLUE;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("ssave")) {
            ServerConfig.save();
            PlayerConfig.save();
            KitsConfig.save();
            player.sendMessage(SutarBase.SUTARBASE + "Saving files...");
        } else if(cmd.getName().equalsIgnoreCase("ssetprefix")) {
            if(args.length == 3) {
                NickChanger.ssetprefix(args, player);
            } else {
                player.sendMessage(commandError + "/ssetprefix [jogador] [tag] [numero da cor]");
            }
        } else if(cmd.getName().equalsIgnoreCase("ssetnick")) {
            if(args.length == 2&&checkPlayerByString(args[0],player)!=null) {
                Player prefixplayer = checkPlayerByString(args[0], player);
                NickChanger.ssetnick(args[1], prefixplayer);
                prefixplayer.sendMessage(SutarBase.CONVERSATION + "Seu nick foi alterado!");
            } else {
                player.sendMessage(commandError + "/ssetnick [jogador] [nick]");
            }
        }
        else if (cmd.getName().equalsIgnoreCase("kit")){
            if(args.length == 1||args.length == 0) {
                Player setKit = player;
                if (args.length==1&&checkPlayerByString(args[0],player)!=null){
                    Player prefixplayer = checkPlayerByString(args[0], player);
                    setKit = checkPlayerByString(args[0],player);
                }
                player.sendMessage(SutarBase.CONVERSATION+"Escolha um kit!");
                ServerGuis.kitGui(setKit);
            } else {
                player.sendMessage(commandError + "/kit");
            }
        }
        return true;
    }

    private static Player checkPlayerByString(String s, Player sender) {
        try {
            if(Bukkit.getPlayer(s) == null) {
                sender.sendMessage(ChatColor.RED + "Jogador Inexistente");
                return null;
            } else {
                Player prefixplayer = Bukkit.getPlayer(s);
                return prefixplayer;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(SutarBase.ERROR);
            return null;
        }
    }
}

