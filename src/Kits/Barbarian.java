package Kits;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import Eventos.*;
import Main.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class Barbarian implements Listener, CommandExecutor
{
    @EventHandler
    public void onKill(final PlayerDeathEvent e) {
        if (e.getEntity().getKiller() instanceof Player) {
            final Player k = e.getEntity().getKiller();
            if (Habilidade.getAbility(k) == "Barbarian") {
                if (k.getItemInHand().getType() == Material.WOOD_SWORD) {
                    k.setItemInHand(new ItemStack(Material.STONE_SWORD));
                    k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                    k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "1");
                }
                else if (k.getItemInHand().getType() == Material.STONE_SWORD) {
                    k.setItemInHand(new ItemStack(Material.IRON_SWORD));
                    k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                    k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "2");
                }
                else if (k.getItemInHand().getType() == Material.IRON_SWORD) {
                    k.setItemInHand(new ItemStack(Material.DIAMOND_SWORD));
                    k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                    k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "3");
                }
                else if (k.getItemInHand().getType() == Material.DIAMOND_SWORD) {
                    final int max = 5;
                    if (k.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
                        final int lvl = k.getItemInHand().getEnchantmentLevel(Enchantment.DAMAGE_ALL);
                        if (lvl + 1 <= 5) {
                            k.getItemInHand().removeEnchantment(Enchantment.DAMAGE_ALL);
                            k.getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, lvl + 1);
                            k.updateInventory();
                            k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                            if (lvl + 1 == 2) {
                                k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "5");
                            }
                            else if (lvl + 1 == 3) {
                                k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "6");
                            }
                            else if (lvl + 1 == 4) {
                                k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "7");
                            }
                            else if (lvl + 1 == 5) {
                                k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "8");
                            }
                        }
                        else {
                            k.sendMessage(ChatColor.GOLD + "Voc\u00ea Est\u00e0 No Level Maximo");
                        }
                    }
                    else {
                        k.getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, 1);
                        k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                        k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "4");
                    }
                }
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
        dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cEspada");
        dima.setItemMeta(souperaa);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6Sopa");
        sopa.setItemMeta(sopas);
        final ItemStack capacete0 = new ItemStack(Material.AIR);
        final ItemStack peitoral0 = new ItemStack(Material.AIR);
        final ItemStack calca0 = new ItemStack(Material.AIR);
        final ItemStack Bota0 = new ItemStack(Material.AIR);
        p.getInventory().setHelmet(capacete0);
        p.getInventory().setChestplate(peitoral0);
        p.getInventory().setLeggings(calca0);
        p.getInventory().setBoots(Bota0);
        if (Habilidade.getAbility(p) == "Barbarian") {
            if (Array.used.contains(p.getName())) {
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVoce ja esta usando um kit!");
                return true;
            }
            if (!p.hasPermission("kit.barbarian")) {
                p.sendMessage("§cVoce nao tem permissao para usar este kit !");
                return true;
            }
            Array.used.add(p.getName());
            p.sendMessage(String.valueOf(Main.prefix) + " §7» Voce escolheu o kit §cBarbarian §7!");
            p.setGameMode(GameMode.ADVENTURE);
            p.getInventory().clear();
            Array.kit.put(p, "Barbarian");
            p.getInventory().addItem(new ItemStack[] { dima });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
