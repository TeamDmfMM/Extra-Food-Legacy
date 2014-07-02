package dmf444.ExtraFood.Common.blocks.guis;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;
import dmf444.ExtraFood.Common.blocks.container.ContainerJuiceBlender;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.Core.lib.GuiLib;

public class GuiJuiceBlender extends GuiContainer {

	private TileEntityJuiceBlender te;
	private ResourceLocation btext = GuiLib.JBgui;



	public GuiJuiceBlender(InventoryPlayer player, TileEntityJuiceBlender te) {
		super(new ContainerJuiceBlender(te, player));
		this.te = te;
		
		// TODO Auto-generated constructor stub
	}


	public void drawFluid(){
		// Bind textures from liquid.
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		System.out.println("drawing rebbryrbtwckut");
		this.mc.renderEngine.bindTexture(TextureMap.locationBlocksTexture);
		this.drawTexturedModelRectFromIcon(x + 147, y + 12, FluidRegistry.WATER.getIcon(), 16, (int) (72 - (0.012 * this.te.getFluidAmount())));
	}
	@Override

	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.renderEngine.bindTexture(btext);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		if (this.te.juice != null){
			this.drawFluid();
			
		}
		// TODO Auto-generated method stub
		
	}}
