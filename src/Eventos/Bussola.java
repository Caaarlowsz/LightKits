package Eventos;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;

public class Bussola implements Listener {
	@EventHandler
	public void clicarBussola(final PlayerInteractEvent e) {
		boolean parar = false;
		if (e.getPlayer().getItemInHand().getType() == Material.COMPASS) {
			for (final Entity entidades : e.getPlayer().getNearbyEntities(100.0, 150.0, 100.0)) {
				if (entidades instanceof Player
						&& e.getPlayer().getLocation().distance(entidades.getLocation()) >= 9.0) {
					if (entidades.getLocation().getY() > 170.0) {
						return;
					}
					parar = true;
					e.getPlayer().setCompassTarget(entidades.getLocation());
					e.getPlayer().sendMessage(String.valueOf(LightPvP.prefix) + " �7Bussola apontando para �2"
							+ ((Player) entidades).getName());
					return;
				}
			}
			if (!parar) {
				e.getPlayer().sendMessage(String.valueOf(LightPvP.prefix) + " �7Nenhum jogador encontrado!");
				e.getPlayer().setCompassTarget(new Location(e.getPlayer().getWorld(), 0.0, 100.0, 0.0));
			}
		}
	}
}
