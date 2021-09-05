package Comandos;

import org.bukkit.event.*;
import java.util.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.scheduler.*;
import org.bukkit.*;
import Main.*;
import org.bukkit.inventory.*;

public class AutoSoupCommand implements CommandExecutor, Listener
{
    public static HashMap<String, ItemStack[]> saveinv;
    public static HashMap<String, ItemStack[]> armadura;
    
    static {
        AutoSoupCommand.saveinv = new HashMap<String, ItemStack[]>();
        AutoSoupCommand.armadura = new HashMap<String, ItemStack[]>();
    }
    
    public boolean onCommand(final CommandSender s, final Command c, final String l, final String[] args) {
        if (!(s instanceof Player)) {
            s.sendMessage("§c§lAUTOSOUP §7Use esse comando no servidor!");
            return true;
        }
        if (c.getName().equalsIgnoreCase("autosoup")) {
            final Player p = (Player)s;
            if (!p.hasPermission("cmd.admin")) {
                p.sendMessage("§cDesculpe, Mas voce nao tem permissao para executar isto.");
            }
            if (args.length == 0) {
                p.sendMessage("§c§lAUTOSOUP §7Use /autosoup (jogador)!");
                return true;
            }
            final Player rr = Bukkit.getPlayer(args[0]);
            if (rr == null) {
                p.sendMessage("§cO Player '" + args[0] + "' esta offline ou nao existe!");
            }
            else {
                AutoSoupCommand.armadura.put(rr.getName(), rr.getInventory().getArmorContents());
                AutoSoupCommand.saveinv.put(rr.getName(), rr.getInventory().getContents());
                rr.getInventory().clear();
                final PlayerInventory rrinv = rr.getInventory();
                p.openInventory((Inventory)rrinv);
                new BukkitRunnable() {
                    public void run() {
                        rr.setHealth(5.0);
                        rr.getInventory().setItem(11, new ItemStack(Material.MUSHROOM_SOUP));
                    }
                }.runTaskLater(Main.getPlugin(), 1L);
                new BukkitRunnable() {
                    public void run() {
                        rr.setHealth(5.0);
                        rr.damage(0.5);
                        rr.getInventory().setItem(12, new ItemStack(Material.MUSHROOM_SOUP));
                    }
                }.runTaskLater(Main.getPlugin(), 10L);
                new BukkitRunnable() {
                    public void run() {
                        rr.setHealth(5.0);
                        rr.damage(0.5);
                        rr.getInventory().setItem(13, new ItemStack(Material.MUSHROOM_SOUP));
                    }
                }.runTaskLater(Main.getPlugin(), 20L);
                new BukkitRunnable() {
                    public void run() {
                        rr.setHealth(5.0);
                        rr.damage(0.5);
                        rr.getInventory().setItem(14, new ItemStack(Material.MUSHROOM_SOUP));
                    }
                }.runTaskLater(Main.getPlugin(), 30L);
                new BukkitRunnable() {
                    public void run() {
                        rr.setHealth(5.0);
                        rr.damage(0.5);
                        rr.getInventory().setItem(15, new ItemStack(Material.MUSHROOM_SOUP));
                    }
                }.runTaskLater(Main.getPlugin(), 40L);
                new BukkitRunnable() {
                    public void run() {
                        rr.setHealth(5.0);
                        rr.damage(0.5);
                        rr.getInventory().setItem(16, new ItemStack(Material.MUSHROOM_SOUP));
                    }
                }.runTaskLater(Main.getPlugin(), 50L);
                new BukkitRunnable() {
                    public void run() {
                        p.getOpenInventory().close();
                        p.sendMessage("§c§lAUTOSOUP §7Voce testou o AutoSoup em " + rr.getName() + "§7Ele tomou §e" + AutoSoupCommand.getAmount(rr, Material.BOWL) + " §7/ §e6");
                    }
                }.runTaskLater(Main.getPlugin(), 60L);
                new BukkitRunnable() {
                    public void run() {
                        rr.getInventory().clear();
                        rr.getInventory().setArmorContents((ItemStack[])AutoSoupCommand.armadura.get(rr.getName()));
                        rr.getInventory().setContents((ItemStack[])AutoSoupCommand.saveinv.get(rr.getName()));
                        rr.setHealth(20.0);
                    }
                }.runTaskLater(Main.getPlugin(), 75L);
            }
        }
        return false;
    }
    
    public static int getAmount(final Player p, final Material m) {
        int amount = 0;
        ItemStack[] arrayOfItemStack;
        for (int j = (arrayOfItemStack = p.getInventory().getContents()).length, i = 0; i < j; ++i) {
            final ItemStack item = arrayOfItemStack[i];
            if (item != null && item.getType() == m && item.getAmount() > 0) {
                amount += item.getAmount();
            }
        }
        return amount;
    }
}
