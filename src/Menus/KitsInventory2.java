package Menus;

import java.util.ArrayList;

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

public class KitsInventory2 implements Listener, CommandExecutor {
	public KitsInventory2(final Main main) {
	}

	@EventHandler
	public void warps(final InventoryClickEvent e) {
		if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
			final Inventory inv = e.getInventory();
			final Player p = (Player) e.getWhoClicked();
			if (inv.getTitle().equals("§8Seus Kits [2]")) {
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
			}
		}
	}

	public static void guiKits1(final Player p) {
		final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder) p, 54, "§8Seus Kits [2]");
		final ItemStack vidro1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
		final ItemMeta meta1v = vidro1.getItemMeta();
		meta1v.setDisplayName("§7+");
		vidro1.setItemMeta(meta1v);
		inv.setItem(1, vidro1);
		inv.setItem(7, vidro1);
		inv.setItem(9, vidro1);
		inv.setItem(17, vidro1);
		inv.setItem(36, vidro1);
		inv.setItem(44, vidro1);
		inv.setItem(45, vidro1);
		inv.setItem(46, vidro1);
		inv.setItem(52, vidro1);
		inv.setItem(53, vidro1);
		final ItemStack vidro2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 4);
		final ItemMeta meta2v = vidro2.getItemMeta();
		meta2v.setDisplayName("§7+");
		vidro2.setItemMeta(meta2v);
		inv.setItem(2, vidro2);
		inv.setItem(3, vidro2);
		inv.setItem(4, vidro2);
		inv.setItem(5, vidro2);
		inv.setItem(6, vidro2);
		inv.setItem(10, vidro2);
		inv.setItem(16, vidro2);
		inv.setItem(18, vidro2);
		inv.setItem(26, vidro2);
		inv.setItem(27, vidro2);
		inv.setItem(35, vidro2);
		inv.setItem(43, vidro2);
		inv.setItem(37, vidro2);
		inv.setItem(47, vidro2);
		inv.setItem(48, vidro2);
		inv.setItem(49, vidro2);
		inv.setItem(50, vidro2);
		inv.setItem(51, vidro2);
		final ItemStack loja2 = new ItemStack(Material.REDSTONE);
		final ItemMeta loja2v = loja2.getItemMeta();
		loja2v.setDisplayName("§aProxima Pagina");
		loja2.setItemMeta(loja2v);
		inv.setItem(8, loja2);
		final ItemStack loja3 = new ItemStack(Material.getMaterial(351), 1, (short) 14);
		final ItemMeta loja23v = loja3.getItemMeta();
		loja23v.setDisplayName("§cVoltar");
		loja3.setItemMeta(loja23v);
		inv.setItem(0, loja3);
		if (p.hasPermission("kit.swords")) {
			final ItemStack pyro = new ItemStack(Material.GOLD_SWORD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Swords");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.terrorista")) {
			final ItemStack pyro = new ItemStack(Material.MAGMA_CREAM);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Terrorista");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.forcefield")) {
			final ItemStack pyro = new ItemStack(Material.NETHER_FENCE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7FF");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.ironman")) {
			final ItemStack pyro = new ItemStack(Material.IRON_INGOT);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7IronMan");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.thor")) {
			final ItemStack pyro = new ItemStack(Material.GOLD_AXE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Thor");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.thresh")) {
			final ItemStack pyro = new ItemStack(Material.LEVER);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Thresh");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.trader")) {
			final ItemStack pyro = new ItemStack(Material.ENDER_CHEST);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Trader");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.turtle")) {
			final ItemStack pyro = new ItemStack(Material.DIAMOND_CHESTPLATE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Turtle");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.velotrol")) {
			final ItemStack pyro = new ItemStack(Material.MINECART);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Velotrol");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.viper")) {
			final ItemStack pyro = new ItemStack(Material.SPIDER_EYE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Viper");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.armor")) {
			final ItemStack pyro = new ItemStack(Material.GOLD_INGOT);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Armor");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.waterbender")) {
			final ItemStack pyro = new ItemStack(Material.INK_SACK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7WaterBender");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.switcher")) {
			final ItemStack pyro = new ItemStack(Material.SNOW_BALL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Switcher");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.viking")) {
			final ItemStack pyro = new ItemStack(Material.STONE_AXE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Viking");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		p.openInventory(inv);
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (commandLabel.equalsIgnoreCase("kits")) {
			final Player p = (Player) sender;
			guiKits1(p);
		}
		return false;
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§8Seus Kits [2]") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.GOLD_SWORD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit swords");
				return;
			}
			if (e.getCurrentItem().getType() == Material.STONE_AXE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit viking");
				return;
			}
			if (e.getCurrentItem().getType() == Material.MAGMA_CREAM) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit terrorista");
				return;
			}
			if (e.getCurrentItem().getType() == Material.MUSHROOM_SOUP) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit resouper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.NETHER_FENCE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit forcefield");
				return;
			}
			if (e.getCurrentItem().getType() == Material.IRON_INGOT) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit ironman");
				return;
			}
			if (e.getCurrentItem().getType() == Material.GOLD_AXE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit thor");
				return;
			}
			if (e.getCurrentItem().getType() == Material.LEVER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit thresh");
				return;
			}
			if (e.getCurrentItem().getType() == Material.GOLD_INGOT) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit armor");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cVoltar")) {
				e.setCancelled(true);
				KitsInventory.guiKits1(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aProxima Pagina")) {
				e.setCancelled(true);
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getType() == Material.ENDER_CHEST) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit trader");
				return;
			}
			if (e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit turtle");
				return;
			}
			if (e.getCurrentItem().getType() == Material.MINECART) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit velotrol");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SPIDER_EYE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit viper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SPIDER_EYE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit viper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.INK_SACK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit waterbender");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SNOW_BALL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit switcher");
			}
		}
	}
}
