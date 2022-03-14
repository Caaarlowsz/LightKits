package Kits;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import Eventos.Basico;
import Eventos.Cooldown;
import Eventos.Habilidade;
import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;

public class Armor implements Listener {
	public static HashMap<String, ItemStack[]> salvararmor;

	static {
		Armor.salvararmor = new HashMap<String, ItemStack[]>();
	}

	public static ItemStack darArmaduraI(final Material material) {
		final ItemStack item = new ItemStack(material);
		final ItemMeta itemm = item.getItemMeta();
		item.setItemMeta(itemm);
		return item;
	}

	@EventHandler
	public void aoArmor(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Armor")
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.GOLD_INGOT) {
			if (Cooldown.add(p)) {
				Basico.MensagemCooldown(p);
				return;
			}
			Armor.salvararmor.put(p.getName(), p.getInventory().getArmorContents());
			Basico.tirarArmadura(p);
			p.sendMessage(
					String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Agora Voc\u00ea Tem uma Armadura Temporaria");
			p.getInventory()
					.setArmorContents(new ItemStack[] { darArmaduraI(Material.GOLD_HELMET),
							darArmaduraI(Material.GOLD_CHESTPLATE), darArmaduraI(Material.GOLD_LEGGINGS),
							darArmaduraI(Material.GOLD_BOOTS) });
			p.updateInventory();
			Cooldown.add(p, 25);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) LightPvP.getInstace(), (Runnable) new Runnable() {
				@Override
				public void run() {
					Basico.tirarArmadura(p);
					p.getInventory().setArmorContents((ItemStack[]) Armor.salvararmor.get(p.getName()));
					Armor.salvararmor.remove(p.getName());
					p.updateInventory();
				}
			}, 200L);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) LightPvP.getInstace(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Seu CoolDown Foi Terminado");
				}
			}, 500L);
		}
	}

	@EventHandler
	public void aomecher(final InventoryClickEvent e) {
		try {
			final Player p = (Player) e.getWhoClicked();
			if (Armor.salvararmor.containsKey(p.getName())
					&& e.getSlotType().equals((Object) InventoryType.SlotType.ARMOR)) {
				e.setCancelled(true);
			}
		} catch (Exception ex) {
		}
	}
}
