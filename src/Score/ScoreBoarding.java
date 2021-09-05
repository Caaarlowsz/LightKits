package Score;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import Main.Main;
import Utils.KillsdeathsmoneyAPI;
import net.md_5.bungee.api.ChatColor;
import Eventos.Habilidade;

public class ScoreBoarding implements Listener {

	public static Main plugin;
	
	public static String Rank(Player p) {
		  double a = KillsdeathsmoneyAPI.getKills(p);
		  if(a <= 100) {
		   return "§7⚊";
		  }
		  if(a <= 200) {
		   return ChatColor.GREEN + "⚌";
		  }
		  if(a <= 300) {
		   return ChatColor.YELLOW + "☰";
		  }
		  if(a <= 400) {
		   return "§1✥";
		  }
		  if(a <= 500) {
		   return "§7✯";
		  }
		  if(a <= 600) {
		   return "§6✪";
		  }
		  if(a <= 700) {
		   return ChatColor.AQUA + "§b❈";
		  }
		  if(a <= 800) {
		   return "§2✸";
		  }
		  if(a <= 900) {
		   return ChatColor.RED + "✹";
		  }
		  if(a <= 1000) {
		   return "§3✷";
		  }
		  if(a <= 1500) {
		   return "§4❂";
		  }
		  return "§4❂";
		 }
		 public static String getRankConfig(Player p) {
		  double a = KillsdeathsmoneyAPI.getKills(p);
		  if(a <= 100) {
		   return "§7Sem Rank";
		  }
		  if(a <= 200) {
		   return "§aINICIANTE";
		  }
		  if(a <= 300) {
		   return "§eAPRENDIZ";
		  }
		  if(a <= 400) {
		   return "§1EXPERT";
		  }
		  if(a <= 500) {
		   return "§7SILVER";
		  }
		  if(a <= 600) {
		   return "§6GOLD";
		  }
		  if(a <= 700) {
		   return "§bDIAMOND";
		  }
		  if(a <= 800) {
		   return "§2EMERALD";
		  }
		  if(a <= 900) {
		   return "§cRUBY";
		  }
		  if(a <= 1000) {
		   return "§3SAFIRA";
		  }
		  if(a <= 1500) {
		   return "§4LENDARIO";
		  }
		  return "§4LENDARIO";
		 }
		 public static String getNomeRank(Player p) {
		  double a = KillsdeathsmoneyAPI.getKills(p);
		  if(a <= 100) {
		   return "§7Sem Rank";
		  }
		  if(a <= 200) {
		   return "§aINICIANTE";
		  }
		  if(a <= 300) {
		   return "§eAPRENDIZ";
		  }
		  if(a <= 400) {
		   return "§1EXPERT";
		  }
		  if(a <= 500) {
		   return "§7SILVER";
		  }
		  if(a <= 600) {
		   return "§6GOLD";
		  }
		  if(a <= 700) {
		   return "§bDIAMOND";
		  }
		  if(a <= 800) {
		   return "§2EMERALD";
		  }
		  if(a <= 900) {
		   return "§CRUBY";
		  }
		  if(a <= 1000) {
		   return "§3SAFIRA";
		  }
		  if(a <= 1500) {
		   return "§4LENDARIO";
		  }
		  return "§4LENDARIO";
		 }
		 public static String Liga(Player p) {
		  double a = KillsdeathsmoneyAPI.getKills(p);
		  if(a <= 100) {
		   return "§7Sem Rank";
		  }
		  if(a <= 200) {
		   return "§aINICIANTE";
		  }
		  if(a <= 300) {
		   return "§eAPRENDIZ";
		  }
		  if(a <= 400) {
		   return "§1EXPERT";
		  }
		  if(a <= 500) {
		   return "§7SILVER";
		  }
		  if(a <= 600) {
		   return "§6GOLD";
		  }
		  if(a <= 700) {
		   return "§bDIAMOND";
		  }
		  if(a <= 800) {
		   return "§2EMERALD";
		  }
		  if(a <= 900) {
		   return "§cRUBY";
		  }
		  if(a <= 1000) {
		   return "§3SAFIRA";
		  }
		  if(a <= 1500) {
		   return "§4LENDARIO";
		  }
		  return "§4LENDARIO";
		 }

