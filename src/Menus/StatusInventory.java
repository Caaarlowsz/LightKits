package Menus;

import java.util.ArrayList;
import java.util.List;

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

import Coins.XpM;
import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;
import Score.ScoreBoarding;

public class StatusInventory implements Listener, CommandExecutor {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void guiKits(final Player p) {
		final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder) p, 27, "�8Status");
		final ItemStack event = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
		final ItemMeta eventv = event.getItemMeta();
		eventv.setDisplayName(LightPvP.prefix);
		event.setItemMeta(eventv);
		inv.setItem(0, event);
		inv.setItem(1, event);
		inv.setItem(2, event);
		inv.setItem(3, event);
		inv.setItem(4, event);
		inv.setItem(5, event);
		inv.setItem(6, event);
		inv.setItem(7, event);
		inv.setItem(8, event);
		inv.setItem(9, event);
		inv.setItem(12, event);
		inv.setItem(14, event);
		inv.setItem(17, event);
		inv.setItem(18, event);
		inv.setItem(19, event);
		inv.setItem(20, event);
		inv.setItem(21, event);
		inv.setItem(22, event);
		inv.setItem(23, event);
		inv.setItem(24, event);
		inv.setItem(25, event);
		inv.setItem(26, event);
		ItemStack pyro1 = new ItemStack(Material.WATCH);
		ItemMeta metapyro1 = pyro1.getItemMeta();
		metapyro1.setDisplayName(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �5Rank");
		ArrayList descpyro1 = new ArrayList();
		descpyro1.add("�7[" + ScoreBoarding.Rank(p) + "�7]");
		metapyro1.setLore((List) descpyro1);
		pyro1.setItemMeta(metapyro1);
		inv.setItem(10, pyro1);
		pyro1 = new ItemStack(Material.COMPASS);
		metapyro1 = pyro1.getItemMeta();
		metapyro1.setDisplayName(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� KDR");
		descpyro1 = new ArrayList();
		descpyro1.add("�7[�8"
				+ LightPvP.plugin.getConfig().getInt(
						new StringBuilder("status.").append(p.getName().toLowerCase()).append(".kills").toString())
				+ "�7/�8"
				+ LightPvP.plugin.getConfig().getInt(
						new StringBuilder("status.").append(p.getName().toLowerCase()).append(".mortes").toString())
				+ "�7]");
		metapyro1.setLore((List) descpyro1);
		pyro1.setItemMeta(metapyro1);
		inv.setItem(11, pyro1);
		pyro1 = new ItemStack(Material.ENCHANTMENT_TABLE);
		metapyro1 = pyro1.getItemMeta();
		metapyro1.setDisplayName(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �eMoney");
		descpyro1 = new ArrayList();
		descpyro1.add("�7[�e" + XpM.getPlayerMoney(p) + "�7]");
		metapyro1.setLore((List) descpyro1);
		pyro1.setItemMeta(metapyro1);
		inv.setItem(13, pyro1);
		pyro1 = new ItemStack(Material.DIAMOND);
		metapyro1 = pyro1.getItemMeta();
		metapyro1.setDisplayName(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �aKills");
		descpyro1 = new ArrayList();
		descpyro1.add("�7[�a"
				+ LightPvP.plugin.getConfig().getInt(
						new StringBuilder("status.").append(p.getName().toLowerCase()).append(".kills").toString())
				+ "�7]");
		metapyro1.setLore((List) descpyro1);
		pyro1.setItemMeta(metapyro1);
		inv.setItem(15, pyro1);
		pyro1 = new ItemStack(Material.COAL);
		metapyro1 = pyro1.getItemMeta();
		metapyro1.setDisplayName(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �cDeaths");
		descpyro1 = new ArrayList();
		descpyro1.add("�7[�c"
				+ LightPvP.plugin.getConfig().getInt(
						new StringBuilder("status.").append(p.getName().toLowerCase()).append(".mortes").toString())
				+ "�7]");
		metapyro1.setLore((List) descpyro1);
		pyro1.setItemMeta(metapyro1);
		inv.setItem(16, pyro1);
		p.openInventory(inv);
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (commandLabel.equalsIgnoreCase("warps")) {
			final Player p = (Player) sender;
			guiKits(p);
		}
		return false;
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("�8Status") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getSlot() == 7) {
				e.setCancelled(true);
				p.closeInventory();
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
			}
		}
	}

	public static void ir(final Player p, final String string) {
	}
}
