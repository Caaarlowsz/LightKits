package Utils;

import org.bukkit.event.*;
import java.util.*;
import org.bukkit.inventory.*;
import Main.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.enchantments.*;
import com.sk89q.worldguard.bukkit.*;
import org.bukkit.*;
import org.bukkit.plugin.*;
import com.sk89q.worldguard.protection.flags.*;
import com.sk89q.worldguard.protection.*;

public class KitAPI implements Listener
{
    public static final String Kitado;
    public static ArrayList<String> Kit;
    public static ArrayList<String> PvP;
    public static ArrayList<String> Ninja;
    public static ArrayList<String> Fisherman;
    public static ArrayList<String> Stomper;
    public static ArrayList<String> Ajnin;
    public static ArrayList<String> Kangaroo;
    public static ArrayList<String> Hulk;
    public static ArrayList<String> Thor;
    public static ArrayList<String> Anchor;
    public static ArrayList<String> Terrorista;
    public static ArrayList<String> Monk;
    public static ArrayList<String> Gladiator;
    public static ArrayList<String> Thresh;
    public static ArrayList<String> DubleJump;
    public static ArrayList<String> Trader;
    public static ArrayList<String> Viper;
    public static ArrayList<String> ForceField;
    public static ArrayList<String> ForceField1;
    public static ArrayList<String> Snail;
    public static ArrayList<String> IronMan;
    public static ArrayList<String> Phantom;
    public static ArrayList<String> C4;
    public static ArrayList<String> Armor;
    public static ArrayList<String> Magma;
    public static ArrayList<String> Turtle;
    public static ArrayList<String> JellyFish;
    public static ArrayList<String> Sonic;
    public static ArrayList<String> WaterBender;
    public static ArrayList<String> FireBender;
    public static ArrayList<String> Velotrol;
    public static ArrayList<String> Urgal;
    public static ArrayList<String> DeshFire;
    public static ArrayList<String> Resouper;
    public static ArrayList<String> Poseidon;
    public static ArrayList<String> Reaper;
    public static ArrayList<String> Grandpa;
    public static ArrayList<String> Swords;
    public static ArrayList<String> Avatar;
    public static ArrayList<String> Boxer;
    public static ArrayList<String> Barbarian;
    public static ArrayList<String> Switcher;
    public static ArrayList<String> Archer;
    public static ArrayList<String> Viking;
    public static ArrayList<String> voidChallenge;
    public static ArrayList<String> TellReceber;
    public static HashMap<String, Integer> voidChallengeTime;
    public static ArrayList<String> refillTest;
    public static HashMap<String, Integer> refillTestTime;
    public static ItemStack peitometa;
    public static LeatherArmorMeta botasmeta;
    public static ItemStack peito;
    public static ItemStack botas;
    public static Object KitDelay;
    public static Object used;
    public static Object cooldown;
    
