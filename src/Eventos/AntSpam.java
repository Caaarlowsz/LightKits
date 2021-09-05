package Eventos;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import Main.Main;

public class AntSpam implements Listener {
	public static HashMap<Player, Long> chat;

	static {
		AntSpam.chat = new HashMap<Player, Long>();
	}

	public AntSpam(final Main main) {
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
	public void aAntiSpam(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (!AntSpam.chat.containsKey(p)) {
			final long time = System.currentTimeMillis() + 2000L;
			if (p.hasPermission("falar.sspam")) {
				return;
			}
			AntSpam.chat.put(p, time);
		} else if (AntSpam.chat.get(p) <= System.currentTimeMillis()) {
			if (p.hasPermission("falar.sspam")) {
				return;
			}
			final long time = System.currentTimeMillis() + 2000L;
			AntSpam.chat.put(p, time);
		} else {
			if (AntSpam.chat.get(p) < System.currentTimeMillis() || p.hasPermission("falar.sspam")) {
				return;
			}
			p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §eEvite flood no chat!");
			e.setCancelled(true);
		}
	}
}
