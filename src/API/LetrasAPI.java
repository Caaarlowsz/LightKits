package API;

import java.util.*;
import org.bukkit.entity.*;

public class LetrasAPI
{
    public static ArrayList<Player> Jogando;
    public static ArrayList<Player> Admin;
    public static ArrayList<Player> Checando;
    public static ArrayList<Player> CooldownDica;
    public static ArrayList<Player> Spec;
    public static ArrayList<Player> Logado;
    public static ArrayList<Player> CooldownChat;
    public static ArrayList<Player> Monitor;
    
    static {
        LetrasAPI.Jogando = new ArrayList<Player>();
        LetrasAPI.Admin = new ArrayList<Player>();
        LetrasAPI.Checando = new ArrayList<Player>();
        LetrasAPI.CooldownDica = new ArrayList<Player>();
        LetrasAPI.Spec = new ArrayList<Player>();
        LetrasAPI.Logado = new ArrayList<Player>();
        LetrasAPI.CooldownChat = new ArrayList<Player>();
        LetrasAPI.Monitor = new ArrayList<Player>();
    }
    
    public static boolean ContemLetra(final String s) {
        final char[] c = s.toCharArray();
        boolean d = false;
        for (int i = 0; i < c.length; ++i) {
            if (!Character.isDigit(c[i])) {
                d = true;
                break;
            }
        }
        return d;
    }
}
