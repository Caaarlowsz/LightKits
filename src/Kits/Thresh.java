package Kits;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;
import Utils.KitAPI;

public class Thresh implements Listener {
	public static HashMap<String, Long> cooldown;
	public static HashMap<String, Snowball> tiros;

	static {
		Thresh.cooldown = new HashMap<String, Long>();
		Thresh.tiros = new HashMap<String, Snowball>();
	}

	public Thresh(final LightPvP main) {
	}

	@EventHandler
	public void disparar(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.LEVER && KitAPI.Thresh.contains(p.getName())) {
			if (!Thresh.cooldown.containsKey(p.getName())
					|| Thresh.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
				e.setCancelled(true);
				p.updateInventory();
				final Snowball tiro = (Snowball) p.launchProjectile(Snowball.class);
				final Vector vec = p.getLocation().getDirection();
				tiro.setVelocity(new Vector(vec.getX() * 1.0 * 3.5, vec.getY() * 1.0 * 4.0, vec.getZ() * 1.0 * 3.5));
				Thresh.tiros.put(p.getName(), tiro);
				Thresh.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(15L));
				p.playSound(p.getLocation(), Sound.GLASS, 1.0f, 1.0f);
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Voc\u00ea Lan\u00e7ou Seu Thresh!");
				return;
			}
			p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Aguarde o CoolDown Terminar");
		}
	}

	@EventHandler
	public void onEntityDamagerByEntity(final EntityDamageByEntityEvent e) {
		final Entity ent = e.getEntity();
		final Entity damager = e.getDamager();
		if (ent instanceof Player) {
			final Player hit = (Player) ent;
			if (damager instanceof Snowball) {
				final Snowball snowball = (Snowball) damager;
				if (snowball.getShooter() instanceof Player) {
					final Player shooter = (Player) snowball.getShooter();
					if (!KitAPI.Thresh.contains(shooter.getName())) {
						return;
					}
					final Location ploc = shooter.getLocation();
					hit.teleport(ploc);
					hit.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1));
					hit.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 1));
					hit.sendMessage(
							String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Usaram o Kit Thresh Em Voc\u00ea");
				}
			}
		}
	}
}
