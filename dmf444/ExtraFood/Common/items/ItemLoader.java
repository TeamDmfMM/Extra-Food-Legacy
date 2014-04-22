package dmf444.ExtraFood.Common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import dmf444.ExtraFood.Core.lib.ItemLib;
import net.minecraft.item.Item;

public class ItemLoader {

	public static Item cheeseWheel;
	public static Item banana;
	
	
	public static boolean Register=false;
	public static void initiateItems() {
		cheeseWheel = new CheeseWheel(ItemLib.idCheeseWheel, 8, 0.6F, false).setUnlocalizedName(ItemLib.iCW);
		banana = new Banana(ItemLib.idBanana, 1, 0.8F, false).setUnlocalizedName(ItemLib.iBan);
		
		
		registerItems();
	}
	private static void registerItems() {
		if(!Register){
			GameRegistry.registerItem(cheeseWheel, ItemLib.iCW);
			GameRegistry.registerItem(banana, ItemLib.iBan);
		}
		Register=true;
	}
}
