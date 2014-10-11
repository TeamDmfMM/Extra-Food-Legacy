package dmf444.ExtraFood.Common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class Whiteout extends Block {

	public Whiteout() {
		super(Material.clay);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}

	@Override
	public void onEntityWalking(World p_149724_1_, int p_149724_2_, int p_149724_3_, int p_149724_4_, Entity entity)
	{
		if(entity instanceof EntityEnderman){
			entity.attackEntityFrom(DamageSource.drown, 2.0F);
		}
	}
}
