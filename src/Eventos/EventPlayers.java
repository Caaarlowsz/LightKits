package Eventos;

import org.bukkit.inventory.*;
import com.connorlinfoot.titleapi.*;
import Utils.*;
import Score.*;
import org.bukkit.enchantments.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;
import Menus.*;
import org.bukkit.event.player.*;

public class EventPlayers implements Listener
{
    public static ItemStack kits;
    public static ItemMeta kitsmeta;
    public static ItemStack warps;
    public static ItemMeta warpsmeta;
    public static ItemStack loja;
    public static ItemMeta lojameta;
    
    @SuppressWarnings({ "deprecation", "unchecked" })
	@EventHandler
    public void Entrar(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        e.setJoinMessage((String)null);
        TitleAPI.sendFullTitle(p, 50, 50, 80, "§aBem Vindo!", p.getName());
        p.teleport(p.getWorld().getSpawnLocation());
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 10.0f, 0.0f);
        p.getInventory().setHelmet((ItemStack)null);
        p.getInventory().setChestplate((ItemStack)null);
        p.getInventory().setLeggings((ItemStack)null);
        p.getInventory().setBoots((ItemStack)null);
        p.getActivePotionEffects().clear();
        KitAPI.remove(p);
        p.setGameMode(GameMode.SURVIVAL);
        Habilidade.removeAbility(p);
        p.getInventory().clear();
        ScoreBoarding.setScoreBoard(p);
        final Firework f = (Firework)p.getPlayer().getWorld().spawn(p.getPlayer().getLocation(), (Class)Firework.class);
        final FireworkMeta fm = f.getFireworkMeta();
        fm.addEffect(FireworkEffect.builder().flicker(true).trail(true).with(FireworkEffect.Type.BALL).withColor(Color.RED).withFade(Color.GREEN).build());
        fm.setPower(2);
        f.setFireworkMeta(fm);
        KitAPI.setitem(p, Material.ENDER_CHEST, "§a\u2022 Kits §a\u2022", 4, Enchantment.DAMAGE_ALL, 0, false);
        KitAPI.setitem(p, Material.ENCHANTED_BOOK, "§9\u2022 Warps \u2022", 5, Enchantment.DAMAGE_ALL, 0, false);
        KitAPI.setitem(p, Material.PAPER, "§b\u2022 Loja \u2022", 3, Enchantment.DAMAGE_ALL, 0, false);
        KitAPI.setitem(p, Material.JUKEBOX, "§c\u2022 Extras \u2022", 6, Enchantment.DAMAGE_ALL, 0, false);
        KitAPI.setitem(p, Material.EXP_BOTTLE, "§c\u2022 Status \u2022", 2, Enchantment.DAMAGE_ALL, 0, false);
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void onColorandChangeChat(final PlayerChatEvent e) {
        final Player p = e.getPlayer();
        if (e.getMessage().equalsIgnoreCase("server lixo") || e.getMessage().equalsIgnoreCase("servidor lixo")) {
            e.setMessage("Amei esse servidor \u00e9 o melhor do mundo <3");
        }
        if (e.getMessage().equalsIgnoreCase("sou hack")) {
            e.setMessage("Sou Um Lixo E Uso Hack Me Bani");
        }
        if (e.getMessage().contains(" ez ") || e.getMessage().contains(" iz ")) {
            e.setCancelled(true);
            p.sendMessage("§cPor Favor N\u00e3o Diga Isso! '<ez, iz>' ");
        }
        if (!p.hasPermission("ver.report") && (e.getMessage().contains(".net") || e.getMessage().contains(".com") || e.getMessage().contains(".crafted") || e.getMessage().contains(".com.br") || e.getMessage().contains(".pro") || e.getMessage().contains(".nu") || e.getMessage().contains(".tk"))) {
            e.setCancelled(true);
            p.sendMessage("§cVoc\u00ea n\u00e3o pode divulgar IP´s nesse servidor");
            p.sendMessage("§cVoc\u00ea foi reportado a um staff");
            Bukkit.broadcast("§7" + p.getName() + " §6Esta Divulgando IP´s Mute-o", "ver.report");
        }
    }
    
    @EventHandler
    public void Respawnar(final PlayerRespawnEvent e) {
        final Player p = e.getPlayer();
        p.getInventory().setHelmet((ItemStack)null);
        p.getInventory().setChestplate((ItemStack)null);
        p.getInventory().setLeggings((ItemStack)null);
        p.getInventory().setBoots((ItemStack)null);
        KitAPI.remove(p);
        Habilidade.removeAbility(p);
        KitAPI.setitem(p, Material.ENDER_CHEST, "§a\u2022 Kits §a\u2022", 4, Enchantment.DAMAGE_ALL, 0, false);
        KitAPI.setitem(p, Material.ENCHANTED_BOOK, "§9\u2022 Warps \u2022", 5, Enchantment.DAMAGE_ALL, 0, false);
        KitAPI.setitem(p, Material.PAPER, "§b\u2022 Loja \u2022", 3, Enchantment.DAMAGE_ALL, 0, false);
        KitAPI.setitem(p, Material.JUKEBOX, "§c\u2022 Extras \u2022", 6, Enchantment.DAMAGE_ALL, 0, false);
        KitAPI.setitem(p, Material.EXP_BOTTLE, "§c\u2022 Status \u2022", 2, Enchantment.DAMAGE_ALL, 0, false);
    }
    
    @EventHandler
    public void onClickItem4(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getPlayer().getItemInHand().getType() == Material.ENDER_CHEST) {
            e.setCancelled(true);
            p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5.0f, 5.0f);
            KitsInventory.guiKits1(p);
        }
    }
    
    @EventHandler
    public void onClickItem5(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getPlayer().getItemInHand().getType() == Material.JUKEBOX) {
            e.setCancelled(true);
            p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5.0f, 5.0f);
            ExtrasInventory.guiKits1(p);
        }
    }
    
    @EventHandler
    public void onClickItem6(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getPlayer().getItemInHand().getType() == Material.EXP_BOTTLE) {
            e.setCancelled(true);
            p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5.0f, 5.0f);
            StatusInventory.guiKits(p);
        }
    }
    
    @EventHandler
    public void onSair(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        e.setQuitMessage((String)null);
    }
}
