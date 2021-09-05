package Comandos;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TellCommand implements CommandExecutor {
	public static HashMap<Player, Player> gettell;
	static ArrayList<Player> telloff;

	static {
		TellCommand.gettell = new HashMap<Player, Player>();
		TellCommand.telloff = new ArrayList<Player>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("tell")) {
			if (args.length == 0) {
				p.sendMessage(String.valueOf("§aUse: /tell (jogador) (msg)"));
				return true;
			}
			final Player target = Bukkit.getPlayer(args[0]);
			if (args[0].toLowerCase().equalsIgnoreCase("on")) {
				TellCommand.telloff.remove(p);
				p.sendMessage(String.valueOf("§6Voce ativou seu §etell"));
			} else if (args[0].toLowerCase().equalsIgnoreCase("off")) {
				TellCommand.telloff.add(p);
				p.sendMessage(String.valueOf("§6Voce desativou seu §etell"));
			}
			if (args.length > 1) {
				if (target == null) {
					p.sendMessage("§cEste jogador est\u00e1 OFF.");
					return true;
				}
				if (TellCommand.telloff.contains(target)) {
					p.sendMessage(String.valueOf("§cO tell desse player esta off"));
					return true;
				}
				final StringBuilder sb = new StringBuilder();
				for (int i = 1; i < args.length; ++i) {
					sb.append(args[i]).append(" ");
				}
				final String allArgs = sb.toString().trim();
				p.sendMessage("§8[Voce \u2799 " + target.getDisplayName() + " ]§6: " + allArgs);
				target.sendMessage("§8[" + p.getDisplayName() + " \u2799 Voce]§6: " + allArgs);
				TellCommand.gettell.put(p, target);
				TellCommand.gettell.put(target, p);
			}
		} else if (label.equalsIgnoreCase("off")) {
			if (args.length == 0) {
				p.sendMessage(String.valueOf("§7fale com o player no chat normal"));
				return true;
			}
			if (!TellCommand.gettell.containsKey(p)) {
				p.sendMessage(String.valueOf("§7Voc\u00ea n\u00e3o tem ninguem para responder"));
				return true;
			}
			final Player deslogo = TellCommand.gettell.get(p);
			if (deslogo == null) {
				p.sendMessage("§cEste jogador esta OFF.");
				return true;
			}
			if (TellCommand.telloff.contains(deslogo)) {
				p.sendMessage(String.valueOf("§cO tell desse player esta off"));
				return true;
			}
			final StringBuilder sb = new StringBuilder();
			for (int i = 0; i < args.length; ++i) {
				sb.append(args[i]).append(" ");
			}
			final String allArgs = sb.toString().trim();
			p.sendMessage("§8[Voce \u2799 " + deslogo.getDisplayName() + "]§6: " + allArgs);
			deslogo.sendMessage("§8[" + p.getDisplayName() + " \u2799 Voce]§6: " + allArgs);
		}
		return false;
	}
}
