package Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Main.Main;

public class SetTextura implements Listener, CommandExecutor {
	public static Main plugin;

	public SetTextura(final Main main) {
		SetTextura.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("settextura") && sender instanceof Player) {
			if (!sender.hasPermission("cmd.setwarp")) {
				final Player p = (Player) sender;
				p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Sem Permiss\u00e3o");
			}
			if (sender.hasPermission("cmd.setwarp")) {
				final Player p = (Player) sender;
				SetTextura.plugin.getConfig().set("textura.x", (Object) p.getLocation().getX());
				SetTextura.plugin.getConfig().set("textura.y", (Object) p.getLocation().getY());
				SetTextura.plugin.getConfig().set("textura.z", (Object) p.getLocation().getZ());
				SetTextura.plugin.getConfig().set("textura.pitch", (Object) p.getLocation().getPitch());
				SetTextura.plugin.getConfig().set("textura.yaw", (Object) p.getLocation().getYaw());
				SetTextura.plugin.getConfig().set("textura.world", (Object) p.getLocation().getWorld().getName());
				SetTextura.plugin.saveConfig();
				p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Textura Foi Setada Com Sucesso");
			}
			return true;
		}
		return false;
	}
}
