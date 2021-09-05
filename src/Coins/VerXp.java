package Coins;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Main.Main;

public class VerXp implements Listener, CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String comando, String[] args) {
		Player p = (Player) sender;
		if (comando.equalsIgnoreCase("mp")) {
			p.sendMessage(Main.prefix + " §4➼ §7Você Possui §2" + XpM.getPlayerMoney(p) + " §7MP");
		}
		return false;
	}
}
