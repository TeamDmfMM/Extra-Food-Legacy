package dmf444.ExtraFood.Common.items;

import dmf444.ExtraFood.Core.EFTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CheeseSlice extends Item {

	public CheeseSlice(int id) {
		super(id);
		this.setCreativeTab(EFTabs.INSTANCE);
		this.setTextureName("extrafood:Bad_Cheeseslice");
	}
	public ItemStack getContainerItemStack(ItemStack itemStack)
    {
        ItemStack copiedStack = itemStack.copy();

        copiedStack.setItemDamage(copiedStack.getItemDamage() + 1);

        // TODO Is this still necessary?
        copiedStack.stackSize = 1;

        return copiedStack;
    }

	
}
