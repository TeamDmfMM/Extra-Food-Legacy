package dmf444.ExtraFood.Core.lib;

import dmf444.ExtraFood.util.ConfigHandler;
import dmf444.ExtraFood.util.EFLog;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class ItemLib {
	static EntityPlayer entityplayer;
	private static Object getName = Minecraft.getMinecraft().getSession().getUsername();


	public static String iCW = "Cheese_Wheel";
	public static String iBan = "Banana";
	public static String iK = "Knife";
	public static String iCS = "Cheese_Slice";
	public static String iCB = "Cookbook";
	public static String iS = "Sausage";
	public static String iST = "Strawberry";
	public static String iBS = "BucketStrawberry";
	public static String iBB = "BucketBanana";
	public static String iBac = "Bacon";
	public static String iBC = "BucketCarrot";
	public static String iV = "Veal";
	public static String iCBac = "CookedBacon";
	public static String iBRS = "BreadSlice";
	public static String iToastS = "Toast";
	public static String iBSW = "BucketSeaWater";
	public static String iBPW = "BucketPurifiedWater";
	public static String iEgg = "Egg";
	public static String iPasta = "Pasta";
	public static String iRH = "RawHamburger";
	public static String iCH = "CookedHamburger";
	public static String iP = "Peanut";
	public static String iTom = "Tomato";
	public static String iTS = "TomatoSeeds";
	
	//Sandwhiches
	public static String iSandCB = "BaconCheeseSandwhich";
	public static String iSandGC = "GrilledCheeseSandwhich";
	public static String iSandS = "SausageSandwhich";
	public static String iSandH = "HamburgerSandwhich";
	
	
	
	
	//Special ones
	public static String iFF(){
		if(getName.equals("dmf444") || getName.equals("matto9193") || getName.equals("Aureylian") || ConfigHandler.FeelLikeAure){
			return "PotatoLava";
		}
		return "FrenchFries";
	}
}
