package Utils;

import org.bukkit.Location;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import Main.Main;

public class Raios implements Listener {
	public static double cos(final double i) {
		return Math.cos(i);
	}

	public static double sin(final double i) {
		return Math.sin(i);
	}

	public static void coneEffect(final Location loc) {
		new BukkitRunnable() {
			double phi = 0.0;

			public void run() {
				this.phi += 0.39269908169872414;
				for (double t = 0.0; t <= 6.283185307179586; t += 0.19634954084936207) {
					for (double i = 0.0; i <= 1.0; ++i) {
						final double x = 0.4 * (6.283185307179586 - t) * 0.5
								* Raios.cos(t + this.phi + i * 3.141592653589793);
						final double y = 0.5 * t;
						final double z = 0.4 * (6.283185307179586 - t) * 0.5
								* Raios.sin(t + this.phi + i * 3.141592653589793);
						loc.add(x, y, z);
						loc.subtract(x, y, z);
					}
				}
				if (this.phi > 31.41592653589793) {
					this.cancel();
				}
			}
		}.runTaskTimer((Plugin) Main.instance, 0L, 3L);
	}

	public static void kitaguala(final Location loc) {
		new BukkitRunnable() {
			double phi = 0.0;

			public void run() {
				this.phi += 0.3141592653589793;
				for (double t = 0.0; t <= 15.707963267948966; t += 0.07853981633974483) {
					final double x = 1.2 * Raios.cos(t) * Raios.sin(this.phi);
					final double y = 1.2 * Raios.cos(this.phi) + 1.2;
					final double z = 1.2 * Raios.sin(t) * Raios.sin(this.phi);
					loc.add(x, y, z);
					loc.subtract(x, y, z);
				}
				if (this.phi > 3.141592653589793) {
					this.cancel();
				}
			}
		}.runTaskTimer((Plugin) Main.instance, 0L, 1L);
	}

	public static void FireBender(final Location loc) {
		new BukkitRunnable() {
			double phi = 0.0;

			public void run() {
				this.phi += 0.3141592653589793;
				for (double t = 0.0; t <= 15.707963267948966; t += 0.07853981633974483) {
					final double x = 1.2 * Raios.cos(t) * Raios.sin(this.phi);
					final double y = 1.2 * Raios.cos(this.phi) + 1.2;
					final double z = 1.2 * Raios.sin(t) * Raios.sin(this.phi);
					loc.add(x, y, z);
					loc.subtract(x, y, z);
				}
				if (this.phi > 3.141592653589793) {
					this.cancel();
				}
			}
		}.runTaskTimer((Plugin) Main.instance, 0L, 1L);
	}
}
