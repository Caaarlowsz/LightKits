package Comandos;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import Main.*;

public class IPCommand implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Comando de Jogador!");
            return true;
        }
        final Player p = (Player)sender;
        p.sendMessage(String.valueOf(Main.prefix) + " §cO Ip de nosso Servidor \u00e9: §2 " + Main.ipsv);
        return false;
    }
}
