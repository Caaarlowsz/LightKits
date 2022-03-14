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

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;
import Score.ScoreBoarding;

public class LojaKitsInventory implements Listener, CommandExecutor {
	public static ItemStack vidro;
	public static ItemMeta vidrometa;
	public static ItemStack vidro2;
	public static ItemMeta vidro2meta;
	public static ItemStack ninja;
	public static ItemMeta ninjameta;
	public static ItemStack viking;
	public static ItemMeta vikingmeta;
	public static ItemStack stomper;
	public static ItemMeta stompermeta;
	public static ItemStack viper;
	public static ItemMeta vipermeta;
	public static ItemStack snail;
	public static ItemMeta snailmeta;
	public static ItemStack fisherman;
	public static ItemMeta fishermanmeta;
	public static ItemStack thor;
	public static ItemMeta thormeta;
	public static ItemStack xp;
	public static ItemMeta xpmeta;
	public static ItemStack coisa;
	public static ItemMeta coisameta;

	public LojaKitsInventory(final LightPvP main) {
	}

	@EventHandler
	public void warps(final InventoryClickEvent e) {
		if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
			final Inventory inv = e.getInventory();
			final Player p = (Player) e.getWhoClicked();
			if (inv.getTitle().equals("�cLoja de Kits")) {
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
				e.setCancelled(true);
				p.closeInventory();
			}
			if (e.getCurrentItem().isSimilar(LojaKitsInventory.ninja)) {
				if (Coins.XpM.getPlayerMoney(p) >= 4000) {
					Coins.XpM.removeMoney(p, 4000);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + p.getName() + " add kit.avatar");
					p.sendMessage(String.valueOf(LightPvP.prefix) + " �7Kit �cAVATAR�7 Adquirido Com Sucesso");
					ScoreBoarding.setScoreBoard(p);
					e.setCancelled(true);
					p.closeInventory();
				} else if (Coins.XpM.getPlayerMoney(p) < 4000) {
					p.sendMessage(String.valueOf(LightPvP.prefix)
							+ " �7Voc\u00ea N\u00e3o Tem Dinheiro o Suficiente Para Esta Compra");
					e.setCancelled(true);
					p.closeInventory();
				}
			}
			if (e.getCurrentItem().isSimilar(LojaKitsInventory.viking)) {
				if (Coins.XpM.getPlayerMoney(p) >= 15000) {
					Coins.XpM.removeMoney(p, 15000);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + p.getName() + " add kit.Stomper");
					p.sendMessage(String.valueOf(LightPvP.prefix) + " �7Kit �cSTOMPER�7 Adquirido Com Sucesso");
					ScoreBoarding.setScoreBoard(p);
					e.setCancelled(true);
					p.closeInventory();
				} else if (Coins.XpM.getPlayerMoney(p) < 15000) {
					p.sendMessage(String.valueOf(LightPvP.prefix)
							+ " �7Voc\u00ea N\u00e3o Tem Dinheiro o Suficiente Para Esta Compra");
					e.setCancelled(true);
					p.closeInventory();
				}
			}
			if (e.getCurrentItem().isSimilar(LojaKitsInventory.stomper)) {
				if (Coins.XpM.getPlayerMoney(p) >= 1000) {
					Coins.XpM.removeMoney(p, 1000);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + p.getName() + " add kit.thor");
					p.sendMessage(String.valueOf(LightPvP.prefix) + " �7Kit �cTHOR�7 Adquirido Com Sucesso");
					e.setCancelled(true);
					p.closeInventory();
					ScoreBoarding.setScoreBoard(p);
				} else if (Coins.XpM.getPlayerMoney(p) < 1000) {
					p.sendMessage(String.valueOf(LightPvP.prefix)
							+ " �7Voc\u00ea N\u00e3o Tem Dinheiro o Suficiente Para Esta Compra");
					e.setCancelled(true);
					p.closeInventory();
				}
			}
			if (e.getCurrentItem().isSimilar(LojaKitsInventory.viper)) {
				if (Coins.XpM.getPlayerMoney(p) >= 5000) {
					Coins.XpM.removeMoney(p, 5000);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + p.getName() + " add kit.swords");
					p.sendMessage(String.valueOf(LightPvP.prefix) + " �7Kit �cSWORDS�7 Adquirido Com Sucesso");
					e.setCancelled(true);
					p.closeInventory();
					ScoreBoarding.setScoreBoard(p);
				} else if (Coins.XpM.getPlayerMoney(p) < 5000) {
					p.sendMessage(String.valueOf(LightPvP.prefix)
							+ " �7Voc\u00ea N\u00e3o Tem Dinheiro o Suficiente Para Esta Compra");
					e.setCancelled(true);
					p.closeInventory();
				}
			}
			if (e.getCurrentItem().isSimilar(LojaKitsInventory.snail)) {
				if (Coins.XpM.getPlayerMoney(p) >= 4000) {
					Coins.XpM.removeMoney(p, 4000);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + p.getName() + " add kit.forcefield");
					p.sendMessage(String.valueOf(LightPvP.prefix) + " �7Kit �cFORCEFIELD�7 Adquirido");
					e.setCancelled(true);
					p.closeInventory();
					ScoreBoarding.setScoreBoard(p);
				} else if (Coins.XpM.getPlayerMoney(p) < 4000) {
					p.sendMessage(String.valueOf(LightPvP.prefix)
							+ " �7Voc\u00ea N\u00e3o Tem Dinheiro o Suficiente Para Esta Compra");
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�cAnterior")) {
					e.setCancelled(true);
					p.closeInventory();
					p.chat("/loja");
				}
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("lojakits")) {
			final Inventory warps = Bukkit.createInventory((InventoryHolder) p, 27, "�cLoja de Kits");
			final ItemStack event451 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
			final ItemMeta event451v = event451.getItemMeta();
			event451v.setDisplayName("�cAnterior");
			event451.setItemMeta(event451v);
			warps.setItem(9, event451);
			final ItemStack event452 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
			final ItemMeta event456v = event452.getItemMeta();
			event456v.setDisplayName("�aProximo");
			event452.setItemMeta(event456v);
			warps.setItem(17, event452);
			LojaKitsInventory.stomper = new ItemStack(Material.GOLD_AXE);
			(LojaKitsInventory.stompermeta = LojaKitsInventory.stomper.getItemMeta())
					.setDisplayName("�cKIT THOR - 1000 Money");
			LojaKitsInventory.stomper.setItemMeta(LojaKitsInventory.stompermeta);
			LojaKitsInventory.viking = new ItemStack(Material.GOLD_BOOTS, 1);
			(LojaKitsInventory.vikingmeta = LojaKitsInventory.viking.getItemMeta())
					.setDisplayName("�cKIT STOMPER - 15000 Money");
			LojaKitsInventory.viking.setItemMeta(LojaKitsInventory.vikingmeta);
			LojaKitsInventory.viper = new ItemStack(Material.WOOD_SWORD);
			(LojaKitsInventory.vipermeta = LojaKitsInventory.viper.getItemMeta())
					.setDisplayName("�cKIT SWORDS - 5000 Money");
			LojaKitsInventory.viper.setItemMeta(LojaKitsInventory.vipermeta);
			LojaKitsInventory.ninja = new ItemStack(Material.BEACON);
			(LojaKitsInventory.ninjameta = LojaKitsInventory.ninja.getItemMeta())
					.setDisplayName("�cKIT AVATAR - 4000 Money");
			LojaKitsInventory.ninja.setItemMeta(LojaKitsInventory.ninjameta);
			LojaKitsInventory.snail = new ItemStack(Material.NETHER_FENCE);
			(LojaKitsInventory.snailmeta = LojaKitsInventory.snail.getItemMeta())
					.setDisplayName("�cKIT FF - 4000 Money");
			LojaKitsInventory.snail.setItemMeta(LojaKitsInventory.snailmeta);
			for (int i = 0; i != 27; ++i) {
				warps.setItem(11, LojaKitsInventory.stomper);
				warps.setItem(12, LojaKitsInventory.viper);
				warps.setItem(13, LojaKitsInventory.snail);
				warps.setItem(14, LojaKitsInventory.ninja);
				warps.setItem(15, LojaKitsInventory.viking);
			}
			p.openInventory(warps);
			return true;
		}
		return true;
	}
}
