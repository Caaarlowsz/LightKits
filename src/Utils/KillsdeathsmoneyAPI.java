package Utils;

import org.bukkit.entity.Player;

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;

public class KillsdeathsmoneyAPI {
	public static void addKill(final Player p, final int i) {
		final int Value = LightPvP.getInstace().stats.getInt(p.getUniqueId() + ".Kills");
		LightPvP.getInstace().stats.set(p.getUniqueId() + ".Kills", (Object) (Value + 1));
		LightPvP.getInstace().save();
	}

	public static void addDeaths(final Player p, final int i) {
		final int Value = LightPvP.getInstace().stats.getInt(p.getUniqueId() + ".Deaths");
		LightPvP.getInstace().stats.set(p.getUniqueId() + ".Deaths", (Object) (Value + 1));
		LightPvP.getInstace().save();
	}

	public static int getKills(final Player p) {
		return LightPvP.getInstace().stats.getInt(p.getUniqueId() + ".Kills");
	}

	public static int getDeaths(final Player p) {
		return LightPvP.getInstace().stats.getInt(p.getUniqueId() + ".Deaths");
	}
}
