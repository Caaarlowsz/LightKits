package Warps;

import org.bukkit.event.*;
import Main.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class SetSpawn implements CommandExecutor, Listener
{
    public static Main plugin;
    
    public SetSpawn(final Main main) {
        SetSpawn.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("setspawn") && sender instanceof Player) {
            if (!sender.hasPermission("utils.setwarp")) {
                final Player p1 = (Player)sender;
                p1.sendMessage("§c§lSETWARP » §fSem Permiss\u00e3o");
            }
            if (sender.hasPermission("sword.setwarp")) {
                final Player p1 = (Player)sender;
                SetSpawn.plugin.getConfig().set("spawn.x", (Object)p1.getLocation().getX());
                SetSpawn.plugin.getConfig().set("spawn.y", (Object)p1.getLocation().getY());
                SetSpawn.plugin.getConfig().set("spawn.z", (Object)p1.getLocation().getZ());
                SetSpawn.plugin.getConfig().set("spawn.pitch", (Object)p1.getLocation().getPitch());
                SetSpawn.plugin.getConfig().set("spawn.yaw", (Object)p1.getLocation().getYaw());
                SetSpawn.plugin.getConfig().set("spawn.world", (Object)p1.getLocation().getWorld().getName());
                SetSpawn.plugin.saveConfig();
                p1.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Spawn Foi Setado Com Sucesso");
                p1.getWorld().setSpawnLocation(p1.getLocation().getBlockX(), p1.getLocation().getBlockY(), p1.getLocation().getBlockZ());
            }
            return false;
        }
        return false;
    }
}
