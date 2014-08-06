package dmf444.ExtraFood.Core.lib;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dmf444.ExtraFood.util.ConfigHandler;
import dmf444.ExtraFood.util.EFLog;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class ItemLib {
	static EntityPlayer entityplayer;



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
	public static String iLet = "Lettuce";
	public static String iULS = "RawLettuceSeeds";
	public static String iCLS = "CoatedLettuceSeeds";
	public static String iCP = "PastaWithSauce";
	public static String iMB = "meatballs";
	public static String iMBP = "pastaMeatballs";
	public static String iSushi = "Sushi";
	public static String iFP = "FishPieces";
	public static String iPKeb = "porkKebab";
	public static String iSKeb = "steakKebab";
	public static String iVKeb = "vealKebab";
	public static String iCho = "chocolate";
	
	//Sandwhiches
	public static String iSandCB = "BaconCheeseSandwhich";
	public static String iSandGC = "GrilledCheeseSandwhich";
	public static String iSandS = "SausageSandwhich";
	public static String iSandH = "HamburgerSandwhich";
	
	

	
	//Special ones
	public static String iFF(){
			if(ConfigHandler.FeelLikeAure){
				return "PotatoLava";
			}
			return "FrenchFries";
	}

}