	@SuppressWarnings({ "deprecation" })
	public static void setScoreBoard(Player p) {
		 final String jogadoronline = String.valueOf(Bukkit.getServer().getOnlinePlayers().length) + "§7/" + Bukkit.getServer().getMaxPlayers();

		
		Random r = new Random();

		int animar = r.nextInt(12);

		if (animar == 1) {
			
			SimpleScoreboard scoreboard = new SimpleScoreboard(Main.prefix);
			scoreboard.add("     §aBem-Vindo!");
			scoreboard.blankLine();
			scoreboard.add("§aKills ➜ §7"  + KillsdeathsmoneyAPI.getKills(p));
			scoreboard.add("§cDeaths ➜ §7" + KillsdeathsmoneyAPI.getDeaths(p));
			scoreboard.blankLine();
			scoreboard.add("§eMoedas ➜ §7" + Coins.XpM.getPlayerMoney(p));
			scoreboard.add("§bSeu Kit ➜ §7" + Habilidade.getAbility(p));
			scoreboard.add("§2Jogadores ➜ §7" + jogadoronline);
			scoreboard.add("§dRank ➜ §7" + Rank(p));
			scoreboard.add("§5Liga ➜ §7" + Liga(p));
			scoreboard.blankLine();
			scoreboard.add("§7    /score");
			scoreboard.build();
			scoreboard.send(p);
		}
		if (animar == 2) {
			SimpleScoreboard scoreboard = new SimpleScoreboard(Main.prefix);
			scoreboard.add("     §aBem-Vindo!");
			scoreboard.blankLine();
			scoreboard.add("§aKills ➜ §7"  + KillsdeathsmoneyAPI.getKills(p));
			scoreboard.add("§cDeaths ➜ §7" + KillsdeathsmoneyAPI.getDeaths(p));
			scoreboard.blankLine();
			scoreboard.add("§eMoedas ➜ §7" + Coins.XpM.getPlayerMoney(p));
			scoreboard.add("§bSeu Kit ➜ §7" + Habilidade.getAbility(p));
			scoreboard.add("§2Jogadores ➜ §7" + jogadoronline);
			scoreboard.add("§dRank ➜ §7" + Rank(p));
			scoreboard.add("§5Liga ➜ §7" + Liga(p));
			scoreboard.blankLine();
			scoreboard.add("§7    /score");
			scoreboard.build();
			scoreboard.send(p);
		}

		if (animar == 3) {
			SimpleScoreboard scoreboard = new SimpleScoreboard(Main.prefix);
			scoreboard.add("     §aBem-Vindo!");
			scoreboard.blankLine();
			scoreboard.add("§aKills ➜ §7"  + KillsdeathsmoneyAPI.getKills(p));
			scoreboard.add("§cDeaths ➜ §7" + KillsdeathsmoneyAPI.getDeaths(p));
			scoreboard.blankLine();
			scoreboard.add("§eMoedas ➜ §7" + Coins.XpM.getPlayerMoney(p));
			scoreboard.add("§bSeu Kit ➜ §7" + Habilidade.getAbility(p));
			scoreboard.add("§2Jogadores ➜ §7" + jogadoronline);
			scoreboard.add("§dRank ➜ §7" + Rank(p));
			scoreboard.add("§5Liga ➜ §7" + Liga(p));
			scoreboard.blankLine();
			scoreboard.add("§7    /score");
			scoreboard.build();
			scoreboard.send(p);
		}

		if (animar == 4) {
			SimpleScoreboard scoreboard = new SimpleScoreboard(Main.prefix);
			scoreboard.add("     §aBem-Vindo!");
			scoreboard.blankLine();
			scoreboard.add("§aKills ➜ §7"  + KillsdeathsmoneyAPI.getKills(p));
			scoreboard.add("§cDeaths ➜ §7" + KillsdeathsmoneyAPI.getDeaths(p));
			scoreboard.blankLine();
			scoreboard.add("§eMoedas ➜ §7" + Coins.XpM.getPlayerMoney(p));
			scoreboard.add("§bSeu Kit ➜ §7" + Habilidade.getAbility(p));
			scoreboard.add("§2Jogadores ➜ §7" + jogadoronline);
			scoreboard.add("§dRank ➜ §7" + Rank(p));
			scoreboard.add("§5Liga ➜ §7" + Liga(p));
			scoreboard.blankLine();
			scoreboard.add("§7    /score");
			scoreboard.build();
			scoreboard.send(p);
		}
		
		if (animar == 5) {
			SimpleScoreboard scoreboard = new SimpleScoreboard(Main.prefix);
			scoreboard.add("     §aBem-Vindo!");
			scoreboard.blankLine();
			scoreboard.add("§aKills ➜ §7"  + KillsdeathsmoneyAPI.getKills(p));
			scoreboard.add("§cDeaths ➜ §7" + KillsdeathsmoneyAPI.getDeaths(p));
			scoreboard.blankLine();
			scoreboard.add("§eMoedas ➜ §7" + Coins.XpM.getPlayerMoney(p));
			scoreboard.add("§bSeu Kit ➜ §7" + Habilidade.getAbility(p));
			scoreboard.add("§2Jogadores ➜ §7" + jogadoronline);
			scoreboard.add("§dRank ➜ §7" + Rank(p));
			scoreboard.add("§5Liga ➜ §7" + Liga(p));
			scoreboard.blankLine();
			scoreboard.add("§7    /score");
			scoreboard.build();
			scoreboard.send(p);
		}
		
		if (animar == 6) {
			SimpleScoreboard scoreboard = new SimpleScoreboard(Main.prefix);
			scoreboard.add("     §aBem-Vindo!");
			scoreboard.blankLine();
			scoreboard.add("§aKills ➜ §7"  + KillsdeathsmoneyAPI.getKills(p));
			scoreboard.add("§cDeaths ➜ §7" + KillsdeathsmoneyAPI.getDeaths(p));
			scoreboard.blankLine();
			scoreboard.add("§eMoedas ➜ §7" + Coins.XpM.getPlayerMoney(p));
			scoreboard.add("§bSeu Kit ➜ §7" + Habilidade.getAbility(p));
			scoreboard.add("§2Jogadores ➜ §7" + jogadoronline);
			scoreboard.add("§dRank ➜ §7" + Rank(p));
			scoreboard.add("§5Liga ➜ §7" + Liga(p));
			scoreboard.blankLine();
			scoreboard.add("§7    /score");
			scoreboard.build();
			scoreboard.send(p);
		}
		
		if (animar == 7) {
			SimpleScoreboard scoreboard = new SimpleScoreboard(Main.prefix);
			scoreboard.add("     §aBem-Vindo!");
			scoreboard.blankLine();
			scoreboard.add("§aKills ➜ §7"  + KillsdeathsmoneyAPI.getKills(p));
			scoreboard.add("§cDeaths ➜ §7" + KillsdeathsmoneyAPI.getDeaths(p));
			scoreboard.blankLine();
			scoreboard.add("§eMoedas ➜ §7" + Coins.XpM.getPlayerMoney(p));
			scoreboard.add("§bSeu Kit ➜ §7" + Habilidade.getAbility(p));
			scoreboard.add("§2Jogadores ➜ §7" + jogadoronline);
			scoreboard.add("§dRank ➜ §7" + Rank(p));
			scoreboard.add("§5Liga ➜ §7" + Liga(p));
			scoreboard.blankLine();
			scoreboard.add("§7    /score");
			scoreboard.build();
			scoreboard.send(p);
		}
		
		if (animar == 8) {
			SimpleScoreboard scoreboard = new SimpleScoreboard(Main.prefix);
			scoreboard.add("     §aBem-Vindo!");
			scoreboard.blankLine();
			scoreboard.add("§aKills ➜ §7"  + KillsdeathsmoneyAPI.getKills(p));
			scoreboard.add("§cDeaths ➜ §7" + KillsdeathsmoneyAPI.getDeaths(p));
			scoreboard.blankLine();
			scoreboard.add("§eMoedas ➜ §7" + Coins.XpM.getPlayerMoney(p));
			scoreboard.add("§bSeu Kit ➜ §7" + Habilidade.getAbility(p));
			scoreboard.add("§2Jogadores ➜ §7" + jogadoronline);
			scoreboard.add("§dRank ➜ §7" + Rank(p));
			scoreboard.add("§5Liga ➜ §7" + Liga(p));
			scoreboard.blankLine();
			scoreboard.add("§7    /score");
			scoreboard.build();
			scoreboard.send(p);
		}
		if (animar == 9) {
			SimpleScoreboard scoreboard = new SimpleScoreboard(Main.prefix);
			scoreboard.add("     §aBem-Vindo!");
			scoreboard.blankLine();
			scoreboard.add("§aKills ➜ §7"  + KillsdeathsmoneyAPI.getKills(p));
			scoreboard.add("§cDeaths ➜ §7" + KillsdeathsmoneyAPI.getDeaths(p));
			scoreboard.blankLine();
			scoreboard.add("§eMoedas ➜ §7" + Coins.XpM.getPlayerMoney(p));
			scoreboard.add("§bSeu Kit ➜ §7" + Habilidade.getAbility(p));
			scoreboard.add("§2Jogadores ➜ §7" + jogadoronline);
			scoreboard.add("§dRank ➜ §7" + Rank(p));
			scoreboard.add("§5Liga ➜ §7" + Liga(p));
			scoreboard.blankLine();
			scoreboard.add("§7    /score");
			scoreboard.build();
			scoreboard.send(p);
		}
	}
	
    
	public static void removeScoreBoard(Player p) {
		Scoreboard score = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective o = score.registerNewObjective("kit", "PvP");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName("");
		p.setScoreboard(score);


	}
}