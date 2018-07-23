package dmf444.ExtraFood.Common.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import dmf444.ExtraFood.Common.WorldGen.BananaWorldGenTrees;
import dmf444.ExtraFood.Core.EFTabs;

public class BananaTreeSapling extends BlockBush implements IGrowable
{
    public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);

    protected BananaTreeSapling()
    {
        float f = 0.4F;
        this.setDefaultState(this.blockState.getBaseState().withProperty(STAGE, Integer.valueOf(0)));
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setCreativeTab(EFTabs.INSTANCE);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        if (!world.isRemote)
        {
            super.updateTick(world, pos, state, rand);

            if (world.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
            {
            	this.grow(world, pos, state, rand);
            }
        }
    }


    public void grow(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (((Integer)state.getValue(STAGE)).intValue() == 0)
        {
            worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
        }
        else
        {
            this.generateTree(worldIn, pos, state, rand);
        }
    }

    public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
    	if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, pos)) return;
        Object object = new BananaWorldGenTrees(false, 6, 3, 3, true);
        int i1 = 0;
        int j1 = 0;
        boolean flag = false;
        Block b = worldIn.getBlockState(pos).getBlock();
        int meta = b.getMetaFromState(state);

        IBlockState iblockstate1 = Blocks.air.getDefaultState();

        if (flag)
        {
            worldIn.setBlockState(pos.add(i1, 0, j1), iblockstate1, 4);
            worldIn.setBlockState(pos.add(i1 + 1, 0, j1), iblockstate1, 4);
            worldIn.setBlockState(pos.add(i1, 0, j1 + 1), iblockstate1, 4);
            worldIn.setBlockState(pos.add(i1 + 1, 0, j1 + 1), iblockstate1, 4);
        }
        else
        {
            worldIn.setBlockState(pos, iblockstate1, 4);
        }

        if (!((WorldGenerator)object).generate(worldIn, rand, pos.add(i1, 0, j1)))
        {
            if (flag)
            {
                worldIn.setBlockState(pos.add(i1, 0, j1), state, 4);
                worldIn.setBlockState(pos.add(i1 + 1, 0, j1), state, 4);
                worldIn.setBlockState(pos.add(i1, 0, j1 + 1), state, 4);
                worldIn.setBlockState(pos.add(i1 + 1, 0, j1 + 1), state, 4);
            }
            else
            {
                worldIn.setBlockState(pos, state, 4);
            }
        }
    }


    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */

    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
    {
        return true;
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        return (double)worldIn.rand.nextFloat() < 0.45D;
    }

    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        this.grow(worldIn, pos, state, rand);
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
    }

    public int getMetaFromState(IBlockState state)
    {
        return 0;
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {STAGE});
    }
}