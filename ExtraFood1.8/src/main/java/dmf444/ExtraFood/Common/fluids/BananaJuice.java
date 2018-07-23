package dmf444.ExtraFood.Common.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BananaJuice extends BlockFluidClassic {

    
    public BananaJuice(Fluid fluid, Material material) {
            super(fluid, material);
            
    }
    
   /* @Override
    public IIcon getIcon(int side, int meta) {
    return side <= 1 ? RenderIcon.getIcon("Fluid" + "BananaJuice") : RenderIcon.getIcon("Fluid" + "BananaJuice", 1);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {

    	RenderIcon.addIcon("Fluid" + "BananaJuice",register.registerIcon(ModInfo.MId.toLowerCase() + ":fluid/Fluid_" + "BananaJuice" + "_Still"));
    	RenderIcon.addIcon("Fluid" + "BananaJuice" + "1",register.registerIcon(ModInfo.MId.toLowerCase() + ":fluid/Fluid_" + "BananaJuice" + "_Flow"));

    }*/
    
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
    
}