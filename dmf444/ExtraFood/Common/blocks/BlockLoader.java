package dmf444.ExtraFood.Common.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import dmf444.ExtraFood.Common.blocks.tileentity.CheesePressTileEntity;
import dmf444.ExtraFood.Core.lib.BlockLib;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockLoader {

	public static Block bananaBunch;
	public static Block saplingBanana;
	public static Block cheesePress;
	
	public static boolean Register=false;
	public static void initiateBlocks() {
		bananaBunch = new BananaBlock(BlockLib.idBanana, Material.cactus).setUnlocalizedName(BlockLib.bBB).setTextureName("extrafood:BananaTree");
		saplingBanana = new BananaTreeSapling(BlockLib.idBananaSap).setUnlocalizedName(BlockLib.bBS);
		cheesePress = new CheesePress(BlockLib.idCheesePress).setUnlocalizedName(BlockLib.bCP);
		
		registerBlocks();
	}
	private static void registerBlocks() {
		if(!Register){
			GameRegistry.registerBlock(bananaBunch, BlockLib.bBB);
			GameRegistry.registerBlock(saplingBanana, BlockLib.bBS);
			GameRegistry.registerBlock(cheesePress, BlockLib.bCP);
			
		}
		Register=true;
	}
	
	public static void initTileEntity() {
		GameRegistry.registerTileEntity(CheesePressTileEntity.class, BlockLib.bCP);
	}
	
}

