package dmf444.ExtraFood.Common.items;

import dmf444.ExtraFood.Core.EFTabs;
import net.minecraft.item.Item;

public class CheeseSlice extends Item {

	public CheeseSlice(int id) {
		super(id);
		this.setCreativeTab(EFTabs.INSTANCE);
		this.setTextureName("extrafood:Bad_Cheeseslice");
	}

	
}
