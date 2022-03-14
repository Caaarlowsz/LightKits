package Coins;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;

public class DarXp implements CommandExecutor, Listener {
	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("darmoedas")) {
			if (!p.hasPermission("cmd.darmoedas")) {
				p.sendMessage(LightPvP.prefix + " �7Sem Permissao");
			} else {
				if (args.length == 0) {
					sender.sendMessage(LightPvP.prefix + " �7Use: /darmoedas (Jogador) (N� De coins)");
					return true;
				}
				Player target = Bukkit.getPlayerExact(args[0]);
				if ((target == null) || (!(target instanceof Player))) {
					sender.sendMessage(LightPvP.prefix + " �4Este player est� off");
					return true;
				}
				if (isNumeric(args[1])) {
					int coins = Integer.parseInt(args[1]);
					XpM.addMoney(target, coins);
					p.sendMessage(
							LightPvP.prefix + " �aVoce deu ao jogador �a" + target.getName() + " �2" + coins + " �7Moedas");

					target.sendMessage(
							LightPvP.prefix + " �aVoce recebeu do jogador �a" + p.getName() + " �2" + coins + " �7Moedas");
				}
			}
		}
		return false;
	}
}
