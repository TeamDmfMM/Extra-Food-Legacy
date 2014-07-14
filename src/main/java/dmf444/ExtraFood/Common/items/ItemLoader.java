package dmf444.ExtraFood.Common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import dmf444.ExtraFood.Core.lib.ItemLib;

import net.minecraft.item.Item;

public class ItemLoader {

	public static Item cheeseWheel;
	public static Item banana;
	public static Item knife;
	public static Item cheeseSlice;
	public static Item cookBook;
	public static Item sausage;
	public static Item strawberry;
	
	
	private static boolean IRegister=false;
	private static boolean FRegister=false;
	
	public static void initiateItems() {

		knife = new Knife().setUnlocalizedName(ItemLib.iK);	
		cookBook = new Cookbook().setUnlocalizedName(ItemLib.iCB);

		
		
		
		registerItems();
	}
	public static void initiateFoods(){
		sausage = new Sausage().setUnlocalizedName(ItemLib.iS);
		cheeseSlice = new CheeseSlice().setUnlocalizedName(ItemLib.iCS);
		cheeseWheel = new CheeseWheel(8, 0.6F, false).setUnlocalizedName(ItemLib.iCW);
		banana = new Banana(1, 0.8F, false).setUnlocalizedName(ItemLib.iBan);
		strawberry = new Strawberry(1, 0.6F, false).setUnlocalizedName(ItemLib.iST);
		
		
		
		registerFood();
	}
	private static void registerItems() {
		if(!IRegister){
			
			GameRegistry.registerItem(knife, ItemLib.iK);
			GameRegistry.registerItem(cookBook, ItemLib.iCB);

		}
		IRegister=true;
	}
	
	private static void registerFood() {
		if(!FRegister){
			GameRegistry.registerItem(cheeseWheel, ItemLib.iCW);
			GameRegistry.registerItem(banana, ItemLib.iBan);
			GameRegistry.registerItem(cheeseSlice, ItemLib.iCS);
			GameRegistry.registerItem(sausage, ItemLib.iS);
			GameRegistry.registerItem(strawberry, ItemLib.iST);
		}
		FRegister=true;
	}
}
