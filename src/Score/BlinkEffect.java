package Score;

public class BlinkEffect {
	
	private int i = 1;
	static String texto = "§b§lLight§f§lKits";
	public BlinkEffect(){
		
	}
	
	public void next(){
		if (i == 1){
			texto = "§f§lM§c§lYTHPVP";
		}
		if (i == 2){
			texto = "§c§lM§f§lY§c§lTHPVP";
		}
		if (i == 3){
			texto = "§c§lMY§f§lT§c§lHPVP";
		}
		if (i == 4){
			texto = "§c§lMYT§f§lH§c§lPVP";
		}
		if (i == 5){
			texto = "§c§lMYTH§f§lP§c§lVP";
		}
		if (i == 6){
			texto = "§c§lMYTHP§f§lV§c§lP";
		}
		if (i == 7){
			texto = "§c§lMYTHPV§f§lP";
		}
		if (i == 8){
			texto = "§c§lMYTH§f§lPVP";
		}
		if (i == 9){
			texto = "§f§lMYTH§c§lPVP";
		}
		if (i == 10){
			texto = "§b§lLight§f§lKits";
		}
		if (i == 11){
			texto = "§b§lLight§f§lKits";
		}
		if (i == 12){
			texto = "§c§lL§f§lI§c§lG§f§lH§c§lT§f§lK§c§lI";
		}
		if (i == 13){
			texto = "";
		}
		if (i == 14){
			texto = "§b§lLight§f§lKits";
		}
		if (i == 15){
			texto = "";
		}
		if (i == 16){
			texto = "§b§lLight§f§lKits";
		}
		if (i == 17){
			texto = "§b§lLight§f§lKits";
			i = 0;
		}
		i++;
		
		
	}
	public String getText(){
		return texto;
	}

}
