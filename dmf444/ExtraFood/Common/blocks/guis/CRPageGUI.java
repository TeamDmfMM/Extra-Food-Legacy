package dmf444.ExtraFood.Common.blocks.guis;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class CRPageGUI extends GuiScreen {

ResourceLocation bookopen = new ResourceLocation("extrafood", "textures/gui/book_texture.png");
ResourceLocation Cinterface = new ResourceLocation("extrafood", "textures/gui/craftingbookGUI.png");
String pageTextFrom;
private ItemStack[] items;
RenderItem irender;



 public CRPageGUI(String pagename, ItemStack[] items) {
	
	 //This will be used to call the name of the page from the .lang file
	pageTextFrom = StatCollector.translateToLocal("cookbook." + pagename);
	this.items = items;
	this.irender = new RenderItem();
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
	 //parts = string.split("-")
	 String[] parts = pageTextFrom.split("%s");
	 String part1 = parts[0];
	 String part2 = parts[1];
	 String part3 = parts[2];
	 String part4 = parts[3];
        int i = (this.width - CookBookGUI.achievementsPaneWidth) / 2;
        int j = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
        int C = 0x00000000;
		 int q;
		 int pg = 0;
		 int loc = j + 19;
		 
	 if(pageTextFrom.contains("%s")){

		 for(q = 0; q < 4; q++) {
		 this.fontRenderer.drawString(parts[q], i + 26, loc, C);
		 pg += 1;
		 loc += 9;
		/* this.fontRenderer.drawString(part2, i + 25, j + 27, C);
		 this.fontRenderer.drawString(part3, i + 25, j + 35, C); 
		 this.fontRenderer.drawString(part4, i + 25, j + 43, C); 
		 */
		 }
	 }else{ 
        this.fontRenderer.drawString(pageTextFrom, i + 25, j + 19, C);
	 }
}

protected void drawBookBackground() {
	//I decided to use the achivement size, because it kinda just worked!
	int i1 = (this.width - CookBookGUI.achievementsPaneWidth) / 2;
    int j1 = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
    
    int k1 = j1 - 32;
	
    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
	this.mc.getTextureManager().bindTexture(bookopen);
    this.drawTexturedModalRect(i1, j1, 0, 0, CookBookGUI.achievementsPaneWidth, CookBookGUI.achievementsPaneHeight);


    this.mc.getTextureManager().bindTexture(Cinterface);
    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    GL11.glEnable(GL11.GL_BLEND);
    this.drawTexturedModalRect(i1 + 155, j1 + 35, 0, 0, CookBookGUI.achievementsPaneWidth, CookBookGUI.achievementsPaneHeight);
    GL11.glDisable(GL11.GL_BLEND);
 }

public void renderItems() {
	// Render code: this.irender.renderItemAndEffectIntoGUI(fontRenderer, this.mc.getTextureManager(), items[0], 100, 100);
	int x = ((this.width - CookBookGUI.achievementsPaneWidth) / 2) + 155 + 4;
    int y = ((this.height - CookBookGUI.achievementsPaneHeight) / 2) + 35 + 42;
    
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


			//System.out.println(iid);
			//System.out.println(xie + " " + yie);
			GL11.glDisable(GL11.GL_LIGHTING);
			int a;
			for(a = 0; a < 1; a++){
			this.irender.renderItemIntoGUI(this.fontRenderer, this.mc.getTextureManager(), i, x, y);
			x += 19;
			}
			
			GL11.glEnable(GL11.GL_LIGHTING);


		}
		iid += 1;
	}

}

}
