package Comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class TpCommand implements CommandExecutor
{
    public String[] aliases;
    
    public TpCommand() {
        this.aliases = new String[] { "tp" };
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Voce nao e um jogador!");
            return false;
        }
        final Player p = (Player)sender;
        if (p.hasPermission("cmd.tp")) {
            if (args.length == 0) {
                p.sendMessage("§7Voce usou de maneira incorreta, por favor use: §e/tp (jogador)");
            }
            else if (args.length == 1) {
                final Player target = p.getServer().getPlayer(args[0]);
                if (target != null) {
                    p.teleport(target.getLocation());
                    Player[] arrayOfPlayer1;
                    for (int j = (arrayOfPlayer1 = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
                        final Player p2 = arrayOfPlayer1[i];
                        if (!p2.hasPermission("cmd.tp")) {
                            p2.isOp();
                        }
                    }
                }
                else {
                    p.sendMessage("§7Este jogador nao esta conectado!");
                }
            }
            else if (args.length == 2) {
                final Player target = p.getServer().getPlayer(args[0]);
                final Player starget = p.getServer().getPlayer(args[1]);
                if (target != null) {
                    if (starget != null) {
                        target.teleport(starget.getLocation());
                        Player[] arrayOfPlayer2;
                        for (int k = (arrayOfPlayer2 = Bukkit.getOnlinePlayers()).length, j = 0; j < k; ++j) {
                            final Player p3 = arrayOfPlayer2[j];
                            if (!p3.hasPermission("comando.admin")) {
                                p3.isOp();
                            }
                        }
                    }
                    else {
                        p.sendMessage("§7Este jogador nao esta conectado!");
                    }
                }
                else {
                    p.sendMessage("§7Este jogador nao esta conectado!");
                }
            }
            else if (args.length == 3) {
                final double x2 = args[0].startsWith("~") ? (p.getLocation().getX() + Integer.parseInt(args[0].substring(1))) : Integer.parseInt(args[0]);
                final double y2 = args[1].startsWith("~") ? (p.getLocation().getY() + Integer.parseInt(args[1].substring(1))) : Integer.parseInt(args[1]);
                final double z2 = args[2].startsWith("~") ? (p.getLocation().getZ() + Integer.parseInt(args[2].substring(1))) : Integer.parseInt(args[2]);
                if (x2 > 3.0E7 || y2 > 3.0E7 || z2 > 3.0E7 || x2 < -3.0E7 || y2 < -3.0E7 || z2 < -3.0E7) {
                    return true;
                }
                final Location locpos = new Location(p.getWorld(), x2, y2, z2, p.getLocation().getYaw(), p.getLocation().getPitch());
                p.teleport(locpos);
                for (int n = Bukkit.getOnlinePlayers().length, m = 0; m < n; ++m) {
                    p.hasPermission("cmd.tp");
                }
            }
            else if (args.length == 4) {
                final Player target2 = p.getServer().getPlayer(args[0]);
                final double x3 = args[1].startsWith("~") ? (target2.getLocation().getX() + Integer.parseInt(args[0].substring(1))) : Integer.parseInt(args[1]);
                final double y3 = args[2].startsWith("~") ? (target2.getLocation().getY() + Integer.parseInt(args[1].substring(1))) : Integer.parseInt(args[2]);
                final double z3 = args[3].startsWith("~") ? (target2.getLocation().getZ() + Integer.parseInt(args[2].substring(1))) : Integer.parseInt(args[3]);
                if (x3 > 3.0E7 || y3 > 3.0E7 || z3 > 3.0E7 || x3 < -3.0E7 || y3 < -3.0E7 || z3 < -3.0E7 || target2 == null) {
                    return true;
                }
                final Location locpos2 = new Location(p.getWorld(), x3, y3, z3, target2.getLocation().getYaw(), target2.getLocation().getPitch());
                target2.teleport(locpos2);
                for (int i2 = Bukkit.getOnlinePlayers().length, n = 0; n < i2; ++n) {
                    p.hasPermission("cmd.tp");
                }
            }
        }
        return false;
    }
}
