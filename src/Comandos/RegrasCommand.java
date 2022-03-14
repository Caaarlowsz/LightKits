package Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;

public class RegrasCommand implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender Sender, final Command cmd, final String string, final String[] args) {
		final Player p = (Player) Sender;
		if (cmd.getName().equalsIgnoreCase("regras")) {
			p.sendMessage("  ");
			p.sendMessage("      " + LightPvP.prefix + "      ");
			p.sendMessage("  ");
			p.sendMessage("�6� �7N\u00e3o Utilizar Hack");
			p.sendMessage("�6� �7N\u00e3o Utilizar Macros");
			p.sendMessage("�6� �7N\u00e3o Utilizar AutoClick");
			p.sendMessage("�6� �7N\u00e3o Utilizar MouseTeaks");
			p.sendMessage("�6� �7N\u00e3o Insultar Staffs");
			p.sendMessage("�6� �7N\u00e3o Insultar Players");
			p.sendMessage("�6� �7N\u00e3o Insultar Server");
			p.sendMessage("�6� �7N\u00e3o Testar Staffs sem Perm do Dono");
			p.sendMessage("�6� �7N\u00e3o Forjar Hacks");
			p.sendMessage("     ");
			p.sendMessage("   �cPuni\u00e7\u00e3o �4�lBan ETERNO   ");
			p.sendMessage("  ");
		}
		return false;
	}
}
