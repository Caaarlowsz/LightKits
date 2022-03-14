package Eventos;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.github.caaarlowsz.lightmc.kitpvp.LightPvP;

public class Basico implements Listener {
	public Basico(final LightPvP main) {
	}

	public static void tirarArmadura(final Player p) {
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
	}

	public static void MensagemCooldown(final Player p) {
		p.sendMessage(String.valueOf(String.valueOf(LightPvP.prefix)) + " �6� �7Aguarde �6" + Cooldown.CoolDown(p)
				+ " �7Segundos Para Usar Novamente");
	}

	public static String getKit(final Player p) {
		return Habilidade.getAbility(p);
	}

	public static void darItem(final Player p, final Material mat, final int quantidade, final String nome,
			final int lugar) {
		final ItemStack item = new ItemStack(mat, quantidade);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		p.getInventory().setItem(lugar, item);
	}

	public static void darItemInv(final Inventory inv, final Material mat, final int quantidade, final int modo,
			final String nome, final int lugar) {
		final ItemStack item = new ItemStack(mat, quantidade, (short) modo);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		inv.setItem(lugar, item);
	}

	public static void darEfeito(final Player p, final PotionEffectType tipo, final int duracao, final int level) {
		p.addPotionEffect(new PotionEffect(tipo, 20 * duracao, level));
	}

	public static void tirarEfeitos(final Player p) {
		p.removePotionEffect(PotionEffectType.ABSORPTION);
		p.removePotionEffect(PotionEffectType.BLINDNESS);
		p.removePotionEffect(PotionEffectType.CONFUSION);
		p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
		p.removePotionEffect(PotionEffectType.FAST_DIGGING);
		p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
		p.removePotionEffect(PotionEffectType.HARM);
		p.removePotionEffect(PotionEffectType.HEAL);
		p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
		p.removePotionEffect(PotionEffectType.HUNGER);
		p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		p.removePotionEffect(PotionEffectType.INVISIBILITY);
		p.removePotionEffect(PotionEffectType.JUMP);
		p.removePotionEffect(PotionEffectType.NIGHT_VISION);
		p.removePotionEffect(PotionEffectType.POISON);
		p.removePotionEffect(PotionEffectType.REGENERATION);
		p.removePotionEffect(PotionEffectType.SATURATION);
		p.removePotionEffect(PotionEffectType.SLOW);
		p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
		p.removePotionEffect(PotionEffectType.SPEED);
		p.removePotionEffect(PotionEffectType.WATER_BREATHING);
		p.removePotionEffect(PotionEffectType.WEAKNESS);
		p.removePotionEffect(PotionEffectType.WITHER);
	}
}
