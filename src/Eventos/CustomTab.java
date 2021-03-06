package Eventos;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.spigotmc.ProtocolInjector;

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PlayerConnection;

public class CustomTab implements Listener {
	private static int VERSION = 47;

	@EventHandler
	void TabDoServidor(PlayerJoinEvent evento) {
		final Player jogador = evento.getPlayer();
		Bukkit.getScheduler().scheduleSyncRepeatingTask(LightPvP.getPlugin(), new Runnable() {

			final int ping = ((CraftPlayer) jogador).getHandle().ping;

			@Override
			public void run() {
				PlayerConnection connect = ((CraftPlayer) jogador).getHandle().playerConnection;
				IChatBaseComponent top = ChatSerializer.a(
						"{'extra': [{text: '', color: 'aqua'}],'color': gold, 'text': '                  �e�lKitPvP              '}");
				IChatBaseComponent bottom = ChatSerializer.a("{'extra': [{'color': 'aqua', 'text': ' �7Online: �6"
						+ Bukkit.getServer().getOnlinePlayers().length + " �c- �7Kit: �b"
						+ Habilidade.getAbility(jogador) + " �c- �7Ping: �a" + ping
						+ " ', 'underline': 'true'}], 'color': 'gold', 'text': ''}");
				if (((CraftPlayer) jogador).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
					return;
				}
				connect.sendPacket(new ProtocolInjector.PacketTabHeader(top, bottom));

			}
		}, 1L, 20L);
	}

}
