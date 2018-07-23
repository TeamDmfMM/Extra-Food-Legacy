package dmf444.ExtraFood.Common.items.nbt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import dmf444.ExtraFood.util.EFLog;

public class NBTFoodSpecs {
	public Dictionary<String, ItemStack> addtypes;
	public Dictionary<String, String> additives;
	public Dictionary<ArrayList<String>, ArrayList<Object>> info = new Hashtable<ArrayList<String>, ArrayList<Object>>();
	public String name;
	public String defualtIcon;
	public float[] defualtHunger;
	public ArrayList<ArrayList<String>> non;
	
	public void setup(){
		Enumeration<String> enu = additives.keys();
		ArrayList<String> dohicker = new ArrayList<String>();
		for (String i : Collections.list(enu)){
			dohicker.add(i);
		}
		ArrayList<ArrayList<String>> combinations = PowerSetGen.combinationsOf(dohicker);
		EFLog.error(combinations);
		Dictionary<String, float[]> addvals = new Hashtable<String, float[]>();
		for (String i : dohicker){
			ItemStack t = addtypes.get(i);
			if (t.getItem() == Items.redstone){
				addvals.put(i, new float[] {0,0});
				continue;
			}
			ItemFood tItem = (ItemFood) t.getItem();
			float[] hv = new float[2];
			hv[0] = tItem.getHealAmount(t) / 4;
			hv[1] = tItem.getSaturationModifier(t) / 4;
			addvals.put(i, hv);
			
		}
		boolean bad = false;
		for (ArrayList<String> comb : combinations){
			bad = false;
			EFLog.error("This is the omb-i-nation: " + comb);
			for (ArrayList<String> t : non){
				if (haveSameElements(comb, t)){
					bad = true;
					EFLog.error("I failed");
					break;
				}
			}
			if (bad == true){
				continue;
			}
			float hunger = defualtHunger[0];
			float saturation = defualtHunger[1];
			for (String add : comb){
				hunger += addvals.get(add)[0];
				saturation += addvals.get(add)[1];
			}
			ArrayList<Object> t = new ArrayList<Object>();
			t.add(hunger);
			t.add(saturation);
			
			info.put((ArrayList<String>) comb.clone(), t);
		}
		EFLog.error("info: " + info);
		
		
		
	}
	private static class Count {
	    public int count = 0;
	}	
	public boolean haveSameElements(ArrayList<String> list1, ArrayList<String> list2) {
	    // (list1, list1) is always true
	    if (list1 == list2) return true;

	    // If either list is null, or the lengths are not equal, they can't possibly match 
	    if (list1 == null || list2 == null || list1.size() != list2.size())
	        return false;

	    // (switch the two checks above if (null, null) should return false)

	    HashMap<String, Count> counts = new HashMap<String, Count>();

	    // Count the items in list1
	    for (String item : list1) {
	        if (!counts.containsKey(item)) counts.put(item, new Count());
	        counts.get(item).count += 1;
	    }

	    // Subtract the count of items in list2
	    for (String item : list2) {
	        // If the map doesn't contain the item here, then this item wasn't in list1
	        if (!counts.containsKey(item)) return false;
	        counts.get(item).count -= 1;
	    }

	    // If any count is nonzero at this point, then the two lists don't match
	    for (Map.Entry<String, Count> entry : counts.entrySet()) {
	        if (entry.getValue().count != 0) return false;
	    }

	    return true;
	}

	
}