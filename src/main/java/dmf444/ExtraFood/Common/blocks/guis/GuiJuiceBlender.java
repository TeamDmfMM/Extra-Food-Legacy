package dmf444.ExtraFood.Common.blocks.guis;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import dmf444.ExtraFood.Common.RecipeHandler.JuiceRegistry;
import dmf444.ExtraFood.Common.blocks.container.ContainerJuiceBlender;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.Core.lib.GuiLib;

public class GuiJuiceBlender extends GuiContainer {

	private TileEntityJuiceBlender te;
	private ResourceLocation btext = GuiLib.JBgui;



	public GuiJuiceBlender(InventoryPlayer player, TileEntityJuiceBlender te) {
		super(new ContainerJuiceBlender(player, te));
		this.te = te;
		
		// TODO Auto-generated constructor stub
	}

	
	public void drawFluid(){
		// Bind textures from liquid.
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		System.out.println("drawing rebbryrbtwckut");
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_BLEND);
		this.mc.renderEngine.bindTexture(new ResourceLocation(JuiceRegistry.instance.getTextureFromJuice(this.te.juice.getFluid())));
		this.drawTexturedModalRect(x + 147, (int)(y + 11 + (61 - (this.te.juice.amount * 0.012))), 0, 0, 16, (int)(this.te.juice.amount * 0.012));
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_BLEND);
	}
	@Override

	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.renderEngine.bindTexture(btext);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		if (this.te.complete > 0){
			int bar = (int) (1.85 * this.te.complete);
			this.drawTexturedModalRect(x + 104, y + 65, 176, 0, bar, 4);
		}
		if (this.te.juice != null){
			this.drawFluid();
			
		}
		if (this.shouldShowToolTip()){
			List<String> list = new ArrayList<String>();
			list.add("Fluid: " + this.te.getFluid().getFluid().getName());
			list.add("Amount: " + this.te.getFluidAmount());
			this.drawHoveringText(list, Mouse.getX(), Mouse.getY(), fontRendererObj);
		}
		
		// TODO Auto-generated method stub
		
	}
private boolean shouldShowToolTip(){
	int x = (width - xSize) / 2;
	int y = (height - ySize) / 2;
	Rectangle rect = new Rectangle(x + 146, y + 11, x + 164, y + 73);
	if (rect.contains(Mouse.getX(), Mouse.getY()) && this.te.juice != null){
		return true;
	}
	return false;
}

public void updateScreen(){
	
}
}
