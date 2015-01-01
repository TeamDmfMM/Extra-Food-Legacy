package dmf444.ExtraFood.Common.EventHandler;

import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.fluids.FluidLoader;

public class ExtraFood_eventTextureHook {

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void textureHook(TextureStitchEvent.Post event) {
		if (event.map.getTextureType() == 0) {
			FluidLoader.Fbananajuice.setIcons(BlockLoader.Bbananajuice.getBlockTextureFromSide(1), BlockLoader.Bbananajuice.getBlockTextureFromSide(2));
			FluidLoader.Fcarrotjuice.setIcons(BlockLoader.Bcarrotjuice.getBlockTextureFromSide(1), BlockLoader.Bcarrotjuice.getBlockTextureFromSide(2));
			FluidLoader.Fstrawberryjuice.setIcons(BlockLoader.Bstrawberryjuice.getBlockTextureFromSide(1), BlockLoader.Bstrawberryjuice.getBlockTextureFromSide(2));
		}
	}
}
