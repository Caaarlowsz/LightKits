package Comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.*;
import org.bukkit.*;

public class PingCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String c, final String[] args) {
        if (sender instanceof Player) {
            final Player p = (Player)sender;
            final int ping = ((CraftPlayer)p).getHandle().ping;
            if (c.equalsIgnoreCase("ping")) {
                if (args.length == 0) {
                    p.sendMessage("§aSeu Ping e de: " + ping + " §aMs");
                }
                else if (p.getServer().getPlayer(args[0]) != null) {
                    final String player2 = args[0];
                    final Player target = Bukkit.getServer().getPlayer(args[0]);
                    final int ping2 = ((CraftPlayer)target).getHandle().ping;
                    p.sendMessage("§aO Jogador " + player2 + " §atem um ping de: " + ping2 + " §ams!");
                }
                else {
                    p.sendMessage("§7Este jogador nao esta conectado!");
                }
            }
        }
        return false;
    }
}
