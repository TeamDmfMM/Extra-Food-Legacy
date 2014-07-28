package dmf444.ExtraFood.Common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Core.EFTabs;
import dmf444.ExtraFood.Core.lib.ItemLib;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ItemLoader {

	public static Item cheeseWheel;
	public static Item banana;
	public static Item knife;
	public static Item cheeseSlice;
	public static Item cookBook;
	public static Item sausage;
	public static Item strawberry, peanut;
	public static Item bucketstrawberry;
	public static Item bucketbanana;
	public static Item bucketcarrot;
	public static Item bacon;
	public static Item cookedBacon;
	public static Item veal;
	public static Item toast;
	public static Item slicedBread;
	public static Item bucketseaWater;
	public static Item bucketpurifiedwater;
	public static Item frenchFries;
	public static Item egg;
	public static Item rawpasta;
	public static Item sandwhichCB;
	public static Item sandwhichGC;
	public static Item sandwhichS;
	public static Item rawHamburger, cookedHamburger;
	public static Item sandwhichHamburger;
	public static Item tomato;
	public static ItemSeeds tomatoSeeds;
	
	private static boolean IRegister=false;
	private static boolean FRegister=false;
	
	


	
	public static void initiateItems() {

		knife = new Knife().setUnlocalizedName(ItemLib.iK);	
		cookBook = new Cookbook().setUnlocalizedName(ItemLib.iCB);
		bucketstrawberry = new BucketStrawberry(2, 0.3F);
		bucketbanana = new BucketBanana(2, 0.4F);
		bucketcarrot = new BucketCarrot(2, 0.6F);
		bucketseaWater = new BucketSeaWater(2, 0.1F);
		bucketpurifiedwater = new BucketPurifiedWater(3, 0.3F);
		tomatoSeeds = (ItemSeeds) new ItemSeeds(BlockLoader.tomatoCrop, Blocks.farmland).setUnlocalizedName(ItemLib.iTS).setTextureName("extrafood:tomatoSeeds").setCreativeTab(EFTabs.INSTANCE);

		
		
		
		registerItems();
	}
	public static void initiateFoods(){
		sausage = new StanFood(3, 0.5F).setUnlocalizedName(ItemLib.iS);
		cheeseSlice = new CheeseSlice().setUnlocalizedName(ItemLib.iCS);
		cheeseWheel = new CheeseWheel(8, 0.6F, false).setUnlocalizedName(ItemLib.iCW);
		banana = new Banana(1, 0.8F, false).setUnlocalizedName(ItemLib.iBan);
		strawberry = new Strawberry(1, 0.6F, false).setUnlocalizedName(ItemLib.iST);
		bacon = new StanFood(1, 0.6F).setUnlocalizedName(ItemLib.iBac);
		veal = new StanFood(1, 0.6F, true).setUnlocalizedName(ItemLib.iV);
		cookedBacon = new StanFood(1, 0.6F).setUnlocalizedName(ItemLib.iCBac);
		toast = new StanFood(1, 0.8F).setUnlocalizedName(ItemLib.iToastS);
		slicedBread = new StanFood(1, 0.2F).setUnlocalizedName(ItemLib.iBRS);
		frenchFries = new StanFood(2, 0.5F).setUnlocalizedName(ItemLib.iFF());
		egg = new StanFood(3, 0.8F).setUnlocalizedName(ItemLib.iEgg);
		rawpasta = new StanFood(2, 0.3F).setUnlocalizedName(ItemLib.iPasta);
		sandwhichS = new StanFood(7, 1.0F).setUnlocalizedName(ItemLib.iSandS);
		sandwhichCB = new StanFood(6, 1.4F).setUnlocalizedName(ItemLib.iSandCB);
		sandwhichGC = new StanFood(3, 0.9F).setUnlocalizedName(ItemLib.iSandGC);
		rawHamburger = new StanFood(4, 0.6F).setUnlocalizedName(ItemLib.iRH);
		cookedHamburger = new StanFood(7, 1.6F).setUnlocalizedName(ItemLib.iCH);
		sandwhichHamburger = new StanFood(9, 1.0F).setUnlocalizedName(ItemLib.iSandH);
		peanut = ((ItemFood) new StanFood(1, 0.2F).setUnlocalizedName(ItemLib.iP)).setAlwaysEdible();
		tomato = new StanFood(4, 0.5F).setUnlocalizedName(ItemLib.iTom);
		
		registerFood();
	}
	private static void registerItems() {
		if(!IRegister){
			
			GameRegistry.registerItem(knife, ItemLib.iK);
			GameRegistry.registerItem(cookBook, ItemLib.iCB);
			GameRegistry.registerItem(tomatoSeeds, ItemLib.iTS);
			GameRegistry.registerItem(bucketstrawberry, ItemLib.iBS);
			GameRegistry.registerItem(bucketbanana, ItemLib.iBB);
			GameRegistry.registerItem(bucketcarrot, ItemLib.iBC);
			GameRegistry.registerItem(bucketseaWater, ItemLib.iBSW);
			GameRegistry.registerItem(bucketpurifiedwater, ItemLib.iBPW);
			FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("bananajuice", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketbanana), new ItemStack(Items.bucket));
			FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("strawberryjuice", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketstrawberry), new ItemStack(Items.bucket));
			FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("carrotjuice", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketcarrot), new ItemStack(Items.bucket));
			FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("water", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketseaWater), new ItemStack(Items.bucket));
			FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("water", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketpurifiedwater), new ItemStack(Items.bucket));
			

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
			GameRegistry.registerItem(cookedBacon, ItemLib.iCBac);
			GameRegistry.registerItem(veal, ItemLib.iV);
			GameRegistry.registerItem(toast, ItemLib.iToastS);
			GameRegistry.registerItem(slicedBread, ItemLib.iBRS);
			GameRegistry.registerItem(frenchFries, "FrenchFries");
			GameRegistry.registerItem(egg, ItemLib.iEgg);
			GameRegistry.registerItem(rawpasta, ItemLib.iPasta);
			GameRegistry.registerItem(sandwhichS, ItemLib.iSandS);
			GameRegistry.registerItem(sandwhichCB, ItemLib.iSandCB);
			GameRegistry.registerItem(sandwhichGC, ItemLib.iSandGC);
			GameRegistry.registerItem(rawHamburger, ItemLib.iRH);
			GameRegistry.registerItem(cookedHamburger, ItemLib.iCH);
			GameRegistry.registerItem(sandwhichHamburger, ItemLib.iSandH);
			GameRegistry.registerItem(peanut, ItemLib.iP);
			GameRegistry.registerItem(tomato, ItemLib.iTom);
			
			//Register into Ore Dictionary
			OreDictionary.registerOre("foodHamburger", ItemLoader.cookedHamburger);
			OreDictionary.registerOre("foodBanana", ItemLoader.banana);
			OreDictionary.registerOre("foodBread", ItemLoader.slicedBread);
			
		}
		FRegister=true;
	}
}
