package dmf444.ExtraFood.Common.blocks.guis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ClickTab extends GuiButton{

	public ItemStack item;
	public RenderItem rinder;
	
	public int x;
	public int y;
	
	public String pagename;
	
	
	
	public ClickTab(int par1, int par2, int par3, int par4, int par5,
			String par6Str, int par7, int par8, ItemStack is, String name) {
		super(par1, par2, par3, par4, par5, par6Str);
		x = par7;
		y = par8;
		item = is;
		this.rinder = new RenderItem();
		this.pagename = name;
		
		
	
		// TODO Auto-generated constructor stub
	}
	
	public void drawButton(Minecraft m, int p1, int p2){
		m.getTextureManager().bindTexture(new ResourceLocation("extrafood", "textures/gui/oline.png"));
		this.drawTexturedModalRect(xPosition, yPosition, 0, 0, 22, 22);
		this.rinder.renderItemIntoGUI(m.fontRenderer, m.getTextureManager(), this.item, xPosition + 2, yPosition + 2);
		
		
	}


}
