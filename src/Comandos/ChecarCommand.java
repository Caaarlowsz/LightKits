package Comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Eventos.Habilidade;
import Main.Main;

public class ChecarCommand implements CommandExecutor {

	public ChecarCommand(final Main plugin) {
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Entre no Servidor para dar este Comando.");
			return false;
		}
		final Player p = (Player) sender;
		if (commandLabel.equalsIgnoreCase("checar") && p.hasPermission("cmd.checar")) {
			if (args.length == 1) {
				final Player target = p.getServer().getPlayer(args[0]);
				if (target != null) {
					p.sendMessage(String.valueOf(Main.prefix) + " §cIP: §4" + target.getAddress().getHostString());
					p.sendMessage(String.valueOf(Main.prefix) + " §cKit: §4" + Habilidade.getAbility(p));
				} else {
					p.sendMessage("Invalid " + args[0] + " Player");
				}
			} else {
				p.sendMessage(String.valueOf(Main.prefix) + " §7Use: /" + commandLabel + " (player)");
			}
		}
		return false;
	}
}
