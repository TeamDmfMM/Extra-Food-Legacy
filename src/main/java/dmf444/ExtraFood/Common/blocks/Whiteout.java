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
		this.setLightLevel(0.875F);
	}

	@Override
	 public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity entity)
	{
		if(entity instanceof EntityEnderman){
			entity.attackEntityFrom(DamageSource.cactus, 2.0F);
		}
	}
}
