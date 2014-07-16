package dmf444.ExtraFood.Common.items;

import net.minecraft.item.ItemBucket;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Core.EFTabs;

public class BucketStrawberry extends ItemBucket {


	public BucketStrawberry(){
		super(BlockLoader.Bstrawberryjuice);
		this.setCreativeTab(EFTabs.INSTANCE);
		this.setUnlocalizedName("strawberrybucket"); // I couldnt help it
		this.setTextureName("extrafood:bucket_straw");


	}


}
