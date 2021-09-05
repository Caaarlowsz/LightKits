package Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Main.Main;

public class SetFps implements Listener, CommandExecutor {
	public static Main plugin;

	public SetFps(final Main main) {
		SetFps.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("setfps") && sender instanceof Player) {
			if (!sender.hasPermission("sword.setwarp")) {
				final Player p = (Player) sender;
				p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Sem Permiss\u00e3o");
			}
			if (sender.hasPermission("sword.setwarp")) {
				final Player p = (Player) sender;
				SetFps.plugin.getConfig().set("fps.x", (Object) p.getLocation().getX());
				SetFps.plugin.getConfig().set("fps.y", (Object) p.getLocation().getY());
				SetFps.plugin.getConfig().set("fps.z", (Object) p.getLocation().getZ());
				SetFps.plugin.getConfig().set("fps.pitch", (Object) p.getLocation().getPitch());
				SetFps.plugin.getConfig().set("fps.yaw", (Object) p.getLocation().getYaw());
				SetFps.plugin.getConfig().set("fps.world", (Object) p.getLocation().getWorld().getName());
				SetFps.plugin.saveConfig();
				p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Fps Foi Setada Com Sucesso");
			}
			return true;
		}
		return false;
	}
}
