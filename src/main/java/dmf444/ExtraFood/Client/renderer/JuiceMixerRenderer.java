package dmf444.ExtraFood.Client.renderer;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

import dmf444.ExtraFood.Common.blocks.tileentity.JuiceMixerTileEntity;
import dmf444.ExtraFood.Core.lib.GuiLib;

public class JuiceMixerRenderer extends TileEntitySpecialRenderer{
	 
	private final JuiceMixerModel JMmodel = new JuiceMixerModel();
	
	public JuiceMixerRenderer(){
	}
	
	  @Override
	    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick)
	    {
	        if (tileEntity instanceof JuiceMixerTileEntity)
	        {
	        	JuiceMixerTileEntity JMtileEntity = (JuiceMixerTileEntity) tileEntity;

	            GL11.glPushMatrix();

	            // Scale, Translate, Rotate
	            scaleTranslateRotate(x, y, z, ForgeDirection.SOUTH);

	            // Bind texture
	            this.bindTexture(GuiLib.TextureJM);

	            // Render
	            JMmodel.render();

	            GL11.glPopMatrix();

	        }
	    }
	  
	  private void scaleTranslateRotate(double x, double y, double z, ForgeDirection orientation)
	    {
	        if (orientation == ForgeDirection.NORTH)
	        {
	            GL11.glTranslated(x + 1, y, z);
	            GL11.glRotatef(180F, 0F, 1F, 0F);
	            GL11.glRotatef(-90F, 1F, 0F, 0F);
	        }
	        else if (orientation == ForgeDirection.EAST)
	        {
	            GL11.glTranslated(x + 1, y, z + 1);
	            GL11.glRotatef(90F, 0F, 1F, 0F);
	            GL11.glRotatef(-90F, 1F, 0F, 0F);
	        }
	        else if (orientation == ForgeDirection.SOUTH)
	        {
	            GL11.glTranslated(x, y, z + 1);
	            GL11.glRotatef(0F, 0F, 1F, 0F);
	            GL11.glRotatef(-90F, 1F, 0F, 0F);
	        }
	        else if (orientation == ForgeDirection.WEST)
	        {
	            GL11.glTranslated(x, y, z);
	            GL11.glRotatef(-90F, 0F, 1F, 0F);
	            GL11.glRotatef(-90F, 1F, 0F, 0F);
	        }
	    }


}
