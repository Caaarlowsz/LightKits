package Warps;

import org.bukkit.event.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import Main.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import Utils.*;
import Eventos.*;
import org.bukkit.enchantments.*;
import com.connorlinfoot.titleapi.*;
import org.bukkit.potion.*;
import org.bukkit.*;
import java.util.*;
import org.bukkit.plugin.*;

public class Spawn implements Listener, CommandExecutor
{
    public static ItemStack kits;
    public static ItemMeta kitsmeta;
    public static ItemStack warps;
    public static ItemMeta warpsmeta;
    public static ItemStack loja;
    public static ItemMeta lojameta;
    public static Main plugin;
    
    public Spawn(final Main main) {
        Spawn.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("spawn")) {
            final Player p = (Player)sender;
            p.getInventory().clear();
            p.getInventory().setBoots((ItemStack)null);
            p.getInventory().setChestplate((ItemStack)null);
            p.getInventory().setLeggings((ItemStack)null);
            p.getInventory().setHelmet((ItemStack)null);
            p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Teleportando Aguarde");
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Spawn.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    final World w = Bukkit.getServer().getWorld(Spawn.plugin.getConfig().getString("spawn.world"));
                    final double x = Spawn.plugin.getConfig().getDouble("spawn.x");
                    final double y = Spawn.plugin.getConfig().getDouble("spawn.y");
                    final double z = Spawn.plugin.getConfig().getDouble("spawn.z");
                    final Location lobby = new Location(w, x, y, z);
                    lobby.setPitch((float)Spawn.plugin.getConfig().getDouble("spawn.pitch"));
                    lobby.setYaw((float)Spawn.plugin.getConfig().getDouble("spawn.yaw"));
                    KitAPI.remove(p);
                    Habilidade.removeAbility(p);
                    p.getInventory().setBoots((ItemStack)null);
                    p.getInventory().setChestplate((ItemStack)null);
                    p.getInventory().setLeggings((ItemStack)null);
                    p.getInventory().setHelmet((ItemStack)null);
                    p.getInventory().clear();
                    p.teleport(lobby);
                    p.setExp(0.0f);
                    p.setExhaustion(20.0f);
                    p.setFireTicks(0);
                    p.setFoodLevel(20000);
                    p.setHealth(20.0);
                    KitAPI.setitem(p, Material.ENDER_CHEST, "§a\u2022 Kits §a\u2022", 4, Enchantment.DAMAGE_ALL, 0, false);
                    KitAPI.setitem(p, Material.ENCHANTED_BOOK, "§9\u2022 Warps \u2022", 5, Enchantment.DAMAGE_ALL, 0, false);
                    KitAPI.setitem(p, Material.PAPER, "§b\u2022 Loja \u2022", 3, Enchantment.DAMAGE_ALL, 0, false);
                    KitAPI.setitem(p, Material.JUKEBOX, "§c\u2022 Extras \u2022", 6, Enchantment.DAMAGE_ALL, 0, false);
                    KitAPI.setitem(p, Material.EXP_BOTTLE, "§c\u2022 Status \u2022", 2, Enchantment.DAMAGE_ALL, 0, false);
                    TitleAPI.sendFullTitle(p, 50, 50, 80, "§aVoce foi para o", "§b§lSPAWN");
                    for (final PotionEffect effect : p.getActivePotionEffects()) {
                        p.removePotionEffect(effect.getType());
                    }
                }
            }, 90L);
        }
        return false;
    }
}
