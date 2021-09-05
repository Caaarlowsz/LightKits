package Menus;

import org.bukkit.event.inventory.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import Coins.XpM;
import Main.Main;
import Score.ScoreBoarding;
import Utils.KillsdeathsmoneyAPI;

import org.bukkit.command.*;

public class LojaPermsInventory implements Listener, CommandExecutor
{
    public LojaPermsInventory(final Main main) {
    }
    
    @EventHandler
    public void warps(final InventoryClickEvent e) {
        if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
            final Inventory inv = e.getInventory();
            final Player p = (Player)e.getWhoClicked();
            if (inv.getTitle().equals("§8Loja de Permissoes")) {
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
            }
        }
    }
    
    @SuppressWarnings({ "deprecation", "unused" })
	public static void guiKits1(final Player p) {
        final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder)p, 27, "§8Loja de Permissoes");
        final ItemStack vidro1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
        final ItemMeta meta1v = vidro1.getItemMeta();
        meta1v.setDisplayName("§7+");
        vidro1.setItemMeta(meta1v);
        
        final ItemStack vidro2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)10);
        final ItemMeta meta2v = vidro2.getItemMeta();
        meta2v.setDisplayName("§7+");
        vidro2.setItemMeta(meta2v);
        
        final ItemStack loja23 = new ItemStack(Material.getMaterial(385), 1, (short)0);
        final ItemMeta loja23v = loja23.getItemMeta();
        loja23v.setDisplayName(String.valueOf(Main.prefix) + " §6» Pagina Atual");
        loja23.setItemMeta(loja23v);
        
        final ItemStack event12 = new ItemStack(Material.getMaterial(402));
        final ItemMeta eventv12 = event12.getItemMeta();
        final ItemStack t1event12 = new ItemStack(Material.PAPER);
        final ItemMeta t1eventv12 = t1event12.getItemMeta();
        t1eventv12.setDisplayName(String.valueOf(Main.prefix) + " §6» §7Falar Colorido 500 Coins");
        t1event12.setItemMeta(t1eventv12);
        inv.setItem(11, t1event12);
        final ItemStack t1event13 = new ItemStack(Material.REDSTONE_COMPARATOR);
        final ItemMeta t1eventv13 = t1event13.getItemMeta();
        t1eventv13.setDisplayName(String.valueOf(Main.prefix) + " §6» §7Falar Com o Chat Mutado 1000 Coins");
        t1event13.setItemMeta(t1eventv13);
        inv.setItem(13, t1event13);
        final ItemStack tloja23 = new ItemStack(Material.SLIME_BALL, 1, (short)0);
        final ItemMeta tloja23v = tloja23.getItemMeta();
        tloja23v.setDisplayName(String.valueOf(Main.prefix) + " §6» §7Entrar No Servidor Lotado 10000 Coins");
        tloja23.setItemMeta(tloja23v);
        inv.setItem(15, tloja23);
        ItemStack[] arrayOfItemStack;
        for (int descpyro1 = (arrayOfItemStack = inv.getContents()).length, metapyro1 = 0; metapyro1 < descpyro1; ++metapyro1) {
            final ItemStack itemStack = arrayOfItemStack[metapyro1];
        }
        p.openInventory(inv);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("lojaperms")) {
            final Player p = (Player)sender;
            guiKits1(p);
        }
        return false;
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onPlayerCLickInventry(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("§8Loja de Permissoes") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(String.valueOf(Main.prefix) + " §6» §7Falar Colorido 500 Coins")) {
                if (XpM.getPlayerMoney(p) >= 500) {
                    XpM.removeMoney(p, 500);
                    Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex user " + p.getName() + " add chat.cor");
                    p.sendMessage(String.valueOf(Main.prefix) + " §6» §7Voc\u00ea Comprou a Permiss\u00e3o §6Falar §6§lColorido");
                    e.setCancelled(true);
                    p.closeInventory();
                    ScoreBoarding.setScoreBoard(p);
                }
                else if (XpM.getPlayerMoney(p) < 500) {
                    p.sendMessage(String.valueOf(Main.prefix) + " §6» §7Sem Moedas o Suficiente");
                    e.setCancelled(true);
                    p.closeInventory();
                }
            }
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(String.valueOf(Main.prefix) + " §6» §7Falar Com o Chat Mutado 1000 Coins")) {
            if (XpM.getPlayerMoney(p) >= 1000) {
                XpM.removeMoney(p, 1000);
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex user " + p.getName() + " add falar.chat");
                p.sendMessage(String.valueOf(Main.prefix) + " §6» §7Voc\u00ea Comprou a Permiss\u00e3o §6Falar Com o Chat Mutado");
                e.setCancelled(true);
                p.closeInventory();
                ScoreBoarding.setScoreBoard(p);
            }
            else if (XpM.getPlayerMoney(p) < 1000) {
                p.sendMessage(String.valueOf(Main.prefix) + " §6» §7Sem Moedas o Suficiente");
                e.setCancelled(true);
                p.closeInventory();
            }
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(String.valueOf(Main.prefix) + " §6» §7Entrar No Servidor Lotado 10000 Coins")) {
            if (XpM.getPlayerMoney(p) >= 10000) {
                XpM.removeMoney(p, 10000);
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex user " + p.getName() + " add entrar.lotado");
                p.sendMessage(String.valueOf(Main.prefix) + " §6» §7Voc\u00ea Comprou a Permiss\u00e3o §6Entrar No Servidor §6§lLotado");
                e.setCancelled(true);
                p.closeInventory();
                ScoreBoarding.setScoreBoard(p);
            }
            else if (XpM.getPlayerMoney(p) < 10000) {
                p.sendMessage(String.valueOf(Main.prefix) + " §6» §7Sem Moedas o Suficiente");
                e.setCancelled(true);
                p.closeInventory();
            }
        }
    }
}
