package Comandos;

import Main.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import java.util.*;
import org.apache.commons.lang.*;
import org.bukkit.*;
import Eventos.*;
import API.*;
import org.bukkit.plugin.*;

public class ReportCommand implements CommandExecutor
{
    public ArrayList<String> reported;
    private Main plugin;
    
    public ReportCommand(final Main plugin) {
        this.reported = new ArrayList<String>();
        this.plugin = plugin;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        final Player p = (Player)sender;
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cVoce nao pode usar isso no console");
            return false;
        }
        if (commandLabel.equalsIgnoreCase("report")) {
            if (args.length >= 2) {
                final Player target = p.getServer().getPlayer(args[0]);
                if (target != null) {
                    if (this.reported.contains(p.getName())) {
                        p.sendMessage("§7Voce ja efetuou um report, por favor aguarde!");
                        return true;
                    }
                    final String reportMsg = StringUtils.join((Object[])Arrays.copyOfRange(args, 1, args.length), " ");
                    this.reported.add(p.getName());
                    p.sendMessage("§7O Report do jogador §6" + target.getName() + "foi enviado para nossa equipe. §7Pelo motivo §6" + reportMsg + " ");
                    Player[] arrayOfPlayer;
                    for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
                        final Player s = arrayOfPlayer[i];
                        if (s.hasPermission("ver.report")) {
                            s.playSound(s.getLocation(), Sound.LEVEL_UP, 15.0f, 1.0f);
                            s.sendMessage("§c");
                            s.sendMessage("§c§m--->-----------------------------<---");
                            s.sendMessage("§c");
                            s.sendMessage("§c             §c§lNOVO REPORT!§c               ");
                            s.sendMessage("§c");
                            s.sendMessage("    §cAcusado: §c" + target.getName());
                            s.sendMessage("     §cReport de: §a" + p.getName());
                            s.sendMessage("       §cMotivo: §e" + reportMsg);
                            s.sendMessage("         §cKit: §a" + Habilidade.getAbility(p));
                            s.sendMessage("§c");
                            ChatInterativoAPI.Comando(s.getName(), "§7Teleporte-se ate ele §b§lCLIQUE", "/tp " + target.getName(), "§eTeleporte Rapido. §7(Clique)");
                            s.sendMessage("§c§m--->-----------------------------<---");
                            s.sendMessage("§c");
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                                @Override
                                public void run() {
                                    ReportCommand.this.reported.remove(p.getName());
                                }
                            }, 300L);
                        }
                    }
                }
                else {
                    p.sendMessage("§7Este jogador nao esta conectado!");
                }
            }
            else {
                p.sendMessage("§7Voce usou de maneira incorreta, por favor use: §e/report (jogador) (motivo)");
            }
        }
        return false;
    }
}
