package Warps;

import Main.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.inventory.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.potion.*;
import com.connorlinfoot.titleapi.*;
import Utils.*;
import Eventos.*;
import java.util.*;
import org.bukkit.plugin.*;

public class Parkour implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Parkour(final Main main) {
        Parkour.plugin = main;
    }
    
    @EventHandler
    public void onClickI1t3em4s(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getPlayer().getItemInHand().getType() == Material.getMaterial(2258)) {
            e.setCancelled(true);
            p.playSound(p.getLocation(), Sound.CLICK, 5.0f, 5.0f);
            final World w = Bukkit.getServer().getWorld(Parkour.plugin.getConfig().getString("parkour.world"));
            final double x = Parkour.plugin.getConfig().getDouble("parkour.x");
            final double y = Parkour.plugin.getConfig().getDouble("parkour.y");
            final double z = Parkour.plugin.getConfig().getDouble("parkour.z");
            final Location lobby = new Location(w, x, y, z);
            lobby.setPitch((float)Parkour.plugin.getConfig().getDouble("parkour.pitch"));
            lobby.setYaw((float)Parkour.plugin.getConfig().getDouble("parkour.yaw"));
            final ItemStack peito = new ItemStack(Material.getMaterial(2258));
            final ItemMeta peito2 = peito.getItemMeta();
            peito2.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Voltar Ao Inicio");
            peito.setItemMeta(peito2);
            final ItemStack peito3 = new ItemStack(Material.getMaterial(2261));
            final ItemMeta peito4 = peito3.getItemMeta();
            peito4.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Voltar Ao Spawn");
            peito3.setItemMeta(peito4);
            p.getInventory().setItem(3, peito3);
            p.getInventory().setItem(5, peito);
            p.setHealthScale(20.0);
            p.teleport(lobby);
            p.setHealth(20.0);
        }
    }
    
    @EventHandler
    public void onCl1ickI1t3em4s(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getPlayer().getItemInHand().getType() == Material.getMaterial(2261)) {
            e.setCancelled(true);
            p.playSound(p.getLocation(), Sound.CLICK, 5.0f, 5.0f);
            p.chat("/spawn");
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("parkour")) {
            final Player p = (Player)sender;
            final World w = Bukkit.getServer().getWorld(Parkour.plugin.getConfig().getString("parkour.world"));
            final double x = Parkour.plugin.getConfig().getDouble("parkour.x");
            final double y = Parkour.plugin.getConfig().getDouble("parkour.y");
            final double z = Parkour.plugin.getConfig().getDouble("parkour.z");
            final Location lobby = new Location(w, x, y, z);
            lobby.setPitch((float)Parkour.plugin.getConfig().getDouble("parkour.pitch"));
            lobby.setYaw((float)Parkour.plugin.getConfig().getDouble("parkour.yaw"));
            p.getInventory().clear();
            p.setHealthScale(1.0);
            p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Teleportando Aguarde");
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
            final ItemStack peito = new ItemStack(Material.getMaterial(2258));
            final ItemMeta peito2 = peito.getItemMeta();
            peito2.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Voltar Ao Inicio");
            peito.setItemMeta(peito2);
            final ItemStack peito3 = new ItemStack(Material.getMaterial(2261));
            final ItemMeta peito4 = peito3.getItemMeta();
            peito4.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Voltar Ao Spawn");
            peito3.setItemMeta(peito4);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Parkour.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.teleport(lobby);
                    p.getInventory().clear();
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Teleportado");
                    TitleAPI.sendFullTitle(p, 50, 50, 80, "§aVoce foi para o", "§b§lPARKOUR");
                    KitAPI.remove(p);
                    Habilidade.setAbility(p, "Parkour");
                    final ItemStack peito = new ItemStack(Material.getMaterial(2258));
                    final ItemMeta peito2 = peito.getItemMeta();
                    peito2.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Voltar Ao Inicio");
                    peito.setItemMeta(peito2);
                    p.getInventory().setBoots((ItemStack)null);
                    p.getInventory().setChestplate((ItemStack)null);
                    p.getInventory().setLeggings((ItemStack)null);
                    p.getInventory().setHelmet((ItemStack)null);
                    p.setHealthScale(20.0);
                    final ItemStack espada = new ItemStack(Material.getMaterial(2258));
                    p.getInventory().setItem(3, peito3);
                    p.getInventory().setItem(5, peito);
                    p.setFireTicks(0);
                    for (final PotionEffect effect : p.getActivePotionEffects()) {
                        p.removePotionEffect(effect.getType());
                    }
                }
            }, 90L);
            return false;
        }
        return false;
    }
}
