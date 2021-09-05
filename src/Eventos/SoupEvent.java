package Eventos;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Utils.KitAPI;

public class SoupEvent implements Listener {
	@EventHandler
	public void SopaBeber(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& e.getMaterial() == Material.MUSHROOM_SOUP) {
			final Damageable d = (Damageable) p;
			if (d.getHealth() != d.getMaxHealth()) {
				if (d.getHealth() > d.getMaxHealth() - 7.0) {
					d.setHealth(d.getMaxHealth());
				} else {
					d.setHealth(d.getHealth() + 7.0);
				}
				p.getItemInHand().setType(Material.BOWL);
				p.getItemInHand().setAmount(1);
				final ItemMeta m = p.getItemInHand().getItemMeta();
				m.setDisplayName("§9Pote");
				p.playSound(p.getLocation(), Sound.BURP, 1.0f, 1.0f);
				p.getInventory().getItemInHand().setItemMeta(m);
				p.updateInventory();
				if (KitAPI.getKit(p) == "QuickDropper") {
					p.setItemInHand((ItemStack) null);
				}
			}
		}
	}
}
