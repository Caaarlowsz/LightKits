package Comandos;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import Main.*;

public class PvPCommand implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (!cmd.getName().equalsIgnoreCase("dano") || (!sender.hasPermission("cmd.dano") && !sender.isOp())) {
            return false;
        }
        if (p.getWorld().getPVP()) {
            p.getWorld().setPVP(false);
            Bukkit.getServer().broadcastMessage(String.valueOf(Main.prefix) + " §7O PvP do servidor foi desativado.");
            return true;
        }
        p.getWorld().setPVP(true);
        Bukkit.getServer().broadcastMessage(String.valueOf(Main.prefix) + " §7O PvP do servidor foi ativado.");
        return true;
    }
}
