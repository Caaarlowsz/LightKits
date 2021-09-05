package Kits;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import Eventos.*;
import org.bukkit.potion.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class Reaper implements Listener, CommandExecutor
{
    @EventHandler
    public void OnClick(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            final Player damager = (Player)e.getDamager();
            final Player victim = (Player)e.getEntity();
            if (Array.kit.get(damager) == "Reaper" && damager.getInventory().getItemInHand().getType() == Material.WOOD_HOE) {
                damager.getLocation().getWorld().playEffect(damager.getLocation(), Effect.GHAST_SHOOT, 8);
                damager.getLocation().getWorld().playEffect(damager.getLocation(), Effect.GHAST_SHRIEK, 8);
                victim.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 3));
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.STONE_SWORD);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cEspada");
        dima.setItemMeta(souperaa);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6Sopa");
        sopa.setItemMeta(sopas);
        final ItemStack especial = new ItemStack(Material.WOOD_HOE);
        final ItemMeta especial2 = especial.getItemMeta();
        especial2.setDisplayName("§0Wither_Hoe");
        especial.setItemMeta(especial2);
        final ItemStack capacete0 = new ItemStack(Material.AIR);
        final ItemStack peitoral0 = new ItemStack(Material.AIR);
        final ItemStack calca0 = new ItemStack(Material.AIR);
        final ItemStack Bota0 = new ItemStack(Material.AIR);
        p.getInventory().setHelmet(capacete0);
        p.getInventory().setChestplate(peitoral0);
        p.getInventory().setLeggings(calca0);
        p.getInventory().setBoots(Bota0);
        if (cmd.equalsIgnoreCase("reaper")) {
            if (Array.used.contains(p.getName())) {
                p.sendMessage("§7» §cVoce ja esta usando um kit!");
                return true;
            }
            if (!p.hasPermission("kit.reaper")) {
                p.sendMessage("§c§l");
                return true;
            }
            Array.used.add(p.getName());
            p.sendMessage("§7» Voce escolheu o kit §cReaper §7!");
            p.setGameMode(GameMode.ADVENTURE);
            p.getInventory().clear();
            Array.kit.put(p, "Reaper");
            p.getInventory().addItem(new ItemStack[] { dima });
            p.getInventory().addItem(new ItemStack[] { especial });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
