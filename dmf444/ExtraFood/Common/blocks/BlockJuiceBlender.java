package dmf444.ExtraFood.Common.blocks;

import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.Core.EFTabs;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockJuiceBlender extends BlockContainer{

	protected BlockJuiceBlender(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(EFTabs.INSTANCE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityJuiceBlender();
	}
	public int getRenderType() {
        return -1;
}

//It's not an opaque cube, so you need this.
@Override
public boolean isOpaqueCube() {
        return false;
}

//It's not a normal block, so you need this too.
public boolean renderAsNormalBlock() {
        return false;
}
	public void registerIcons(IconRegister icon) {
        this.blockIcon = icon.registerIcon("extrafood:juiceblenderitem");
}

}
