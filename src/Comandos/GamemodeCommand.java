package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§bPrecisa ser um Player para usar esse comando");
			return true;
		}
		final Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("gm") || cmd.getName().equalsIgnoreCase("gamemode")) {
			if (player.hasPermission("cmd.gm")) {
				if (args.length != 1) {
					player.sendMessage("§7Voce usou de maneira incorreta, por favor use: §e/gm (0/1)");
					return true;
				}
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("0")) {
						player.setGameMode(GameMode.SURVIVAL);
						player.sendMessage("§7Modo de jogo setado para §aSURVIVAL§7.");
					}
					if (args[0].equalsIgnoreCase("1")) {
						player.setGameMode(GameMode.CREATIVE);
						player.sendMessage("§7Modo de jogo setado para §aCRIATIVE§7.");
						Player[] arrayOfPlayer;
						for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
							final Player p2 = arrayOfPlayer[i];
							if (p2.hasPermission("ver.spy")) {
								p2.sendMessage("§7[STAFF-SPY] O Staff " + player.getName()
										+ " §7Alterou seu GAMEMODE para CRIATIVO.");
							}
						}
					}
				}
			} else {
				player.sendMessage("§7Voce precisa ser §dTrialMod§7 Ou Superior para executar este comando.");
			}
		}
		return false;
	}
}
