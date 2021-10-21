package main.com.robsutar.sutarbase.api;

import org.bukkit.event.Listener;

public class ScoreboardPlayerEvents implements Listener {

    /*

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        try {
            createScoreboard(e.getPlayer());
            updateScoreboard();
        } catch (NullPointerException exception){
            System.out.println(ChatColor.RED+"ScrPlauerEvents playerjoin null error");
        }

    }

    @EventHandler
    public void onPlayerLeaves(PlayerQuitEvent e){
        //updateScoreboard();
    }

    @SuppressWarnings("deprecation")

    public static void createScoreboard(Player p){
        if (p!=null){
            ScoreboardManager manager = Bukkit.getScoreboardManager();
            Scoreboard board = manager.getNewScoreboard();

            //Objective objective = board.registerNewObjective("Stats","dummy");
            //objective.setDisplayName(ChatColor.RED+"❤"+ChatColor.WHITE+String.valueOf(p.getHealth()));
            //objective.setDisplaySlot(DisplaySlot.BELOW_NAME);

            //Team dev = board.registerNewTeam("dev");
            //dev.addPlayer(p);
            //dev.setPrefix(SutarBase.playerData.getPrefix(p));
            //dev.setNameTagVisibility(NameTagVisibility.ALWAYS);
            //dev.setSuffix(PlayerTimer.getTimer(p));
            //p.setPlayerListName(dev.getPrefix()+SutarBase.NAMECOLOR+p.getName()+PlayerTimer.getTimer(p));

            p.setScoreboard(board);
        }
    }



    public static void updateScoreboard() {
        for (Player online : Bukkit.getOnlinePlayers()){
            Score score = online.getScoreboard().getObjective(DisplaySlot.PLAYER_LIST).getScore("players");
            score.setScore(Bukkit.getOnlinePlayers().size());
        }
    }
    */

}
