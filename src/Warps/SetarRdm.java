package Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Main.Main;

public class SetarRdm implements Listener, CommandExecutor {
	public static Main plugin;

	public SetarRdm(final Main main) {
		SetarRdm.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("setrdm") && sender instanceof Player) {
			if (!sender.hasPermission("sword.setwarp")) {
				final Player p = (Player) sender;
				p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Sem Permiss\u00e3o");
			}
			if (sender.hasPermission("sword.setwarp")) {
				final Player p = (Player) sender;
				SetarRdm.plugin.getConfig().set("rdm.x", (Object) p.getLocation().getX());
				SetarRdm.plugin.getConfig().set("rdm.y", (Object) p.getLocation().getY());
				SetarRdm.plugin.getConfig().set("rdm.z", (Object) p.getLocation().getZ());
				SetarRdm.plugin.getConfig().set("rdm.pitch", (Object) p.getLocation().getPitch());
				SetarRdm.plugin.getConfig().set("rdm.yaw", (Object) p.getLocation().getYaw());
				SetarRdm.plugin.getConfig().set("rdm.world", (Object) p.getLocation().getWorld().getName());
				SetarRdm.plugin.saveConfig();
				p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " §6» §7Rdm Foi Setada Com Sucesso");
			}
			return true;
		}
		return false;
	}
}
