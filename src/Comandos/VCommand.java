package Comandos;

import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import org.bukkit.*;

public class VCommand implements CommandExecutor
{
    public static ArrayList<Player> emver;
    
    static {
        VCommand.emver = new ArrayList<Player>();
    }
    
    public static boolean emInvisivel(final Player p) {
        return VCommand.emver.contains(p);
    }
    
    public static void addInvisivel(final Player p) {
        VCommand.emver.add(p);
    }
    
    public static void removerInvisivel(final Player p) {
        VCommand.emver.remove(p);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("v")) {
            if (p.hasPermission("cmd.v")) {
                if (!emInvisivel(p)) {
                    addInvisivel(p);
                    p.sendMessage("§aVoc\u00ea ficou invisivel para todos os players");
                    p.setGameMode(GameMode.CREATIVE);
                    Player[] onlinePlayers;
                    for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                        final Player todos = onlinePlayers[i];
                        todos.hidePlayer(p);
                    }
                }
                else {
                    removerInvisivel(p);
                    Player[] onlinePlayers2;
                    for (int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length, j = 0; j < length2; ++j) {
                        final Player todos = onlinePlayers2[j];
                        todos.showPlayer(p);
                    }
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage("§cVoc\u00ea ficou visivel para todos os players");
                }
            }
            else {
                p.sendMessage("§cDesculpe, Mas apenas pessoas do grupo §3Ajudante §cou Superior podem executar este Comando.");
            }
        }
        return false;
    }
}
