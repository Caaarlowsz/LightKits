package Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Main.Main;

public class SetLava implements Listener, CommandExecutor {
	public static Main plugin;

	public SetLava(final Main main) {
		SetLava.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("setchallenge") && sender instanceof Player) {
			if (!sender.hasPermission("sword.setwarp")) {
				final Player p = (Player) sender;
				p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Sem Permiss\u00e3o");
			}
			if (sender.hasPermission("sword.setwarp")) {
				final Player p = (Player) sender;
				SetLava.plugin.getConfig().set("lava.x", (Object) p.getLocation().getX());
				SetLava.plugin.getConfig().set("lava.y", (Object) p.getLocation().getY());
				SetLava.plugin.getConfig().set("lava.z", (Object) p.getLocation().getZ());
				SetLava.plugin.getConfig().set("lava.pitch", (Object) p.getLocation().getPitch());
				SetLava.plugin.getConfig().set("lava.yaw", (Object) p.getLocation().getYaw());
				SetLava.plugin.getConfig().set("lava.world", (Object) p.getLocation().getWorld().getName());
				SetLava.plugin.saveConfig();
				p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Lava Foi Setada Com Sucesso");
			}
			return true;
		}
		return false;
	}
}
