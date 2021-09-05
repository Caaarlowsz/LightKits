package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Manager.Grupos;
import Score.ScoreBoarding;

public class AccountCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("account") || cmd.getName().equalsIgnoreCase("acc")) {
			if (args.length == 0) {
				p.sendMessage("§7Voce usou de maneira incorreta, por favor use: §e/account (jogador)");
				return true;
			}
			final Player acc = Bukkit.getPlayer(args[0]);
			final Player t = p.getServer().getPlayer(args[0]);
			if (acc == null) {
				p.sendMessage("§6* §7Este jogador nunca esteve aqui!");
				return true;
			}
			p.sendMessage("§c§m--->-----------------------<---");
			p.sendMessage("§6* §7Voce esta puxando informacoes do jogador: " + t.getName());
			p.sendMessage("§7");
			p.sendMessage("§7Grupo: §6" + Grupos.getGroupMax(t));
			p.sendMessage("§7Rank: §6" + ScoreBoarding.Rank(p));
			p.sendMessage("§7Status: §6Online");
			p.sendMessage("§7UUID: §6" + t.getUniqueId());
			p.sendMessage("§7");
			p.sendMessage("§c§m--->-----------------------<---");
		}
		return false;
	}
}
