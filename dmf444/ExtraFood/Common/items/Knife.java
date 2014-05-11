package dmf444.ExtraFood.Common.items;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
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
	
	@Override
	public ItemStack getContainerItemStack(ItemStack itemstack) {
		itemstack.setItemDamage(itemstack.getItemDamage() + 1);
		return itemstack;
	}

    public int getMetadata(int par1)
    {
        return 1;
    }
    
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack) {
    	return true;
    }
    public boolean getShareTag()
    {
        return true;
    }
    
}

