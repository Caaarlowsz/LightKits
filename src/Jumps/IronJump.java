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

public class IronJump implements Listener
{
    public static Main plugin;
    public static ArrayList<String> Ferro;
    
    static {
        IronJump.Ferro = new ArrayList<String>();
    }
    
    public IronJump(final Main main) {
        IronJump.plugin = main;
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJump1(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.IRON_BLOCK) {
            IronJump.Ferro.remove(p.getName());
            final Location loc = e.getTo().getBlock().getLocation();
            final Vector sponge = p.getLocation().getDirection().multiply(0).setY(2);
            p.setVelocity(sponge);
            p.playSound(loc, Sound.ANVIL_BREAK, 6.0f, 1.0f);
            p.playEffect(loc, Effect.ENDER_SIGNAL, (Object)null);
            IronJump.Ferro.add(p.getName());
        }
    }
    
    @EventHandler
    public void onFall(final EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            if (e.getCause().equals((Object)EntityDamageEvent.DamageCause.FALL) && IronJump.Ferro.contains(p.getName())) {
                e.setCancelled(true);
                IronJump.Ferro.remove(p.getName());
            }
        }
    }
}
