package dmf444.ExtraFood.Core;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import dmf444.ExtraFood.Common.CommonProxy;
import dmf444.ExtraFood.Common.EventHandler.ExtraFood_EventBonemeal;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.lib.ModInfo;


@Mod(modid = ModInfo.MId,name = ModInfo.Mname, version = ModInfo.Vers)
@NetworkMod(clientSideRequired = true)
public class ExtraFood {
	@Instance(value = "ExtraFood")
	public static ExtraFood instance;
	
	@SidedProxy(clientSide= ModInfo.Clientproxy, serverSide= ModInfo.Serverproxy)
	public static CommonProxy proxy;
	
	TreeManager treeManager = new TreeManager();
	
	
		@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
			
			System.out.println("Extra Food has been activated, loading blocks,items and Events");
			
		ItemLoader.initiateItems();
		BlockLoader.initiateBlocks();
		GameRegistry.registerWorldGenerator(treeManager);
		MinecraftForge.EVENT_BUS.register(new ExtraFood_EventBonemeal());
		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
		
		
			System.out.println("Cleared EF's Registry");
		
	}
		

	@EventHandler
	public void load(FMLInitializationEvent event){
		
		BlockLoader.initTileEntity();
		
		proxy.registerRenderers();
		
		CraftingRecipies.craftering();

		
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
}
