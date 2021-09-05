package Eventos;

import org.bukkit.event.*;
import org.bukkit.inventory.*;
import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.*;

public class Array implements Listener
{
    public static String monkCooldownMessage;
    public String monkedMessage;
    public static int cooldownmonk;
    public static int monkItemId;
    public static boolean sendThroughInventory;
    public static transient HashMap<ItemStack, Long> monkStaff;
    public static ArrayList<String> admin;
    public static ArrayList<String> report;
    public static ArrayList<String> used;
    public static ArrayList<String> warp;
    public static ArrayList<String> Velotrol2;
    public static ArrayList<String> freeze;
    public static ArrayList<String> freezing;
    public static HashMap<Player, String> kit;
    
    static {
        Array.monkCooldownMessage = "§cVoce pode monkar denovo em %s segundos!";
        Array.cooldownmonk = 15;
        Array.monkItemId = Material.BLAZE_ROD.getId();
        Array.sendThroughInventory = true;
        Array.monkStaff = new HashMap<ItemStack, Long>();
        Array.admin = new ArrayList<String>();
        Array.report = new ArrayList<String>();
        Array.used = new ArrayList<String>();
        Array.warp = new ArrayList<String>();
        Array.Velotrol2 = new ArrayList<String>();
        Array.freeze = new ArrayList<String>();
        Array.freezing = new ArrayList<String>();
        Array.kit = new HashMap<Player, String>();
    }
    
    public Array() {
        this.monkedMessage = "§cVoce usou o poder monk !";
    }
    
    public static int getPing(final Player p) {
        return ((CraftPlayer)p).getHandle().ping;
    }
    
    public static int Ping(final Player p) {
        return ((CraftPlayer)p).getHandle().ping;
    }
    
    public static String getShortStr(final String name) {
        if (name.length() >= 16) {
            final String shorts = name.substring(0, 13);
            return shorts;
        }
        if (name.length() >= 15) {
            final String shorts = name.substring(0, 13);
            return shorts;
        }
        return name;
    }
    
    public static String getShortTagMod(final String name) {
        if (name.length() >= 16) {
            final String shorts = name.substring(0, 12);
            return shorts;
        }
        if (name.length() >= 15) {
            final String shorts = name.substring(0, 12);
            return shorts;
        }
        if (name.length() >= 14) {
            final String shorts = name.substring(0, 12);
            return shorts;
        }
        if (name.length() >= 13) {
            final String shorts = name.substring(0, 12);
            return shorts;
        }
        return name;
    }
}
