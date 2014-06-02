package dmf444.ExtraFood.Common.blocks.guis;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class CRPageGUI extends GuiScreen {

ResourceLocation bookopen = new ResourceLocation("extrafood", "textures/gui/book_texture.png");
ResourceLocation Cinterface = new ResourceLocation("extrafood", "textures/gui/craftingbookGUI.png");
String pageTextFrom;

 public CRPageGUI(String pagename, int b1, int b2, int b3, int b4, int b5, int b6, int b7, int b8, int b9) {
	
	pageTextFrom = StatCollector.translateToLocal("cookbook." + pagename);

 }
 
 public void drawScreen(int par1, int par2, float par3) {
	 
	this.drawDefaultBackground();	
	this.drawBookBackground();
	this.drawTextSide();
    GL11.glDisable(GL11.GL_LIGHTING);
    GL11.glDisable(GL11.GL_DEPTH_TEST);
    GL11.glEnable(GL11.GL_LIGHTING);
    GL11.glEnable(GL11.GL_DEPTH_TEST);
 }

 protected void drawTextSide() {
        int i = (this.width - CookBookGUI.achievementsPaneWidth) / 2;
        int j = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
        this.fontRenderer.drawString(pageTextFrom, i + 6, j + 5, 0xFFFFFFFF);
	
}

protected void drawBookBackground() {
	int i1 = (this.width - CookBookGUI.achievementsPaneWidth) / 2;
    int j1 = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
    
    int k1 = j1 - 32;
	
    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
	this.mc.getTextureManager().bindTexture(bookopen);
    this.drawTexturedModalRect(i1, j1, 0, 0, CookBookGUI.achievementsPaneWidth, CookBookGUI.achievementsPaneHeight);


    this.mc.getTextureManager().bindTexture(Cinterface);
    //GL11.glScalef(-1.5f, -1.5f, -1.5f);
    this.drawTexturedModalRect(i1, j1, 0, 0, CookBookGUI.achievementsPaneWidth, CookBookGUI.achievementsPaneHeight);
    //GL11.glScalef(1.5f, 2, 2);
 }
}
