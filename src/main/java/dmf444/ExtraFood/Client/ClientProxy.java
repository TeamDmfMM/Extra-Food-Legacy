package dmf444.ExtraFood.Client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import dmf444.ExtraFood.Client.renderer.AutoCutterRenderer;
import dmf444.ExtraFood.Client.renderer.CheesePressRenderer;
import dmf444.ExtraFood.Client.renderer.JuiceMixerRenderer;
import dmf444.ExtraFood.Client.renderer.RenderOven;
import dmf444.ExtraFood.Client.renderer.RendererJuiceBlender;
import dmf444.ExtraFood.Common.CommonProxy;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.blocks.tileentity.AutoCutterTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.CheesePressTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.JuiceMixerTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityOven;
import dmf444.ExtraFood.Core.Crossmod.WailaConfig;
import dmf444.ExtraFood.Core.lib.BlockLib;

public class ClientProxy extends CommonProxy{

	//public static BerryRender bushrender;
	
	public void registerRenderers(){ 
		ClientRegistry.bindTileEntitySpecialRenderer(CheesePressTileEntity.class, new CheesePressRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(AutoCutterTileEntity.class, new AutoCutterRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJuiceBlender.class, new RendererJuiceBlender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOven.class, new RenderOven());
		//ClientRegistry.bindTileEntitySpecialRenderer(JuiceMixerTileEntity.class, new JuiceMixerRenderer());
		//bushrender = new BerryRender();
		RenderingRegistry.registerBlockHandler(bushrender);
	     


	     }
	
		
	@Override
	public void intermodComm(){
		FMLInterModComms.sendMessage("Waila", "register", WailaConfig.class.getName() + ".callbackRegister");
	}
}

