package Outros;

import org.bukkit.event.server.*;
import Main.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class MotdOther implements Listener
{
    @EventHandler
    public void NomedoServer(final ServerListPingEvent e) {
        e.setMotd(Main.motd);
        if (Bukkit.hasWhitelist()) {
            e.setMotd(Main.motd2);
        }
    }
}
