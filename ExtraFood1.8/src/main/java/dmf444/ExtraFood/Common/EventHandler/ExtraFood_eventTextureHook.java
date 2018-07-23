package dmf444.ExtraFood.Common.EventHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.fluids.FluidLoader;

public class ExtraFood_eventTextureHook {
	
	@SideOnly(Side.CLIENT) 
	public static TextureAtlasSprite BananaJuice; 
	@SideOnly(Side.CLIENT) 
	public static TextureAtlasSprite CarrotJuice; 
	@SideOnly(Side.CLIENT) 
	public static TextureAtlasSprite StrawberryJuice; 


	@SubscribeEvent 
	@SideOnly(Side.CLIENT) 
	public void onModelBakeEvent(ModelBakeEvent event) { 
			this.BananaJuice = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite("extrafood:Fluid_BananaJuice_Still");
			this.CarrotJuice = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite("extrafood:Fluid_CarrotJuice_Still");
			this.StrawberryJuice = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite("extrafood:Fluid_StrawberryJuice_Still");
			//FluidLoader.Fbananajuice.setIcons(BlockLoader.Bbananajuice.getBlockTextureFromSide(1), BlockLoader.Bbananajuice.getBlockTextureFromSide(2));
			//FluidLoader.Fcarrotjuice.setIcons(BlockLoader.Bcarrotjuice.getBlockTextureFromSide(1), BlockLoader.Bcarrotjuice.getBlockTextureFromSide(2));
			//FluidLoader.Fstrawberryjuice.setIcons(BlockLoader.Bstrawberryjuice.getBlockTextureFromSide(1), BlockLoader.Bstrawberryjuice.getBlockTextureFromSide(2));
	}
}
