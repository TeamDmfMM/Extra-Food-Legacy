package dmf444.ExtraFood.Common.RecipeHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import net.minecraft.item.ItemStack;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.blocks.guis.ClickTab;
import dmf444.ExtraFood.Common.items.ItemLoader;

public class CookbookButtonLoader {

	public ArrayList<ClickTab> buttons;
	public static CookbookButtonLoader bookButton = new CookbookButtonLoader();
	public Dictionary<String, Boolean> truth;
	public Dictionary<String, Integer> multiNum;

	public CookbookButtonLoader() {
		// TODO Auto-generated constructor stub
		this.buttons = new ArrayList<ClickTab>();
		this.truth = new Hashtable<String, Boolean>();
		this.multiNum = new Hashtable<String, Integer>();
		// TODO Add buttons here
		buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 1, 1, new ItemStack(BlockLoader.cheesePress), "cheesepress"));
		buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 6, 5, new ItemStack(ItemLoader.cheeseSlice), "cheeseslice", "cheesepress", "knife" ));
		buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 1, 5, new ItemStack(ItemLoader.knife), "knife"));
		
		//TODO on add book page, add multi buttons
		  //this.truth.put("knife", true);


	}
	
	/*
	 * This is what will catch for multiple pages, default is 1 (Page 0 and Page 1)
	 */	
	public int NumOfPages(String page){
		if (this.multiNum.get(page) != null){
			return this.multiNum.get(page);
		} else {
			return 1;
		}
	}
	
	/*
	 * Catches calls for more than one page, default is false, changable above
	 */	
	public Boolean DoesHaveMultiPage(String page){
		if (this.truth.get(page) != null){
		return this.truth.get(page);
		} else {
			return false;
		}		
	}
	
	public ArrayList<ArrayList<int[]>> getXYCoordsOfLineForButton(String name){
		try {
		ArrayList<ArrayList<int[]>> xys = new ArrayList<ArrayList<int[]>>();
		ClickTab ctr = this.find(name);
		List<String> pre = Arrays.asList(ctr.pre);
		ArrayList<ClickTab> prectr = new ArrayList<ClickTab>();
		for (String p : pre){
			prectr.add(this.find(p));
		}
		for (ClickTab ct : prectr){
			ArrayList<int[]> arraytemp = new ArrayList<int[]>();
			arraytemp.add(new int[]{ctr.x, ctr.y});
			arraytemp.add(new int[]{ct.x, ct.y});
			xys.add(arraytemp);
		}
		return xys;}
		catch (Exception e){
			return null;
		}


	}
	private ClickTab find(String name){
		for (ClickTab tab : this.buttons){
			if (tab.pagename == name){
				return tab;
			}
		}
		return null;
	}







}
