package Kits;

import Main.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import Utils.*;
import org.bukkit.potion.*;
import org.bukkit.event.*;

public class Snail implements Listener
{
    public Snail(final Main main) {
    }
    
    @EventHandler
    public void onSnail(final EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        if (!(e.getDamager() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        final Player d = (Player)e.getDamager();
        if (!KitAPI.Snail.contains(d.getName())) {
            return;
        }
        if (Math.random() > 0.4 && Math.random() > 0.1) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120, 0));
            d.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Voc\u00ea Infectou o Player §e " + p.getDisplayName());
        }
    }
}
