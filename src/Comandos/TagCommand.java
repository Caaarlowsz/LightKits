package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;

public class TagCommand implements Listener, CommandExecutor {
	public TagCommand(final LightPvP main) {
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!cmd.getName().equalsIgnoreCase("tag")) {
			return false;
		}
		final Player p = (Player) sender;
		if (args.length != 0) {
			if (args[0].equalsIgnoreCase("normal")) {
				if (p.hasPermission("tag.normal")) {
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �aTag Alterada");
					p.setDisplayName("�7" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("�7" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &7&lJOGADOR &7");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �cSem Permiss\u00e3o");
			}
			if (args[0].equalsIgnoreCase("light")) {
				if (p.hasPermission("tag.light")) {
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �aTag Alterada");
					p.setDisplayName("�a�lLIGHT �7" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("�a" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &a&lLIGHT &7");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �cSem Permiss\u00e3o");
			}
			if (args[0].equalsIgnoreCase("coder")) {
				if (p.hasPermission("tag.coder")) {
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �aTag Alterada");
					p.setDisplayName("�3�lCODER �7" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("�3" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &3&lCoder &7");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �cSem Permiss\u00e3o");
			}
			if (args[0].equalsIgnoreCase("subdono")) {
				if (p.hasPermission("tag.subdono")) {
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �aTag Alterada");
					p.setDisplayName("�c�lSUB�4�lDONO �7" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("�4" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &c&lSUB&4&lDONO &7");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �cSem Permiss\u00e3o");
			}
			if (args[0].equalsIgnoreCase("builder+")) {
				if (p.hasPermission("tag.builder+")) {
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �aTag Alterada");
					p.setDisplayName("�1�lBUILDER+ �7" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("�1" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &1&lBUILDER+ &7");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �cSem Permiss\u00e3o");
			}
			if (args[0].equalsIgnoreCase("master")) {
				if (p.hasPermission("tag.master")) {
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �aTag Alterada");
					p.setDisplayName("�6�lMASTER �7" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("�6" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &6&lMASTER &7");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �cSem Permiss\u00e3o");
			}
			if (args[0].equalsIgnoreCase("premium")) {
				if (p.hasPermission("tag.premium")) {
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �aTag Alterada");
					p.setDisplayName("�e�lPREMIUM �7" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("�e" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &e&lPREMIUM &7");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �cSem Permiss\u00e3o");
			}
			if (args[0].equalsIgnoreCase("ultimate")) {
				if (p.hasPermission("tag.ultimate")) {
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �aTag Alterada");
					p.setDisplayName("�d�lULTIMATE �7" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("�d" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &d�lULTIMATE &7");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �cSem Permiss\u00e3o");
			}
			if (args[0].equalsIgnoreCase("beta")) {
				if (p.hasPermission("tag.beta")) {
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �aTag Alterada");
					p.setDisplayName("�1�lBETA �7" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("�1" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &1�lBETA &7");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �cSem Permiss\u00e3o");
			}
			if (args[0].equalsIgnoreCase("youtuber")) {
				if (p.hasPermission("tag.youtuber")) {
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �aTag Alterada");
					p.setDisplayName("�c�lY�f�lT �7" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("�b" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &c�lY�f�lT &7");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �cSem Permiss\u00e3o");
			}
			if (args[0].equalsIgnoreCase("youtuber+")) {
				if (p.hasPermission("tag.youtuber+")) {
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �aTag Alterada");
					p.setDisplayName("�c�lY�f�lT�3+ �7" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("�b" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " �c�lY�f�lT�3+ &7");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �cSem Permiss\u00e3o");
			}
			if (args[0].equalsIgnoreCase("ajudante")) {
				if (p.hasPermission("tag.ajudante")) {
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �aTag Alterada");
					p.setDisplayName("�3�lAJUDANTE �7" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("�3" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &3&lAJUDANTE &7");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �cSem Permiss\u00e3o");
			}
			if (args[0].equalsIgnoreCase("builder")) {
				if (p.hasPermission("tag.builder")) {
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �aTag Alterada");
					p.setDisplayName("�1�lBUILDER �7" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("�1" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &1&lBUILDER &7");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �cSem Permiss\u00e3o");
			}
			if (args[0].equalsIgnoreCase("trial")) {
				if (p.hasPermission("tag.trial")) {
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �aTag Alterada");
					p.setDisplayName("�d�lTRIAL �7" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("�d" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &d&lTRIAL &7");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �cSem Permiss\u00e3o");
			}
			if (args[0].equalsIgnoreCase("mod")) {
				if (p.hasPermission("tag.mod")) {
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �aTag Alterada");
					p.setDisplayName("�5�lMOD �7" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("�5" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &5&lMOD &7");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �cSem Permiss\u00e3o");
			}
			if (args[0].equalsIgnoreCase("mod+")) {
				if (p.hasPermission("tag.mod+")) {
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �aTag Alterada");
					p.setDisplayName("�5�lMOD+ �7" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("�5" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &5&lMOD+ &7");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �cSem Permiss\u00e3o");
			}
			if (args[0].equalsIgnoreCase("admin")) {
				if (p.hasPermission("tag.admin")) {
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �aTag Alterada");
					p.setDisplayName("�c�lADM �7" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("�c" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &c&lADMIN &7");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �cSem Permiss\u00e3o");
			}
			if (args[0].equalsIgnoreCase("dono")) {
				if (p.hasPermission("tag.dono")) {
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �aTag Alterada");
					p.setDisplayName("�4�lDONO �7" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("�4" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &4&lDONO &7");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �cSem Permiss\u00e3o");
			}
			if (args[0].equalsIgnoreCase("gerente")) {
				if (p.hasPermission("tag.gerente")) {
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �aTag Alterada");
					p.setDisplayName("�2�lGERENTE �7" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("�2" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &2&lGERENTE &7");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �cSem Permiss\u00e3o");
			}
			if (args[0].equalsIgnoreCase("semiyt")) {
				if (p.hasPermission("tag.semiyt")) {
					p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �aTag Alterada");
					p.setDisplayName("�7�lSEMI-YT �7" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("�7" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &f&lSEMI-YT &7");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �cSem Permiss\u00e3o");
			}
			return false;
		}
		if (p.hasPermission("*")) {
			p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �eTags Disponiveis No Momento");
			p.sendMessage("�7� �7�lNORMAL");
			p.sendMessage("�7� �a�lLIGHT");
			p.sendMessage("�7� �6�lPREMIUM");
			p.sendMessage("�7� �d�lULTIMATE");
			p.sendMessage("�7� �7�lSEMI-YT");
			p.sendMessage("�7� �7�lYOUTUBER+");
			p.sendMessage("�7� �b�lYOUTUBER");
			p.sendMessage("�7� �3�lAJUDANTE");
			p.sendMessage("�7� �e�lBUILDER");
			p.sendMessage("�7� �d�lTRIAL");
			p.sendMessage("�7� �5�lMOD");
			p.sendMessage("�7� �c�lADM");
			p.sendMessage("�7� �2�lGERENTE");
			p.sendMessage("�7� �4�lDONO");
			return true;
		}
		if (p.hasPermission("tag.normal")) {
			p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �eTags Disponiveis No Momento");
			p.sendMessage("�7� �7�lNORMAL");
		}
		if (p.hasPermission("tag.LIGHT")) {
			p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �eTags Disponiveis No Momento");
			p.sendMessage("�7� �7�lNORMAL");
			p.sendMessage("�7� �a�lLIGHT");
		}
		if (p.hasPermission("tag.PREMIUM")) {
			p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �eTags Disponiveis No Momento");
			p.sendMessage("�7� �7�lNORMAL");
			p.sendMessage("�7� �a�lLIGHT");
			p.sendMessage("�7� �6�lPREMIUM");
		}
		if (p.hasPermission("tag.ULTIMATE")) {
			p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �eTags Disponiveis No Momento");
			p.sendMessage("�7� �7�lNORMAL");
			p.sendMessage("�7� �a�lLIGHT");
			p.sendMessage("�7� �6�lPREMIUM");
			p.sendMessage("�7� �9�lULTIMATE");
		}
		if (p.hasPermission("tag.semiyt")) {
			p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �eTags Disponiveis No Momento");
			p.sendMessage("�7� �7�lNORMAL");
			p.sendMessage("�7� �a�lLIGHT");
			p.sendMessage("�7� �6�lPREMIUM");
			p.sendMessage("�7� �9�lULTIMATE");
			p.sendMessage("�7� �7�lSEMI-YT");
		}
		if (p.hasPermission("tag.youtuber")) {
			p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �eTags Disponiveis No Momento");
			p.sendMessage("�7� �7�lNORMAL");
			p.sendMessage("�7� �a�lLIGHT");
			p.sendMessage("�7� �6�lPREMIUM");
			p.sendMessage("�7� �9�lULTIMATE");
			p.sendMessage("�7� �7�lSEMI-YT");
			p.sendMessage("�7� �b�lYOUTUBER");
		}
		if (p.hasPermission("tag.youtuber+")) {
			p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �eTags Disponiveis No Momento");
			p.sendMessage("�7� �7�lNORMAL");
			p.sendMessage("�7� �b�lYOUTUBER");
			p.sendMessage("�7� �b�lYOUTUBER�3+");
		}
		if (p.hasPermission("tag.ajudante")) {
			p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �eTags Disponiveis No Momento");
			p.sendMessage("�7� �7�lNORMAL");
			p.sendMessage("�7� �a�lLIGHT");
			p.sendMessage("�7� �6�lPREMIUM");
			p.sendMessage("�7� �9�lULTIMATE");
			p.sendMessage("�7� �7�lSEMI-YT");
			p.sendMessage("�7� �b�lYOUTUBER");
			p.sendMessage("�7� �3�lAJUDANTE");
		}
		if (p.hasPermission("tag.builder")) {
			p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �eTags Disponiveis No Momento");
			p.sendMessage("�7� �7�lNORMAL");
			p.sendMessage("�7� �a�lLIGHT");
			p.sendMessage("�7� �6�lPREMIUM");
			p.sendMessage("�7� �9�lULTIMATE");
			p.sendMessage("�7� �7�lSEMI-YT");
			p.sendMessage("�7� �b�lYOUTUBER");
			p.sendMessage("�7� �3�lAJUDANTE");
			p.sendMessage("�7� �e�lBUILDER");
		}
		if (p.hasPermission("tag.trial")) {
			p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �eTags Disponiveis No Momento");
			p.sendMessage("�7� �7�lNORMAL");
			p.sendMessage("�7� �a�lLIGHT");
			p.sendMessage("�7� �6�lPREMIUM");
			p.sendMessage("�7� �9�lULTIMATE");
			p.sendMessage("�7� �7�lSEMI-YT");
			p.sendMessage("�7� �b�lYOUTUBER");
			p.sendMessage("�7� �3�lAJUDANTE");
			p.sendMessage("�7� �e�lBUILDER");
			p.sendMessage("�7� �d�lTRIAL");
		}
		if (p.hasPermission("tag.mod")) {
			p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �eTags Disponiveis No Momento");
			p.sendMessage("�7� �7�lNORMAL");
			p.sendMessage("�7� �a�lLIGHT");
			p.sendMessage("�7� �6�lPREMIUM");
			p.sendMessage("�7� �9�lULTIMATE");
			p.sendMessage("�7� �7�lSEMI-YT");
			p.sendMessage("�7� �b�lYOUTUBER");
			p.sendMessage("�7� �3�lAJUDANTE");
			p.sendMessage("�7� �e�lBUILDER");
			p.sendMessage("�7� �d�lTRIAL");
			p.sendMessage("�7� �5�lMOD");
		}
		if (p.hasPermission("tag.admin")) {
			p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �eTags Disponiveis No Momento");
			p.sendMessage("�7� �7�lNORMAL");
			p.sendMessage("�7� �a�lLIGHT");
			p.sendMessage("�7� �6�lPREMIUM");
			p.sendMessage("�7� �9�lULTIMATE");
			p.sendMessage("�7� �7�lSEMI-YT");
			p.sendMessage("�7� �b�lYOUTUBER");
			p.sendMessage("�7� �3�lAJUDANTE");
			p.sendMessage("�7� �e�lBUILDER");
			p.sendMessage("�7� �d�lTRIAL");
			p.sendMessage("�7� �5�lMOD");
			p.sendMessage("�7� �c�lADM");
		}
		if (p.hasPermission("tag.gerente")) {
			p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �eTags Disponiveis No Momento");
			p.sendMessage("�7� �7�lNORMAL");
			p.sendMessage("�7� �a�lLIGHT");
			p.sendMessage("�7� �6�lPREMIUM");
			p.sendMessage("�7� �9�lULTIMATE");
			p.sendMessage("�7� �7�lSEMI-YT");
			p.sendMessage("�7� �b�lYOUTUBER");
			p.sendMessage("�7� �3�lAJUDANTE");
			p.sendMessage("�7� �e�lBUILDER");
			p.sendMessage("�7� �d�lTRIAL");
			p.sendMessage("�7� �5�lMOD");
			p.sendMessage("�7� �c�lADM");
			p.sendMessage("�7� �2�lGERENTE");
		}
		if (p.hasPermission("tag.subdono")) {
			p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �eTags Disponiveis No Momento");
			p.sendMessage("�7� �7�lNORMAL");
			p.sendMessage("�7� �a�lLIGHT");
			p.sendMessage("�7� �6�lPREMIUM");
			p.sendMessage("�7� �9�lULTIMATE");
			p.sendMessage("�7� �7�lSEMI-YT");
			p.sendMessage("�7� �b�lYOUTUBER");
			p.sendMessage("�7� �3�lAJUDANTE");
			p.sendMessage("�7� �1�lBUILDER");
			p.sendMessage("�7� �d�lTRIAL");
			p.sendMessage("�7� �5�lMOD");
			p.sendMessage("�7� �c�lADM");
			p.sendMessage("�7� �2�lGERENTE");
			p.sendMessage("�7� �c�lSUB�4�lDONO");
		}
		if (p.hasPermission("tag.builder+")) {
			p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �eTags Disponiveis No Momento");
			p.sendMessage("�7� �7�lNORMAL");
			p.sendMessage("�7� �1�lBUILDER");
			p.sendMessage("�7� �1�lBUILDER+");
		}
		if (p.hasPermission("tag.dono")) {
			p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �7� �eTags Disponiveis No Momento");
			p.sendMessage("�7� �7�lNORMAL");
			p.sendMessage("�7� �a�lLIGHT");
			p.sendMessage("�7� �6�lPREMIUM");
			p.sendMessage("�7� �9�lULTIMATE");
			p.sendMessage("�7� �7�lSEMI-YT");
			p.sendMessage("�7� �b�lYOUTUBER");
			p.sendMessage("�7� �3�lAJUDANTE");
			p.sendMessage("�7� �1�lBUILDER");
			p.sendMessage("�7� �d�lTRIAL");
			p.sendMessage("�7� �5�lMOD");
			p.sendMessage("�7� �c�lADM");
			p.sendMessage("�7� �2�lGERENTE");
			p.sendMessage("�7� �4�lDONO");
		}
		return false;
	}

	public static String getShortStr(final String s) {
		if (s.length() == 16) {
			final String shorts = s.substring(0, s.length() - 6);
			return shorts;
		}
		if (s.length() == 15) {
			final String shorts = s.substring(0, s.length() - 5);
			return shorts;
		}
		if (s.length() == 14) {
			final String shorts = s.substring(0, s.length() - 4);
			return shorts;
		}
		if (s.length() == 13) {
			final String shorts = s.substring(0, s.length() - 4);
			return shorts;
		}
		if (s.length() == 12) {
			final String shorts = s.substring(0, s.length() - 2);
			return shorts;
		}
		if (s.length() == 11) {
			final String shorts = s.substring(0, s.length() - 1);
			return shorts;
		}
		return s;
	}

	@EventHandler
	public void aoEntrar(final PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		p.setDisplayName("�7" + p.getName() + ChatColor.GRAY);
		p.setPlayerListName("�7" + getShortStr(p.getName()) + ChatColor.GRAY + ChatColor.ITALIC);
		Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(), "ne prefix " + p.getName() + "&7");
	}
}
