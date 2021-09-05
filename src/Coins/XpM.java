package Coins;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Main.Main;

public class XpM implements Listener {
	public static MyConfig PlayerMoney;
	public static int defaultmoney = 0;

	public static void loadMoneyManager() {
		PlayerMoney = Main.manager.getNewConfig("XP.yml");
	}

	public static int getPlayerMoney(Player p) {
		return PlayerMoney.getInt(p.getUniqueId().toString());
	}

	public static void addMoney(Player p, int add) {
		PlayerMoney.set(p.getUniqueId().toString(), Integer.valueOf(getPlayerMoney(p) + add));
		PlayerMoney.saveConfig();
	}

	public static void removeMoney(Player p, int remove) {
		PlayerMoney.set(p.getUniqueId().toString(), Integer.valueOf(getPlayerMoney(p) - remove));
		PlayerMoney.saveConfig();
	}
}
