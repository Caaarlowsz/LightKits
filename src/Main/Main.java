package Main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import Coins.DarXp;
import Coins.MyConfigManager;
import Coins.VerXp;
import Coins.XpM;
import Comandos.AccountCommand;
import Comandos.AddPermissionCommand;
import Comandos.AdminCommand;
import Comandos.AplicarCommand;
import Comandos.ArenaCommand;
import Comandos.AutoSoupCommand;
import Comandos.BroadcastCommand;
import Comandos.BuildCommand;
import Comandos.CCCommand;
import Comandos.ChatCommand;
import Comandos.ChecarCommand;
import Comandos.DeathCommand;
import Comandos.DonoCommand;
import Comandos.FlyCommand;
import Comandos.GamemodeCommand;
import Comandos.HeadCommand;
import Comandos.HelpCommand;
import Comandos.IPCommand;
import Comandos.InvCommand;
import Comandos.KitsCommand;
import Comandos.OnlinesCommand;
import Comandos.PingCommand;
import Comandos.PvPCommand;
import Comandos.RankCommand;
import Comandos.RegrasCommand;
import Comandos.ReportCommand;
import Comandos.SCCommand;
import Comandos.ScoreCommand;
import Comandos.SetArenaCommand;
import Comandos.Skit;
import Comandos.TagCommand;
import Comandos.TellCommand;
import Comandos.TpCommand;
import Comandos.TpallCommand;
import Comandos.VCommand;
import Comandos.YTCommand;
import Eventos.AllEvent;
import Eventos.AntSpam;
import Eventos.BrokenEvent;
import Eventos.Bussola;
import Eventos.ChatEvent;
import Eventos.Comum;
import Eventos.CustomTab;
import Eventos.EventPlayers;
import Eventos.NerfsEvent;
import Eventos.PluginsEvent;
import Eventos.SoupEvent;
import Jumps.DiamondJump;
import Jumps.EmeraldJump;
import Jumps.IronJump;
import Jumps.RedstoneJump;
import Kits.Ajnin;
import Kits.Anchor;
import Kits.Armor;
import Kits.Avatar;
import Kits.Barbarian;
import Kits.Boxer;
import Kits.C4;
import Kits.DeshFire;
import Kits.DubleJump;
import Kits.FireBender;
import Kits.Fisherman;
import Kits.Gladiator;
import Kits.Hulk;
import Kits.JellyFish;
import Kits.Kangaroo;
import Kits.Magma;
import Kits.Monk;
import Kits.Ninja;
import Kits.Phantom;
import Kits.Poseidon;
import Kits.Resouper;
import Kits.Snail;
import Kits.Sonic;
import Kits.Stomper;
import Kits.Switcher;
import Kits.Swords;
import Kits.Terrorista;
import Kits.TheForceField;
import Kits.TheIronMan;
import Kits.Thor;
import Kits.Thresh;
import Kits.Trader;
import Kits.Turtle;
import Kits.Velotrol;
import Kits.Viking;
import Kits.Viper;
import Kits.WaterBender;
import Menus.EventosInventory;
import Menus.ExtrasInventory;
import Menus.KitsInventory;
import Menus.KitsInventory2;
import Menus.LojaInventory;
import Menus.LojaKitsInventory;
import Menus.LojaPermsInventory;
import Menus.StatusInventory;
import Menus.WarpsInventory;
import Outros.MotdOther;
import Outros.RecraftsignOther;
import Outros.SoupsignOther;
import Score.ScoreBoarding;
import Score.Scroller;
import Utils.CombatLog;
import Warps.Fps;
import Warps.Knock;
import Warps.Lava;
import Warps.Mdr;
import Warps.Parkour;
import Warps.SetFps;
import Warps.SetKnock;
import Warps.SetLava;
import Warps.SetMdr;
import Warps.SetParkour;
import Warps.SetSpawn;
import Warps.SetTextura;
import Warps.SetarRdm;
import Warps.Setthemain;
import Warps.Spawn;
import Warps.Textura;
import Warps.TheMain;
import Warps.WarpRdm;

