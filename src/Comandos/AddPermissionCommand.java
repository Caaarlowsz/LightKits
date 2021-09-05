package Comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class AddPermissionCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("addpermission")) {
            if (!p.hasPermission("cmd.addpermission")) {}
            p.sendMessage("§7Voce precisa ser §cGerente§7 Ou superior para usar este comando.");
        }
        if (args.length == 0) {
            p.sendMessage("§7Voce usou de maneira incorreta, por favor use: §e/addpermission (jogador) (permiss\u00e3o)");
            return true;
        }
        if (args.length == 1) {
            p.sendMessage("§7Voce usou de maneira incorreta, por favor use: §e/addpermission (jogador) (permiss\u00e3o)");
            return true;
        }
        final Player k = Bukkit.getPlayer(args[0]);
        final String permissao = args[1];
        p.chat("/pex user " + k + " add " + permissao);
        p.sendMessage("§7Permiss\u00e3o §6" + permissao + " §7adicionada ao jogador §6" + k.getName());
        return false;
    }
}
