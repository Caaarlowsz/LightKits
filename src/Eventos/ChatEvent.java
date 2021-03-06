package Eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import Score.ScoreBoarding;

public class ChatEvent implements Listener {
	@EventHandler
	public void modificarchat(final AsyncPlayerChatEvent evento) {
		final Player jogador = evento.getPlayer();
		if (jogador.hasPermission("chat.cor")) {
			evento.setFormat(
					"?8{" + String.valueOf(ScoreBoarding.Rank(jogador) + "?8}") + " ?7" + jogador.getDisplayName() + " "
							+ "?a? ?7" + evento.getMessage().replace("&", "?").replace("<3", "?c<3"));
		} else {
			evento.setFormat("?8{" + String.valueOf(ScoreBoarding.Rank(jogador) + "?8}") + " ?7"
					+ jogador.getDisplayName() + " " + "?a? ?7" + evento.getMessage());
		}
	}
}
