package Comandos;

import org.bukkit.command.*;
import org.bukkit.*;
import Main.*;
import org.bukkit.entity.*;

public class CCCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, j = 0; j < length; ++j) {
            final Player s = onlinePlayers[j];
            if (!sender.hasPermission("cmd.cc")) {
                sender.sendMessage("§7Voce precisa ser §dTrialMod§7 Ou superior para executar este comando.");
                return true;
            }
            for (int i = 0; i != 100; ++i) {
                s.sendMessage("  ");
            }
            s.sendMessage(String.valueOf(Main.prefix) + " §4§lAVISO: §7O Chat foi limpo!");
        }
        return false;
    }
}
