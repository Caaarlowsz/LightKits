package Outros;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;

public class MotdOther implements Listener {
	@EventHandler
	public void NomedoServer(final ServerListPingEvent e) {
		e.setMotd(LightPvP.motd);
		if (Bukkit.hasWhitelist()) {
			e.setMotd(LightPvP.motd2);
		}
	}
}
