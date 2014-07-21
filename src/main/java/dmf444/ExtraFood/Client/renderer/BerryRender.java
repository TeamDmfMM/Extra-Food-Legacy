package dmf444.ExtraFood.Client.renderer;

import dmf444.ExtraFood.Common.blocks.BlockLoader;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class BerryRender extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
		// TODO Auto-generated method stub
		// TESSELATOR!!!!!!!! PREPARE TO BE CONFUSED DAVID!!!!!!!!!
		Tessellator tess = Tessellator.instance;
		tess.startDrawingQuads();
		tess.setTranslation(x, y, z);
		float minu = BlockLoader.whiteout.getIcon(0, 0).getMinU();
		float minv = BlockLoader.whiteout.getIcon(0, 0).getMinV();
		float maxu = BlockLoader.whiteout.getIcon(0, 0).getMaxU();
		float maxv = BlockLoader.whiteout.getIcon(0, 0).getMaxV();
		// For the time being, i am going to use the whiteteout. WILL BE CAHNGED
		
		// Start tesselator!
		tess.addVertexWithUV(1, 0, 0, maxu, maxv);
		tess.addVertexWithUV(1, 0.25, 0, maxu, minv);
		tess.addVertexWithUV(0, 0.25, 0, minu, minv);
		tess.addVertexWithUV(0, 0, 0, minu, maxv);
		// tess face 2
		tess.draw();
		
		
		
		
	}

}
