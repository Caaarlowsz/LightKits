package Manager;

import org.bukkit.entity.Player;

public class Grupos {
	public static String getGroupMax(final Player p) {
		if (p.hasPermission("tag.dono")) {
			return "§4§lDONO";
		}
		if (p.hasPermission("tag.gerente")) {
			return "§3§lGERENTE";
		}
		if (p.hasPermission("tag.admin")) {
			return "§c§lADMIN";
		}
		if (p.hasPermission("tag.mod")) {
			return "§5§lMOD";
		}
		if (p.hasPermission("tag.trial")) {
			return "§d§lTRIAL";
		}
		if (p.hasPermission("tag.builder")) {
			return "§e§lBUILDER";
		}
		if (p.hasPermission("tag.ajudante")) {
			return "§b§lAJUDANTE";
		}
		if (p.hasPermission("tag.youtuber")) {
			return "§b§lYT";
		}
		if (p.hasPermission("tag.coder")) {
			return "§3§lPROGRAMADOR";
		}
		if (p.hasPermission("tag.pro")) {
			return "§6§lPRO";
		}
		if (p.hasPermission("tag.mvp")) {
			return "§b§lMVP";
		}
		if (p.hasPermission("tag.vip")) {
			return "§a§lVIP";
		}
		return "§7Membro";
	}

	public static String getGroupMin(final Player p) {
		if (p.hasPermission("tag.dono")) {
			return "§4Dono";
		}
		if (p.hasPermission("tag.gerente")) {
			return "§3Gerente";
		}
		if (p.hasPermission("tag.admin")) {
			return "§cAdministrador";
		}
		if (p.hasPermission("tag.mod")) {
			return "§5Moderador";
		}
		if (p.hasPermission("tag.trial")) {
			return "§dTrialMod";
		}
		if (p.hasPermission("tag.builder")) {
			return "§eBuilder";
		}
		if (p.hasPermission("tag.ajudante")) {
			return "§9§oAjudante";
		}
		if (p.hasPermission("tag.youtuber")) {
			return "§bYoutuber";
		}
		if (p.hasPermission("tag.coder")) {
			return "§3Progamador";
		}
		if (p.hasPermission("tag.pro")) {
			return "§6Pro";
		}
		if (p.hasPermission("tag.mvp")) {
			return "§9Mvp";
		}
		if (p.hasPermission("tag.vip")) {
			return "§aVip";
		}
		return "§7Membro";
	}
}
