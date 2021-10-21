package main.com.robsutar.sutarbase;

import main.com.robsutar.sutarbase.Timer.PlayerTimer;
import main.com.robsutar.sutarbase.api.NickChanger;
import main.com.robsutar.sutarbase.api.PlayerEvents;
import main.com.robsutar.sutarbase.api.ScoreboardPlayerEvents;
import main.com.robsutar.sutarbase.api.ServerEvents;
import main.com.robsutar.sutarbase.commands.SCommands;
import main.com.robsutar.sutarbase.files.PlayerConfig;
import main.com.robsutar.sutarbase.files.KitsConfig;
import main.com.robsutar.sutarbase.files.ServerConfig;
import main.com.robsutar.sutarbase.items.kits.KitItemsManager;
import main.com.robsutar.sutarbase.items.kits.itemEvent.FlameEventListener;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;


public class SutarBase extends JavaPlugin {

    public static final ChatColor NAMECOLOR = ChatColor.WHITE;
    public static final ChatColor CONVERSATIONCOLOR = ChatColor.AQUA;
    public static final ChatColor ALERT = ChatColor.YELLOW;
    public static final ChatColor WARNING = ChatColor.RED;
    public static final ChatColor CONGRATULATIONS = ChatColor.GREEN;

    public static final String SUTARBASE = ChatColor.GOLD + "[SutarBase] "+CONVERSATIONCOLOR;
    public static final String CONVERSATION = SUTARBASE + CONVERSATIONCOLOR;
    public static final String GOODCREDITS = ChatColor.GREEN + " is enabled, Robsutar sent a hug";
    public static final String BADCRETODS = ChatColor.RED + " Saving files... Robsutar send a bye";
    public static final String ERROR = ChatColor.RED+"Ocorreu um erro, lamentamos";

    @Override
    public void onEnable() {
        if (!getDataFolder().exists()){
            getDataFolder().mkdirs();
        }

        //Set Config -config.yml-
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        KitsConfig.onServerEnable();
        PlayerConfig.onServerEnable();
        ServerConfig.onServerEnable();

        SCommands commands = new SCommands();
        getCommand("ssetprefix").setExecutor(commands);
        getCommand("ssave").setExecutor(commands);
        getCommand("ssetnick").setExecutor(commands);
        getCommand("kit").setExecutor(commands);

        KitItemsManager.init();

        getServer().getPluginManager().registerEvents(new ScoreboardPlayerEvents(),this);
        getServer().getPluginManager().registerEvents(new PlayerTimer(),this);
        getServer().getPluginManager().registerEvents(new NickChanger(),this);
        getServer().getPluginManager().registerEvents(new PlayerEvents(),this);
        getServer().getPluginManager().registerEvents(new FlameEventListener(),this);

        ServerEvents.serverTicable();
        getServer().getConsoleSender().sendMessage(SUTARBASE+GOODCREDITS);
    }

    @Override
    public void onDisable() {
        KitsConfig.onServerDisable();
        PlayerConfig.onServerDisable();
        ServerConfig.onServerDisable();
        getServer().getConsoleSender().sendMessage(SUTARBASE+BADCRETODS);
    }
}
