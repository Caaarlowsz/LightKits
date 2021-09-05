package Kits;

import org.bukkit.event.player.*;
import Eventos.*;
import org.bukkit.*;
import Main.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class Hulk implements Listener
{
    @EventHandler
    public void PickUpPlayer(final PlayerInteractEntityEvent e) {
        if (!(e.getRightClicked() instanceof Player)) {
            return;
        }
        if (e.getRightClicked() instanceof Player) {
            final Player p = e.getPlayer();
            if (Habilidade.getAbility(p).equalsIgnoreCase("Hulk")) {
                final Player r = (Player)e.getRightClicked();
                if (Cooldown.add(p)) {
                    Basico.MensagemCooldown(p);
                    return;
                }
                if (p.getItemInHand().getType() != Material.SADDLE) {
                    return;
                }
                if (p.getPassenger() != null) {
                    p.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " �6� �7Aguarde o Outro Player Sair");
                    return;
                }
                if (r.getPassenger() != null) {
                    return;
                }
                Cooldown.add(p, 6);
                p.setPassenger((Entity)r);
                r.sendMessage(String.valueOf(String.valueOf(Main.prefix)) + " �6� �7Um Hulk Prendeu Voc\u00ea Aperde SHIFT Para Se Desprender");
            }
        }
    }
}