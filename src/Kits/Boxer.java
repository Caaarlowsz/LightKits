package Kits;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import Eventos.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class Boxer implements Listener
{
    @EventHandler
    public void AoBoxer(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getDamager() instanceof Player) {
            final Player p = (Player)e.getDamager();
            if (Habilidade.getAbility(p).equalsIgnoreCase("Boxer") && e.getEntity() instanceof Player && p.getItemInHand().getType() == Material.QUARTZ) {
                e.setDamage(e.getDamage() + 2.5);
            }
        }
    }
}
