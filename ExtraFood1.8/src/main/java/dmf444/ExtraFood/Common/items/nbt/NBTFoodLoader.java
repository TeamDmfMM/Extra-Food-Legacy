package dmf444.ExtraFood.Common.items.nbt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class NBTFoodLoader {
	
	public static Dictionary<String, Item> foods = new Hashtable<String, Item>();
	
	public static ArrayList<String> registered = new ArrayList<String>();
	
	public static void addItem(String foodname){
		foods.put(foodname, new NBTFood(foodname));
	}
	
	public static void register(){
		for (String food : Collections.list(foods.keys())){
			if (registered.contains(food)){
				continue;
			}
			else {
				GameRegistry.registerItem(foods.get(food), "NBT" + food);
			}
		}
	}
	
	public static Item getItem(String name){
		return foods.get(name);
	}
	
	public static void initiateItems(){
		NBTFoodRegistry.food = new NBTFoodRegistry();
		addItem("pizza");
	}
	
	
}
	
