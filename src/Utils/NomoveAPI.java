package Utils;

import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.util.*;
import org.bukkit.util.Vector;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class NomoveAPI implements Listener
{
    public static ArrayList<String> AntiMove1;
    public static ArrayList<String> AntiMove2;
    
    static {
        NomoveAPI.AntiMove1 = new ArrayList<String>();
        NomoveAPI.AntiMove2 = new ArrayList<String>();
    }
    
    @EventHandler
    public void Andar(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (NomoveAPI.AntiMove1.contains(p.getName())) {
            e.setCancelled(true);
        }
        if (NomoveAPI.AntiMove2.contains(p.getName())) {
            p.setVelocity(new Vector(0.0, -2.0, 0.0));
        }
    }
}
