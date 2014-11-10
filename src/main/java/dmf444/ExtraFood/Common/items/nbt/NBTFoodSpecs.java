package dmf444.ExtraFood.Common.items.nbt;

import java.util.ArrayList;
import java.util.Dictionary;

import net.minecraft.item.ItemStack;

public class NBTFoodSpecs {
	public Dictionary<String, ItemStack> addtypes;
	public Dictionary<String, String> additives;
	public Dictionary<ArrayList<String>, ArrayList<Object>> info;
	public String name;
	public String defualtIcon;
	public float[] defualtHunger;
	public ArrayList<ArrayList<String>> non;
	
}