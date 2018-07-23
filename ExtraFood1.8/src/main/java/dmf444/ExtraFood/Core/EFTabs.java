package dmf444.ExtraFood.Core;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.lib.ModInfo;

public class EFTabs extends CreativeTabs {
	
	public static EFTabs INSTANCE = new EFTabs();


	public EFTabs() {
		super(ModInfo.MId);
	}


	/*@Override
	public ItemStack getIconItemStack() {
		
		return new ItemStack(ItemLoader.cheeseWheel);
	}*/


	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return Items.pumpkin_pie;//ItemLoader.cheeseWheel;
	}
}