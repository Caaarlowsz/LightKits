package Menus;

import java.util.*;
import Main.*;
import org.bukkit.event.inventory.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.command.*;

public class ExtrasInventory implements Listener, CommandExecutor
{
    public static ArrayList<String> setandokit;
    
    static {
        ExtrasInventory.setandokit = new ArrayList<String>();
    }
    
    public ExtrasInventory(final Main main) {
    }
    
    @EventHandler
    public void warps(final InventoryClickEvent e) {
        if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
            final Inventory inv = e.getInventory();
            final Player p = (Player)e.getWhoClicked();
            if (inv.getTitle().equals("§8Extras")) {
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
            }
        }
    }
    
    public static void guiKits1(final Player p) {
        final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder)p, 27, "§8Extras");
        final ItemStack vidro1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
        final ItemMeta meta1v = vidro1.getItemMeta();
        meta1v.setDisplayName("§7+");
        vidro1.setItemMeta(meta1v);
        final ItemStack vidro2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)4);
        final ItemMeta meta2v = vidro2.getItemMeta();
        meta2v.setDisplayName("§7+");
        vidro2.setItemMeta(meta2v);
        inv.setItem(0, vidro2);
        inv.setItem(1, vidro2);
        inv.setItem(2, vidro2);
        inv.setItem(3, vidro2);
        inv.setItem(4, vidro2);
        inv.setItem(5, vidro2);
        inv.setItem(6, vidro2);
        inv.setItem(7, vidro2);
        inv.setItem(8, vidro2);
        inv.setItem(9, vidro2);
        inv.setItem(10, vidro2);
        inv.setItem(16, vidro2);
        inv.setItem(17, vidro2);
        inv.setItem(18, vidro2);
        inv.setItem(19, vidro2);
        inv.setItem(20, vidro2);
        inv.setItem(21, vidro2);
        inv.setItem(22, vidro2);
        inv.setItem(23, vidro2);
        inv.setItem(24, vidro2);
        inv.setItem(25, vidro2);
        inv.setItem(26, vidro2);
        final ItemStack loja2 = new ItemStack(Material.DIAMOND_SWORD);
        final ItemMeta loja2v = loja2.getItemMeta();
        loja2v.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Ranks");
        loja2.setItemMeta(loja2v);
        inv.setItem(13, loja2);
        final ItemStack loja3 = new ItemStack(Material.ANVIL, 1, (short)0);
        final ItemMeta loja27v = loja3.getItemMeta();
        loja27v.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Requisitos");
        loja3.setItemMeta(loja27v);
        inv.setItem(14, loja3);
        final ItemStack loja4 = new ItemStack(Material.SLIME_BALL);
        final ItemMeta loja26v = loja4.getItemMeta();
        loja26v.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Dono");
        loja4.setItemMeta(loja26v);
        inv.setItem(11, loja4);
        final ItemStack loja5 = new ItemStack(Material.getMaterial(339));
        final ItemMeta loja24v = loja5.getItemMeta();
        loja24v.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Formul\u00e1rios");
        loja5.setItemMeta(loja24v);
        inv.setItem(12, loja5);
        final ItemStack loja6 = new ItemStack(Material.getMaterial(58), 1, (short)0);
        final ItemMeta loja23v = loja6.getItemMeta();
        loja23v.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Regras");
        loja6.setItemMeta(loja23v);
        inv.setItem(15, loja6);
        ItemStack[] arrayOfItemStack;
        for (int descpyro1 = (arrayOfItemStack = inv.getContents()).length, metapyro1 = 0; metapyro1 < descpyro1; ++metapyro1) {
            final ItemStack itemStack = arrayOfItemStack[metapyro1];
        }
        p.openInventory(inv);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("extras")) {
            final Player p = (Player)sender;
            guiKits1(p);
        }
        return false;
    }
    
    @EventHandler
    public void onPlayerCLickInventry(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("§8Extras") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/ranks");
                return;
            }
            if (e.getCurrentItem().getType() == Material.ANVIL) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/youtuber");
                return;
            }
            if (e.getCurrentItem().getType() == Material.SLIME_BALL) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/dono");
                return;
            }
            if (e.getCurrentItem().getType() == Material.getMaterial(58)) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/regras");
                return;
            }
            if (e.getCurrentItem().getType() == Material.getMaterial(339)) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/aplicar");
                return;
            }
            if (e.getCurrentItem().getType() == Material.SKULL_ITEM) {
                e.setCancelled(true);
                p.closeInventory();
                StatusInventory.guiKits(p);
            }
        }
    }
}