public class Main extends JavaPlugin {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<String> score = new ArrayList();
	public static MyConfigManager manager;
	public static Scroller sc;
	public static Plugin plugin;
	public static Main instance;
	public static String prefix;
	public static String motd;
	public static String motd2;
	public static String ipsv;
	public static String site;
	public static String aplicar;
	public static String donos;
	public File stats1;
	public YamlConfiguration stats;
	public File warps1;
	public YamlConfiguration warps;
	public File loja1;
	public YamlConfiguration loja;
	public File arenas1;
	public YamlConfiguration arenas;

	public static Main getInstace() {
		return Main.instance;
	}

	public static Plugin getPlugin() {
		return Main.plugin;
	}

	public void onEnable() {
		manager = new MyConfigManager(this);
		XpM.loadMoneyManager();
		Main.manager = new MyConfigManager(this);
		Main.plugin = (Plugin) this;
		(Main.instance = this).saveConfig();
		(Main.instance = this).saveDefaultConfig();
		final File stats = new File(this.getDataFolder(), "stats.yml");
		if (!stats.exists()) {
			this.saveResource("stats.yml", false);
		}
		this.stats1 = new File(this.getDataFolder(), "stats.yml");
		this.stats = YamlConfiguration.loadConfiguration(this.stats1);
		final File warps = new File(this.getDataFolder(), "warps.yml");
		if (!warps.exists()) {
			this.saveResource("warps.yml", false);
		}
		this.warps1 = new File(this.getDataFolder(), "warps.yml");
		this.warps = YamlConfiguration.loadConfiguration(this.warps1);
		Main.ipsv = this.getConfig().getString("ip_do_sv").replace("&", "§");
		Main.site = this.getConfig().getString("Site").replace("&", "§");
		Main.prefix = this.getConfig().getString("Prefix").replace("&", "§");
		Main.donos = this.getConfig().getString("Dono").replace("&", "§");
		Main.aplicar = this.getConfig().getString("Formulario").replace("&", "§");
		Main.motd = this.getConfig().getString("Motd").replace("&", "§");
		Main.motd2 = this.getConfig().getString("Motd_Manutencao").replace("&", "§");
		new BukkitRunnable() {
			public void run() {
				Player[] arrayOfPlayer;
				int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
				for (int i = 0; i < j; i++) {
					Player p = arrayOfPlayer[i];
					if (!Main.score.contains(p.getName()))
						ScoreBoarding.setScoreBoard(p);
					else {
						ScoreBoarding.removeScoreBoard(p);
					}
				}
			}
		}.runTaskTimer(this, 0L, 20L);
		this.RegisterEvents();
		Comandos();
		manager = new MyConfigManager(this);
		Bukkit.getConsoleSender().sendMessage("§6Plugin §eKitPvP §6Ativado!");
	}

	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("§6Plugin §eKitPvP §6Desativado!");
	}

	public void onLoad() {
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player todos = onlinePlayers[i];
			final ArrayList<String> msg = new ArrayList<>();
			msg.add(" §4§lAVISO ");
			msg.add("§cServidor Reiniciando Voltamos Em Instantes Aguarde§7 ");
			todos.kickPlayer(String.valueOf(msg));
		}
	}

	public void RegisterEvents() {
		final PluginManager Eventos = Bukkit.getPluginManager();
		Eventos.registerEvents((Listener) new LojaInventory(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Bussola(), (Plugin) this);
		Eventos.registerEvents((Listener) new CombatLog(), (Plugin) this);
		Eventos.registerEvents((Listener) new EventosInventory(), (Plugin) this);
		Eventos.registerEvents((Listener) new MyConfigManager(this), (Plugin) this);
		Eventos.registerEvents((Listener) new EventPlayers(), (Plugin) this);
		Eventos.registerEvents((Listener) new Comum(this), (Plugin) this);
		Eventos.registerEvents((Listener) new AntSpam(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Fps(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Lava(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Mdr(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Parkour(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Spawn(this), (Plugin) this);
		Eventos.registerEvents((Listener) new WarpRdm(this), (Plugin) this);
		Eventos.registerEvents((Listener) new SetTextura(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Textura(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Knock(this), (Plugin) this);
		Eventos.registerEvents((Listener) new SetKnock(this), (Plugin) this);
		Eventos.registerEvents((Listener) new SetarRdm(this), (Plugin) this);
		Eventos.registerEvents((Listener) new SetFps(this), (Plugin) this);
		Eventos.registerEvents((Listener) new SetLava(this), (Plugin) this);
		Eventos.registerEvents((Listener) new SetMdr(this), (Plugin) this);
		Eventos.registerEvents((Listener) new SetParkour(this), (Plugin) this);
		Eventos.registerEvents((Listener) new SetSpawn(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Setthemain(this), (Plugin) this);
		Eventos.registerEvents((Listener) new SCCommand(), (Plugin) this);
		Eventos.registerEvents((Listener) new PluginsEvent(), (Plugin) this);
		Eventos.registerEvents((Listener) new WarpsInventory(), (Plugin) this);
		Eventos.registerEvents((Listener) new TagCommand(this), (Plugin) this);
		Eventos.registerEvents((Listener) new ExtrasInventory(this), (Plugin) this);
		Eventos.registerEvents((Listener) new LojaPermsInventory(this), (Plugin) this);
		Eventos.registerEvents((Listener) new BrokenEvent(), (Plugin) this);
		Eventos.registerEvents((Listener) new MotdOther(), (Plugin) this);
		Eventos.registerEvents((Listener) new DiamondJump(getInstace()), (Plugin) this);
		Eventos.registerEvents((Listener) new RedstoneJump(getInstace()), (Plugin) this);
		Eventos.registerEvents((Listener) new EmeraldJump(getInstace()), (Plugin) this);
		Eventos.registerEvents((Listener) new IronJump(getInstace()), (Plugin) this);
		Eventos.registerEvents((Listener) new BuildCommand(), (Plugin) this);
		Eventos.registerEvents((Listener) new AdminCommand(this), (Plugin) this);
		Eventos.registerEvents((Listener) new SoupsignOther(), (Plugin) this);
		Eventos.registerEvents((Listener) new RecraftsignOther(), (Plugin) this);
		Eventos.registerEvents((Listener) new AllEvent(), (Plugin) this);
		Eventos.registerEvents((Listener) new SoupEvent(), (Plugin) this);
		Eventos.registerEvents((Listener) new Turtle(), (Plugin) this);
		Eventos.registerEvents((Listener) new Hulk(), (Plugin) this);
		Eventos.registerEvents((Listener) new NerfsEvent(), (Plugin) this);
		Eventos.registerEvents((Listener) new ChatEvent(), (Plugin) this);
		Eventos.registerEvents((Listener) new KitsInventory(this), (Plugin) this);
		Eventos.registerEvents((Listener) new KitsInventory2(this), (Plugin) this);
		Eventos.registerEvents((Listener) new StatusInventory(), (Plugin) this);
		Eventos.registerEvents((Listener) new Viking(), (Plugin) this);
		Eventos.registerEvents((Listener) new Boxer(), (Plugin) this);
		Eventos.registerEvents((Listener) new YTCommand(), (Plugin) this);
		Eventos.registerEvents((Listener) new SetArenaCommand(this), (Plugin) this);
		Eventos.registerEvents((Listener) new ChatCommand(), (Plugin) this);
		Eventos.registerEvents((Listener) new Stomper(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Ninja(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Fisherman(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Ajnin(), (Plugin) this);
		Eventos.registerEvents((Listener) new Kangaroo(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Hulk(), (Plugin) this);
		Eventos.registerEvents((Listener) new Thor(), (Plugin) this);
		Eventos.registerEvents((Listener) new Anchor(), (Plugin) this);
		Eventos.registerEvents((Listener) new DubleJump(), (Plugin) this);
		Eventos.registerEvents((Listener) new Phantom(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Monk(), (Plugin) this);
		Eventos.registerEvents((Listener) new Gladiator(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Thresh(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Velotrol(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Viper(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Snail(this), (Plugin) this);
		Eventos.registerEvents((Listener) new TheIronMan(), (Plugin) this);
		Eventos.registerEvents((Listener) new TheForceField(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Terrorista(), (Plugin) this);
		Eventos.registerEvents((Listener) new Trader(), (Plugin) this);
		Eventos.registerEvents((Listener) new Armor(), (Plugin) this);
		Eventos.registerEvents((Listener) new JellyFish(), (Plugin) this);
		Eventos.registerEvents((Listener) new Magma(), (Plugin) this);
		Eventos.registerEvents((Listener) new Resouper(), (Plugin) this);
		Eventos.registerEvents((Listener) new Barbarian(), (Plugin) this);
		Eventos.registerEvents((Listener) new DeshFire(this), (Plugin) this);
		Eventos.registerEvents((Listener) new FireBender(this), (Plugin) this);
		Eventos.registerEvents((Listener) new WaterBender(), (Plugin) this);
		Eventos.registerEvents((Listener) new Swords(), (Plugin) this);
		Eventos.registerEvents((Listener) new Sonic(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Turtle(), (Plugin) this);
		Eventos.registerEvents((Listener) new C4(), (Plugin) this);
		Eventos.registerEvents((Listener) new Poseidon(), (Plugin) this);
		Eventos.registerEvents((Listener) new Avatar(), (Plugin) this);
		Eventos.registerEvents((Listener) new Switcher(), (Plugin) this);
		Eventos.registerEvents((Listener) new Viking(), (Plugin) this);
		Eventos.registerEvents((Listener) new Boxer(), (Plugin) this);
		Eventos.registerEvents((Listener) new ScoreCommand(), (Plugin) this);
		Eventos.registerEvents(new MyConfigManager(this), this);
		Eventos.registerEvents(new VerXp(), this);
		Eventos.registerEvents(new XpM(), this);
		Eventos.registerEvents(new LojaKitsInventory(this), this);
		Eventos.registerEvents(new CustomTab(), this);
	}

	public void Comandos() {
		this.getCommand("lojakits").setExecutor(new LojaKitsInventory(this));
		this.getCommand("darmoedas").setExecutor(new DarXp());
		this.getCommand("score").setExecutor(new ScoreCommand());
		this.getCommand("dano").setExecutor((CommandExecutor) new PvPCommand());
		this.getCommand("v").setExecutor((CommandExecutor) new VCommand());
		this.getCommand("themain").setExecutor((CommandExecutor) new TheMain(this));
		this.getCommand("autosoup").setExecutor((CommandExecutor) new AutoSoupCommand());
		this.getCommand("events").setExecutor((CommandExecutor) new EventosInventory());
		this.getCommand("lojaperms").setExecutor((CommandExecutor) new LojaPermsInventory(this));
		this.getCommand("setknock").setExecutor((CommandExecutor) new SetKnock(this));
		this.getCommand("knock").setExecutor((CommandExecutor) new Knock(this));
		this.getCommand("settextura").setExecutor((CommandExecutor) new SetTextura(this));
		this.getCommand("textura").setExecutor((CommandExecutor) new Textura(this));
		this.getCommand("fly").setExecutor((CommandExecutor) new FlyCommand());
		this.getCommand("checar").setExecutor((CommandExecutor) new ChecarCommand(this));
		this.getCommand("status").setExecutor((CommandExecutor) new StatusInventory());
		this.getCommand("loja").setExecutor((CommandExecutor) new LojaInventory(this));
		this.getCommand("dono").setExecutor((CommandExecutor) new DonoCommand());
		this.getCommand("aplicar").setExecutor((CommandExecutor) new AplicarCommand());
		this.getCommand("ranks").setExecutor((CommandExecutor) new RankCommand());
		this.getCommand("online").setExecutor((CommandExecutor) new OnlinesCommand());
		this.getCommand("mdr").setExecutor((CommandExecutor) new Mdr(this));
		this.getCommand("setmdr").setExecutor((CommandExecutor) new SetMdr(this));
		this.getCommand("setrdm").setExecutor((CommandExecutor) new SetarRdm(this));
		this.getCommand("rdm").setExecutor((CommandExecutor) new WarpRdm(this));
		this.getCommand("setparkour").setExecutor((CommandExecutor) new SetParkour(this));
		this.getCommand("parkour").setExecutor((CommandExecutor) new Parkour(this));
		this.getCommand("skit").setExecutor((CommandExecutor) new Skit());
		this.getCommand("moedas").setExecutor((CommandExecutor) new VerXp());
		this.getCommand("ping").setExecutor((CommandExecutor) new PingCommand());
		this.getCommand("head").setExecutor((CommandExecutor) new HeadCommand());
		this.getCommand("inv").setExecutor((CommandExecutor) new InvCommand());
		this.getCommand("fps").setExecutor((CommandExecutor) new Fps(this));
		this.getCommand("setfps").setExecutor((CommandExecutor) new SetFps(this));
		this.getCommand("gm").setExecutor((CommandExecutor) new GamemodeCommand());
		this.getCommand("challenge").setExecutor((CommandExecutor) new Lava(this));
		this.getCommand("setchallenge").setExecutor((CommandExecutor) new SetLava(this));
		this.getCommand("help").setExecutor((CommandExecutor) new HelpCommand());
		this.getCommand("setmain").setExecutor((CommandExecutor) new Setthemain(this));
		this.getCommand("setspawn").setExecutor((CommandExecutor) new SetSpawn(this));
		this.getCommand("spawn").setExecutor((CommandExecutor) new Spawn(this));
		this.getCommand("ip").setExecutor((CommandExecutor) new IPCommand());
		this.getCommand("extras").setExecutor((CommandExecutor) new ExtrasInventory(this));
		this.getCommand("tell").setExecutor((CommandExecutor) new TellCommand());
		this.getCommand("tpall").setExecutor((CommandExecutor) new TpallCommand());
		this.getCommand("warps").setExecutor((CommandExecutor) new WarpsInventory());
		this.getCommand("spawn").setExecutor((CommandExecutor) new Spawn(this));
		this.getCommand("tags").setExecutor((CommandExecutor) new TagCommand(this));
		this.getCommand("tag").setExecutor((CommandExecutor) new TagCommand(this));
		this.getCommand("bc").setExecutor((CommandExecutor) new BroadcastCommand());
		this.getCommand("sc").setExecutor((CommandExecutor) new SCCommand());
		this.getCommand("youtuber").setExecutor((CommandExecutor) new YTCommand());
		this.getCommand("tp").setExecutor((CommandExecutor) new TpCommand());
		this.getCommand("jail").setExecutor((CommandExecutor) new ArenaCommand());
		this.getCommand("morrer").setExecutor((CommandExecutor) new DeathCommand());
		this.getCommand("setarena").setExecutor((CommandExecutor) new SetArenaCommand(this));
		this.getCommand("build").setExecutor((CommandExecutor) new BuildCommand());
		this.getCommand("admin").setExecutor((CommandExecutor) new AdminCommand(this));
		this.getCommand("kit").setExecutor((CommandExecutor) new KitsCommand(this));
		this.getCommand("kits").setExecutor((CommandExecutor) new KitsInventory(this));
		this.getCommand("kits2").setExecutor((CommandExecutor) new KitsInventory2(this));
		this.getCommand("clearchat").setExecutor((CommandExecutor) new CCCommand());
		this.getCommand("report").setExecutor((CommandExecutor) new ReportCommand(getInstace()));
		this.getCommand("account").setExecutor((CommandExecutor) new AccountCommand());
		this.getCommand("addpermission").setExecutor((CommandExecutor) new AddPermissionCommand());
		this.getCommand("chat").setExecutor((CommandExecutor) new ChatCommand());
		this.getCommand("regras").setExecutor((CommandExecutor) new RegrasCommand());
	}

	public void save() {
		try {
			this.stats.save(this.stats1);
			this.warps.save(this.warps1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
