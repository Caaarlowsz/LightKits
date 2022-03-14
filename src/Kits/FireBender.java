package Kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;
import Utils.KitAPI;

public class FireBender implements Listener {
	public static ArrayList<String> wateratack;
	public static ArrayList<String> cooldown;

	static {
		FireBender.wateratack = new ArrayList<String>();
		FireBender.cooldown = new ArrayList<String>();
	}

	public FireBender() {
	}

	public FireBender(final LightPvP main) {
	}

	@EventHandler
	public void PlayerInteractEvt(final PlayerInteractEntityEvent e) {
		final Player p = e.getPlayer();
		final Player ent = (Player) e.getRightClicked();
		if (FireBender.cooldown.contains(p.getName())) {
			p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Aguarde o CoolDown Acabar");
			return;
		}
		if (KitAPI.FireBender.contains(p.getName()) && p.getItemInHand().getType() == Material.REDSTONE) {
			FireBender.wateratack.add(ent.getName());
			FireBender.cooldown.add(p.getName());
			ent.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 50, 200));
			ent.setFireTicks(150);
			Bukkit.getScheduler().scheduleAsyncDelayedTask((Plugin) LightPvP.instance, (Runnable) new Runnable() {
				@Override
				public void run() {
					FireBender.wateratack.remove(ent.getName());
				}
			}, 40L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) LightPvP.instance,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							FireBender.cooldown.remove(p.getName());
							p.sendMessage(
									String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Seu CoolDown Foi Terminado");
						}
					}, 400L);
		}
	}

	@EventHandler
	public void PlayerMov(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (FireBender.wateratack.contains(p.getName())) {
			p.teleport((Entity) p);
		}
	}
}
