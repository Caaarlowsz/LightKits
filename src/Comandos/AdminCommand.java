package Comandos;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import API.TitleAPI;
import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;

public class AdminCommand implements Listener, CommandExecutor {
	public static ArrayList<String> admin;
	public static HashMap<String, ItemStack[]> salvarinv;

	static {
		AdminCommand.admin = new ArrayList<String>();
		AdminCommand.salvarinv = new HashMap<String, ItemStack[]>();
	}

	public AdminCommand(final LightPvP main) {
	}

	@EventHandler
	public void onAdminAbririnv(final PlayerInteractEntityEvent event) {
		if (!(event.getRightClicked() instanceof Player)) {
			return;
		}
		final Player p1 = event.getPlayer();
		final Player r = (Player) event.getRightClicked();
		if (AdminCommand.admin.contains(p1.getName()) && p1.getItemInHand().getType() == Material.AIR) {
			p1.openInventory((Inventory) r.getInventory());
		}
	}

	@EventHandler
	public void onAdminCrash(final PlayerInteractEntityEvent event) {
		if (!(event.getRightClicked() instanceof Player)) {
			return;
		}
		final Player p1 = event.getPlayer();
		final Player r = (Player) event.getRightClicked();
		if (AdminCommand.admin.contains(p1.getName()) && p1.getItemInHand().getType() == Material.MUSHROOM_SOUP) {
			p1.chat("/autosoup " + r.getName());
		}
	}

	@EventHandler
	public void onAdminNoFall(final PlayerInteractEntityEvent event) {
		final Player p = event.getPlayer();
		if (AdminCommand.admin.contains(p.getName()) && p.getItemInHand().getType() == Material.BEDROCK) {
			final Player p2 = (Player) event.getRightClicked();
			if (p2 != null) {
				p2.getLocation().add(0.0, 40.0, 0.0).getBlock().setType(Material.BEDROCK);
				p2.getLocation().add(0.0, 40.0, 1.0).getBlock().setType(Material.BEDROCK);
				p2.getLocation().add(1.0, 40.0, 0.0).getBlock().setType(Material.BEDROCK);
				p2.getLocation().add(0.0, 40.0, -1.0).getBlock().setType(Material.BEDROCK);
				p2.getLocation().add(-1.0, 40.0, 0.0).getBlock().setType(Material.BEDROCK);
				p2.getLocation().add(0.0, 40.0, 0.0).getBlock().setType(Material.BEDROCK);
				p2.teleport(p2.getLocation().add(0.0, 11.0, -0.05));
			}
		}
	}

	@EventHandler
	public void onAdminArena(final PlayerInteractEntityEvent event) {
		final Player p = event.getPlayer();
		if (AdminCommand.admin.contains(p.getName()) && p.getItemInHand().getType() == Material.IRON_FENCE) {
			final Player p2 = (Player) event.getRightClicked();
			if (p2 != null) {
				p2.getLocation().add(0.0, 13.0, 0.0).getBlock().setType(Material.BEDROCK);
				p2.getLocation().add(0.0, 11.0, 1.0).getBlock().setType(Material.BEDROCK);
				p2.getLocation().add(1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
				p2.getLocation().add(0.0, 11.0, -1.0).getBlock().setType(Material.BEDROCK);
				p2.getLocation().add(-1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
				p2.getLocation().add(0.0, 10.0, 0.0).getBlock().setType(Material.BEDROCK);
				p2.teleport(p2.getLocation().add(0.0, 11.0, -0.05));
			}
		}
	}

	@EventHandler
	public void onPlayerInfo(final PlayerInteractEntityEvent e) {
		final Player p = e.getPlayer();
		if (AdminCommand.admin.contains(p.getName()) && p.getItemInHand().getType() == Material.PAPER) {
			final Damageable hp;
			final Player p2 = (Player) (hp = (Damageable) e.getRightClicked());
			p.sendMessage("�7-=-=-=-=-=-=-=-=-�c{�4+�c}�7-=-=-=-=-=-=-=-=-");
			p.sendMessage("�4\u27bc �7Nick �c" + p2.getName());
			p.sendMessage("�4\u27bc �7Life �c" + (int) hp.getHealth());
			p.sendMessage("�4\u27bc �7Sopas �c" + getAmount(p2, Material.MUSHROOM_SOUP));
			p.sendMessage("�4\u27bc �7Gm �c" + p2.getGameMode());
			p.sendMessage("�4\u27bc �7Ip �c" + p2.getAddress().getHostName());
			p.sendMessage("�7-=-=-=-=-=-=-=-=-�c{�4+�c}�7-=-=-=-=-=-=-=-=-");
		}
	}

	public static int getAmount(final Player p, final Material m) {
		int amount = 0;
		ItemStack[] contents;
		for (int length = (contents = p.getInventory().getContents()).length, i = 0; i < length; ++i) {
			final ItemStack item = contents[i];
			if (item != null && item.getType() == m && item.getAmount() > 0) {
				amount += item.getAmount();
			}
		}
		return amount;
	}

	@EventHandler
	public void aoInteragir(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (AdminCommand.admin.contains(p.getName())
				&& (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)
				&& p.getItemInHand().getType() == Material.MAGMA_CREAM) {
			p.chat("/admin");
			Bukkit.getScheduler().scheduleSyncDelayedTask(LightPvP.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.chat("/admin");
				}
			}, 20L);
		}
	}

