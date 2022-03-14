package Kits;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import Eventos.Basico;
import Eventos.Cooldown;
import Eventos.Habilidade;
import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;

public class Thor implements Listener {
	@EventHandler
	public void ThorKit(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Thor")
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.GOLD_AXE) {
			if (Cooldown.add(p)) {
				Basico.MensagemCooldown(p);
				return;
			}
			Cooldown.add(p, 5);
			final Location loc = p.getTargetBlock(null, 30).getLocation();
			p.getWorld().strikeLightning(loc);
			e.setCancelled(true);
			Bukkit.getScheduler().scheduleSyncDelayedTask(LightPvP.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Seu CoolDown Foi Terminado");
				}
			}, 100L);
		}
	}
}
