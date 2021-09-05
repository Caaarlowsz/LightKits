package Comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import Main.Main;

public final class BuildCommand implements Listener, CommandExecutor {
	public static ArrayList<Player> embuild;

	static {
		BuildCommand.embuild = new ArrayList<Player>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("build")) {
			if (p.hasPermission("cmd.build")) {
				if (args.length == 0) {
					if (!BuildCommand.embuild.contains(p)) {
						BuildCommand.embuild.add(p);
						p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §7» §7Build §a§lATIVADO§7!");
					} else {
						BuildCommand.embuild.remove(p);
						p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §7» §7Build §c§lDESATIVADO§7!");
					}
				} else {
					final Player t = Bukkit.getPlayer(args[0]);
					if (t == null) {
						p.sendMessage(
								String.valueOf(String.valueOf(Main.prefix)) + " §7» §cEste Player Est\u00e1 Offline");
						return true;
					}
					if (!BuildCommand.embuild.contains(t)) {
						BuildCommand.embuild.add(t);
						p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §7» §7Build §a§lATIVADO§7 Para "
								+ t.getName());
					} else {
						BuildCommand.embuild.remove(t);
						p.sendMessage(String.valueOf(String.valueOf(Main.prefix))
								+ " §7» §7Build §c§lDESATIVADO§7 Para " + t.getName());
					}
				}
			} else {
				p.sendMessage(String.valueOf(String.valueOf(Main.prefix))
						+ " §7» Desculpe, Mas voce precisa do grupo §5Moderador§7 ou Superior para executar isto.");
			}
		}
		return false;
	}

	@EventHandler
	public void aoconstruir(final BlockPlaceEvent e) {
		final Player p = e.getPlayer();
		if (!BuildCommand.embuild.contains(p)) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void aoconstruir(final BlockBreakEvent e) {
		final Player p = e.getPlayer();
		if (!BuildCommand.embuild.contains(p)) {
			e.setCancelled(true);
		}
	}
}
