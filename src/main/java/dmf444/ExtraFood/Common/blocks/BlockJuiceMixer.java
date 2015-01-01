package dmf444.ExtraFood.Common.blocks;


import cpw.mods.fml.client.registry.RenderingRegistry;
import dmf444.ExtraFood.Common.blocks.tileentity.JuiceMixerTileEntity;
import dmf444.ExtraFood.Core.EFTabs;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockJuiceMixer extends BlockContainer{

	protected BlockJuiceMixer() {
		super(Material.iron);
		this.setCreativeTab(EFTabs.INSTANCE);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		// TODO Auto-generated method stub
		return new JuiceMixerTileEntity();
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
private void setDefaultDirection(World world, int x, int y, int z, EntityLivingBase entity) {
	int rotation = MathHelper.floor_double((double)(entity.rotationYaw * 4F / 360F) + 0.5D) & 3;

	if(rotation == 0) {
	world.setBlockMetadataWithNotify(x, y, z, 2, 2);
	}

	if(rotation == 1) {
	world.setBlockMetadataWithNotify(x, y, z, 5, 2);
	}

	if(rotation == 2) {
	world.setBlockMetadataWithNotify(x, y, z, 3, 2);
	}

	if(rotation == 3) {
	world.setBlockMetadataWithNotify(x, y, z, 4, 2);
	}
}

	
public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack stack){
super.onBlockAdded(worldIn, pos, state);
this.setDefaultDirection(worldIn, pos.getX(), pos.getY(), pos.getZ(), entity);
}
}
