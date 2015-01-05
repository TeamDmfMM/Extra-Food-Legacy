package dmf444.ExtraFood.Common.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class CarrotJuice extends BlockFluidClassic {

    
    public CarrotJuice(Fluid fluid, Material material) {
            super(fluid, material);
            
            
    }
    
    /*@Override
    public IIcon getIcon(int side, int meta) {
    	return side <= 1 ? RenderIcon.getIcon("Fluid" + "CarrotJuice") : RenderIcon.getIcon("Fluid" + "CarrotJuice", 1);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
    	RenderIcon.addIcon("Fluid" + "CarrotJuice",register.registerIcon(ModInfo.MId.toLowerCase() + ":fluid/Fluid_" + "CarrotJuice" + "_Still"));
    	RenderIcon.addIcon("Fluid" + "CarrotJuice" + "1",register.registerIcon(ModInfo.MId.toLowerCase() + ":fluid/Fluid_" + "CarrotJuice" + "_Flow"));
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