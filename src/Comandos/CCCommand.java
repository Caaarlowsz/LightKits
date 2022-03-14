package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;

public class CCCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, j = 0; j < length; ++j) {
			final Player s = onlinePlayers[j];
			if (!sender.hasPermission("cmd.cc")) {
				sender.sendMessage("�7Voce precisa ser �dTrialMod�7 Ou superior para executar este comando.");
				return true;
			}
			for (int i = 0; i != 100; ++i) {
				s.sendMessage("  ");
			}
			s.sendMessage(String.valueOf(LightPvP.prefix) + " �4�lAVISO: �7O Chat foi limpo!");
		}
		return false;
	}
}
