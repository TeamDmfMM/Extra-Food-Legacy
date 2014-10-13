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
import net.minecraft.potion.Potion;
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
	public static Item toast, frenchToast;
	public static Item slicedBread;
	public static Item bucketseaWater;
	public static Item bucketpurifiedwater;
	public static Item frenchFries;
	public static Item egg;
	public static Item rawpasta, cookedpasta, meatballpasta;
	public static Item sandwhichCB, sandwhichGC, sandwichPBN, sandwichPBJ, sandwichBLT, sandwichPB, sandwhichS, sandwichC;
	public static Item pork_kebab, steak_kebab, veal_kebab;
	public static Item rawHamburger, cookedHamburger;
	public static Item sandwhichHamburger, sandwichCheeseburger, sandwichSupremeBurger;
	public static Item tomato, lettuce;
	public static Item rawlettuceSeeds;
	public static ItemSeeds tomatoSeeds, uselettuceSeeds;
	public static Item peanutButter, chocolateSpread, jelly;
	public static Item meatballs;
	public static Item chocolate;
	public static Item pancakes;
	public static Item sushi, fishpieces, chineseFood;
	public static Item grater;
	public static Item vanillaIceCream, chocolateIceCream, strawberryIceCream, icePop, neoIceCream;
	public static Item butter, butterMilk;
	public static Item yogurt, stawberryYogurt;
	
	
	private static boolean IRegister=false;
	private static boolean FRegister=false;
	
	
	
	public static void initiateItems() {

		knife = new Knife().setUnlocalizedName(ItemLib.iK);	
		cookBook = new Cookbook().setUnlocalizedName(ItemLib.iCB);
		bucketstrawberry = new BucketStrawberry(6, 0.8F);
		bucketbanana = new BucketBanana(6, 0.6F);
		bucketcarrot = new BucketCarrot(6, 0.9F);
		bucketseaWater = new BucketSeaWater(2, 0.5F);
		bucketpurifiedwater = new BucketPurifiedWater(4, 0.5F);
		tomatoSeeds = (ItemSeeds) new ItemSeeds(BlockLoader.tomatoCrop, Blocks.farmland).setUnlocalizedName(ItemLib.iTS).setTextureName("extrafood:tomatoSeeds").setCreativeTab(EFTabs.INSTANCE);
		rawlettuceSeeds = new Item().setUnlocalizedName(ItemLib.iULS).setTextureName("extrafood:uselessLettuceSeeds").setCreativeTab(EFTabs.INSTANCE);
		uselettuceSeeds = (ItemSeeds) new ItemSeeds(BlockLoader.lettuceCrop, Blocks.farmland).setUnlocalizedName(ItemLib.iCLS).setTextureName("extrafood:coatedLettuceSeeds").setCreativeTab(EFTabs.INSTANCE);
		grater = new Grater().setUnlocalizedName(ItemLib.iGrater);
		
		
		registerItems();
	}
	public static void initiateFoods(){
		//Semi-balanced foods
		sausage = new StanFood(3, 0.9F).setUnlocalizedName(ItemLib.iS);
		cheeseSlice = new StanFood(2, 3.0F).setUnlocalizedName(ItemLib.iCS);
		cheeseWheel = new CheeseWheel(8, 5.6F, false).setUnlocalizedName(ItemLib.iCW);
		banana = new Banana(4, 0.8F, false).setUnlocalizedName(ItemLib.iBan);
		strawberry = ((ItemFood) new Strawberry(2, 2.0F, false).setUnlocalizedName(ItemLib.iST)).setAlwaysEdible();
		bacon = new StanFood(1, 0.6F).setUnlocalizedName(ItemLib.iBac);
		veal = new StanFood(8, 19.5F, true).setUnlocalizedName(ItemLib.iV);
		cookedBacon = new StanFood(2, 5.2F).setUnlocalizedName(ItemLib.iCBac);
		toast = new StanFood(6, 0.8F).setUnlocalizedName(ItemLib.iToastS);
		slicedBread = new StanFood(4, 3.0F).setUnlocalizedName(ItemLib.iBRS);
		frenchFries = new ItemFood(8, 0.7F, false).setUnlocalizedName(ItemLib.iFF()).setCreativeTab(EFTabs.INSTANCE).setTextureName("extrafood:" + ItemLib.iFF());//" + ItemLib.iFF()
		tomato = new StanFood(4, 2.5F).setUnlocalizedName(ItemLib.iTom);
		lettuce = new StanFood(4, 1.6F).setUnlocalizedName(ItemLib.iLet);	
		egg = new StanFood(3, 0.8F).setUnlocalizedName(ItemLib.iEgg);
		pork_kebab = new StanFood(3, 12.3F).setUnlocalizedName(ItemLib.iPKeb);
		steak_kebab = new StanFood(3, 12.4F).setUnlocalizedName(ItemLib.iSKeb);
		veal_kebab = new StanFood(3, 12.6F).setUnlocalizedName(ItemLib.iVKeb);		
		sushi = new StanFood(8, 2.6F).setUnlocalizedName(ItemLib.iSushi);
		rawHamburger = ((ItemFood) new StanFood(5, 0.6F).setUnlocalizedName(ItemLib.iRH)).setPotionEffect(Potion.hunger.id, 30, 0, 0.4F);
		
		//Non-balanced foods
		rawpasta = new ReturnFood(3, 0.3F, Items.bowl).setUnlocalizedName(ItemLib.iPasta);
		sandwhichS = new StanFood(7, 1.0F).setUnlocalizedName(ItemLib.iSandS);
		sandwhichCB = new StanFood(6, 1.4F).setUnlocalizedName(ItemLib.iSandCB);
		sandwhichGC = new StanFood(6, 1.9F).setUnlocalizedName(ItemLib.iSandGC);
		cookedHamburger = new StanFood(7, 1.6F).setUnlocalizedName(ItemLib.iCH);
		sandwhichHamburger = new StanFood(9, 1.0F).setUnlocalizedName(ItemLib.iSandH);
		peanut = ((ItemFood) new StanFood(1, 0.2F).setUnlocalizedName(ItemLib.iP)).setAlwaysEdible();
		cookedpasta = new ReturnFood(6, 1.3F, Items.bowl).setUnlocalizedName(ItemLib.iCP);
		meatballs = new StanFood(3, 0.4F).setUnlocalizedName(ItemLib.iMB);
		meatballpasta = new ReturnFood(12, 1.4F, Items.bowl).setUnlocalizedName(ItemLib.iMBP);
		fishpieces = new StanFood(4, 0.5F).setUnlocalizedName(ItemLib.iFP);
		chocolate = new StanFood(4, 1.8F).setUnlocalizedName(ItemLib.iCho);
		pancakes = new StanFood(6, 1.2F).setUnlocalizedName(ItemLib.iPC);
		peanutButter = ((ItemFood) new StanFood(3, 4.5F).setUnlocalizedName(ItemLib.iPB)).setPotionEffect(Potion.confusion.id, 10, 0, 0.8F);
		butter = new StanFood(1, 1.0F).setUnlocalizedName(ItemLib.iButter);
		vanillaIceCream = new DrinkActionFood(4, 0.8F).setUnlocalizedName(ItemLib.iVanIceCream);
		chocolateIceCream = new DrinkActionFood(8, 0.8F).setUnlocalizedName(ItemLib.iChoIceCream);
		strawberryIceCream = new DrinkActionFood(9, 2.5F).setUnlocalizedName(ItemLib.iStrawIceCream);
		chineseFood = new StanFood(7, 5.0F).setUnlocalizedName(ItemLib.iCNF);
		chocolateSpread = ((ItemFood) new StanFood(8, 4.5F).setUnlocalizedName(ItemLib.iChoSpread)).setPotionEffect(Potion.confusion.id, 10, 0, 0.8F);
		jelly = ((ItemFood) new StanFood(5, 2.0F).setUnlocalizedName(ItemLib.iJ)).setPotionEffect(Potion.heal.id, 5, 0, 0.1F);
		sandwichBLT = new StanFood(8, 10.0F).setUnlocalizedName(ItemLib.iSandBLT);
		sandwichPBJ = new StanFood(8, 9.5F).setUnlocalizedName(ItemLib.iSandPBJ);
		sandwichPBN = new StanFood(8, 9.0F).setUnlocalizedName(ItemLib.iSandPBN);
		icePop = new DrinkActionFood(5, 3.3F).setUnlocalizedName(ItemLib.iPopcicle);
		neoIceCream = new ReturnFood(8, 4.5F, Items.bowl).setUnlocalizedName(ItemLib.iNeoIceCream);
		sandwichPB = new StanFood(6, 3.5F).setUnlocalizedName(ItemLib.iSandPeanutB);
		butterMilk = new ButterMilk(8, 3.6F).setUnlocalizedName(ItemLib.iButterMilk);
		yogurt = new ReturnFood(5, 6.3F, Items.bowl).setUnlocalizedName(ItemLib.iYogurt);
		stawberryYogurt = new ReturnFood(5, 6.8F, Items.bowl).setUnlocalizedName(ItemLib.iStrawYogurt);
		sandwichC = new StanFood(9, 5.5F).setUnlocalizedName(ItemLib.iChoSandwich);
		frenchToast = new StanFood(7, 2.7F).setUnlocalizedName(ItemLib.iFrenchToast);
		sandwichCheeseburger = new StanFood(10, 12.0F).setUnlocalizedName(ItemLib.iSandCheeseBurger);
		sandwichSupremeBurger = new StanFood(15, 11.2F).setUnlocalizedName(ItemLib.iSandSupremeH);
		
		registerFood();
	}
	private static void registerItems() {
		if(!IRegister){
			
			GameRegistry.registerItem(knife, ItemLib.iK);
			GameRegistry.registerItem(cookBook, ItemLib.iCB);
			GameRegistry.registerItem(tomatoSeeds, ItemLib.iTS);
			GameRegistry.registerItem(uselettuceSeeds, ItemLib.iCLS);
			GameRegistry.registerItem(rawlettuceSeeds, ItemLib.iULS);
			GameRegistry.registerItem(grater, ItemLib.iGrater);
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
			GameRegistry.registerItem(lettuce, ItemLib.iLet);
			GameRegistry.registerItem(cookedpasta, ItemLib.iCP);
			GameRegistry.registerItem(meatballs, ItemLib.iMB);
			GameRegistry.registerItem(meatballpasta, ItemLib.iSushi);
			GameRegistry.registerItem(sushi, ItemLib.iMBP);
			GameRegistry.registerItem(fishpieces, ItemLib.iFP);
			GameRegistry.registerItem(pork_kebab, ItemLib.iPKeb);
			GameRegistry.registerItem(veal_kebab, ItemLib.iVKeb);
			GameRegistry.registerItem(steak_kebab, ItemLib.iSKeb);
			GameRegistry.registerItem(chocolate, ItemLib.iCho);
			GameRegistry.registerItem(pancakes, ItemLib.iPC);
			GameRegistry.registerItem(peanutButter, ItemLib.iPB);
			GameRegistry.registerItem(butter, ItemLib.iButter);
			GameRegistry.registerItem(strawberryIceCream, ItemLib.iStrawIceCream);
			GameRegistry.registerItem(vanillaIceCream, ItemLib.iVanIceCream);
			GameRegistry.registerItem(chocolateIceCream, ItemLib.iChoIceCream);
			GameRegistry.registerItem(chineseFood, ItemLib.iCNF);
			GameRegistry.registerItem(chocolateSpread, ItemLib.iChoSpread);
			GameRegistry.registerItem(jelly, ItemLib.iJ);
			GameRegistry.registerItem(sandwichBLT, ItemLib.iSandBLT);
			GameRegistry.registerItem(sandwichPBJ, ItemLib.iSandPBJ);
			GameRegistry.registerItem(sandwichPBN, ItemLib.iSandPBN);
			GameRegistry.registerItem(icePop, ItemLib.iPopcicle);
			GameRegistry.registerItem(neoIceCream, ItemLib.iNeoIceCream);
			GameRegistry.registerItem(sandwichPB, ItemLib.iSandPeanutB);
			GameRegistry.registerItem(butterMilk, ItemLib.iButterMilk);
			GameRegistry.registerItem(yogurt, ItemLib.iYogurt);
			GameRegistry.registerItem(stawberryYogurt, ItemLib.iStrawYogurt);
			GameRegistry.registerItem(sandwichC, ItemLib.iChoSandwich);
			GameRegistry.registerItem(frenchToast, ItemLib.iFrenchToast);
			GameRegistry.registerItem(sandwichCheeseburger, ItemLib.iSandCheeseBurger);
			GameRegistry.registerItem(sandwichSupremeBurger, ItemLib.iSandSupremeH);
			
			//Register into Ore Dictionary
			OreDictionary.registerOre("foodHamburger", ItemLoader.cookedHamburger);
			OreDictionary.registerOre("foodBanana", ItemLoader.banana);
			OreDictionary.registerOre("foodBread", ItemLoader.slicedBread);
			OreDictionary.registerOre("foodToast", ItemLoader.toast);
			OreDictionary.registerOre("foodCheeseSlice", ItemLoader.cheeseSlice);
			OreDictionary.registerOre("foodSausage", ItemLoader.sausage);
			OreDictionary.registerOre("foodRawPasta", ItemLoader.rawpasta);
			OreDictionary.registerOre("foodPeanuts", ItemLoader.peanut);
			OreDictionary.registerOre("foodStrawberry", ItemLoader.strawberry);
			OreDictionary.registerOre("cropTomato", ItemLoader.tomato);
			OreDictionary.registerOre("cropLettuce", ItemLoader.lettuce);
			OreDictionary.registerOre("foodCookedBacon", ItemLoader.cookedBacon);
			OreDictionary.registerOre("foodCookedPasta", ItemLoader.cookedpasta);
			OreDictionary.registerOre("foodMeatballs", ItemLoader.meatballs);
			OreDictionary.registerOre("foodMeatballPasta", ItemLoader.meatballpasta);
			OreDictionary.registerOre("foodSushi", ItemLoader.sushi);
			OreDictionary.registerOre("foodStrawberryIceCream", ItemLoader.strawberryIceCream);
			OreDictionary.registerOre("foodVanillaIceCream", ItemLoader.vanillaIceCream);
			OreDictionary.registerOre("foodChocolateIceCream", ItemLoader.chocolateIceCream);
			OreDictionary.registerOre("fishpieces", ItemLoader.fishpieces);
			OreDictionary.registerOre("foodChocolate", ItemLoader.chocolate);
			OreDictionary.registerOre("itemKnife", ItemLoader.knife);
			OreDictionary.registerOre("foodPancakes", ItemLoader.pancakes);
			OreDictionary.registerOre("foodPeanutButter", ItemLoader.peanutButter);
			OreDictionary.registerOre("foodChinese", ItemLoader.chineseFood);
			OreDictionary.registerOre("itemGrater", ItemLoader.grater);
			OreDictionary.registerOre("foodButter", ItemLoader.butter);
			OreDictionary.registerOre("foodChocolateSpread", ItemLoader.chocolateSpread);
			OreDictionary.registerOre("foodEgg", ItemLoader.egg);
			OreDictionary.registerOre("foodJelly", ItemLoader.jelly);
			OreDictionary.registerOre("foodBLT", ItemLoader.sandwichBLT);
			OreDictionary.registerOre("foodPBJ", ItemLoader.sandwichPBJ);
			OreDictionary.registerOre("foodPBN", ItemLoader.sandwichPBN);
			OreDictionary.registerOre("foodNeoIceCream", ItemLoader.neoIceCream);
			OreDictionary.registerOre("foodIcePop", ItemLoader.icePop);
			OreDictionary.registerOre("foodSandwichPeanutButter", ItemLoader.sandwichPB);
			OreDictionary.registerOre("foodButterMilk", ItemLoader.butterMilk);
			OreDictionary.registerOre("foodYogurt", ItemLoader.yogurt);
			OreDictionary.registerOre("foodStrawberryYogurt", ItemLoader.stawberryYogurt);
			OreDictionary.registerOre("foodChocolateSandwich", ItemLoader.sandwichC);
			OreDictionary.registerOre("foodHamburgerSandwich", ItemLoader.sandwhichHamburger);
			OreDictionary.registerOre("foodCheeseburger", ItemLoader.sandwichCheeseburger);
			OreDictionary.registerOre("foodSupremeBurger", ItemLoader.sandwichSupremeBurger);
			OreDictionary.registerOre("foodFrenchToast", ItemLoader.frenchToast);
			
		}
		FRegister=true;
	}
}
