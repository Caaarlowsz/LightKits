package Comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;

public class SCCommand implements Listener, CommandExecutor {
	public static ArrayList<String> staff;

	static {
		SCCommand.staff = new ArrayList<String>();
	}

	@EventHandler
	public void onChat(final PlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (this.isStaffChatting(p)) {
			Bukkit.broadcast(ChatColor.GRAY + "[�dStaff" + ChatColor.GRAY + "]�9 " + p.getDisplayName() + "�2 \u27a1 "
					+ "�7" + e.getMessage().replaceAll("&", "�"), "cmd.sc");
			e.setCancelled(true);
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("sc")) {
			if (p.hasPermission("cmd.sc")) {
				if (this.isStaffChatting(p)) {
					SCCommand.staff.remove(p.getName());
					p.sendMessage(ChatColor.GRAY + " �7Voce saiu do Chat da Staff!");
					Player[] onlinePlayers;
					for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
						final Player online = onlinePlayers[i];
						if (this.isStaffChatting(p) && !online.hasPermission("cmd.sc")) {
							this.isStaffChatting(online);
						}
					}
				} else {
					SCCommand.staff.add(p.getName());
					p.sendMessage(ChatColor.GRAY + " �7Voce entrou no Chat da Staff");
					Player[] onlinePlayers2;
					for (int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length, j = 0; j < length2; ++j) {
						final Player online = onlinePlayers2[j];
						if (this.isStaffChatting(p) && !online.hasPermission("cmd.sc")) {
							this.isStaffChatting(online);
						}
					}
				}
			} else {
				p.sendMessage(String.valueOf(LightPvP.prefix)
						+ "�cDesculpe, Mas voce precisa do Grupo �3Ajudante �cou Superior para executar este comando.");
			}
		}
		return true;
	}

	public boolean isStaffChatting(final Player player) {
		return SCCommand.staff.contains(player.getName());
	}
}
