package Comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class HeadCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cVoce nao pode usar isso no console");
			return true;
		}
		final Player p = (Player) sender;
		if (!p.hasPermission("cmd.head")) {
			p.sendMessage("§7Voce precisa ser §cGerente§7 Ou superior para executar este comando.");
			return true;
		}
		if (args.length == 0) {
			p.sendMessage("§7Voce usou de maneira incorreta, por favor use: §e/head (jogador)");
		} else {
			final ItemStack C1 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
			final SkullMeta sm = (SkullMeta) C1.getItemMeta();
			sm.setOwner(args[0]);
			sm.setDisplayName(args[0]);
			sm.setDisplayName("§c:" + args[0]);
			C1.setItemMeta((ItemMeta) sm);
			p.getInventory().addItem(new ItemStack[] { C1 });
			p.updateInventory();
		}
		return false;
	}
}
