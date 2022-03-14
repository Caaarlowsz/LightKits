package Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;

public class AplicarCommand implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender Sender, final Command cmd, final String string, final String[] args) {
		final Player p = (Player) Sender;
		if (cmd.getName().equalsIgnoreCase("aplicar")) {
			p.sendMessage(LightPvP.aplicar);
		}
		return false;
	}
}
