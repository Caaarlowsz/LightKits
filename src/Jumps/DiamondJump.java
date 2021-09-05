package Jumps;

import Main.*;
import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.block.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.util.*;
import org.bukkit.util.Vector;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;

public class DiamondJump implements Listener
{
    public static Main plugin;
    public static ArrayList<String> Diamante;
    
    static {
        DiamondJump.Diamante = new ArrayList<String>();
    }
    
    public DiamondJump(final Main main) {
        DiamondJump.plugin = main;
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJump1(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.DIAMOND_BLOCK) {
            DiamondJump.Diamante.remove(p.getName());
            final Location loc = e.getTo().getBlock().getLocation();
            final Vector sponge = p.getLocation().getDirection().multiply(0).setY(1);
            p.setVelocity(sponge);
            p.playSound(loc, Sound.ARROW_HIT, 6.0f, 1.0f);
            p.playEffect(loc, Effect.ENDER_SIGNAL, (Object)null);
            DiamondJump.Diamante.add(p.getName());
        }
    }
    
    @EventHandler
    public void onFall(final EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            if (e.getCause().equals((Object)EntityDamageEvent.DamageCause.FALL) && DiamondJump.Diamante.contains(p.getName())) {
                e.setCancelled(true);
                DiamondJump.Diamante.remove(p.getName());
            }
        }
    }
}
