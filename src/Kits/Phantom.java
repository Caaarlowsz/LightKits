package Kits;

import java.util.*;
import Main.*;
import org.bukkit.event.player.*;
import Utils.*;
import org.bukkit.potion.*;
import org.bukkit.*;
import java.util.concurrent.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;

public class Phantom implements Listener
{
    public static HashMap<String, Long> cooldown;
    
    static {
        Phantom.cooldown = new HashMap<String, Long>();
    }
    
    public Phantom(final Main main) {
    }
    
    @EventHandler
    public void voar(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getAction().name().contains("RIGHT") && p.getItemInHand().getType() == Material.FEATHER) {
            e.setCancelled(true);
            p.updateInventory();
            if (KitAPI.Phantom.contains(p.getName())) {
                if (!Phantom.cooldown.containsKey(p.getName()) || Phantom.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
                    p.setAllowFlight(true);
                    p.setFlying(true);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
                    p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " �6� �7 Agora Voc\u00ea Pode Voar Mas Cuidado");
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            p.setFlying(false);
                            p.setAllowFlight(false);
                            p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " �6� �7Voc\u00ea Est\u00e1 Caindo");
                        }
                    }, 150L);
                    Phantom.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(60L));
                }
                else {
                    p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " �6� �7Aguarde o CoolDown Terminar");
                }
            }
        }
    }
    
    @EventHandler
    public void onTomarDano(final EntityDamageEvent event) {
        final Entity e = event.getEntity();
        if (e instanceof Player) {
            final Player player = (Player)e;
            if (event.getEntity() instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.FALL && player.getInventory().contains(Material.GLOWSTONE_DUST) && event.getDamage() >= 0.0) {
                event.setDamage(0.0);
            }
        }
    }
}