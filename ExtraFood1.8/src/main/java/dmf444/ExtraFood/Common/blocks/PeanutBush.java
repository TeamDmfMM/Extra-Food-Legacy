package dmf444.ExtraFood.Common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.EFTabs;

public class PeanutBush extends BlockCrops{


	public PeanutBush(Material material){
		super();
		float f = 0.5F;
		 this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		this.setHardness(0.0F);
        this.disableStats();
		this.setCreativeTab(EFTabs.INSTANCE);
		this.setTickRandomly(true);
	}
	
	@Override
    protected boolean canPlaceBlockOn(Block ground)
    {
        return true;
    }
    
	@Override
	protected Item getSeed()
    {
        return Item.getItemFromBlock(BlockLoader.strawberryBush);
    }
	
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ){
    	int states = (Integer) state.getValue(AGE);
    	if (player.inventory.getCurrentItem() != null){
    		ItemStack is = player.inventory.getCurrentItem();
    		if (is.getItem() == Items.dye){
    			if (is.getItemDamage() == 15){
    				return false;
    			}
    		}
    	}
    	switch (states) {
    	case -1:
    		return false;
    	
    	case 7: case 8:
    		if(!world.isRemote){
    		ItemStack item1 = new ItemStack(ItemLoader.peanut, 4);
    		Entity Ientity1 = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), item1);
			world.spawnEntityInWorld(Ientity1);
			world.setBlockState(pos, getDefaultState(), 2);
    		return true;
    		}
    	}
    	return false;
    }

	public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block neighborBlock){
		boolean drop = false; //False don't drop. True break
		
		if(!world.isSideSolid(pos.down(), EnumFacing.UP)){
			drop = true;
		}
		if(drop == true){
			this.dropBlockAsItem(world, pos, state, 0);
			world.setBlockToAir(pos);
		}
	}
	


		public boolean isOpaqueCube()
	    {
	        return false;
	    }
	    public boolean renderAsNormalBlock()
	    {
	        return false;
	    }

}
