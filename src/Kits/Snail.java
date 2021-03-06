package Kits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;
import Utils.KitAPI;

public class Snail implements Listener {
	public Snail(final LightPvP main) {
	}

	@EventHandler
	public void onSnail(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player p = (Player) e.getEntity();
		final Player d = (Player) e.getDamager();
		if (!KitAPI.Snail.contains(d.getName())) {
			return;
		}
		if (Math.random() > 0.4 && Math.random() > 0.1) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120, 0));
			d.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Voc\u00ea Infectou o Player �e "
					+ p.getDisplayName());
		}
	}
}
