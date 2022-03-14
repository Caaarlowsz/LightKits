package Warps;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;

import com.connorlinfoot.titleapi.TitleAPI;

import Eventos.Habilidade;
import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;
import Utils.KitAPI;

public class Textura implements Listener, CommandExecutor {
	public static ItemStack kits;
	public static ItemMeta kitsmeta;
	public static ItemStack warps;
	public static ItemMeta warpsmeta;
	public static ItemStack loja;
	public static ItemMeta lojameta;
	public static LightPvP plugin;

	public Textura(final LightPvP main) {
		Textura.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("textura")) {
			final Player p = (Player) sender;
			p.getInventory().clear();
			p.getInventory().setBoots((ItemStack) null);
			p.getInventory().setChestplate((ItemStack) null);
			p.getInventory().setLeggings((ItemStack) null);
			p.getInventory().setHelmet((ItemStack) null);
			p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Teleportando Aguarde");
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Textura.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					final World w = Bukkit.getServer().getWorld(Textura.plugin.getConfig().getString("textura.world"));
					final double x = Textura.plugin.getConfig().getDouble("textura.x");
					final double y = Textura.plugin.getConfig().getDouble("textura.y");
					final double z = Textura.plugin.getConfig().getDouble("textura.z");
					final Location lobby = new Location(w, x, y, z);
					lobby.setPitch((float) Textura.plugin.getConfig().getDouble("textura.pitch"));
					lobby.setYaw((float) Textura.plugin.getConfig().getDouble("textura.yaw"));
					KitAPI.remove(p);
					Habilidade.removeAbility(p);
					p.getInventory().setBoots((ItemStack) null);
					p.getInventory().setChestplate((ItemStack) null);
					p.getInventory().setLeggings((ItemStack) null);
					p.getInventory().setHelmet((ItemStack) null);
					p.getInventory().clear();
					p.teleport(lobby);
					p.setExp(0.0f);
					p.setExhaustion(20.0f);
					p.setFireTicks(0);
					p.setFoodLevel(20000);
					p.setHealth(20.0);
					TitleAPI.sendFullTitle(p, 50, 50, 80, "�aVoce foi para a", "�b�lTextura");
					for (final PotionEffect effect : p.getActivePotionEffects()) {
						p.removePotionEffect(effect.getType());
					}
				}
			}, 90L);
		}
		return false;
	}
}
