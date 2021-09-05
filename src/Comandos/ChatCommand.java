package Comandos;

import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import Main.*;

public class ChatCommand implements Listener, CommandExecutor
{
    public static boolean chat1;
    
    static {
        ChatCommand.chat1 = true;
    }
    
    @EventHandler
    public void onPlayerChat(final AsyncPlayerChatEvent e) {
        if (!e.getPlayer().hasPermission("falar.chat") && !ChatCommand.chat1) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(" §cVoce nao pode falar com o Chat Desativado!");
        }
    }
    
    @EventHandler
    public void onPlayerChat1(final PlayerChatEvent e) {
        if (!e.getPlayer().hasPermission("falar.chat") && !ChatCommand.chat1) {
            e.setCancelled(true);
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        if (sender.hasPermission("cmd.chat")) {
            if (args.length > 0) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("off")) {
                        ChatCommand.chat1 = false;
                        Bukkit.broadcastMessage("§4§lAVISO: §7O Chat foi Desativado!");
                    }
                    else if (args[0].equalsIgnoreCase("on")) {
                        ChatCommand.chat1 = true;
                        Bukkit.broadcastMessage("§4§lAVISO: §7O Chat foi Ativado!");
                    }
                }
                else {
                    sender.sendMessage(String.valueOf(Main.prefix) + " §cOps! Use isso De Maneira Correta: §7/chat (on/off)");
                }
            }
            else {
                sender.sendMessage(String.valueOf(Main.prefix) + " §cOps! Use isso De Maneira Correta: §7/chat (on/off)");
            }
        }
        return true;
    }
}
