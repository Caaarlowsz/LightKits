package Comandos;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class DeathCommand implements Listener, CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("morrer")) {
            p.setHealth(0.0);
            p.sendMessage("§7Voce se matou, nao foi retirado nada de sua conta.");
        }
        return false;
    }
}
