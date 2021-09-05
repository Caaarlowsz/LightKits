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

public class WaterBender implements Listener
{
    public static ArrayList<String> wateratack;
    public static ArrayList<String> cooldown;
    
    static {
        WaterBender.wateratack = new ArrayList<String>();
        WaterBender.cooldown = new ArrayList<String>();
    }
    
    @EventHandler
    public void PlayerInteractEvt(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        final Player ent = (Player)e.getRightClicked();
        if (WaterBender.cooldown.contains(p.getName())) {
            p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Aguarde o CoolDown Terminar");
            return;
        }
        if (KitAPI.WaterBender.contains(p.getName()) && p.getItemInHand().getType() == Material.INK_SACK) {
            WaterBender.wateratack.add(ent.getName());
            Raios.kitaguala(ent.getLocation());
            WaterBender.cooldown.add(p.getName());
            ent.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 50, 200));
            Bukkit.getScheduler().scheduleAsyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                @Override
                public void run() {
                    WaterBender.wateratack.remove(ent.getName());
                }
            }, 40L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                @Override
                public void run() {
                    WaterBender.cooldown.remove(p.getName());
                    p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Seu CoolDown Foi Terminado");
                }
            }, 800L);
        }
    }
    
    @EventHandler
    public void PlayerMov(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (WaterBender.wateratack.contains(p.getName())) {
            p.teleport((Entity)p);
        }
    }
}
