package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class TpallCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		final Player p = (Player) sender;
		if (commandLabel.equalsIgnoreCase("tpall") && p.hasPermission("cmd.tpall")) {
			Player[] onlinePlayers;
			for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, k = 0; k < length; ++k) {
				final Player s = onlinePlayers[k];
				s.sendMessage("§7Todos foram puxados ate §a" + p.getName());
			}
			Player[] arrayOfPlayer;
			for (int j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length, i = 0; i < j; ++i) {
				final Player all = arrayOfPlayer[i];
				all.teleport((Entity) p);
			}
		}
		return false;
	}
}
