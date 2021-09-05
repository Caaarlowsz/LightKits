package Kits;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import Eventos.Basico;
import Eventos.Cooldown;
import Eventos.Habilidade;
import Main.Main;

public class Monk implements Listener {
	@EventHandler
	public void aoMonk(final PlayerInteractEntityEvent e) {
		final Player p = e.getPlayer();
		if (e.getRightClicked() instanceof Player) {
			final Player jogadorClicado = (Player) e.getRightClicked();
			if (Habilidade.getAbility(p).equalsIgnoreCase("Monk")
					&& p.getItemInHand().getType() == Material.BLAZE_ROD) {
				if (Cooldown.add(p)) {
					Basico.MensagemCooldown(p);
					return;
				}
				final int random = new Random().nextInt(jogadorClicado.getInventory().getSize() - 10 + 1 + 10);
				final ItemStack ItemSelecionado = jogadorClicado.getInventory().getItem(random);
				final ItemStack ItemMudado = jogadorClicado.getItemInHand();
				jogadorClicado.setItemInHand(ItemSelecionado);
				jogadorClicado.getInventory().setItem(random, ItemMudado);
				jogadorClicado.sendMessage(String.valueOf(String.valueOf(Main.prefix))
						+ " §6» §7Voc\u00ea Foi Monkado Arrume Seu Inventario");
				p.sendMessage(String.valueOf(String.valueOf(String.valueOf(Main.prefix))
						+ " §6» §7Voc\u00ea Monkou o Player " + jogadorClicado.getName()));
				Cooldown.add(p, 20);
				Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstace(), (Runnable) new Runnable() {
					@Override
					public void run() {
						p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7CoolDown §aAcabou");
					}
				}, 400L);
			}
		}
	}
}
