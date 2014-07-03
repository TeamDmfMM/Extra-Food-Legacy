package dmf444.ExtraFood.Common.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.EFTabs;

public class StrawberryBush extends Block {
	
	private static IIcon[] growingTextures;

	
	public StrawberryBush(Material material){
		super(material);
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		this.setHardness(0.0F);
        this.disableStats();
		this.setCreativeTab(EFTabs.INSTANCE);
		this.setTickRandomly(true);
	}
	@Override
	  public IIcon getIcon(int side, int meta){
		  if (meta == 0)
	        {
	            if (meta == 1)
	            {
	                meta = 2;
	            }

	            return this.growingTextures[meta >> 1];
	        }
	        else
	        {
	            return this.growingTextures[2];
	        }
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random random) {
	    if (world.getBlockMetadata(x, y, z) == 1) {
	        return;
	    }

	    if (world.getBlockLightValue(x, y + 1, z) < 9) {
	        return;
	    }


	    world.setBlockMetadataWithNotify(x, y, z, 1, 2);
	}
	
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
    	switch (metadata) {
    	case 0:
    			return false;
    	case 1: 
			this.placeDuoInInv(player);
			world.setBlockMetadataWithNotify(x, y, z, 0, 2);   		
    			return true;
    	case 2:
    			this.placeInInv(player);
    			world.setBlockMetadataWithNotify(x, y, z, 0, 2);
    			return true;
    	}
		return false;
    }

	private void placeDuoInInv(EntityPlayer player) {
		player.inventory.setInventorySlotContents(player.inventory.getFirstEmptyStack(), new ItemStack(ItemLoader.strawberry, 2));
		
	}
	private void placeInInv(EntityPlayer player) {
			
		player.inventory.setInventorySlotContents(player.inventory.getFirstEmptyStack(), new ItemStack(ItemLoader.strawberry, 4));
		
	}
	 @SideOnly(Side.CLIENT)
	    public void registerBlockIcons(IIconRegister iiconr)
	    {
	        this.growingTextures = new IIcon[3];

	            this.growingTextures[0] = iiconr.registerIcon("extrafood:berries_stage_0");
	            this.growingTextures[1] = iiconr.registerIcon("extrafood:strawberry_stage_1");
	            this.growingTextures[2] = iiconr.registerIcon("extrafood:strawberry_stage_2");

	    }
	    public int getRenderType()
	    {
	        return 6;
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
