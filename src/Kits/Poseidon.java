package Kits;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

import Eventos.Basico;
import Eventos.Habilidade;

public class Poseidon implements Listener {
	@EventHandler
	public void aoPoseidon(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		final Block b = p.getLocation().getBlock();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Poseidon")
				&& (b.getType() == Material.WATER || b.getType() == Material.STATIONARY_WATER)) {
			Basico.darEfeito(p, PotionEffectType.INCREASE_DAMAGE, 10, 1);
			Basico.darEfeito(p, PotionEffectType.DAMAGE_RESISTANCE, 10, 1);
			Basico.darEfeito(p, PotionEffectType.SPEED, 8, 0);
		}
	}
}
