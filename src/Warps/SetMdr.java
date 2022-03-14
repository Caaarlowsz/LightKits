package Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;

public class SetMdr implements Listener, CommandExecutor {
	public static LightPvP plugin;

	public SetMdr(final LightPvP main) {
		SetMdr.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("setmdr") && sender instanceof Player) {
			if (!sender.hasPermission("sword.setwarp")) {
				final Player p = (Player) sender;
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Sem Permiss\u00e3o");
			}
			if (sender.hasPermission("sword.setwarp")) {
				final Player p = (Player) sender;
				SetMdr.plugin.getConfig().set("mdr.x", (Object) p.getLocation().getX());
				SetMdr.plugin.getConfig().set("mdr.y", (Object) p.getLocation().getY());
				SetMdr.plugin.getConfig().set("mdr.z", (Object) p.getLocation().getZ());
				SetMdr.plugin.getConfig().set("mdr.pitch", (Object) p.getLocation().getPitch());
				SetMdr.plugin.getConfig().set("mdr.yaw", (Object) p.getLocation().getYaw());
				SetMdr.plugin.getConfig().set("mdr.world", (Object) p.getLocation().getWorld().getName());
				SetMdr.plugin.saveConfig();
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Mdr Foi Setada Com Sucesso");
			}
			return true;
		}
		return false;
	}
}
