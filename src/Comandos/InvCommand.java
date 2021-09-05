package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InvCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cVoce nao pode usar isso no console");
			return true;
		}
		final Player p = (Player) sender;
		if (!p.hasPermission("cmd.inv")) {
			p.sendMessage("§7Voce precisa ser §dTrialMod§7 Ou superior para executar este comando.");
			return true;
		}
		if (args.length == 0) {
			p.sendMessage("§7Voce usou de maneira incorreta, por favor use: §e/inv (jogador)");
		} else {
			final Player t = Bukkit.getPlayer(args[0]);
			if (t == null) {
				p.sendMessage("§7Este jogador nao esta conectado!");
				return true;
			}
			p.openInventory((Inventory) t.getInventory());
			p.sendMessage("§7Voce abriu o inventario do jogador §a" + t.getDisplayName());
		}
		return false;
	}
}
