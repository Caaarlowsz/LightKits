package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class ArenaCommand implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] args) {
		final Player p = (Player) sender;
		if (p.hasPermission("cmd.admin") && cmd.getName().equalsIgnoreCase("jail")) {
			if (args.length == 0) {
				p.sendMessage("§7Voce usou de maneira incorreta, por favor use: §e/jail (Jogador)");
			}
			if (args.length == 1) {
				final Player o = Bukkit.getPlayer(args[0]);
				if (o != null) {
					o.getLocation().add(0.0, 13.0, 0.0).getBlock().setType(Material.BEDROCK);
					o.getLocation().add(0.0, 11.0, 1.0).getBlock().setType(Material.BEDROCK);
					o.getLocation().add(1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
					o.getLocation().add(0.0, 11.0, -1.0).getBlock().setType(Material.BEDROCK);
					o.getLocation().add(-1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
					o.getLocation().add(0.0, 10.0, 0.0).getBlock().setType(Material.BEDROCK);
					o.teleport(o.getLocation().add(0.0, 11.0, -0.05));
					p.sendMessage("§7Sua jaula foi criada no jogador §a " + o.getName());
					Player[] arrayOfPlayer;
					for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
						final Player p2 = arrayOfPlayer[i];
						if (p2.hasPermission("ver.spy")) {
							p2.sendMessage("§7[STAFF-SPY] §7O Staff " + sender.getName() + " §7Prendeu o jogador §7"
									+ o.getDisplayName());
						}
					}
				} else {
					p.sendMessage("§7Este jogador nao esta conectado!");
				}
			}
		} else {
			p.sendMessage("§7Voce precisa ser §dTrialMod§7 Ou superior para executar este comando.");
		}
		return false;
	}
}
