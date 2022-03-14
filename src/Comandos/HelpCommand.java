package Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;

public class HelpCommand implements Listener, CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		cmd.getName().equalsIgnoreCase("help");
		p.sendMessage(" ");
		p.sendMessage("�aOla, Bem-Vindo a ferramente de �aAjuda�7 do �7" + LightPvP.prefix + "!");
		p.sendMessage(" ");
		p.sendMessage("�7Deseja tornar-se �bYoutuber�7? Utilize o comando: �b/youtuber�7.");
		p.sendMessage(" ");
		p.sendMessage("�7Deseja Aplicar-se na staff? Utilize o comando �c/aplicar�7.");
		return false;
	}
}
