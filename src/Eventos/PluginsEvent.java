package Eventos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import Main.Main;

public class PluginsEvent implements Listener {
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCommandPreProcess(final PlayerCommandPreprocessEvent e) {
		final String[] msg = e.getMessage().split(" ");
		final List<String> plugins = new ArrayList<String>();
		plugins.add("pl");
		plugins.add("plugin");
		plugins.add("about" + msg);
		plugins.add("ver" + msg);
		plugins.add("help" + msg);
		plugins.add("ver");
		plugins.add("help");
		plugins.add("?");
		plugins.add("me");
		plugins.add("bukkit:me");
		plugins.add("calc");
		plugins.add("bukkit:help");
		plugins.add("bukkit:pl");
		plugins.add("bukkit:plugins");
		plugins.add("about");
		plugins.add("about" + msg);
		plugins.add("bukkit:?");
		plugins.add("plugins");
		plugins.add("minecraft:me");
		for (final String Loop : plugins) {
			if (msg[0].equalsIgnoreCase("/" + Loop)) {
				e.getPlayer().sendMessage("  §7Plugin criado pelo EhOMarcello");
				e.getPlayer().sendMessage(" §7Servidor Utilizando " + Main.prefix);
				e.setCancelled(true);
			}
		}
	}
}
