package Comandos;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import Main.*;

public class AplicarCommand implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender Sender, final Command cmd, final String string, final String[] args) {
        final Player p = (Player)Sender;
        if (cmd.getName().equalsIgnoreCase("aplicar")) {
            p.sendMessage(Main.aplicar);
        }
        return false;
    }
}
