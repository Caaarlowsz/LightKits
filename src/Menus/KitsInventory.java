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

public class KitsInventory implements Listener, CommandExecutor {
	public KitsInventory(final Main main) {
	}

	@EventHandler
	public void warps(final InventoryClickEvent e) {
		if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
			final Inventory inv = e.getInventory();
			final Player p = (Player) e.getWhoClicked();
			if (inv.getTitle().equals("§8Seus Kits [1]")) {
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
			}
		}
	}

	public static void guiKits1(final Player p) {
		final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder) p, 54, "§8Seus Kits [1]");
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
		if (p.hasPermission("kit.pvp")) {
			final ItemStack pyro = new ItemStack(Material.STONE_SWORD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7PvP");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.ajnin")) {
			final ItemStack pyro = new ItemStack(Material.NETHER_STAR);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Ajnin");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.anchor")) {
			final ItemStack pyro = new ItemStack(Material.ANVIL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Anchor");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.avatar")) {
			final ItemStack pyro = new ItemStack(Material.BEACON);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Avatar");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.barbarian")) {
			final ItemStack pyro = new ItemStack(Material.WOOD_SWORD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Barbarian");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.boxer")) {
			final ItemStack pyro = new ItemStack(Material.QUARTZ);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Boxer");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.c4")) {
			final ItemStack pyro = new ItemStack(Material.SLIME_BALL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7C4");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.deshfire")) {
			final ItemStack pyro = new ItemStack(Material.REDSTONE_BLOCK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7DeshFire");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.DubleJump")) {
			final ItemStack pyro = new ItemStack(Material.PISTON_BASE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7DubleJump");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.firebender")) {
			final ItemStack pyro = new ItemStack(Material.REDSTONE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7FireBender");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.fisherman")) {
			final ItemStack pyro = new ItemStack(Material.FISHING_ROD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Fisherman");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.gladiator")) {
			final ItemStack pyro = new ItemStack(Material.IRON_FENCE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Gladiator");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.hulk")) {
			final ItemStack pyro = new ItemStack(Material.SADDLE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Hulk");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.jellyfish")) {
			final ItemStack pyro = new ItemStack(Material.CLAY_BALL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7JellyFish");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.kangaroo")) {
			final ItemStack pyro = new ItemStack(Material.FIREWORK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Kangaroo");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.magma")) {
			final ItemStack pyro = new ItemStack(Material.FIREBALL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Magma");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.monk")) {
			final ItemStack pyro = new ItemStack(Material.BLAZE_ROD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Monk");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.ninja")) {
			final ItemStack pyro = new ItemStack(Material.COMPASS);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Ninja");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.phantom")) {
			final ItemStack pyro = new ItemStack(Material.FEATHER);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Phantom");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.poseidon")) {
			final ItemStack pyro = new ItemStack(Material.WATER);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Poseidon");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Resouper")) {
			final ItemStack pyro = new ItemStack(Material.MUSHROOM_SOUP);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Resouper");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.snail")) {
			final ItemStack pyro = new ItemStack(Material.WEB);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Snail");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.stomper")) {
			final ItemStack pyro = new ItemStack(Material.IRON_BOOTS);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Stomper");
			final ArrayList<String> descpyro1 = new ArrayList<>();
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.sonic")) {
			final ItemStack pyro = new ItemStack(Material.LAPIS_BLOCK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Sonic");
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
		if (e.getInventory().getTitle().equalsIgnoreCase("§8Seus Kits [1]") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.STONE_SWORD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit pvp");
				return;
			}
			if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit ajnin");
				return;
			}
			if (e.getCurrentItem().getType() == Material.ANVIL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit anchor");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BEACON) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit avatar");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aProxima Pagina")) {
				e.setCancelled(true);
				KitsInventory2.guiKits1(p);
				return;
			}
			if (e.getCurrentItem().getType() == Material.WOOD_SWORD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit barbarian");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SLIME_BALL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit c4");
				return;
			}
			if (e.getCurrentItem().getType() == Material.QUARTZ) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit Boxer");
				return;
			}
			if (e.getCurrentItem().getType() == Material.REDSTONE_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit deshfire");
				return;
			}
			if (e.getCurrentItem().getType() == Material.PISTON_BASE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit dublejump");
				return;
			}
			if (e.getCurrentItem().getType() == Material.REDSTONE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit firebender");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FISHING_ROD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit fisherman");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FISHING_ROD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit fisherman");
				return;
			}
			if (e.getCurrentItem().getType() == Material.IRON_FENCE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit gladiator");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SADDLE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit hulk");
				return;
			}
			if (e.getCurrentItem().getType() == Material.CLAY_BALL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit jellyfish");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FIREWORK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit kangaroo");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FIREBALL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit magma");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BLAZE_ROD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit monk");
				return;
			}
			if (e.getCurrentItem().getType() == Material.COMPASS) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit ninja");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FEATHER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit phantom");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WATER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit poseidon");
				return;
			}
			if (e.getCurrentItem().getType() == Material.MUSHROOM_SOUP) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit resouper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WEB) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit snail");
				return;
			}
			if (e.getCurrentItem().getType() == Material.IRON_BOOTS) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit stomper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.LAPIS_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit sonic");
			}
		}
	}
}
