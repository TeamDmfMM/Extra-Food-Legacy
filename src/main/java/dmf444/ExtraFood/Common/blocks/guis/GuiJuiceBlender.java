package dmf444.ExtraFood.Common.blocks.guis;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraftforge.fluids.FluidRegistry;
import dmf444.ExtraFood.Common.blocks.container.ContainerJuiceBlender;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;

public class GuiJuiceBlender extends GuiContainer {

	private TileEntityJuiceBlender te;



	public GuiJuiceBlender(InventoryPlayer player, TileEntityJuiceBlender te) {
		super(new ContainerJuiceBlender(te, player));
		this.te = te;
		
		// TODO Auto-generated constructor stub
	}


	public void drawFluid(){
		// Bind textures from liquid.
		this.mc.renderEngine.bindTexture(TextureMap.locationBlocksTexture);
		this.drawTexturedModelRectFromIcon(147, 12, FluidRegistry.getFluid("Water").getIcon(), 16, (int) (72 - (0.012 * this.te.getFluidAmount())));
	}
	@Override

	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		if (this.te.getFluid() != null){
			this.drawFluid();
			
		}
		// TODO Auto-generated method stub
		
	}}
