package Kits;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;
import Utils.KitAPI;

public class Fisherman implements Listener {
	public Fisherman(final LightPvP main) {
	}

	@EventHandler
	public void onPlayerFish(final PlayerFishEvent event) {
		final Entity caught = event.getCaught();
		final Block block = event.getHook().getLocation().getBlock();
		if (caught != null && caught != block && KitAPI.Fisherman.contains(event.getPlayer().getName())) {
			caught.teleport(event.getPlayer().getLocation());
		}
	}
}
