package dmf444.ExtraFood.Common.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.EFTabs;
import dmf444.ExtraFood.util.EFLog;

public class StrawberryBush extends Block implements IGrowable {
	
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
		  if (meta  < 7)
	        {
	            if (meta == 6)
	            {
	                meta = 5;
	            }

	            return this.growingTextures[0];
	        }
	        else
	        {
	            return this.growingTextures[2];
	        }
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random random) {
		  if (world.getBlockLightValue(x, y + 1, z) >= 9)
	        {
	            int l = world.getBlockMetadata(x, y, z);

	            if (l < 7)
	            {
	                float f = 2; //= this.func_149864_n(world, x, y, z);
	            	

	                if (random.nextInt((int)(25.0F / f) + 1) == 0)
	                {
	                    ++l;
	                    world.setBlockMetadataWithNotify(x, y, z, l, 2);
	                }
	            }
	        }
	}
	
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float what, float these, float are) {
    	int meta = world.getBlockMetadata(x, y, z);
    	EFLog.info("Current Meta:" + meta);
    	switch (meta) {
    	case -1:
    			return false;
    	case 5: 
			this.placeDuoInInv(player);
			world.setBlockMetadataWithNotify(x, y, z, 0, 2);   		
    			return true;
    	case 7:
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
		@Override
		public boolean func_149851_a(World world, int x, int y, int z, boolean bool) {
			return world.getBlockMetadata(x, y, z) != 7;
		}
		@Override
		public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
			//Copy of BlockCrops
			return true;
		}
		@Override
		public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
			this.onBonemealEvent(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_);			
		}
		
	    public void onBonemealEvent(World world, int x, int y, int z)
	    {
	        int l = world.getBlockMetadata(x, y, z) + MathHelper.getRandomIntegerInRange(world.rand, 2, 5);

	        if (l > 7)
	        {
	            l = 7;
	        }

	        world.setBlockMetadataWithNotify(x, y, z, l++, 2);
	    }
	    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
	    {
	        return null;
	    }

}
