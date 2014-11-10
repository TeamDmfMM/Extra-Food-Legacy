package dmf444.ExtraFood.Common.items.nbt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NBTFoodRegistry {
	
	public static NBTFoodRegistry food;
	
	public ArrayList<NBTFoodSpecs> foods;
	
	public NBTFoodSpecs getSpecs(String name){
		for (NBTFoodSpecs i : foods){
			if (i.name == name){
				return i;
			}
		}
		return null;
	}
	
	public NBTFoodRegistry(){
		// TODO Place food registries in here
		foods = new ArrayList<NBTFoodSpecs>();
		addFood("pizza",
				dict(
						"pepperoni",
						"extrafood:fork",
						null,
						"fish",
						"extrafood:fork",
						null,
						"olives",
						"extrafood:jelly",
						null,
						"cheese"
					),
				createInfo(
						"pepperoni",
						
						16,
						13,
						
						"fish",
						
						15,
						12,
						
						"pepperoni",
						"olives",
						
						18,
						14
					),
				"extrafood:fork",
				new float[] {10, 9},
				lst(
						ar(
								"pepperoni",
								"fish"
							)
					)	
								
			);
				
				
						
	}
	
	public void addFood(String name, Dictionary<String, ArrayList<Object>> adds, Dictionary<ArrayList<String>, ArrayList<Object>> info, String dIcon, float[] dHunger, ArrayList<ArrayList<String>> non){
		NBTFoodSpecs spec = new NBTFoodSpecs();
		spec.additives = convert(adds);
		spec.addtypes = convert2(adds);
		spec.name = name;
		spec.defualtIcon = dIcon;
		spec.defualtHunger = dHunger;
		spec.info = info;
		spec.non = non;
		System.out.println(spec.info);
		foods.add(spec);
		
	}
	
	public Dictionary<String,String> convert(Dictionary<String,ArrayList<Object>> to){
		Dictionary<String,String> d = new Hashtable<String,String>();
		for (String i : Collections.list(to.keys())){
			d.put(i, (String) to.get(i).get(0));
		}
		return d;
	}
	
	public Dictionary<String,ItemStack> convert2(Dictionary<String,ArrayList<Object>> to){
		Dictionary<String,ItemStack> d = new Hashtable<String,ItemStack>();
		for (String i : Collections.list(to.keys())){
			if (to.get(i).get(1) == null){
				d.put(i, new ItemStack(Items.redstone));
			}
			else {
				d.put(i, (ItemStack) to.get(i).get(1));
			}
		}
		return d;
	}
	public ItemStack is(Item i){
		return new ItemStack(i, 1);
	}
	
	public ArrayList<String> ar(String... strings){
		ArrayList<String> rval = new ArrayList<String>();
		for (String i : strings){
			rval.add(i);
		}
		return rval;
	}
	public ArrayList<ArrayList<String>> lst(ArrayList<String>... strings){
		ArrayList<ArrayList<String>> rval = new ArrayList<ArrayList<String>>();
		for (ArrayList<String> i : strings){
			rval.add(i);
		}
		return rval;
	}
	
	public Dictionary<String, ArrayList<Object>> dict(Object... strings){
		Dictionary<String, ArrayList<Object>> d = new Hashtable<String, ArrayList<Object>>();
		String key = "";
		String val1 = "";
		ArrayList<Object> thing = null;
		int ready = 0;
		for (Object s : strings){
			if (ready == 0){
				key = (String) s;
				ready = 1;
				
			}
			else if (ready == 1){
				val1 = (String) s;
				ready = 2;
				
			}
			else {
				thing = new ArrayList<Object>();
				thing.add(val1);
				thing.add(s);
				ready = 0;
				d.put(key, thing);
			}
		}
		System.out.println(d);
		return d;
		
	}
	
	public Dictionary<ArrayList<String>, ArrayList<Object>> createInfo(Object... info){
		Dictionary<ArrayList<String>, ArrayList<Object>> rval = new Hashtable<ArrayList<String>, ArrayList<Object>>();
		String defining = "";
		ArrayList<String> strings = new ArrayList<String>();
		boolean ggg = false;
		float[] dmfmm = new float[2];
		boolean done = false;
		for (Object o : info){
			if (o instanceof String){
				if (ggg == false){
					ggg = true;
					defining = (String) o;
					strings.add(defining);
				}
				else {
					strings.add((String) o);
				}
			}
			if (o instanceof Float || o instanceof Integer){
				float ot;
				if (o instanceof Integer){
					ot = new Float((int)o);
				}
				else {
					ot = (float)o;
				}
				if (done == false){
					dmfmm[0] = (float) ot;
					done = true;
				}
				else {
					dmfmm[1] = (float) ot;
					done = false;
					
					ggg = false;
					
					ArrayList<Object> tttt = new ArrayList<Object>();
					
					tttt.add(dmfmm[0]);
					tttt.add(dmfmm[1]);
					System.out.println("Strings: " + strings);
					rval.put((ArrayList<String>) strings.clone(), tttt);
					strings.clear();
				}
			}
		}
		System.out.println(Collections.list(rval.keys()).size());
		return (Dictionary<ArrayList<String>, ArrayList<Object>>)rval;
	}
	
	
}

