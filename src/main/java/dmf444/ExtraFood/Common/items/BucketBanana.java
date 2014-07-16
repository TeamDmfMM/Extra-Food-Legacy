package dmf444.ExtraFood.Common.items;

import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Core.EFTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;

public class BucketBanana extends ItemBucket {

	public BucketBanana(){
		super(BlockLoader.Bbananajuice);
		this.setCreativeTab(EFTabs.INSTANCE);
		this.setUnlocalizedName("bucketbanana");
		this.setTextureName("extrafood:bucket_banana");
	}
	
}
