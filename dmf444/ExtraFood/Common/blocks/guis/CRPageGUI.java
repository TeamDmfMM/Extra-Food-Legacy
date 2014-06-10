package dmf444.ExtraFood.Common.blocks.guis;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import dmf444.ExtraFood.Core.ExtraFood;

public class CRPageGUI extends GuiScreen {

ResourceLocation bookopen = new ResourceLocation("extrafood", "textures/gui/book_texture.png");
ResourceLocation Cinterface = new ResourceLocation("extrafood", "textures/gui/craftingbookGUI1.png");
String pageTextFrom;
private ItemStack[] items;
RenderItem irender;
GuiButton next;
int page = 1;
String pagen;
GuiButton back;


 public CRPageGUI(String pagename) {
	
	 //This will be used to call the name of the page from the .lang file
	pageTextFrom = StatCollector.translateToLocal("cookbook." + pagename);
	this.items = ExtraFood.crafterPage.getArray(pagename);
	this.irender = new RenderItem();
	pagen =pagename;
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
    super.drawScreen(par1, par2, par3);
 }

 protected void drawTextSide() {
     int i = (this.width - CookBookGUI.achievementsPaneWidth) / 2;
     int j = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
	 this.fontRenderer.drawSplitString(pageTextFrom, i + 26, j + 19, 93, 0x0000000);
	 }
 
 public void initGui(){
     int i = (this.width - CookBookGUI.achievementsPaneWidth) / 2;
     int j = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
     if (StatCollector.translateToLocal("cookbook." + pagen + "2") != "cookbook." + pagen + "2"){
	 this.buttonList.add(next = new GuiButton(0, i + 180, j + 150, 40, 20, "-->"));
	 this.buttonList.add(back = new GuiButton(1, i + 130, j + 150, 40, 20, "<--"));
     }
 }

protected void drawBookBackground() {
	//I decided to use the achivement size, because it kinda just worked!
	int i1 = (this.width - CookBookGUI.achievementsPaneWidth) / 2;
    int j1 = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
    
    int k1 = j1 - 32;
	
    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
	this.mc.getTextureManager().bindTexture(bookopen);
    this.drawTexturedModalRect(i1, j1, 0, 0, CookBookGUI.achievementsPaneWidth, CookBookGUI.achievementsPaneHeight + 50);


    this.mc.getTextureManager().bindTexture(Cinterface);
    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    GL11.glEnable(GL11.GL_BLEND);
    this.drawTexturedModalRect(i1 + 145, j1 + 26, 0, 0, CookBookGUI.achievementsPaneWidth, CookBookGUI.achievementsPaneHeight);
    GL11.glDisable(GL11.GL_BLEND);
 }

public void renderItems() {
	// Render code: this.irender.renderItemAndEffectIntoGUI(fontRenderer, this.mc.getTextureManager(), items[0], 100, 100);
	int x = ((this.width - CookBookGUI.achievementsPaneWidth) / 2) + 155 + 4;
    int y = ((this.height - CookBookGUI.achievementsPaneHeight) / 2) + 35 + 42;
    
    int tillrow = 3;
    int iid = 0;
	for (iid = 0; iid < 9; iid++){
		
		if (items[iid] != null){

			


			//System.out.println(iid);
			//System.out.println(xie + " " + yie);
			GL11.glDisable(GL11.GL_LIGHTING);
			int a;
			for(a = 0; a < 1; a++){
			this.irender.renderItemIntoGUI(this.fontRenderer, this.mc.getTextureManager(), items[iid], x - 3, y);
			
			}
			
			GL11.glEnable(GL11.GL_LIGHTING);
			
			

		}
		tillrow -= 1;
		x += 22;
		System.out.println(iid + " X assumed : " + x + " Y assumed : " + y);
		if (tillrow == 0){
			tillrow = 3;
			y += 22;
			x = ((this.width - CookBookGUI.achievementsPaneWidth) / 2) + 155 + 4;
		}
	}

}
public void actionPerformed(GuiButton button){
	if (button.id == 0){
		page++;
		if (StatCollector.translateToLocal("cookbook." + pagen + page) != "cookbook." + pagen + page){
		this.pageTextFrom = StatCollector.translateToLocal(StatCollector.translateToLocal("cookbook." + pagen + page));
		}
		else {
			page--;
		}
	}
	if (button.id == 1){
		page--;
		if (StatCollector.translateToLocal("cookbook." + pagen + page) != "cookbook." + pagen + page && page > 0){
		this.pageTextFrom = StatCollector.translateToLocal("cookbook." + pagen + page);
		}
		else if (page <= 0){
			this.pageTextFrom = StatCollector.translateToLocal("cookbook." + pagen);
			page = 0;
		}
		
	}
}

}
