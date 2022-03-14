package Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;

public class SetParkour implements Listener, CommandExecutor {
	public static LightPvP plugin;

	public SetParkour(final LightPvP main) {
		SetParkour.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("setparkour") && sender instanceof Player) {
			if (!sender.hasPermission("sword.setwarp")) {
				final Player p = (Player) sender;
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Sem Permiss\u00e3o");
			}
			if (sender.hasPermission("sword.setwarp")) {
				final Player p = (Player) sender;
				SetParkour.plugin.getConfig().set("parkour.x", (Object) p.getLocation().getX());
				SetParkour.plugin.getConfig().set("parkour.y", (Object) p.getLocation().getY());
				SetParkour.plugin.getConfig().set("parkour.z", (Object) p.getLocation().getZ());
				SetParkour.plugin.getConfig().set("parkour.pitch", (Object) p.getLocation().getPitch());
				SetParkour.plugin.getConfig().set("parkour.yaw", (Object) p.getLocation().getYaw());
				SetParkour.plugin.getConfig().set("parkour.world", (Object) p.getLocation().getWorld().getName());
				SetParkour.plugin.saveConfig();
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Parkour Foi Setada Com Sucesso");
			}
			return true;
		}
		return false;
	}
}
