package dmf444.ExtraFood.Common.blocks.guis;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class CRPageGUI extends GuiScreen {

ResourceLocation bookopen = new ResourceLocation("extrafood", "textures/gui/book_texture.png");
ResourceLocation Cinterface = new ResourceLocation("extrafood", "textures/gui/craftingbookGUI.png");
String pageTextFrom;
private ItemStack[] items;
RenderItem irender;

 public CRPageGUI(String pagename, ItemStack[] items) {
	 this.items = items;
	 this.irender = new RenderItem();
	pageTextFrom = StatCollector.translateToLocal("cookbook." + pagename);

 }
 
 public void drawScreen(int par1, int par2, float par3) {
	 
	this.drawDefaultBackground();	
	this.drawBookBackground();
	this.drawTextSide();
	this.renderItems();
    GL11.glDisable(GL11.GL_LIGHTING);
    GL11.glDisable(GL11.GL_DEPTH_TEST);
    GL11.glEnable(GL11.GL_LIGHTING);
    GL11.glEnable(GL11.GL_DEPTH_TEST);
 }

 protected void drawTextSide() {
        int i = (this.width - CookBookGUI.achievementsPaneWidth) / 2;
        int j = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
        this.fontRenderer.drawString(pageTextFrom, i + 14, j + 8, 0xFFFFFFFF);
	
}

protected void drawBookBackground() {
	int i1 = (this.width - CookBookGUI.achievementsPaneWidth) / 2;
    int j1 = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
    
    int k1 = j1 - 32;
	
    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
	this.mc.getTextureManager().bindTexture(bookopen);
    this.drawTexturedModalRect(i1, j1, 0, 0, CookBookGUI.achievementsPaneWidth, CookBookGUI.achievementsPaneHeight);

    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    this.mc.getTextureManager().bindTexture(Cinterface);
    //GL11.glScalef(-1.5f, -1.5f, -1.5f);
    this.drawTexturedModalRect(i1 + 150, j1 + 30, 0, 0, CookBookGUI.achievementsPaneWidth, CookBookGUI.achievementsPaneHeight);
    //GL11.glScalef(1.5f, 2, 2);
    
    
    
 }
public void renderItems() {
	// Render code: this.irender.renderItemAndEffectIntoGUI(fontRenderer, this.mc.getTextureManager(), items[0], 100, 100);
	int x = ((this.width - CookBookGUI.achievementsPaneWidth) / 2) + 150 + 17;
    int y = ((this.height - CookBookGUI.achievementsPaneHeight) / 2) + 30 + 94;
    
    int xo = 38;
    int yo = 38;
    
    int iid = 0;
	for (ItemStack i : this.items){
		if (i != null){
			

			
			int xie = 0;
			int yie;
			if (iid > 0){
				int row = iid / 3;
			
			xie = (((iid - (Math.max((int)row, 0) * 3))) - 1) * xo;
			yie = row * yo;
			}
			else {
				xie = xo;
				yie = yo;
			}
			xie += x; 
			yie += y;
			
			System.out.println(iid);
			System.out.println(xie + " " + yie);
			this.irender.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.getTextureManager(), i, x, y);
			
		}
		iid += 1;
	}
	
	
	
}
}
