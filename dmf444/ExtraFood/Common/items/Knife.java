package dmf444.ExtraFood.Common.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import dmf444.ExtraFood.Core.EFTabs;

public class Knife extends Item {

	
	public Knife(int id)
	{
        super(id);
        //this.maxStackSize = 1;
        this.setMaxDamage(10);
        this.setCreativeTab(EFTabs.INSTANCE);
        this.setTextureName("extrafood:fork");
    }
	
	public boolean isRepariable() {
		return false;
	}

    
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack) {
    	return false;
    }
    public boolean getShareTag()
    {
        return true;
    }
    @Override
    public ItemStack getContainerItemStack(ItemStack itemStack)
    {
        ItemStack copiedStack = itemStack.copy();

        copiedStack.setItemDamage(copiedStack.getItemDamage() + 1);

        // TODO Is this still necessary?
        copiedStack.stackSize = 1;

        return copiedStack;
    }
    
    
}

