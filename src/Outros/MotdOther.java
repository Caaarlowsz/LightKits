package Outros;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import Main.Main;

public class MotdOther implements Listener {
	@EventHandler
	public void NomedoServer(final ServerListPingEvent e) {
		e.setMotd(Main.motd);
		if (Bukkit.hasWhitelist()) {
			e.setMotd(Main.motd2);
		}
	}
}
