package Kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;
import Utils.KitAPI;

public class Kangaroo implements Listener {
	ArrayList<String> tempo;
	ArrayList<String> naofugir;

	public Kangaroo(final LightPvP main) {
		this.tempo = new ArrayList<String>();
		this.naofugir = new ArrayList<String>();
	}

	@EventHandler
	public void pular(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (p.getItemInHand().getType() == Material.FIREWORK && KitAPI.Kangaroo.contains(p.getName())) {
			event.setCancelled(true);
			final Vector vector = p.getEyeLocation().getDirection();
			if (!this.naofugir.contains(p.getName())) {
				if (!this.tempo.contains(p.getName())) {
					this.tempo.add(p.getName());
					if (!p.isSneaking()) {
						p.setFallDistance(-1.0f);
						vector.multiply(0.5f);
						vector.setY(1.0);
						p.setVelocity(vector);
					} else {
						p.setFallDistance(-1.0f);
						vector.multiply(1.5f);
						vector.setY(0.5);
						p.setVelocity(vector);
					}
				}
			} else if (!this.tempo.contains(p.getName())) {
				this.tempo.add(p.getName());
				p.setFallDistance(0.0f);
				vector.multiply(0.0f);
				vector.setY(0.0);
				p.setVelocity(vector);
			}
			if (this.naofugir.contains(p.getName())) {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Pode Utilizar Seu Kit Em Combate");
			}
		}
	}

	@EventHandler
	public void onDamageds(final EntityDamageEvent event) {
		final Entity e = event.getEntity();
		if (e instanceof Player) {
			final Player player = (Player) e;
			if (event.getEntity() instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.FALL
					&& player.getInventory().contains(Material.FIREWORK) && event.getDamage() >= 7.0) {
				event.setDamage(7.0);
			}
		}
	}

	@EventHandler
	public void removertempo(final PlayerMoveEvent event) {
		final Player p = event.getPlayer();
		if (this.tempo.contains(p.getName())) {
			final Block b = p.getLocation().getBlock();
			if (b.getType() != Material.AIR || b.getRelative(BlockFace.DOWN).getType() != Material.AIR) {
				this.tempo.remove(p.getName());
			}
		}
	}

	@EventHandler
	public void adicionartempo(final EntityDamageByEntityEvent event) {
		if (!(event.getEntity() instanceof Player)) {
			return;
		}
		final Player kangaroo = (Player) event.getEntity();
		if (event.getDamager() instanceof Player) {
			final Player p = (Player) event.getDamager();
			if (kangaroo instanceof Player && p instanceof Player
					&& kangaroo.getInventory().contains(Material.FIREWORK)) {
				this.naofugir.add(kangaroo.getName());
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) LightPvP.getInstace(),
						(Runnable) new Runnable() {
							@Override
							public void run() {
								Kangaroo.this.naofugir.remove(kangaroo.getName());
							}
						}, 100L);
			}
		}
	}
}