    static {
        Kitado = null;
        KitAPI.Kit = new ArrayList<String>();
        KitAPI.PvP = new ArrayList<String>();
        KitAPI.Ninja = new ArrayList<String>();
        KitAPI.Fisherman = new ArrayList<String>();
        KitAPI.Stomper = new ArrayList<String>();
        KitAPI.Ajnin = new ArrayList<String>();
        KitAPI.Boxer = new ArrayList<String>();
        KitAPI.Kangaroo = new ArrayList<String>();
        KitAPI.Hulk = new ArrayList<String>();
        KitAPI.Thor = new ArrayList<String>();
        KitAPI.Anchor = new ArrayList<String>();
        KitAPI.Terrorista = new ArrayList<String>();
        KitAPI.Monk = new ArrayList<String>();
        KitAPI.Gladiator = new ArrayList<String>();
        KitAPI.Thresh = new ArrayList<String>();
        KitAPI.DubleJump = new ArrayList<String>();
        KitAPI.Trader = new ArrayList<String>();
        KitAPI.Viper = new ArrayList<String>();
        KitAPI.ForceField = new ArrayList<String>();
        KitAPI.ForceField1 = new ArrayList<String>();
        KitAPI.Snail = new ArrayList<String>();
        KitAPI.IronMan = new ArrayList<String>();
        KitAPI.Phantom = new ArrayList<String>();
        KitAPI.C4 = new ArrayList<String>();
        KitAPI.Armor = new ArrayList<String>();
        KitAPI.Magma = new ArrayList<String>();
        KitAPI.Turtle = new ArrayList<String>();
        KitAPI.JellyFish = new ArrayList<String>();
        KitAPI.Sonic = new ArrayList<String>();
        KitAPI.WaterBender = new ArrayList<String>();
        KitAPI.FireBender = new ArrayList<String>();
        KitAPI.Velotrol = new ArrayList<String>();
        KitAPI.Urgal = new ArrayList<String>();
        KitAPI.DeshFire = new ArrayList<String>();
        KitAPI.Resouper = new ArrayList<String>();
        KitAPI.Poseidon = new ArrayList<String>();
        KitAPI.Reaper = new ArrayList<String>();
        KitAPI.Grandpa = new ArrayList<String>();
        KitAPI.Swords = new ArrayList<String>();
        KitAPI.Avatar = new ArrayList<String>();
        KitAPI.Barbarian = new ArrayList<String>();
        KitAPI.Switcher = new ArrayList<String>();
        KitAPI.Archer = new ArrayList<String>();
        KitAPI.Viking = new ArrayList<String>();
        KitAPI.voidChallenge = new ArrayList<String>();
        KitAPI.TellReceber = new ArrayList<String>();
        KitAPI.voidChallengeTime = new HashMap<String, Integer>();
        KitAPI.refillTest = new ArrayList<String>();
        KitAPI.refillTestTime = new HashMap<String, Integer>();
    }
    
    public KitAPI(final Main main) {
    }
    
    public static void remove(final Player p) {
        KitAPI.Kit.remove(p.getName());
        KitAPI.PvP.remove(p.getName());
        KitAPI.Ninja.remove(p.getName());
        KitAPI.Velotrol.remove(p.getName());
        KitAPI.Gladiator.remove(p.getName());
        KitAPI.Poseidon.remove(p.getName());
        KitAPI.Urgal.remove(p.getName());
        KitAPI.Fisherman.remove(p.getName());
        KitAPI.Turtle.remove(p.getName());
        KitAPI.Swords.remove(p.getName());
        KitAPI.DeshFire.remove(p.getName());
        KitAPI.Grandpa.remove(p.getName());
        KitAPI.FireBender.remove(p.getName());
        KitAPI.Trader.remove(p.getName());
        KitAPI.Sonic.remove(p.getName());
        KitAPI.Magma.remove(p.getName());
        KitAPI.Avatar.remove(p.getName());
        KitAPI.Reaper.remove(p.getName());
        KitAPI.WaterBender.remove(p.getName());
        KitAPI.IronMan.remove(p.getName());
        KitAPI.ForceField.remove(p.getName());
        KitAPI.Viking.remove(p.getName());
        KitAPI.ForceField1.remove(p.getName());
        KitAPI.JellyFish.remove(p.getName());
        KitAPI.Boxer.remove(p.getName());
        KitAPI.Stomper.remove(p.getName());
        KitAPI.Barbarian.remove(p.getName());
        KitAPI.C4.remove(p.getName());
        KitAPI.Terrorista.remove(p.getName());
        KitAPI.Monk.remove(p.getName());
        KitAPI.Ajnin.remove(p.getName());
        KitAPI.Armor.remove(p.getName());
        KitAPI.Kangaroo.remove(p.getName());
        KitAPI.Archer.remove(p.getName());
        KitAPI.Hulk.remove(p.getName());
        KitAPI.Thor.remove(p.getName());
        KitAPI.Anchor.remove(p.getName());
        KitAPI.Viper.remove(p.getName());
        KitAPI.Snail.remove(p.getName());
        KitAPI.Switcher.remove(p.getName());
        KitAPI.Phantom.remove(p.getName());
        KitAPI.Thresh.remove(p.getName());
        KitAPI.DubleJump.remove(p.getName());
        KitAPI.Resouper.remove(p.getName());
    }
    
