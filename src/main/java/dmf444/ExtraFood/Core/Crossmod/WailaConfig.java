package dmf444.ExtraFood.Core.Crossmod;

import mcp.mobius.waila.api.IWailaRegistrar;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;

public class WailaConfig {

	public static void callbackRegister(IWailaRegistrar registrar) {
		registrar.registerBodyProvider(new WailaProviderJuiceBlender(), TileEntityJuiceBlender.class);
	}
}
