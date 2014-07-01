package dmf444.ExtraFood.Common.blocks.guis;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fluids.FluidRegistry;

import org.lwjgl.opengl.GL11;

import dmf444.ExtraFood.Common.blocks.container.ContainerJuiceBlender;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.Core.lib.GuiLib;

public class GuiJuiceBlender extends GuiContainer {


	private TileEntityJuiceBlender te;



	public GuiJuiceBlender(InventoryPlayer player, TileEntityJuiceBlender te) {
		super(new ContainerJuiceBlender(player, te));
		this.te = te;

		// TODO Auto-generated constructor stub
	}

    @Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
            //draw text and stuff here
            //the parameters for drawString are: string, x, y, color
            fontRendererObj.drawString("Juice Blender", 8, 6, 4210752);
            //draws "Inventory" or your regional equivalent
            fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }


	public void drawFluid(){
		// Bind textures from liquid.
		this.mc.renderEngine.bindTexture(TextureMap.locationBlocksTexture);
		this.drawTexturedModelRectFromIcon(147, 12, FluidRegistry.getFluid("Water").getIcon(), 16, (int) (72 - (0.012 * this.te.getFluidAmount())));
	}
	@Override


	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.renderEngine.bindTexture(GuiLib.JBgui);            
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		if (this.te.getFluid() != null){
			this.drawFluid();


		}
		// TODO Auto-generated method stub


	}
	}
