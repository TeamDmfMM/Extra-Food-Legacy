package dmf444.ExtraFood.Common.fluids;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class GeneralFluid extends BlockFluidClassic {

	
    public GeneralFluid(Fluid fluid, Material material) {
            super(fluid, material);
           
            
            
    }
    
    
    @Override
    public boolean canDisplace(IBlockAccess world, BlockPos pos) {
            if (world.getBlockState(pos).getBlock().getMaterial().isLiquid()) return false;
            return super.canDisplace(world, pos);
    }
    
    @Override
    public boolean displaceIfPossible(World world, BlockPos pos) {
            if (world.getBlockState(pos).getBlock().getMaterial().isLiquid()) return false;
            return super.displaceIfPossible(world, pos);
    }
    
    public boolean isFullCube()
    {
        return false;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }
   /* public int getRenderType()
    {
        return 1;
    }*/

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return null;
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(LEVEL, Integer.valueOf(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(LEVEL)).intValue();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {LEVEL});
    }
    
}