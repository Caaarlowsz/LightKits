package API;

import org.bukkit.entity.Player;

public class TextConverter {
	public static String convert(final String text) {
		if (text == null || text.length() == 0) {
			return "\"\"";
		}
		final int len = text.length();
		final StringBuilder sb = new StringBuilder(len + 4);
		sb.append('\"');
		for (int i = 0; i < len; ++i) {
			final char c = text.charAt(i);
			switch (c) {
			case '\"':
			case '\\': {
				sb.append('\\');
				sb.append(c);
				break;
			}
			case '/': {
				sb.append('\\');
				sb.append(c);
				break;
			}
			case '\b': {
				sb.append("\\b");
				break;
			}
			case '\t': {
				sb.append("\\t");
				break;
			}
			case '\n': {
				sb.append("\\n");
				break;
			}
			case '\f': {
				sb.append("\\f");
				break;
			}
			case '\r': {
				sb.append("\\r");
				break;
			}
			default: {
				if (c < ' ') {
					final String t = "000" + Integer.toHexString(c);
					sb.append("\\u" + t.substring(t.length() - 4));
					break;
				}
				sb.append(c);
				break;
			}
			}
		}
		sb.append('\"');
		return sb.toString();
	}

	public static String setPlayerName(final Player player, final String text) {
		return text.replaceAll("(?i)\\{PLAYER\\}", player.getName());
	}
}
