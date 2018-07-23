package dmf444.ExtraFood.Client.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

/*
 * This class was not made by me, nor will i try to fake it as mine.
 * @author WayofTime
 * Link to where it was taken from:
 * https://github.com/WayofTime/BloodMagic/blob/master/1.7.10/main/java/WayofTime/alchemicalWizardry/common/renderer/block/itemRender/TEWritingTableItemRenderer.java
 * 
 * ----This class has been modified to fit Extra Food's needs and naming----
 * If you own this class and would like me to remove it, just ask
 */


public class CheesePressItemRenderer implements IItemRenderer
{
    private CheesePressModel CPmodel;


    public CheesePressItemRenderer()
    {
        CPmodel = new CheesePressModel();
    }


    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        // TODO Auto-generated method stub
        return true;
    }


    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        // TODO Auto-generated method stub
        return true;
    }


    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        float scale = 0.08f;


        // TODO Auto-generated method stub
        switch (type)
        {
            case ENTITY:
            {
                renderCP(0f, 0f, 0f, scale);
                return;
            }


            case EQUIPPED:
            {
                renderCP(0f, 0f, 0f, scale);
                return;
            }


            case INVENTORY:
            {
                renderCP(0f, -0.25f, 0f, scale);
                return;
            }


            default:
                return;
        }
    }


    private void renderCP(float x, float y, float z, float scale)
    {
        GL11.glPushMatrix();
        // Disable Lighting Calculations
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glTranslatef(x, y, z);
        GL11.glScalef(scale, scale, scale);
        GL11.glRotatef(180f, 0f, 1f, 0f);
        ResourceLocation test = new ResourceLocation("extrafood:textures/blocks/BlockCheesePress.png");
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(test);
        CPmodel.render((Entity)null, 0, 0, 0, 0, 0, 0);
        // Re-enable Lighting Calculations
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }
}
