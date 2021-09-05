package API;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.spigotmc.ProtocolInjector;

import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.Packet;
import net.minecraft.server.v1_7_R4.PlayerConnection;

public class TitleAPI extends JavaPlugin implements Listener {
	@Deprecated
	public static void sendTitle(final Player player, final Integer fadeIn, final Integer stay, final Integer fadeOut,
			final String message) {
		sendTitle(player, fadeIn, stay, fadeOut, message, null);
	}

	@Deprecated
	public static void sendSubtitle(final Player player, final Integer fadeIn, final Integer stay,
			final Integer fadeOut, final String message) {
		sendTitle(player, fadeIn, stay, fadeOut, null, message);
	}

	@Deprecated
	public static void sendFullTitle(final Player player, final Integer fadeIn, final Integer stay,
			final Integer fadeOut, final String title, final String subtitle) {
		sendTitle(player, fadeIn, stay, fadeOut, title, subtitle);
	}

	public static void sendTitle(final Player player, final Integer fadeIn, final Integer stay, final Integer fadeOut,
			String title, String subtitle) {
		final CraftPlayer craftPlayer = (CraftPlayer) player;
		if (craftPlayer.getHandle().playerConnection.networkManager.getVersion() != 47) {
			return;
		}
		if (title == null) {
			title = "";
		}
		title = ChatColor.translateAlternateColorCodes('&', title);
		if (subtitle == null) {
			subtitle = "";
		}
		subtitle = ChatColor.translateAlternateColorCodes('&', subtitle);
		title = title.replaceAll("%player%", player.getDisplayName());
		subtitle = subtitle.replaceAll("%player%", player.getDisplayName());
		final IChatBaseComponent serializedTitle = ChatSerializer.a(TextConverter.convert(title));
		final IChatBaseComponent serializedSubTitle = ChatSerializer.a(TextConverter.convert(subtitle));
		final IChatBaseComponent title2 = serializedTitle;
		final IChatBaseComponent subtitle2 = serializedSubTitle;
		craftPlayer.getHandle().playerConnection
				.sendPacket((Packet) new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.TIMES,
						(int) fadeIn, (int) stay, (int) fadeOut));
		if (title != null) {
			craftPlayer.getHandle().playerConnection.sendPacket(
					(Packet) new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.TITLE, title2));
		}
		if (subtitle != null) {
			craftPlayer.getHandle().playerConnection.sendPacket(
					(Packet) new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.SUBTITLE, subtitle2));
		}
	}

	public static void sendTabTitle(final Player player, String header, String footer) {
		final CraftPlayer craftPlayer = (CraftPlayer) player;
		if (craftPlayer.getHandle().playerConnection.networkManager.getVersion() != 47) {
			return;
		}
		final PlayerConnection connection = craftPlayer.getHandle().playerConnection;
		if (header == null) {
			header = "";
		}
		header = ChatColor.translateAlternateColorCodes('&', header);
		if (footer == null) {
			footer = "";
		}
		footer = ChatColor.translateAlternateColorCodes('&', footer);
		header = header.replaceAll("%player%", player.getDisplayName());
		footer = footer.replaceAll("%player%", player.getDisplayName());
		final IChatBaseComponent header2 = ChatSerializer.a("{'color': 'white', 'text': '" + header + "'}");
		final IChatBaseComponent footer2 = ChatSerializer.a("{'color': 'white', 'text': '" + footer + "'}");
		connection.sendPacket((Packet) new ProtocolInjector.PacketTabHeader(header2, footer2));
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String string,
			final String[] args) {
		if (args.length < 6) {
			sender.sendMessage(
					ChatColor.RED + "Usage: /title <player> title|subtitle <fadeIn> <stay> <fadeOut> <text>");
			sender.sendMessage(ChatColor.RED
					+ "Note: fadeIn, stay &, fadeOut require to be a number, works in ticks; 20 = 1 second");
			return false;
		}
		if (Bukkit.getPlayer(args[0]) == null) {
			sender.sendMessage(ChatColor.RED + "Player not found");
			return false;
		}
		final Player player = Bukkit.getPlayer(args[0]);
		if (!args[1].equalsIgnoreCase("title") && !args[1].equalsIgnoreCase("subtitle")) {
			sender.sendMessage(ChatColor.RED + "Invalid argument: " + args[1]);
			return false;
		}
		if (!this.isInteger(args[2])) {
			sender.sendMessage(ChatColor.RED + "Not a number: " + args[2]);
			return false;
		}
		if (!this.isInteger(args[3])) {
			sender.sendMessage(ChatColor.RED + "Not a number: " + args[3]);
			return false;
		}
		if (!this.isInteger(args[4])) {
			sender.sendMessage(ChatColor.RED + "Not a number: " + args[4]);
			return false;
		}
		final StringBuilder builder = new StringBuilder();
		for (final String value : args) {
			builder.append(value).append(" ");
		}
		String message = builder.toString();
		message = message.replace(String.valueOf(args[0]) + " ", "");
		message = message.replace(String.valueOf(args[1]) + " ", "");
		message = message.replace(String.valueOf(args[2]) + " ", "");
		message = message.replace(String.valueOf(args[3]) + " ", "");
		message = message.replace(String.valueOf(args[4]) + " ", "");
		if (args[1].equalsIgnoreCase("title")) {
			sendTitle(player, Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), message,
					null);
			sender.sendMessage(ChatColor.GREEN + "Title sent");
			return true;
		}
		if (args[1].equalsIgnoreCase("subtitle")) {
			sendTitle(player, Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), null,
					message);
			sender.sendMessage(ChatColor.GREEN + "Title sent");
			return true;
		}
		return false;
	}

	public void onEnable() {
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		final Server server = this.getServer();
		final ConsoleCommandSender console = server.getConsoleSender();
		console.sendMessage("");
		console.sendMessage(ChatColor.BLUE + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		console.sendMessage("");
		console.sendMessage(ChatColor.AQUA + this.getDescription().getName());
		console.sendMessage(ChatColor.AQUA + "Version " + this.getDescription().getVersion());
		console.sendMessage("");
		console.sendMessage(ChatColor.BLUE + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		console.sendMessage("");
		Bukkit.getPluginManager().registerEvents((Listener) this, (Plugin) this);
	}

	boolean isInteger(final String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent event) {
		if (this.getConfig().getBoolean("Title On Join")) {
			sendTitle(event.getPlayer(), 20, 50, 20, this.getConfig().getString("Title Message"),
					this.getConfig().getString("Subtitle Message"));
		}
		if (this.getConfig().getBoolean("Tab Header Enabled")) {
			sendTabTitle(event.getPlayer(), this.getConfig().getString("Tab Header Message"),
					this.getConfig().getString("Tab Footer Message"));
		}
	}

	public void onDisable() {
		this.getLogger().info(String.valueOf(this.getDescription().getName()) + " has been disabled!");
	}
}
