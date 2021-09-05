package Menus;

import org.bukkit.entity.*;
import Main.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.command.*;
import org.bukkit.event.inventory.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class WarpsInventory implements Listener, CommandExecutor
{
    public static void guiKits(final Player p) {
        final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder)p, 27, "§8Warps");
        final ItemStack event = new ItemStack(Material.BLAZE_ROD);
        final ItemMeta eventv = event.getItemMeta();
        eventv.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §71v1");
        event.setItemMeta(eventv);
        inv.setItem(15, event);
        final ItemStack eventu = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)4);
        final ItemMeta eventuv = eventu.getItemMeta();
        eventuv.setDisplayName("§7+");
        eventu.setItemMeta(eventuv);
        inv.setItem(0, eventu);
        inv.setItem(1, eventu);
        inv.setItem(2, eventu);
        inv.setItem(3, eventu);
        inv.setItem(4, eventu);
        inv.setItem(5, eventu);
        inv.setItem(6, eventu);
        inv.setItem(7, eventu);
        inv.setItem(9, eventu);
        inv.setItem(10, eventu);
        inv.setItem(17, eventu);
        inv.setItem(18, eventu);
        inv.setItem(19, eventu);
        inv.setItem(20, eventu);
        inv.setItem(21, eventu);
        inv.setItem(22, eventu);
        inv.setItem(23, eventu);
        inv.setItem(24, eventu);
        inv.setItem(25, eventu);
        inv.setItem(26, eventu);
        final ItemStack eventos = new ItemStack(Material.BOOK);
        final ItemMeta eventosv = eventos.getItemMeta();
        eventosv.setDisplayName("§aEventos");
        eventos.setItemMeta(eventosv);
        inv.setItem(8, eventos);
        final ItemStack event2 = new ItemStack(Material.GLASS);
        final ItemMeta eventv2 = event2.getItemMeta();
        eventv2.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Fps");
        event2.setItemMeta(eventv2);
        inv.setItem(11, event2);
        final ItemStack event3 = new ItemStack(Material.LAVA_BUCKET);
        final ItemMeta eventv3 = event3.getItemMeta();
        eventv3.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Lava Challenge");
        event3.setItemMeta(eventv3);
        inv.setItem(12, event3);
        final ItemStack event4 = new ItemStack(Material.GRASS);
        final ItemMeta eventv4 = event4.getItemMeta();
        eventv4.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Parkour");
        event4.setItemMeta(eventv4);
        inv.setItem(13, event4);
        final ItemStack event5 = new ItemStack(Material.POTION);
        final ItemMeta eventv5 = event5.getItemMeta();
        eventv5.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Main");
        event5.setItemMeta(eventv5);
        inv.setItem(14, event5);
        final ItemStack event6 = new ItemStack(Material.STICK);
        final ItemMeta eventv6 = event6.getItemMeta();
        eventv6.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Knock");
        event6.setItemMeta(eventv6);
        inv.setItem(16, event6);
        final ItemStack event7 = new ItemStack(Material.ITEM_FRAME);
        final ItemMeta eventv7 = event7.getItemMeta();
        eventv7.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Texturas");
        event7.setItemMeta(eventv7);
        inv.setItem(10, event7);
        ItemStack[] arrayOfItemStack;
        for (int descpyro1 = (arrayOfItemStack = inv.getContents()).length, metapyro1 = 0; metapyro1 < descpyro1; ++metapyro1) {
            final ItemStack itemStack = arrayOfItemStack[metapyro1];
        }
        p.openInventory(inv);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("warps")) {
            final Player p = (Player)sender;
            guiKits(p);
        }
        return false;
    }
    
    @EventHandler
    public void onPlayerCLickInventry(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("§8Warps") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            if (e.getSlot() == 15) {
                e.setCancelled(true);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                p.chat("/1v1");
                return;
            }
            if (e.getSlot() == 11) {
                e.setCancelled(true);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                p.chat("/fps");
                return;
            }
            if (e.getSlot() == 16) {
                e.setCancelled(true);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                p.chat("/knock");
                return;
            }
            if (e.getSlot() == 10) {
                e.setCancelled(true);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                p.chat("/textura");
                return;
            }
            if (e.getSlot() == 12) {
                e.setCancelled(true);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                p.chat("/challenge");
                return;
            }
            if (e.getSlot() == 13) {
                e.setCancelled(true);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                p.chat("/parkour");
                return;
            }
            if (e.getSlot() == 14) {
                e.setCancelled(true);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                p.chat("/themain");
                return;
            }
            if (e.getSlot() == 8) {
                e.setCancelled(true);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                EventosInventory.guiKits(p);
            }
        }
    }
    
    public static void ir(final Player p, final String string) {
    }
}
