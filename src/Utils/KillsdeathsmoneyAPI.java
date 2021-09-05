package Utils;

import org.bukkit.entity.*;

import Main.*;

public class KillsdeathsmoneyAPI
{
    public static void addKill(final Player p, final int i) {
        final int Value = Main.getInstace().stats.getInt(p.getUniqueId() + ".Kills");
        Main.getInstace().stats.set(p.getUniqueId() + ".Kills", (Object)(Value + 1));
        Main.getInstace().save();
    }
    
    public static void addDeaths(final Player p, final int i) {
        final int Value = Main.getInstace().stats.getInt(p.getUniqueId() + ".Deaths");
        Main.getInstace().stats.set(p.getUniqueId() + ".Deaths", (Object)(Value + 1));
        Main.getInstace().save();
    }
    
    public static int getKills(final Player p) {
        return Main.getInstace().stats.getInt(p.getUniqueId() + ".Kills");
    }
    
    public static int getDeaths(final Player p) {
        return Main.getInstace().stats.getInt(p.getUniqueId() + ".Deaths");
    }
}
