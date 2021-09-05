package Comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import API.*;

public class BroadcastCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("bc") && sender.hasPermission("cmd.bc")) {
            if (args.length >= 1) {
                String bcast = "";
                for (int x = 0; x < args.length; ++x) {
                    bcast = String.valueOf(bcast) + args[x] + " ";
                }
                final Player p = (Player)sender;
                bcast = ChatColor.translateAlternateColorCodes('&', bcast);
                Bukkit.broadcastMessage("§4§lAVISO§7 " + bcast);
                TitleAPI.sendTitle(p, 10, 60, 10, bcast, "§5§lNitec§f§l-§a§lMC");
            }
            else {
                sender.sendMessage("§7Voce usou de maneira incorreta, por favor use: §e/bc (mensagem)");
            }
        }
        else {
            sender.sendMessage("§7Voce precisa ser §5Moderador§7 Ou superior para executar este comando.");
        }
        return false;
    }
}
