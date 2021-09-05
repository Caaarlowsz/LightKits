package Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class YTCommand implements Listener, CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		cmd.getName().equalsIgnoreCase("youtuber");
		p.sendMessage("§7");
		p.sendMessage("§7Ola, Bem-Vindo a area de requisitos para a tag §bYoutuber§7!");
		p.sendMessage("§7");
		p.sendMessage("§b* §7Para adquirir tag §bYoutuber§7 voce precisa de:");
		p.sendMessage("§7- Video no servidor");
		p.sendMessage("§7- 50 likes no video do servidor");
		p.sendMessage("§7- 500 Subs");
		p.sendMessage("§7- FeedBack bom por video");
		p.sendMessage("§7- Mais de 20 visualiza\u00e7\u00f5es no canal.");
		p.sendMessage("§7");
		p.sendMessage("§b* §7O que daremos em troca?");
		p.sendMessage("§b* §7Voce tera acesso a:");
		p.sendMessage("§7");
		p.sendMessage("§7- Tag §b§lYOUTUBER§b " + p.getName());
		p.sendMessage("§7- Todos os Kits do servidor");
		p.sendMessage("§7- Entrar com o servidor lotado");
		p.sendMessage("§7- Privilegio em eventos");
		p.sendMessage("§7- Acesso a vantagens vip.");
		return false;
	}
}
