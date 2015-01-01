package dmf444.ExtraFood;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler; // used in 1.6.2
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import dmf444.ExtraFood.Common.CommonProxy;
import dmf444.ExtraFood.Common.EventHandler.ExtraFood_EventBonemeal;
import dmf444.ExtraFood.Common.RecipeHandler.CRPageCraftGet;
import dmf444.ExtraFood.Common.RecipeHandler.RegistryAutoCutter;
import dmf444.ExtraFood.Common.WorldGen.TreeManager;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.GuiHandler;
import dmf444.ExtraFood.Core.lib.BlockLib;
import dmf444.ExtraFood.Core.lib.ItemLib;
import dmf444.ExtraFood.Core.lib.ModInfo;
import dmf444.ExtraFood.util.ConfigHandler;
import dmf444.ExtraFood.util.EFLog;


@Mod(modid = ModInfo.MId,name = ModInfo.Mname, version = ModInfo.Vers)

public class ExtraFood {
	@Instance(value = "ExtraFood")
	public static ExtraFood instance;
	
	@SidedProxy(clientSide= ModInfo.Clientproxy, serverSide= ModInfo.Serverproxy)
	public static CommonProxy proxy;
	
	
	public static CRPageCraftGet crafterPage;
	public static RegistryAutoCutter registryCutter;
	TreeManager treeManager = new TreeManager();
	
	public static SimpleNetworkWrapper JBTanknet;

	
	
		@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
			
			EFLog.info("Extra Food has been activated, loading blocks,items and Events");
		ConfigHandler.init(event.getSuggestedConfigurationFile());
			
		//FluidLoader.initiateFluids();
		BlockLoader.initiateBlocks();
		ItemLoader.initiateItems();
		ItemLoader.initiateFoods();
		//NBTFoodLoader.initiateItems();
		//NBTFoodLoader.register();
		
		if (ConfigHandler.GenBananaTrees){
		GameRegistry.registerWorldGenerator(treeManager, 0);
		MinecraftForge.EVENT_BUS.register(new ExtraFood_EventBonemeal());
		}
		
		//EventsLoader.loadEvents();
		//Gui Handler Registration
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		//Init the packet Handler
		//JBTanknet = NetworkRegistry.INSTANCE.newSimpleChannel(ModInfo.MId);
		//JBTanknet.registerMessage(PacketJBTank.Handler.class, PacketJBTank.class, 1,Side.CLIENT);

		
		
			EFLog.info("Cleared EF's Registry");
		
	}
		

	@EventHandler
	public void load(FMLInitializationEvent event){
		EFLog.info("Extra Food is in Init, loading stuff");
			BlockLoader.initTileEntity();
		
			proxy.registerRenderers();
			//this.registryCutter = new RegistryAutoCutter();
			//CraftingRecipies.craftering();
			//CraftingRecipies.furnacing();
		
			//proxy.registerKeybinds();
			//proxy.intermodComm();
			//CrossModModules.magic();
			if(event.getSide() == Side.CLIENT){
				//RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

			     //blocks
				RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
				renderItem.getItemModelMesher().register(ItemLoader.cheeseWheel, 0, new ModelResourceLocation("extrafood:Cheese_Wheel", "inventory"));
				registerBlock(BlockLib.bBB, 0, "extrafood:Banana_Bunch");
				registerBlock("BananaLeaf", 0, "extrafood:BananaLeaf");
				registerBlock("TheWhiteBlock", 0, "extrafood:TheWhiteBlock");
				registerBlock(BlockLib.bBS, 0, "extrafood:Bannana_Sapling");
				registerBlock(BlockLib.bCP, 0, "extrafood:CheesePress");
				registerBlock(BlockLib.bAC, 0);
				//registerBlock(ItemLib.iCW, 0, "extrafood:models/item/Cheese_Wheel");
			    // renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockLoader.bananaBunch), 0, new ModelResourceLocation("extrafood:models/item/Banana_Bunch", "inventory"));
			}
		EFLog.info("Finished all INIT!");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
		//crafterPage = new CRPageCraftGet();
		//JuiceRegistry.instance = new JuiceRegistry();
		//OvenRegistry.instance = new OvenRegistry();



	}
	private void registerBlock(String blockName, int meta, String resource){
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		Item itemB = GameRegistry.findItem("extrafood", blockName);
		renderItem.getItemModelMesher().register(itemB, meta, new ModelResourceLocation(resource, "inventory"));
	}
	private void registerBlock(String blockName, int meta){
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		Item itemB = GameRegistry.findItem("extrafood", blockName);
		renderItem.getItemModelMesher().register(itemB, meta, new ModelResourceLocation("extrafood:"+ blockName, "inventory"));
	}
}
