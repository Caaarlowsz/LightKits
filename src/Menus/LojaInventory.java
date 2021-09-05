package Menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Main.Main;

public class LojaInventory implements Listener, CommandExecutor {
	public LojaInventory(final Main main) {
	}

	@EventHandler
	public void warps(final InventoryClickEvent e) {
		if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
			final Inventory inv = e.getInventory();
			final Player p = (Player) e.getWhoClicked();
			if (inv.getTitle().equals("§8Loja")) {
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
			}
		}
	}

	@SuppressWarnings("unused")
	public static void guiKits1(final Player p) {
		final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder) p, 27, "§8Loja");
		final ItemStack loja23 = new ItemStack(Material.getMaterial(385), 1, (short) 0);
		final ItemMeta loja23v = loja23.getItemMeta();
		loja23v.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» Pagina Atual");
		loja23.setItemMeta(loja23v);
		inv.setItem(4, loja23);

		final ItemStack loja25 = new ItemStack(Material.ENCHANTED_BOOK);
		final ItemMeta loja25v = loja25.getItemMeta();
		loja25v.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» Loja de Permissoes");
		loja25.setItemMeta(loja25v);
		inv.setItem(14, loja25);

		final ItemStack loja26 = new ItemStack(Material.EYE_OF_ENDER);
		final ItemMeta loja26v = loja26.getItemMeta();
		loja26v.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» Loja de Kits");
		loja26.setItemMeta(loja26v);
		inv.setItem(13, loja26);

		final ItemStack loja24 = new ItemStack(Material.BOOK);
		final ItemMeta loja232v = loja24.getItemMeta();
		loja232v.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» Loja Online");
		loja24.setItemMeta(loja232v);
		inv.setItem(12, loja24);
		ItemStack[] arrayOfItemStack;
		for (int descpyro1 = (arrayOfItemStack = inv.getContents()).length,
				metapyro1 = 0; metapyro1 < descpyro1; ++metapyro1) {
			final ItemStack itemStack = arrayOfItemStack[metapyro1];
		}
		p.openInventory(inv);
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (commandLabel.equalsIgnoreCase("loja")) {
			final Player p = (Player) sender;
			guiKits1(p);
		}
		return false;
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§8Loja") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.BOOK) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage(
						String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Acesse nosso Site §6» " + Main.site);
			}
		}
		if (e.getInventory().getTitle().equalsIgnoreCase("§8Loja") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.ENCHANTED_BOOK) {
				e.setCancelled(true);
				p.closeInventory();
				LojaPermsInventory.guiKits1(p);
			}
		}
		if (e.getInventory().getTitle().equalsIgnoreCase("§8Loja") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.EYE_OF_ENDER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/lojakits");
			}
		}
	}
}