	@EventHandler
	public void aoInteragi2(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (AdminCommand.admin.contains(p.getName())
				&& (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)
				&& p.getItemInHand().getType() == Material.STAINED_GLASS_PANE) {
			p.chat("/admin");
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(
					String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� Apenas Players Podem Executar Esse Comando");
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("admin")) {
			if (!p.hasPermission("cmd.admin")) {
				return true;
			}
			if (AdminCommand.admin.contains(p.getName())) {
				Player[] arrayOfPlayer;
				for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
					final Player all = arrayOfPlayer[i];
					all.showPlayer(p);
					if (!all.hasPermission("cmd.admin")) {
						all.sendMessage(" ");
					}
				}
				p.setGameMode(GameMode.SURVIVAL);
				for (int i2 = 0; i2 < 10; ++i2) {
				}
				TitleAPI.sendFullTitle(p, 50, 50, 80, "�cAdmin", "�4�lOFF");
				AdminCommand.admin.remove(p.getName());
				p.getInventory().setContents((ItemStack[]) AdminCommand.salvarinv.get(p.getName()));
				p.updateInventory();
			} else {
				AdminCommand.admin.add(p.getName());
				Player[] arrayOfPlayer;
				for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
					final Player all = arrayOfPlayer[i];
					all.hidePlayer(p);
					if (!all.hasPermission("cmd.admin")) {
						all.sendMessage(" ");
					}
				}
				p.setGameMode(GameMode.CREATIVE);
				for (int i2 = 0; i2 < 10; ++i2) {
				}
				TitleAPI.sendFullTitle(p, 50, 50, 80, "�aAdmin", "�2�lON");
				AdminCommand.salvarinv.put(p.getName(), p.getInventory().getContents());
				p.getInventory().clear();
				this.darItem(p, Material.MAGMA_CREAM, "�b�lTroca-Rapida", 5);
				this.darItem(p, Material.MUSHROOM_SOUP, "�b�lTestar Auto-Soup", 3);
				this.darItem(p, Material.IRON_FENCE, "�b�lPrender (Player)", 7);
				final ItemStack KitPadrao = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
				final ItemMeta kKitPadrao = KitPadrao.getItemMeta();
				kKitPadrao.setDisplayName("�c�lSAIR");
				KitPadrao.setItemMeta(kKitPadrao);
				p.getInventory().setItem(8, KitPadrao);
			}
		}
		return true;
	}

	public void darItem(final Player p, final Material material, final String nome, final int slot) {
		final ItemStack l = new ItemStack(material);
		final ItemMeta metal = l.getItemMeta();
		metal.setDisplayName(nome);
		l.setItemMeta(metal);
		p.getInventory().setItem(slot - 1, l);
	}

	public static void setitem(final Player p, final Material mat, final String nome, final int lugar,
			final Enchantment enchant, final int level, final boolean trueorfalse) {
		final ItemStack item = new ItemStack(mat);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		itemmeta.addEnchant(enchant, level, trueorfalse);
		item.setItemMeta(itemmeta);
		p.getInventory().setItem(lugar, item);
	}
}
