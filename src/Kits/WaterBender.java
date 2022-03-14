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
import Utils.Raios;

public class WaterBender implements Listener {
	public static ArrayList<String> wateratack;
	public static ArrayList<String> cooldown;

	static {
		WaterBender.wateratack = new ArrayList<String>();
		WaterBender.cooldown = new ArrayList<String>();
	}

	@EventHandler
	public void PlayerInteractEvt(final PlayerInteractEntityEvent e) {
		final Player p = e.getPlayer();
		final Player ent = (Player) e.getRightClicked();
		if (WaterBender.cooldown.contains(p.getName())) {
			p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Aguarde o CoolDown Terminar");
			return;
		}
		if (KitAPI.WaterBender.contains(p.getName()) && p.getItemInHand().getType() == Material.INK_SACK) {
			WaterBender.wateratack.add(ent.getName());
			Raios.kitaguala(ent.getLocation());
			WaterBender.cooldown.add(p.getName());
			ent.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 50, 200));
			Bukkit.getScheduler().scheduleAsyncDelayedTask((Plugin) LightPvP.instance, (Runnable) new Runnable() {
				@Override
				public void run() {
					WaterBender.wateratack.remove(ent.getName());
				}
			}, 40L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) LightPvP.instance,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							WaterBender.cooldown.remove(p.getName());
							p.sendMessage(
									String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Seu CoolDown Foi Terminado");
						}
					}, 800L);
		}
	}

	@EventHandler
	public void PlayerMov(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (WaterBender.wateratack.contains(p.getName())) {
			p.teleport((Entity) p);
		}
	}
}
