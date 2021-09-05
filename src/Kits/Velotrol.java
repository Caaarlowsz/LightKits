package Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import Main.Main;
import Utils.KitAPI;

public class Velotrol implements Listener {
	public int boost;
	public static ArrayList<String> velotrol;
	public static List<Player> cooldownm;

	static {
		Velotrol.velotrol = new ArrayList<String>();
		Velotrol.cooldownm = new ArrayList<Player>();
	}

	public Velotrol(final Main main) {
		this.boost = Integer.valueOf(6);
	}

	@EventHandler
	public void VelotrolClick(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (event.getPlayer().getItemInHand().getType() == Material.MINECART
				&& KitAPI.Velotrol.contains(event.getPlayer().getName())) {
			if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
					|| event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
				event.setCancelled(true);
			}
			if (Velotrol.cooldownm.contains(p)) {
				p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Aguarde o CoolDown Acabar");
				return;
			}
			p.setVelocity(p.getEyeLocation().getDirection().multiply(this.boost).add(new Vector(0, 0, 0)));
			p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
			final Location loc = p.getLocation();
			Velotrol.velotrol.add(p.getName());
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
				}
			}, 15L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
				}
			}, 14L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
				}
			}, 13L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
				}
			}, 12L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
				}
			}, 11L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
				}
			}, 10L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
				}
			}, 9L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.getWorld().createExplosion(loc, 3.0f);
				}
			}, 30L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					Velotrol.velotrol.remove(p.getName());
				}
			}, 50L);
			p.getWorld().playSound(loc, Sound.ENDERMAN_TELEPORT, 5.0f, -5.0f);
			Velotrol.cooldownm.add(p);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					Velotrol.cooldownm.remove(p);
					p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Seu CoolDown Foi Terminado");
					p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0f, 5.0f);
				}
			}, 700L);
		}
	}
}
