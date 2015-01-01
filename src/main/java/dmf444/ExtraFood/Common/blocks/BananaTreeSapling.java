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
    public static final PropertyEnum TYPE = PropertyEnum.create("type", BlockPlanks.EnumType.class);
    //private static final String __OBFID = "CL_00000305";

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
        Object object = rand.nextInt(10) == 0 ? new WorldGenBigTree(true) :  new BananaWorldGenTrees(false, 6, 3, 3, true);
        int i1 = 0;
        int j1 = 0;
        boolean flag = false;

        switch (BananaTreeSapling.SwitchEnumType.WOOD_TYPE_LOOKUP[((BlockPlanks.EnumType)state.getValue(TYPE)).ordinal()])
        {
            case 0:
            default:
                break;
            case 1:
                label78:

                for (i1 = 0; i1 >= -1; --i1)
                {
                    for (j1 = 0; j1 >= -1; --j1)
                    {
                        if (this.isTypeAt(worldIn, pos.add(i1, 0, j1), BlockPlanks.EnumType.SPRUCE) && this.isTypeAt(worldIn, pos.add(i1 + 1, 0, j1), BlockPlanks.EnumType.SPRUCE) && this.isTypeAt(worldIn, pos.add(i1, 0, j1 + 1), BlockPlanks.EnumType.SPRUCE) && this.isTypeAt(worldIn, pos.add(i1 + 1, 0, j1 + 1), BlockPlanks.EnumType.SPRUCE))
                        {
                            object = new WorldGenMegaPineTree(false, rand.nextBoolean());
                            flag = true;
                            break label78;
                        }
                    }
                }

                if (!flag)
                {
                    j1 = 0;
                    i1 = 0;
                    object = new WorldGenTaiga2(true);
                }

                break;
            case 2:
                object = new BananaWorldGenTrees(false, 6, 3, 3, true);
                break;
            case 3:
                label93:

                for (i1 = 0; i1 >= -1; --i1)
                {
                    for (j1 = 0; j1 >= -1; --j1)
                    {
                        if (this.isTypeAt(worldIn, pos.add(i1, 0, j1), BlockPlanks.EnumType.JUNGLE) && this.isTypeAt(worldIn, pos.add(i1 + 1, 0, j1), BlockPlanks.EnumType.JUNGLE) && this.isTypeAt(worldIn, pos.add(i1, 0, j1 + 1), BlockPlanks.EnumType.JUNGLE) && this.isTypeAt(worldIn, pos.add(i1 + 1, 0, j1 + 1), BlockPlanks.EnumType.JUNGLE))
                        {
                            object = new WorldGenMegaJungle(true, 10, 20, 3, 3);
                            flag = true;
                            break label93;
                        }
                    }
                }

                if (!flag)
                {
                    j1 = 0;
                    i1 = 0;
                    object = new BananaWorldGenTrees(false, 6, 3, 3, true);
                }

                break;
            case 4:
                object = new BananaWorldGenTrees(true);
                break;
            case 5:
                label108:

                for (i1 = 0; i1 >= -1; --i1)
                {
                    for (j1 = 0; j1 >= -1; --j1)
                    {
                        if (this.isTypeAt(worldIn, pos.add(i1, 0, j1), BlockPlanks.EnumType.DARK_OAK) && this.isTypeAt(worldIn, pos.add(i1 + 1, 0, j1), BlockPlanks.EnumType.DARK_OAK) && this.isTypeAt(worldIn, pos.add(i1, 0, j1 + 1), BlockPlanks.EnumType.DARK_OAK) && this.isTypeAt(worldIn, pos.add(i1 + 1, 0, j1 + 1), BlockPlanks.EnumType.DARK_OAK))
                        {
                            object = new WorldGenCanopyTree(true);
                            flag = true;
                            break label108;
                        }
                    }
                }

                if (!flag)
                {
                    return;
                }
        }

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

    public boolean isTypeAt(World worldIn, BlockPos pos, BlockPlanks.EnumType type)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        return iblockstate.getBlock() == this && iblockstate.getValue(TYPE) == type;
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int p_149692_1_)
    {
        return MathHelper.clamp_int(p_149692_1_ & 7, 0, 5);
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs par2, List par3)
    {
        par3.add(new ItemStack(item, 1, 0));

    }


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
        return this.getDefaultState().withProperty(TYPE, BlockPlanks.EnumType.byMetadata(meta & 7)).withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
    }

    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i = b0 | ((BlockPlanks.EnumType)state.getValue(TYPE)).getMetadata();
        i |= ((Integer)state.getValue(STAGE)).intValue() << 3;
        return i;
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {TYPE, STAGE});
    }
    
    //1.8!
    static final class SwitchEnumType
    {
        static final int[] WOOD_TYPE_LOOKUP = new int[BlockPlanks.EnumType.values().length];
        private static final String __OBFID = "CL_00002067";

        static
        {
            try
            {
                WOOD_TYPE_LOOKUP[BlockPlanks.EnumType.SPRUCE.ordinal()] = 1;
            }
            catch (NoSuchFieldError var6)
            {
                ;
            }

            try
            {
                WOOD_TYPE_LOOKUP[BlockPlanks.EnumType.BIRCH.ordinal()] = 2;
            }
            catch (NoSuchFieldError var5)
            {
                ;
            }

            try
            {
                WOOD_TYPE_LOOKUP[BlockPlanks.EnumType.JUNGLE.ordinal()] = 3;
            }
            catch (NoSuchFieldError var4)
            {
                ;
            }

            try
            {
                WOOD_TYPE_LOOKUP[BlockPlanks.EnumType.ACACIA.ordinal()] = 4;
            }
            catch (NoSuchFieldError var3)
            {
                ;
            }

            try
            {
                WOOD_TYPE_LOOKUP[BlockPlanks.EnumType.DARK_OAK.ordinal()] = 5;
            }
            catch (NoSuchFieldError var2)
            {
                ;
            }

            try
            {
                WOOD_TYPE_LOOKUP[BlockPlanks.EnumType.OAK.ordinal()] = 6;
            }
            catch (NoSuchFieldError var1)
            {
                ;
            }
        }
    }
}