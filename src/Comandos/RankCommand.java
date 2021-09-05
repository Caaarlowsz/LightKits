package Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class RankCommand implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender Sender, final Command cmd, final String string, final String[] args) {
		final Player p = (Player) Sender;
		if (cmd.getName().equalsIgnoreCase("ranks")) {
			p.sendMessage("  ");
			p.sendMessage("        §5§lRa§a§lnk        ");
			p.sendMessage("  ");
			p.sendMessage("§6» §7(§7⚊§7) 0 á 100 Kills");
			p.sendMessage("§6» §7(§a⚌§7) §7100 á 200 Kills");
			p.sendMessage("§6» §7(§e☰§7) §7300 á 400 Kills");
			p.sendMessage("§6» §7(§1✥§7) §7400 á 500 Kills");
			p.sendMessage("§6» §7(§9✯§7) §7500 á 600 Kills");
			p.sendMessage("§6» §7(§6✪§7) §7600 á 700 Kills");
			p.sendMessage("§6» §7(§b❈§7) §7700 á 800 Kills");
			p.sendMessage("§6» §7(§2✸§7) §7800 á 900 Kills");
			p.sendMessage("§6» §7(§c✹§7) §7900 á 1000 Kills");
			p.sendMessage("§6» §7(§4✷§7) §71000 á 1500 Kills");
			p.sendMessage("     ");
			p.sendMessage("  §cFarm Kill \u00e9 §4§lPROIBIDO ");
			p.sendMessage("  ");
		}
		return false;
	}
}
