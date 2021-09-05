package Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Main.Main;


public class ScoreCommand implements CommandExecutor, Listener {
 
 @Override
 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
  if(!(sender instanceof Player)) {
   sender.sendMessage("Comando de Jogador!");
   return true;
  }
  Player p = (Player) sender;
  if(Main.score.contains(p.getName())) {
   Main.score.remove(p.getName());
   p.sendMessage(Main.prefix + " §7Sua scoreboard foi Ativada!");
  
  }
  else {
   Main.score.add(p.getName());
   p.sendMessage(Main.prefix + " §8Sua scoreboard foi Desativada!");
  }
  
  return false;
 }
}