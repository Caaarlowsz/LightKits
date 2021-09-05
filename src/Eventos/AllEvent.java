package Eventos;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class AllEvent implements Listener {
	@EventHandler
	public void Drop(final ItemSpawnEvent e) {
		e.getEntity().remove();
		e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), Effect.SMOKE, 1);
		e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.LAVA_POP, 1.0f, 1.0f);
	}

	@EventHandler
	public void Fome(final FoodLevelChangeEvent e) {
		e.setCancelled(true);
		e.setFoodLevel(20);
	}

	@EventHandler
	public void Chuva(final WeatherChangeEvent e) {
		if (e.toWeatherState()) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlayerColor(final SignChangeEvent e) {
		if (e.getLine(0).contains("&")) {
			e.setLine(0, e.getLine(0).replace("&", "§"));
		}
		if (e.getLine(1).contains("&")) {
			e.setLine(1, e.getLine(1).replace("&", "§"));
		}
		if (e.getLine(2).contains("&")) {
			e.setLine(2, e.getLine(2).replace("&", "§"));
		}
		if (e.getLine(3).contains("&")) {
			e.setLine(3, e.getLine(3).replace("&", "§"));
		}
	}

	@EventHandler
	public void CancelarDrop(final PlayerDropItemEvent e) {
		final Material T = e.getItemDrop().getItemStack().getType();
		if (T.equals((Object) Material.CHEST) || T.equals((Object) Material.ENCHANTED_BOOK)
				|| T.equals((Object) Material.BLAZE_ROD) || T.equals((Object) Material.LADDER)
				|| T.equals((Object) Material.EMERALD) || T.equals((Object) Material.STONE_SWORD)
				|| T.equals((Object) Material.FIREWORK) || T.equals((Object) Material.DIAMOND_SWORD)
				|| T.equals((Object) Material.WOOD_HOE) || T.equals((Object) Material.FISHING_ROD)
				|| T.equals((Object) Material.STONE_AXE) || T.equals((Object) Material.EMERALD)
				|| T.equals((Object) Material.QUARTZ) || T.equals((Object) Material.STONE_HOE)
				|| T.equals((Object) Material.REDSTONE_BLOCK) || T.equals((Object) Material.EMERALD_BLOCK)
				|| T.equals((Object) Material.IRON_FENCE) || T.equals((Object) Material.DIAMOND_BLOCK)
				|| T.equals((Object) Material.LAPIS_BLOCK) || T.equals((Object) Material.ENCHANTED_BOOK)
				|| T.equals((Object) Material.BEDROCK) || T.equals((Object) Material.REDSTONE)
				|| T.equals((Object) Material.GOLD_AXE) || T.equals((Object) Material.WATCH)
				|| T.equals((Object) Material.FEATHER) || T.equals((Object) Material.DIAMOND)
				|| T.equals((Object) Material.NAME_TAG) || T.equals((Object) Material.SLIME_BALL)
				|| T.equals((Object) Material.MAGMA_CREAM)) {
			e.setCancelled(true);
		} else {
			e.getItemDrop().remove();
		}
	}
}
