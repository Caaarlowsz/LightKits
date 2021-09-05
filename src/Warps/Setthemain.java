package Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Main.Main;

public class Setthemain implements Listener, CommandExecutor {
	public static Main plugin;

	public Setthemain(final Main main) {
		Setthemain.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("setmain") && sender instanceof Player) {
			if (!sender.hasPermission("sword.setwarp")) {
				final Player p = (Player) sender;
				p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Sem Permiss\u00e3o");
			}
			if (sender.hasPermission("sword.setwarp")) {
				final Player p = (Player) sender;
				Setthemain.plugin.getConfig().set("themain.x", (Object) p.getLocation().getX());
				Setthemain.plugin.getConfig().set("themain.y", (Object) p.getLocation().getY());
				Setthemain.plugin.getConfig().set("themain.z", (Object) p.getLocation().getZ());
				Setthemain.plugin.getConfig().set("themain.pitch", (Object) p.getLocation().getPitch());
				Setthemain.plugin.getConfig().set("themain.yaw", (Object) p.getLocation().getYaw());
				Setthemain.plugin.getConfig().set("themain.world", (Object) p.getLocation().getWorld().getName());
				Setthemain.plugin.saveConfig();
				p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Main Foi Setada Com Sucesso");
			}
			return true;
		}
		return false;
	}
}
