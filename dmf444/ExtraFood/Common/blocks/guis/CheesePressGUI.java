package dmf444.ExtraFood.Common.blocks.guis;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import dmf444.ExtraFood.Common.blocks.container.CheesePressContainer;
import dmf444.ExtraFood.Common.blocks.tileentity.CheesePressTileEntity;

public class CheesePressGUI extends GuiContainer {

    public CheesePressGUI (InventoryPlayer inventoryPlayer,
                    CheesePressTileEntity tileEntity) {
            //the container is instanciated and passed to the superclass for handling
            super(new CheesePressContainer(inventoryPlayer, tileEntity));
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
            //draw text and stuff here
            //the parameters for drawString are: string, x, y, color
            fontRenderer.drawString("Cheese Press", 8, 6, 4210752);
            //draws "Inventory" or your regional equivalent
            fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2,
                    int par3) {
            //draw your Gui here, only thing you need to change is the path
    	ResourceLocation r = new ResourceLocation("extrafood", "textures/gui/cheese_press.png");
    		this.mc.renderEngine.bindTexture(r);            
    		int x = (width - xSize) / 2;
    		int y = (height - ySize) / 2;
    		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

    }
    
}
