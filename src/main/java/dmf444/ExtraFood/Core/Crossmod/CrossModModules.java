package dmf444.ExtraFood.Core.Crossmod;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Core.Crossmod.forestry.ForestryFarming;
import dmf444.ExtraFood.Core.lib.ModInfo;
import dmf444.ExtraFood.util.EFLog;

public class CrossModModules {
	
	private static boolean thaumcraft = false;
	private static boolean versionCheck = false;
	private static boolean forestry = false;
	
	
	public static void magic(){
	if (Loader.isModLoaded("Thaumcraft")){
		thaumcraft = true;
		ThaumcraftAspects.registerThaumAspect();
		FMLInterModComms.sendMessage("Thaumcraft", "harvestStandardCrop", new ItemStack(BlockLoader.tomatoCrop,1,7));
		FMLInterModComms.sendMessage("Thaumcraft", "harvestStandardCrop", new ItemStack(BlockLoader.lettuceCrop,1,7));
		FMLInterModComms.sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(BlockLoader.strawberryBush,1,7));
		FMLInterModComms.sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(BlockLoader.peanutbush,1,7));
	}
	if(Loader.isModLoaded("VersionChecker")){
		versionCheck = true;
		NBTTagCompound info = new NBTTagCompound();
		info.setString("curseProjectName", "222348-extra-food");
		info.setString("curseFilenameParser", "ExtraFood-[].jar");
		info.setString("modDisplayName", "Extra Food");
		FMLInterModComms.sendRuntimeMessage(ModInfo.MId, "VersionChecker", "addCurseCheck", info);
	}
	if(Loader.isModLoaded("Forestry")){
		forestry = true;
		ForestryFarming.test();
	}
	EFLog.info("Mods Loaded:");
	EFLog.info("Thaumcraft=" + thaumcraft);
	EFLog.info("VersionChecker=" + versionCheck);
	EFLog.info("Forestry=" + forestry);
	
	}
}
