package dmf444.ExtraFood.Common.RecipeHandler;

import java.util.ArrayList;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import dmf444.ExtraFood.Common.items.ItemLoader;


public class RegistryAutoCutter {
	ArrayList<RecipeAutoCutter> recipes = new ArrayList<RecipeAutoCutter>();


	public RegistryAutoCutter(){
		//this.registerRecipe(new RecipeAutoCutter(new ItemStack(ItemLoader.cheeseWheel, 1), new ItemStack(ItemLoader.cheeseSlice, 8)));
		//this.registerRecipe(new RecipeAutoCutter(new ItemStack(Items.porkchop, 1), new ItemStack(ItemLoader.sausage, 2)));
	}
	public void registerRecipe(RecipeAutoCutter recipe){
		recipes.add(recipe);
	}
	public ItemStack getItemOutput(ItemStack in){
		for (int i = 0; i < recipes.size(); i++){
			if (recipes.get(i).in.getItem() == in.getItem()){
				return recipes.get(i).out;
			}
		}
		return null;
	}


}
