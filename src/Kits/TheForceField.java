package Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;
import Utils.KitAPI;

public class TheForceField implements Listener {
	public static List<Player> cooldownm;

	static {
		TheForceField.cooldownm = new ArrayList<Player>();
	}

	public TheForceField(final LightPvP main) {
	}

	@EventHandler
	public void stomperApple(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (event.getPlayer().getItemInHand().getType() == Material.NETHER_FENCE
				&& KitAPI.ForceField.contains(event.getPlayer().getName())) {
			if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
					|| event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
				event.setCancelled(true);
			}
			if (TheForceField.cooldownm.contains(p)) {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Aguarde o CoolDown Terminar");
				return;
			}
			final Location loc = p.getLocation();
			p.getWorld().playSound(loc, Sound.MAGMACUBE_WALK2, 0.5f, 0.5f);
			TheForceField.cooldownm.add(p);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(LightPvP.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					KitAPI.ForceField1.add(p.getName());
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
							+ " �6� �7Voc\u00ea Ativou O ForceField Seu Hask");
				}
			}, 0L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(LightPvP.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					KitAPI.ForceField1.remove(p.getName());
				}
			}, 50L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(LightPvP.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					TheForceField.cooldownm.remove(p);
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Seu CoolDown Foi Terminado");
					p.getWorld().playSound(p.getLocation(), Sound.BURP, 0.5f, 0.5f);
				}
			}, 500L);
		}
	}

	@EventHandler
	public void fraqueza(final PlayerMoveEvent event) {
		final Player p = event.getPlayer();
		if (KitAPI.ForceField1.contains(p.getName())) {
			for (final Entity pertos : p.getNearbyEntities(8.0, 8.0, 8.0)) {
				if (pertos instanceof Player) {
					if (KitAPI.ForceField.contains(p.getName())) {
						((Player) pertos).damage(3.0);
					}
					pertos.setVelocity(new Vector(0.1, 0.0, 0.1));
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(LightPvP.plugin, (Runnable) new Runnable() {
						@Override
						public void run() {
						}
					}, 10L);
				}
			}
		}
	}
}