    public static void sopa(final Player p) {
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta ksopa = sopa.getItemMeta();
        ksopa.setDisplayName("§6Sopa");
        sopa.setItemMeta(ksopa);
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
        p.getInventory().addItem(new ItemStack[] { sopa });
    }
    
    public static void recraft(final Player p) {
        final ItemStack sopas = new ItemStack(Material.BOWL, 64);
        final ItemMeta ksopas = sopas.getItemMeta();
        sopas.setItemMeta(ksopas);
        final ItemStack cogur = new ItemStack(Material.RED_MUSHROOM, 64);
        final ItemMeta kcogur = cogur.getItemMeta();
        cogur.setItemMeta(kcogur);
        final ItemStack cogum = new ItemStack(Material.BROWN_MUSHROOM, 64);
        final ItemMeta kcogum = cogum.getItemMeta();
        cogum.setItemMeta(kcogum);
        p.getInventory().setItem(13, sopas);
        p.getInventory().setItem(14, cogur);
        p.getInventory().setItem(15, cogum);
        final ItemStack espada1 = new ItemStack(Material.COMPASS);
        final ItemMeta kespada1 = espada1.getItemMeta();
        kespada1.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6B\u00fassola");
        espada1.setItemMeta(kespada1);
        p.getInventory().setItem(8, espada1);
    }
    
    public static void sword(final Player p) {
        final ItemStack espada = new ItemStack(Material.STONE_SWORD);
        final ItemMeta kespada = espada.getItemMeta();
        kespada.setDisplayName(String.valueOf(String.valueOf(Main.prefix)) + " §6Espada");
        kespada.addEnchant(Enchantment.DURABILITY, 10, true);
        espada.setItemMeta(kespada);
        p.getInventory().setItem(0, espada);
        KitAPI.botas = new ItemStack(Material.LEATHER_CHESTPLATE);
        (KitAPI.botasmeta = (LeatherArmorMeta)KitAPI.botas.getItemMeta()).setDisplayName("§7Peitoral");
        KitAPI.botas.setItemMeta((ItemMeta)KitAPI.botasmeta);
        p.getInventory().setBoots((ItemStack)null);
        p.getInventory().setChestplate((ItemStack)null);
        p.getInventory().setLeggings((ItemStack)null);
        p.getInventory().setHelmet((ItemStack)null);
    }
    
    public static void setitem(final Player p, final Material mat, final String nome, final int lugar, final Enchantment enchant, final int level, final boolean trueorfalse) {
        final ItemStack item = new ItemStack(mat);
        final ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(nome);
        itemmeta.addEnchant(enchant, level, trueorfalse);
        item.setItemMeta(itemmeta);
        p.getInventory().setItem(lugar, item);
    }
    
    public static WorldGuardPlugin getWorldGuard() {
        final Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
        if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
            return null;
        }
        return (WorldGuardPlugin)plugin;
    }
    
    public static boolean areaPvP(final Player p) {
        final ApplicableRegionSet region = getWorldGuard().getRegionManager(p.getWorld()).getApplicableRegions(p.getLocation());
        return region.allows(DefaultFlag.PVP);
    }
    
    public static void Challenge(final Player p) {
    }
    
    public static void removeAbility(final Player p) {
    }
    
    public static String PegarKit(final Player p) {
        return null;
    }
    
    public static String PegarKit2(final Player localPlayer1) {
        return null;
    }
    
    public static Object getKit(final Player p) {
        return null;
    }
    
    public static String getAbility(final Player p) {
        return null;
    }
    
    public void remove(final String name) {
    }
}
