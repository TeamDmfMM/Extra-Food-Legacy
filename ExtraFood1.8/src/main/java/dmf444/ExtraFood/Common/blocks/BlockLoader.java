package dmf444.ExtraFood.Common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;
import dmf444.ExtraFood.Common.blocks.tileentity.AutoCutterTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.CheesePressTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityOven;
import dmf444.ExtraFood.Common.fluids.FluidLoader;
import dmf444.ExtraFood.Common.fluids.GeneralFluid;
import dmf444.ExtraFood.Core.EFTabs;
import dmf444.ExtraFood.Core.lib.BlockLib;
import dmf444.ExtraFood.Core.lib.ModInfo;

public class BlockLoader {

	public static Block bananaBunch;
	public static Block saplingBanana;
	public static Block cheesePress;
	public static Block autoCutter;
	public static Block juiceBlender;
	public static Block oven;
	public static Block whiteout;
	public static Block Bbananajuice;
	public static Block Bstrawberryjuice;
	public static Block strawberryBush;
	public static Block Bcarrotjuice;
	public static Block bananaLeaf;
	public static Block peanutbush;
	public static Block tomatoCrop;
	public static Block lettuceCrop;
	public static Block juiceMixer;
	
	public static boolean Register=false;
	
	public static void initiateBlocks() {
		/*juiceMixer = new BlockJuiceMixer().setUnlocalizedName(BlockLib.bJM);*/
		tomatoCrop = new CropBlock("tomato").setUnlocalizedName(BlockLib.bCT);
		lettuceCrop = new CropBlock("lettuce").setUnlocalizedName(BlockLib.bCL);
		peanutbush = new PeanutBush(Material.plants).setUnlocalizedName(BlockLib.bPB);
		Bstrawberryjuice = new GeneralFluid(FluidLoader.Fstrawberryjuice, Material.water).setUnlocalizedName("StrawberryJuice").setCreativeTab(EFTabs.INSTANCE);
		//Bcarrotjuice = new CarrotJuice(FluidLoader.Fcarrotjuice, Material.water).setUnlocalizedName("Fcarrotjuice");
		strawberryBush = new StrawberryBush(Material.plants).setUnlocalizedName(BlockLib.bSB);
		//Bbananajuice = new BananaJuice(FluidLoader.Fbananajuice, Material.water).setUnlocalizedName("Fbananajuice");
		juiceBlender = new BlockJuiceBlender().setUnlocalizedName(BlockLib.bJB).setHardness(1.5F);
		oven = new Oven().setUnlocalizedName(BlockLib.bO);
		saplingBanana = new BananaTreeSapling().setUnlocalizedName(BlockLib.bBS);
		whiteout = new Whiteout().setUnlocalizedName(BlockLib.bWhite).setHardness(1.5F);
		bananaLeaf = new BananaLeaf().setUnlocalizedName(BlockLib.bBananaLeaf);
		autoCutter = new AutoCutter().setUnlocalizedName(BlockLib.bAC).setHardness(2.0F);
		cheesePress = new CheesePress().setUnlocalizedName(BlockLib.bCP).setHardness(1.5F);
		bananaBunch = new BananaBlock(Material.cactus).setUnlocalizedName(BlockLib.bBB);
		
		registerBlocks();
	}
	private static void registerBlocks() {
		if(!Register){
			/*GameRegistry.registerBlock(juiceMixer, BlockLib.bJM);*/
			GameRegistry.registerBlock(peanutbush, BlockLib.bPB);
			GameRegistry.registerBlock(tomatoCrop, BlockLib.bCT);
			GameRegistry.registerBlock(lettuceCrop, BlockLib.bCL);
			GameRegistry.registerBlock(Bstrawberryjuice, "StrawberryJuice");
			//GameRegistry.registerBlock(Bcarrotjuice, ModInfo.MId + "_" + Bcarrotjuice.getUnlocalizedName().substring(5));			
			GameRegistry.registerBlock(strawberryBush, BlockLib.bSB);
			//GameRegistry.registerBlock(Bbananajuice, ModInfo.MId + "_" + Bbananajuice.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(juiceBlender, BlockLib.bJB);
			GameRegistry.registerBlock(oven, BlockLib.bO);
			GameRegistry.registerBlock(saplingBanana, BlockLib.bBS);
			GameRegistry.registerBlock(whiteout, BlockLib.bWhite);
			GameRegistry.registerBlock(bananaLeaf, BlockLib.bBananaLeaf);
			GameRegistry.registerBlock(autoCutter, BlockLib.bAC);
			GameRegistry.registerBlock(cheesePress, BlockLib.bCP);
			GameRegistry.registerBlock(bananaBunch, BlockLib.bBB);
			
		}
		Register=true;
	}
	
	public static void initTileEntity() {
		GameRegistry.registerTileEntity(CheesePressTileEntity.class, BlockLib.bCP);
		GameRegistry.registerTileEntity(AutoCutterTileEntity.class, BlockLib.bAC);
		GameRegistry.registerTileEntity(TileEntityJuiceBlender.class, BlockLib.bJB);
		GameRegistry.registerTileEntity(TileEntityOven.class, BlockLib.bO);
		/*GameRegistry.registerTileEntity(JuiceMixerTileEntity.class, BlockLib.bJM);*/
	}
	
}

