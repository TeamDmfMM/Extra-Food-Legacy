package dmf444.ExtraFood.Core;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import dmf444.ExtraFood.ExtraFood;
import dmf444.ExtraFood.Common.RecipeHandler.RecipeAutoCutter;
import dmf444.ExtraFood.Common.RecipeHandler.RegistryAutoCutter;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;


public class CraftingRecipies {
	
	public static void craftering()
	{
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockLoader.cheesePress, 1), new Object[] {"ipi", "ibi", "sss", 'i', "ingotIron", 'p', "plankWood", 'b', Items.bucket, 's', new ItemStack(Blocks.stone_slab, 1, 0)}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockLoader.autoCutter, 1), new Object[] {"pki", "psp", "p p", 'p', "plankWood", 'k', ItemLoader.knife, 'i', "ingotIron", 's', "slabWood"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.knife, 1), new Object[] {"ii ", "ii ", " j ", 'i', "ingotIron", 'j', "stickWood"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.sandwhichHamburger), new Object[] { " i ", " h ", " i ", 'i', "foodBread", 'h', "foodHamburger"}));
	GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.tomatoSeeds, 2), new ItemStack(ItemLoader.tomato));
	
	Cutting(new ItemStack(ItemLoader.cheeseWheel, 1), new ItemStack(ItemLoader.cheeseSlice, 8));
	Cutting(new ItemStack(Items.bread, 1), new ItemStack(ItemLoader.slicedBread, 6));
	Cutting(new ItemStack(Items.porkchop, 1), new ItemStack(ItemLoader.sausage, 2));
	Cutting(new ItemStack(Items.potato, 1), new ItemStack(ItemLoader.frenchFries, 1));
	Cutting(new ItemStack(Items.beef, 1), new ItemStack(ItemLoader.rawHamburger, 1));
	Cutting(new ItemStack(Items.cooked_beef, 1), new ItemStack(ItemLoader.cookedHamburger, 1));
	}
	public static void furnacing()
	{
		GameRegistry.addSmelting(ItemLoader.bacon, new ItemStack(ItemLoader.cookedBacon, 1), 0.2F);
		GameRegistry.addSmelting(ItemLoader.slicedBread, new ItemStack(ItemLoader.toast, 1), 0.1F);
		GameRegistry.addSmelting(ItemLoader.bucketseaWater, new ItemStack(ItemLoader.bucketpurifiedwater, 1), 0.5F);
		GameRegistry.addSmelting(ItemLoader.rawHamburger, new ItemStack(ItemLoader.cookedHamburger), 0.7F);
	}
	
	/*
	 *  Adds in recipes that can be cut by the knife and cut by the Auto Cutter.
	 * 
	 */
	public static void Cutting(ItemStack input, ItemStack output){
		ExtraFood.instance.registryCutter.registerRecipe(new RecipeAutoCutter(input, output));
		GameRegistry.addShapelessRecipe(output, new ItemStack(ItemLoader.knife, 1, 32767), input);
	}
}
