package Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;

public class SetKnock implements Listener, CommandExecutor {
	public static LightPvP plugin;

	public SetKnock(final LightPvP main) {
		SetKnock.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("setknock") && sender instanceof Player) {
			if (!sender.hasPermission("cmd.setwarp")) {
				final Player p = (Player) sender;
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Sem Permiss\u00e3o");
			}
			if (sender.hasPermission("cmd.setwarp")) {
				final Player p = (Player) sender;
				SetKnock.plugin.getConfig().set("knock.x", (Object) p.getLocation().getX());
				SetKnock.plugin.getConfig().set("knock.y", (Object) p.getLocation().getY());
				SetKnock.plugin.getConfig().set("knock.z", (Object) p.getLocation().getZ());
				SetKnock.plugin.getConfig().set("knock.pitch", (Object) p.getLocation().getPitch());
				SetKnock.plugin.getConfig().set("knock.yaw", (Object) p.getLocation().getYaw());
				SetKnock.plugin.getConfig().set("knock.world", (Object) p.getLocation().getWorld().getName());
				SetKnock.plugin.saveConfig();
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Knock Foi Setada Com Sucesso");
			}
			return true;
		}
		return false;
	}
}
