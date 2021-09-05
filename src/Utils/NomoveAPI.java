package Utils;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class NomoveAPI implements Listener {
	public static ArrayList<String> AntiMove1;
	public static ArrayList<String> AntiMove2;

	static {
		NomoveAPI.AntiMove1 = new ArrayList<String>();
		NomoveAPI.AntiMove2 = new ArrayList<String>();
	}

	@EventHandler
	public void Andar(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (NomoveAPI.AntiMove1.contains(p.getName())) {
			e.setCancelled(true);
		}
		if (NomoveAPI.AntiMove2.contains(p.getName())) {
			p.setVelocity(new Vector(0.0, -2.0, 0.0));
		}
	}
}
