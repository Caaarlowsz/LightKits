package Outros;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SoupsignOther implements Listener {
	@EventHandler
	public void Escrever(final SignChangeEvent e) {
		final Player p = e.getPlayer();
		if (p.hasPermission("placa.sopa") && e.getLine(0).equalsIgnoreCase("sopa")) {
			e.setLine(0, "§5Nitec");
			e.setLine(1, "§aSopa!");
			e.setLine(3, "§c(Clique)");
			p.sendMessage("§7Sua placa foi criada!");
		}
	}

	@EventHandler
	public void Inv(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK
				&& ((e.getClickedBlock() != null && e.getClickedBlock().getType() == Material.WALL_SIGN)
						|| e.getClickedBlock().getType() == Material.SIGN_POST)) {
			final Sign s = (Sign) e.getClickedBlock().getState();
			final String[] lines = s.getLines();
			if (lines.length > 0 && lines[0].equals("§5Nitec") && lines.length > 1 && lines[1].equals("§aSopa!")
					&& lines.length > 3 && lines[3].equals("§c(Clique)")) {
				final Inventory inv = Bukkit.createInventory((InventoryHolder) p, 54, "§cSopas");
				final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
				final ItemMeta sopameta = sopa.getItemMeta();
				sopameta.setDisplayName("§6Sopa");
				sopa.setItemMeta(sopameta);
				for (int i = 0; i != 54; ++i) {
					inv.setItem(i, sopa);
				}
				p.openInventory(inv);
			}
		}
	}
}
