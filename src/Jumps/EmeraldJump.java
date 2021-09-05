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

public class EmeraldJump implements Listener
{
    public static Main plugin;
    public static ArrayList<String> Esmeralda;
    
    static {
        EmeraldJump.Esmeralda = new ArrayList<String>();
    }
    
    public EmeraldJump(final Main main) {
        EmeraldJump.plugin = main;
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJump1(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.EMERALD_BLOCK) {
            EmeraldJump.Esmeralda.remove(p.getName());
            final Location loc = e.getTo().getBlock().getLocation();
            final Vector sponge = p.getLocation().getDirection().multiply(0).setY(3);
            p.setVelocity(sponge);
            p.playSound(loc, Sound.ORB_PICKUP, 6.0f, 1.0f);
            p.playEffect(loc, Effect.ENDER_SIGNAL, (Object)null);
            p.playEffect(loc, Effect.CLICK1, (Object)null);
            p.playEffect(loc, Effect.BLAZE_SHOOT, (Object)null);
            EmeraldJump.Esmeralda.add(p.getName());
        }
    }
    
    @EventHandler
    public void onFall(final EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            if (e.getCause().equals((Object)EntityDamageEvent.DamageCause.FALL) && EmeraldJump.Esmeralda.contains(p.getName())) {
                e.setCancelled(true);
                EmeraldJump.Esmeralda.remove(p.getName());
            }
        }
    }
}
