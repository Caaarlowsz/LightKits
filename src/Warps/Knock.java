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

public class Knock implements Listener, CommandExecutor
{
    public static ItemStack kits;
    public static ItemMeta kitsmeta;
    public static ItemStack warps;
    public static ItemMeta warpsmeta;
    public static ItemStack loja;
    public static ItemMeta lojameta;
    public static Main plugin;
    
    public Knock(final Main main) {
        Knock.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("knock")) {
            final Player p = (Player)sender;
            p.getInventory().clear();
            p.getInventory().setBoots((ItemStack)null);
            p.getInventory().setChestplate((ItemStack)null);
            p.getInventory().setLeggings((ItemStack)null);
            p.getInventory().setHelmet((ItemStack)null);
            p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Teleportando Aguarde");
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Knock.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    final World w = Bukkit.getServer().getWorld(Knock.plugin.getConfig().getString("knock.world"));
                    final double x = Knock.plugin.getConfig().getDouble("knock.x");
                    final double y = Knock.plugin.getConfig().getDouble("knock.y");
                    final double z = Knock.plugin.getConfig().getDouble("knock.z");
                    final Location lobby = new Location(w, x, y, z);
                    lobby.setPitch((float)Knock.plugin.getConfig().getDouble("knock.pitch"));
                    lobby.setYaw((float)Knock.plugin.getConfig().getDouble("knock.yaw"));
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
                    KitAPI.setitem(p, Material.STICK, "§cBata", 0, Enchantment.KNOCKBACK, 5, true);
                    TitleAPI.sendFullTitle(p, 50, 50, 80, "§aVoce foi para a", "§b§lKnock");
                    for (final PotionEffect effect : p.getActivePotionEffects()) {
                        p.removePotionEffect(effect.getType());
                    }
                }
            }, 90L);
        }
        return false;
    }
}
