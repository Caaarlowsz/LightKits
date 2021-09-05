package Eventos;

import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import Main.*;
import org.bukkit.*;
import java.util.*;
import org.bukkit.event.*;

public class Bussola implements Listener
{
    @EventHandler
    public void clicarBussola(final PlayerInteractEvent e) {
        boolean parar = false;
        if (e.getPlayer().getItemInHand().getType() == Material.COMPASS) {
            for (final Entity entidades : e.getPlayer().getNearbyEntities(100.0, 150.0, 100.0)) {
                if (entidades instanceof Player && e.getPlayer().getLocation().distance(entidades.getLocation()) >= 9.0) {
                    if (entidades.getLocation().getY() > 170.0) {
                        return;
                    }
                    parar = true;
                    e.getPlayer().setCompassTarget(entidades.getLocation());
                    e.getPlayer().sendMessage(String.valueOf(Main.prefix) + " §7Bussola apontando para §2" + ((Player)entidades).getName());
                    return;
                }
            }
            if (!parar) {
                e.getPlayer().sendMessage(String.valueOf(Main.prefix) + " §7Nenhum jogador encontrado!");
                e.getPlayer().setCompassTarget(new Location(e.getPlayer().getWorld(), 0.0, 100.0, 0.0));
            }
        }
    }
}
