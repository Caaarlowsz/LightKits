package Comandos;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;

public class Skit implements Listener, CommandExecutor {
	public HashMap<String, ItemStack[]> kits;
	public HashMap<String, ItemStack[]> armor;

	public Skit() {
		this.kits = new HashMap<String, ItemStack[]>();
		this.armor = new HashMap<String, ItemStack[]>();
	}

	public boolean isInt(final String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Este comando e para uso apenas dos jogadores.");
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("skit")) {
			if (!p.hasPermission("cmd.skit")) {
				p.sendMessage(ChatColor.RED + "Comando inv\u00e1lido.");
				p.playSound(p.getLocation(), Sound.LAVA_POP, 15.0f, 1.0f);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(String.valueOf(LightPvP.prefix)
						+ " >>�7 Sintaxe correta: �c/skit criar|aplicar <nome>|<distancia>");
				return true;
			}
			if (args[0].equalsIgnoreCase("criar")) {
				if (args.length == 1) {
					p.sendMessage(String.valueOf(LightPvP.prefix) + " >>�7 Sintaxe correta: �c/skit criar <nome>");
					return true;
				}
				final String name = args[1];
				this.kits.put(name, p.getInventory().getContents());
				this.armor.put(name, p.getInventory().getArmorContents());
				p.sendMessage(String.valueOf(LightPvP.prefix) + " >>�7Kit�c " + args[1] + "�7 criado com sucesso!");
				return true;
			} else if (args[0].equalsIgnoreCase("aplicar")) {
				if (args.length <= 2) {
					p.sendMessage(
							String.valueOf(LightPvP.prefix) + " >>�7 Uso correto: �c/skit aplicar <nome> <distancia>");
					return true;
				}
				final String name = args[1];
				if (!this.kits.containsKey(name) && !this.armor.containsKey(name)) {
					p.sendMessage(String.valueOf(LightPvP.prefix) + " >>�7 Kit �c" + name + "�7 nao encontrado!");
					return true;
				}
				if (this.isInt(args[2])) {
					final int numero = Integer.parseInt(args[2]);
					for (final Entity ent : p.getNearbyEntities((double) numero, (double) numero, (double) numero)) {
						if (ent instanceof Player) {
							final Player p2 = (Player) ent;
							p2.getInventory().setArmorContents((ItemStack[]) this.armor.get(name));
							p2.getInventory().setContents((ItemStack[]) this.kits.get(name));
						}
					}
					Bukkit.getServer()
							.broadcastMessage(String.valueOf(LightPvP.prefix) + " >>�7 Kit�c " + name
									+ "�7 aplicado para jogadores em um raio de�c " + numero + "�7 blocos do staffer "
									+ p.getName());
					p.sendMessage(String.valueOf(LightPvP.prefix) + " >>�7 Kit�c " + name
							+ "�7 aplicado para jogadores em um raio de�c " + numero + "�7 blocos de voc\u00ea.");
					return true;
				}
				return true;
			}
		}
		return true;
	}
}
