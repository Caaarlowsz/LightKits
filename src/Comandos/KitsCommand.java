package Comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Eventos.Array;
import Eventos.Basico;
import Eventos.Habilidade;
import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;
import Utils.KitAPI;

public class KitsCommand implements CommandExecutor, Listener {
	public KitsCommand(final LightPvP main) {
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("kit")) {
			if (args.length == 0) {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Especifique Um Kit (Kit)");
				return true;
			}
			if (KitAPI.Kit.contains(p.getName())) {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Apenas Um Kit Por Vida");
				return true;
			}
		}
		if (args[0].equalsIgnoreCase("pvp")) {
			if (p.hasPermission("kit.pvp")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "PvP");
				KitAPI.Kit.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit PvP Foi Selecionado");
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("viking")) {
			if (p.hasPermission("kit.Viking")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				Basico.darItem(p, Material.STONE_AXE, 1, "�6Viking", 0);
				Habilidade.setAbility(p, "Viking");
				KitAPI.Kit.add(p.getName());
				KitAPI.Viking.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Viking Foi Selecionado");
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("ninja")) {
			if (p.hasPermission("kit.ninja")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Ninja");
				KitAPI.Kit.add(p.getName());
				KitAPI.Ninja.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Ninja Foi Selecionado");
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("Boxer")) {
			if (p.hasPermission("kit.Boxer")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				Basico.darItem(p, Material.QUARTZ, 1, "�6Boxer", 0);
				Habilidade.setAbility(p, "Boxer");
				KitAPI.Kit.add(p.getName());
				KitAPI.Boxer.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Boxer Foi Selecionado");
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("avatar")) {
			if (p.hasPermission("kit.avatar")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Avatar");
				KitAPI.Kit.add(p.getName());
				KitAPI.setitem(p, Material.BEACON, String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Avatar", 1,
						Enchantment.DAMAGE_ALL, 0, false);
				KitAPI.Avatar.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Avatar Foi Selecionado");
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("fisherman")) {
			if (p.hasPermission("kit.fisherman")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Fisherman");
				KitAPI.Kit.add(p.getName());
				KitAPI.Fisherman.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Fisherman Foi Selecionado");
				KitAPI.setitem(p, Material.FISHING_ROD,
						String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Varinha De Pesca", 1,
						Enchantment.DAMAGE_ALL, 0, false);
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("sonic")) {
			if (p.hasPermission("kit.sonic")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Sonic");
				KitAPI.Kit.add(p.getName());
				KitAPI.Sonic.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Sonic Foi Selecionado");
				KitAPI.setitem(p, Material.LAPIS_BLOCK, String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Sonic", 1,
						Enchantment.DAMAGE_ALL, 0, false);
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("turtle")) {
			if (p.hasPermission("kit.turtle")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Turtle");
				KitAPI.Kit.add(p.getName());
				KitAPI.Turtle.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Turtle Foi Selecionado");
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("poseidon")) {
			if (p.hasPermission("kit.poseidon")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Poseidon");
				KitAPI.Kit.add(p.getName());
				KitAPI.Poseidon.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Poseidon Foi Selecionado");
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("barbarian")) {
			if (p.hasPermission("kit.barbarian")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Barbarian");
				KitAPI.Kit.add(p.getName());
				KitAPI.Barbarian.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Barbarian Foi Selecionado");
				Array.kit.put(p, "Barbarian");
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("swords")) {
			if (p.hasPermission("kit.swords")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Swords");
				KitAPI.Kit.add(p.getName());
				KitAPI.Swords.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Swords Foi Selecionado");
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("waterbender")) {
			if (p.hasPermission("kit.waterbender")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "WaterBender");
				KitAPI.Kit.add(p.getName());
				KitAPI.WaterBender.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit WaterBender Foi Selecionado");
				KitAPI.setitem(p, Material.INK_SACK, String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7WaterBender",
						1, Enchantment.DAMAGE_ALL, 0, false);
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("velotrol")) {
			if (p.hasPermission("kit.velotrol")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Velotrol");
				KitAPI.Kit.add(p.getName());
				KitAPI.Velotrol.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Velotrol Foi Selecionado");
				KitAPI.setitem(p, Material.MINECART, String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Velotrol", 1,
						Enchantment.DAMAGE_ALL, 0, false);
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("firebender")) {
			if (p.hasPermission("kit.firebender")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "FireBender");
				KitAPI.Kit.add(p.getName());
				KitAPI.FireBender.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit FireBender Foi Selecionado");
				KitAPI.setitem(p, Material.REDSTONE, String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7FireBender",
						1, Enchantment.DAMAGE_ALL, 0, false);
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("c4")) {
			if (p.hasPermission("kit.c4")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "C4");
				KitAPI.Kit.add(p.getName());
				KitAPI.C4.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit C4 Foi Selecionado");
				KitAPI.setitem(p, Material.SLIME_BALL, String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7C4", 1,
						Enchantment.DAMAGE_ALL, 0, false);
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("terrorista")) {
			if (p.hasPermission("kit.terrorista")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Terrorista");
				KitAPI.Kit.add(p.getName());
				KitAPI.Terrorista.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Terrorista Foi Selecionado");
				KitAPI.setitem(p, Material.MAGMA_CREAM, String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7KaaaBumm",
						1, Enchantment.DAMAGE_ALL, 0, false);
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("stomper")) {
			if (p.hasPermission("kit.stomper")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Stomper");
				KitAPI.Kit.add(p.getName());
				KitAPI.Stomper.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Stomper Foi Selecionado");
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("ajnin")) {
			if (p.hasPermission("kit.ajnin")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Ajnin");
				KitAPI.Kit.add(p.getName());
				KitAPI.Ajnin.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Ajnin Foi Selecionado");
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("kangaroo")) {
			if (p.hasPermission("kit.kangaroo")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Kangaroo");
				KitAPI.Kit.add(p.getName());
				KitAPI.Kangaroo.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Kangaroor Foi Selecionado");
				KitAPI.setitem(p, Material.FIREWORK, String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7FireWork", 1,
						Enchantment.DAMAGE_ALL, 0, false);
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("hulk")) {
			if (p.hasPermission("kit.Hulk")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Hulk");
				KitAPI.Kit.add(p.getName());
				KitAPI.Hulk.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Hulk Foi Selecionado");
				KitAPI.setitem(p, Material.SADDLE, String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Hulk", 1,
						Enchantment.DAMAGE_ALL, 0, false);
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("thor")) {
			if (p.hasPermission("kit.thor")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Thor");
				KitAPI.Kit.add(p.getName());
				KitAPI.Thor.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Thor Foi Selecionado");
				KitAPI.setitem(p, Material.GOLD_AXE,
						String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Machado Rel\u00e2mpago", 1,
						Enchantment.DAMAGE_ALL, 0, false);
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("anchor")) {
			if (p.hasPermission("kit.anchor")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Anchor");
				KitAPI.Kit.add(p.getName());
				KitAPI.Anchor.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Anchorr Foi Selecionado");
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("grandpa")) {
			if (p.hasPermission("kit.grandpa")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Grandpa");
				KitAPI.Kit.add(p.getName());
				KitAPI.Grandpa.add(p.getName());
				final ItemStack kpiru = new ItemStack(Material.STICK);
				kpiru.addUnsafeEnchantment(Enchantment.KNOCKBACK, 4);
				final ItemMeta kkpiru = kpiru.getItemMeta();
				kkpiru.setDisplayName(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Graveto");
				kpiru.setItemMeta(kkpiru);
				p.getInventory().setItem(1, kpiru);
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Grandpa Foi Selecionado");
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("resouper")) {
			if (p.hasPermission("kit.resouper")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Resouper");
				KitAPI.Kit.add(p.getName());
				KitAPI.Resouper.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Resouper Foi Selecionado");
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("monk")) {
			if (p.hasPermission("kit.monk")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Monk");
				KitAPI.Kit.add(p.getName());
				KitAPI.Monk.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Monk Foi Selecionado");
				KitAPI.setitem(p, Material.BLAZE_ROD, String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Monk", 1,
						Enchantment.DAMAGE_ALL, 0, false);
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("switcher")) {
			if (p.hasPermission("kit.switcher")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Switcher");
				KitAPI.Kit.add(p.getName());
				KitAPI.Switcher.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Switcher Foi Selecionado");
				Basico.darItem(p, Material.SNOW_BALL, 32, "�fBola de Neve", 1);
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("gladiator")) {
			if (p.hasPermission("kit.gladiator")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Gladiator");
				KitAPI.Kit.add(p.getName());
				KitAPI.Gladiator.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Gladiator Foi Selecionado");
				KitAPI.setitem(p, Material.IRON_FENCE, String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Glad", 1,
						Enchantment.DAMAGE_ALL, 0, false);
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("archer")) {
			if (p.hasPermission("kit.archer")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Archer");
				KitAPI.Kit.add(p.getName());
				KitAPI.Archer.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Archer Foi Selecionado");
				KitAPI.setitem(p, Material.BOW, String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Arco", 1,
						Enchantment.ARROW_INFINITE, 1, false);
				KitAPI.setitem(p, Material.ARROW, String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Flecha", 2,
						Enchantment.DAMAGE_ALL, 0, false);
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("thresh")) {
			if (p.hasPermission("kit.thresh")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Thresh");
				KitAPI.Kit.add(p.getName());
				KitAPI.Thresh.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Thresh Foi Selecionado");
				KitAPI.setitem(p, Material.LEVER, String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Thresh", 1,
						Enchantment.DAMAGE_ALL, 0, false);
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("viper")) {
			if (p.hasPermission("kit.viper")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Viper");
				KitAPI.Kit.add(p.getName());
				KitAPI.Viper.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Viper Foi Selecionado");
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("snail")) {
			if (p.hasPermission("kit.snail")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Snail");
				KitAPI.Kit.add(p.getName());
				KitAPI.Snail.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Snail Foi Selecionado");
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("dublejump")) {
			if (p.hasPermission("kit.dublejump")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "DubleJump");
				KitAPI.Kit.add(p.getName());
				KitAPI.DubleJump.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit DubleJump Foi Selecionado");
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("magma")) {
			if (p.hasPermission("kit.magma")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Magma");
				KitAPI.Kit.add(p.getName());
				KitAPI.Magma.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Magma Foi Selecionado");
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("phantom")) {
			if (p.hasPermission("kit.phantom")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Phantom");
				KitAPI.Kit.add(p.getName());
				KitAPI.Phantom.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Phantom Foi Selecionado");
				KitAPI.setitem(p, Material.FEATHER, String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Pena", 1,
						Enchantment.DAMAGE_ALL, 0, false);
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("armor")) {
			if (p.hasPermission("kit.armor")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Armor");
				KitAPI.Kit.add(p.getName());
				KitAPI.Armor.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Armor Foi Selecionado");
				KitAPI.setitem(p, Material.GOLD_INGOT,
						String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Armadura Portatil", 1,
						Enchantment.DAMAGE_ALL, 0, false);
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("urgal")) {
			if (p.hasPermission("kit.urgal")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Urgal");
				KitAPI.Kit.add(p.getName());
				KitAPI.Urgal.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Urgal Foi Selecionado");
				final ItemStack mf = new ItemStack(Material.POTION, 3, (short) 8201);
				final ItemMeta kmf = mf.getItemMeta();
				kmf.setDisplayName(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Urgal");
				mf.setItemMeta(kmf);
				p.getInventory().setItem(1, mf);
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("ironman")) {
			if (p.hasPermission("kit.ironman")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "IronMan");
				KitAPI.Kit.add(p.getName());
				KitAPI.IronMan.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit IronMan Foi Selecionado");
				KitAPI.setitem(p, Material.getMaterial(58),
						String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Mesa De Trabalho", 1,
						Enchantment.DAMAGE_ALL, 0, false);
				KitAPI.setitem(p, Material.STICK, String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Graveto", 2,
						Enchantment.DAMAGE_ALL, 0, false);
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("forcefield")) {
			if (p.hasPermission("kit.forcefield")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "ForceField");
				KitAPI.Kit.add(p.getName());
				KitAPI.ForceField.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit FF Foi Selecionado");
				KitAPI.setitem(p, Material.NETHER_FENCE, String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7FF", 1,
						Enchantment.DAMAGE_ALL, 0, false);
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("trader")) {
			if (p.hasPermission("kit.trader")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "Trader");
				KitAPI.Kit.add(p.getName());
				KitAPI.Trader.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit Trader Foi Selecionado");
				KitAPI.setitem(p, Material.ENDER_CHEST, String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Lojinha",
						1, Enchantment.DAMAGE_ALL, 0, false);
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("jellyfish")) {
			if (p.hasPermission("kit.jellyfish")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "JellyFish");
				KitAPI.Kit.add(p.getName());
				KitAPI.JellyFish.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit JellyFish Foi Selecionado");
				KitAPI.setitem(p, Material.CLAY_BALL, String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7JellyFish",
						1, Enchantment.DAMAGE_ALL, 0, false);
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		if (args[0].equalsIgnoreCase("deshfire")) {
			if (p.hasPermission("kit.deshfire")) {
				p.getInventory().clear();
				KitAPI.recraft(p);
				KitAPI.sopa(p);
				KitAPI.sword(p);
				Habilidade.setAbility(p, "DeshFire");
				KitAPI.Kit.add(p.getName());
				KitAPI.DeshFire.add(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Kit DeshFire Foi Selecionado");
				KitAPI.setitem(p, Material.REDSTONE_BLOCK,
						String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7DeshFire", 1, Enchantment.DAMAGE_ALL, 0,
						false);
				SetArenaCommand.TeleportArenaRandom(p);
			} else {
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix))
						+ " �6� �7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
			}
		}
		return false;
	}
}
