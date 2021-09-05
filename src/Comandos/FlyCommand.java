package Comandos;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import Main.*;
import org.bukkit.*;

public class FlyCommand implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §7» Apenas Players Podem Executar Esse Comando");
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("fly")) {
            final Player p = (Player)sender;
            if (args.length == 0) {
                if (p.hasPermission("cmd.fly")) {
                    if (!p.getAllowFlight()) {
                        p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §7» Voc\u00ea §a§lHABILITOU§7 o Modo Fly");
                        p.setAllowFlight(true);
                    }
                    else {
                        p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §7» Voc\u00ea §c§lDESABILITOU§7 o Modo Fly");
                        p.setAllowFlight(false);
                    }
                }
                else {
                    p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §7» §cSem Permiss\u00e3o");
                }
                if (args.length == 1) {
                    if (sender.hasPermission("cmd.fly")) {
                        final Player k = Bukkit.getPlayer(args[0]);
                        if (k == null) {
                            sender.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §7» §cEste Player Est\u00e1 Offline");
                            return true;
                        }
                        if (!p.getAllowFlight()) {
                            p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §7» Voc\u00ea §a§lHABILITOU§7 o Fly Para " + k.getName());
                            k.setAllowFlight(true);
                            k.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §7» Seu Fly Foi §a§lHABILITADO§7 Por " + p.getName());
                        }
                        else {
                            p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §7» Voc\u00ea §c§lDESABILITOU§7 o Fly Para " + k.getName());
                            k.setAllowFlight(false);
                            k.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §7» Seu Fly Foi §c§lDESABILITADO§7 Por " + p.getName());
                        }
                    }
                    else {
                        p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §7» §cSem Permiss\u00e3o");
                    }
                }
            }
        }
        return false;
    }
}
