package dmf444.ExtraFood.Core.Crossmod.forestry;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.event.FMLInterModComms;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;
import forestry.api.farming.Farmables;

public class ForestryFarming {

	public static void test(){
		//FMLInterModComms.sendMessage("forestry", "add-farmable-crop", String.format("farmWheat@%s.+2", BlockLoader.tomatoCrop));
		Farmables.farmables.get("farmVegetables").add(new FarmCrop(new ItemStack(ItemLoader.tomatoSeeds), BlockLoader.tomatoCrop, 7));
		Farmables.farmables.get("farmVegetables").add(new FarmCrop(new ItemStack(ItemLoader.uselettuceSeeds), BlockLoader.lettuceCrop, 7));
	}
}
