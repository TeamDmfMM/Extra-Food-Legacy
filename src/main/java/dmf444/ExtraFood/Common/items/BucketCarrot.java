package dmf444.ExtraFood.Common.items;


import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Core.EFTabs;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBucket;


public class BucketCarrot extends ItemBucket{


	public BucketCarrot() {
		super(BlockLoader.Bcarrotjuice);
		this.setCreativeTab(EFTabs.INSTANCE);
		this.setTextureName("extrafood:bucket_carrot");


	}


}
