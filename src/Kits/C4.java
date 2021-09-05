package Kits;

import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import Eventos.*;
import org.bukkit.util.*;
import org.bukkit.util.Vector;
import org.bukkit.inventory.*;
import Main.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;

public class C4 implements Listener
{
    public static HashMap<String, Item> bomba;
    
    static {
        C4.bomba = new HashMap<String, Item>();
    }
    
    @EventHandler
    public void aoBotar(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Habilidade.getAbility(p).equalsIgnoreCase("C4")) {
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (p.getItemInHand().getType() == Material.SLIME_BALL) {
                    if (Cooldown.add(p)) {
                        Basico.MensagemCooldown(p);
                        return;
                    }
                    final Location loc = p.getLocation();
                    final Vector vec = new Vector(0, 2, 0);
                    final Location direc = loc.add(vec);
                    final Item item = p.getWorld().dropItem(direc, new ItemStack(Material.TNT, 1));
                    item.setVelocity(p.getEyeLocation().getDirection());
                    C4.bomba.put(p.getName(), item);
                    final ItemStack itemb = new ItemStack(Material.STONE_BUTTON);
                    final ItemMeta itembm = itemb.getItemMeta();
                    itembm.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6C4");
                    itemb.setItemMeta(itembm);
                    p.getInventory().setItemInHand(itemb);
                    p.updateInventory();
                    p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Bomba Armada");
                }
                else if (p.getItemInHand().getType() == Material.STONE_BUTTON) {
                    final ItemStack itemb2 = new ItemStack(Material.SLIME_BALL);
                    final ItemMeta itembm2 = itemb2.getItemMeta();
                    itembm2.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6C4");
                    itemb2.setItemMeta(itembm2);
                    p.getInventory().setItemInHand(itemb2);
                    final Item item2 = C4.bomba.get(p.getName());
                    p.getWorld().createExplosion(item2.getLocation(), 2.5f);
                    item2.getWorld().playEffect(item2.getLocation(), Effect.EXPLOSION_HUGE, 10);
                    C4.bomba.remove(p.getName());
                    item2.remove();
                    p.updateInventory();
                    p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Bomba Explodida");
                    Cooldown.add(p, 20);
                    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstace(), (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Seu CoolDown Foi Terminado");
                        }
                    }, 400L);
                }
            }
            else if ((e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.STONE_BUTTON) {
                if (Cooldown.add(p)) {
                    Basico.MensagemCooldown(p);
                    return;
                }
                final ItemStack itemb2 = new ItemStack(Material.SLIME_BALL);
                final ItemMeta itembm2 = itemb2.getItemMeta();
                itembm2.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6C4");
                itemb2.setItemMeta(itembm2);
                p.getInventory().setItemInHand(itemb2);
                final Item item2 = C4.bomba.get(p.getName());
                C4.bomba.remove(p.getName());
                item2.remove();
                p.updateInventory();
                p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Bomba Desarmada");
            }
        }
    }
    
    @EventHandler
    public void aomorrer(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        if (C4.bomba.containsKey(p.getName())) {
            final Item item = C4.bomba.get(p.getName());
            item.remove();
            C4.bomba.remove(p.getName());
        }
    }
}
