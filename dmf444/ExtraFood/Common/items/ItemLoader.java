package dmf444.ExtraFood.Common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import dmf444.ExtraFood.Core.lib.ItemLib;
import net.minecraft.item.Item;

public class ItemLoader {

	public static Item cheeseWheel;
	
	
	public static boolean Register=false;
	public static void initiateItems() {
		cheeseWheel = new CheeseWheel(ItemLib.idCheeseWheel, 8, 0.6F, false).setUnlocalizedName(ItemLib.iCW);
		
		
		registerItems();
	}
	private static void registerItems() {
		if(!Register){
			GameRegistry.registerItem(cheeseWheel, ItemLib.iCW);
		}
		Register=true;
	}
}
