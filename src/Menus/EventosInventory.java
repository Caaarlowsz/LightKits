package Menus;

import org.bukkit.entity.*;
import Main.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.command.*;
import org.bukkit.event.inventory.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class EventosInventory implements Listener, CommandExecutor
{
    public static void guiKits(final Player p) {
        final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder)p, 27, "�8Eventos");
        final ItemStack eventu = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)4);
        final ItemMeta eventuv = eventu.getItemMeta();
        eventuv.setDisplayName("�7+");
        eventu.setItemMeta(eventuv);
        inv.setItem(0, eventu);
        inv.setItem(1, eventu);
        inv.setItem(2, eventu);
        inv.setItem(3, eventu);
        inv.setItem(4, eventu);
        inv.setItem(5, eventu);
        inv.setItem(6, eventu);
        inv.setItem(7, eventu);
        inv.setItem(8, eventu);
        inv.setItem(9, eventu);
        inv.setItem(10, eventu);
        inv.setItem(11, eventu);
        inv.setItem(13, eventu);
        inv.setItem(15, eventu);
        inv.setItem(16, eventu);
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
        final ItemStack eventos = new ItemStack(Material.CAKE);
        final ItemMeta eventosv = eventos.getItemMeta();
        eventosv.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " �6� �7MDR");
        eventos.setItemMeta(eventosv);
        inv.setItem(12, eventos);
        final ItemStack event2 = new ItemStack(Material.STONE_SWORD);
        final ItemMeta eventv2 = event2.getItemMeta();
        eventv2.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " �6� �7RDM");
        event2.setItemMeta(eventv2);
        inv.setItem(14, event2);
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
        if (e.getInventory().getTitle().equalsIgnoreCase("�8Eventos") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            if (e.getSlot() == 12) {
                e.setCancelled(true);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                p.chat("/mdr");
                return;
            }
            if (e.getSlot() == 14) {
                e.setCancelled(true);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                p.chat("/rdm");
            }
        }
    }
    
    public static void ir(final Player p, final String string) {
    }
}
