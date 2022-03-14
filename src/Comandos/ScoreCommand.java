package Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;

public class ScoreCommand implements CommandExecutor, Listener {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Comando de Jogador!");
			return true;
		}
		Player p = (Player) sender;
		if (LightPvP.score.contains(p.getName())) {
			LightPvP.score.remove(p.getName());
			p.sendMessage(LightPvP.prefix + " �7Sua scoreboard foi Ativada!");

		} else {
			LightPvP.score.add(p.getName());
			p.sendMessage(LightPvP.prefix + " �8Sua scoreboard foi Desativada!");
		}

		return false;
	}
}