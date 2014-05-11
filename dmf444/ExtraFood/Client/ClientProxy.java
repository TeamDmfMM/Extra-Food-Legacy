package dmf444.ExtraFood.Client;

import cpw.mods.fml.client.registry.ClientRegistry;
import dmf444.ExtraFood.Client.renderer.AutoCutterRenderer;
import dmf444.ExtraFood.Client.renderer.CheesePressRenderer;
import dmf444.ExtraFood.Common.CommonProxy;
import dmf444.ExtraFood.Common.blocks.tileentity.AutoCutterTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.CheesePressTileEntity;

public class ClientProxy extends CommonProxy{
	public void registerRenderers(){ 
		ClientRegistry.bindTileEntitySpecialRenderer(CheesePressTileEntity.class, new CheesePressRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(AutoCutterTileEntity.class, new AutoCutterRenderer());
		
	}
}

