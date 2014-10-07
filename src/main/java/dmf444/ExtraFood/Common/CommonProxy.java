package dmf444.ExtraFood.Common;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Core.Crossmod.ThaumcraftAspects;

public class CommonProxy {
	public void registerRenderers(){//NOOOP
		}

	public void registerKeybinds() {// NOOP
	}
	public void intermodComm(){
		if (Loader.isModLoaded("Thaumcraft")){
			ThaumcraftAspects.registerThaumAspect();
			FMLInterModComms.sendMessage("Thaumcraft", "harvestStandardCrop", new ItemStack(BlockLoader.tomatoCrop,1,7));
			FMLInterModComms.sendMessage("Thaumcraft", "harvestStandardCrop", new ItemStack(BlockLoader.lettuceCrop,1,7));
			FMLInterModComms.sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(BlockLoader.strawberryBush,1,7));
			FMLInterModComms.sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(BlockLoader.peanutbush,1,7));
		}
	}
}
