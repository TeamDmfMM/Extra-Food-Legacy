package dmf444.ExtraFood.Common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import dmf444.ExtraFood.Core.lib.ItemLib;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class ItemLoader {

	public static Item cheeseWheel;
	public static Item banana;
	public static Item knife;
	public static Item cheeseSlice;
	public static Item cookBook;
	public static Item sausage;
	public static Item strawberry;
	public static Item bucketstrawberry;
	public static Item bucketbanana;
	public static Item bucketcarrot;
	public static Item bacon;
	
	
	private static boolean IRegister=false;
	private static boolean FRegister=false;

	
	public static void initiateItems() {

		knife = new Knife().setUnlocalizedName(ItemLib.iK);	
		cookBook = new Cookbook().setUnlocalizedName(ItemLib.iCB);
		bucketstrawberry = new BucketStrawberry(2, 0.3F);
		bucketbanana = new BucketBanana();
		bucketcarrot = new BucketCarrot();


		
		
		
		registerItems();
	}
	public static void initiateFoods(){
		sausage = new Sausage().setUnlocalizedName(ItemLib.iS);
		cheeseSlice = new CheeseSlice().setUnlocalizedName(ItemLib.iCS);
		cheeseWheel = new CheeseWheel(8, 0.6F, false).setUnlocalizedName(ItemLib.iCW);
		banana = new Banana(1, 0.8F, false).setUnlocalizedName(ItemLib.iBan);
		strawberry = new Strawberry(1, 0.6F, false).setUnlocalizedName(ItemLib.iST);
		bacon = new StanFood(1, 0.6F, false).setUnlocalizedName(ItemLib.iBac);
		
		
		
		registerFood();
	}
	private static void registerItems() {
		if(!IRegister){
			
			GameRegistry.registerItem(knife, ItemLib.iK);
			GameRegistry.registerItem(cookBook, ItemLib.iCB);
			GameRegistry.registerItem(bucketstrawberry, ItemLib.iBS);
			GameRegistry.registerItem(bucketbanana, ItemLib.iBB);
			GameRegistry.registerItem(bucketcarrot, ItemLib.iBC);


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
			GameRegistry.registerItem(bacon, ItemLib.iBac);
		}
		FRegister=true;
	}
}
