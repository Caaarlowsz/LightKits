package Kits;

import java.util.*;
import Main.*;
import Utils.*;
import org.bukkit.potion.*;
import org.bukkit.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.entity.*;

public class FireBender implements Listener
{
    public static ArrayList<String> wateratack;
    public static ArrayList<String> cooldown;
    
    static {
        FireBender.wateratack = new ArrayList<String>();
        FireBender.cooldown = new ArrayList<String>();
    }
    
    public FireBender() {
    }
    
    public FireBender(final Main main) {
    }
    
    @EventHandler
    public void PlayerInteractEvt(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        final Player ent = (Player)e.getRightClicked();
        if (FireBender.cooldown.contains(p.getName())) {
            p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Aguarde o CoolDown Acabar");
            return;
        }
        if (KitAPI.FireBender.contains(p.getName()) && p.getItemInHand().getType() == Material.REDSTONE) {
            FireBender.wateratack.add(ent.getName());
            FireBender.cooldown.add(p.getName());
            ent.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 50, 200));
            ent.setFireTicks(150);
            Bukkit.getScheduler().scheduleAsyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                @Override
                public void run() {
                    FireBender.wateratack.remove(ent.getName());
                }
            }, 40L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                @Override
                public void run() {
                    FireBender.cooldown.remove(p.getName());
                    p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Seu CoolDown Foi Terminado");
                }
            }, 400L);
        }
    }
    
    @EventHandler
    public void PlayerMov(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (FireBender.wateratack.contains(p.getName())) {
            p.teleport((Entity)p);
        }
    }
}
