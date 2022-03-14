package Warps;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
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

public class Knock implements Listener, CommandExecutor {
	public static ItemStack kits;
	public static ItemMeta kitsmeta;
	public static ItemStack warps;
	public static ItemMeta warpsmeta;
	public static ItemStack loja;
	public static ItemMeta lojameta;
	public static LightPvP plugin;

	public Knock(final LightPvP main) {
		Knock.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("knock")) {
			final Player p = (Player) sender;
			p.getInventory().clear();
			p.getInventory().setBoots((ItemStack) null);
			p.getInventory().setChestplate((ItemStack) null);
			p.getInventory().setLeggings((ItemStack) null);
			p.getInventory().setHelmet((ItemStack) null);
			p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Teleportando Aguarde");
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Knock.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					final World w = Bukkit.getServer().getWorld(Knock.plugin.getConfig().getString("knock.world"));
					final double x = Knock.plugin.getConfig().getDouble("knock.x");
					final double y = Knock.plugin.getConfig().getDouble("knock.y");
					final double z = Knock.plugin.getConfig().getDouble("knock.z");
					final Location lobby = new Location(w, x, y, z);
					lobby.setPitch((float) Knock.plugin.getConfig().getDouble("knock.pitch"));
					lobby.setYaw((float) Knock.plugin.getConfig().getDouble("knock.yaw"));
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
					KitAPI.setitem(p, Material.STICK, "�cBata", 0, Enchantment.KNOCKBACK, 5, true);
					TitleAPI.sendFullTitle(p, 50, 50, 80, "�aVoce foi para a", "�b�lKnock");
					for (final PotionEffect effect : p.getActivePotionEffects()) {
						p.removePotionEffect(effect.getType());
					}
				}
			}, 90L);
		}
		return false;
	}
}
