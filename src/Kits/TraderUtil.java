package Kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Main.Main;

public class TraderUtil {
	public static void MsgSemTrader(final Player p) {
		p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Sem Coins o Suficiente");
	}

	public static void darItemTroca(final Player p, final Material mat, final int modo) {
		final ItemStack item = new ItemStack(mat, 1, (short) modo);
		final ItemMeta itemm = item.getItemMeta();
		item.setItemMeta(itemm);
		p.getInventory().addItem(new ItemStack[] { item });
		p.updateInventory();
	}
}
