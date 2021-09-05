package Outros;

import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.inventory.*;
import org.bukkit.entity.*;

public class RecraftsignOther implements Listener
{
    @EventHandler
    public void Escrever(final SignChangeEvent e) {
        if (e.getLine(0).equalsIgnoreCase("recraft")) {
            e.setLine(0, "§5Nitec");
            e.setLine(1, "§a§lRecraft");
            e.setLine(2, "");
            e.setLine(3, "§c(Clique)");
        }
    }
    
    @EventHandler
    public void inv(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock() != null && (e.getClickedBlock().getType() == Material.WALL_SIGN || e.getClickedBlock().getType() == Material.SIGN_POST)) {
            final Sign s = (Sign)e.getClickedBlock().getState();
            final String[] lines = s.getLines();
            if (lines.length > 0 && lines[0].equals("§5Nitec") && lines.length > 1 && lines[1].equals("§a§lRecraft") && lines.length > 2 && lines[2].equals("") && lines.length > 3 && lines[3].equals("§c(Clique)")) {
                final ItemStack cogu1 = new ItemStack(Material.BROWN_MUSHROOM, 64);
                final ItemStack cogu2 = new ItemStack(Material.RED_MUSHROOM, 64);
                final ItemStack pote = new ItemStack(Material.BOWL, 64);
                p.sendMessage("§aO recraft foi enviado para o seu inventario!");
                p.getInventory().addItem(new ItemStack[] { cogu1 });
                p.getInventory().addItem(new ItemStack[] { cogu2 });
                p.getInventory().addItem(new ItemStack[] { pote });
                p.updateInventory();
            }
        }
    }
}
