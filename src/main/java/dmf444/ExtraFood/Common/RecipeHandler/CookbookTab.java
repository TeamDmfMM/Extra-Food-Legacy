package dmf444.ExtraFood.Common.RecipeHandler;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import dmf444.ExtraFood.Common.blocks.guis.ClickTab;
import dmf444.ExtraFood.Common.blocks.guis.CookBookGUI;
import dmf444.ExtraFood.Core.lib.GuiLib;

public class CookbookTab {
	public ArrayList<ClickTab> buttons;
	public String name;
	
	public ItemStack display;
	
	public RenderItem rinder;
	
	public ResourceLocation back = new ResourceLocation("extrafood:textures/gui/cookbookgui.png");
	
	public CookbookTab(String name){
		this.name = name;
		this.buttons = new ArrayList<ClickTab>();
		this.rinder = new RenderItem();
	}
	public void addButton(ClickTab tabby){
		this.buttons.add(tabby);
	}
	public void drawButton(Minecraft m, int p1, int p2, CookBookGUI gui){

		m.getTextureManager().bindTexture(GuiLib.CBborder);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_BLEND);
		gui.drawTexturedModalRect(p1, p2, 2, 204, 22, 22);
		this.rinder.renderItemIntoGUI(m.fontRenderer, m.getTextureManager(), this.display,p1 + 3, p2 + 2);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_BLEND);

}
}
