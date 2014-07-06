package dmf444.ExtraFood.Common.RecipeHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.blocks.guis.ClickTab;
import dmf444.ExtraFood.Common.items.ItemLoader;

public class CookbookButtonLoader {

	public ArrayList<ClickTab> buttons;
	public static CookbookButtonLoader bookButton = new CookbookButtonLoader();

	public CookbookButtonLoader() {
		// TODO Auto-generated constructor stub
		this.buttons = new ArrayList<ClickTab>();
		// TODO Add buttons here
		buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 1, 1, new ItemStack(BlockLoader.cheesePress), "cheesepress"));
		buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 6, 5, new ItemStack(ItemLoader.cheeseSlice), "cheeseslice", "cheesepress", "knife" ));
		buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 1, 5, new ItemStack(ItemLoader.knife), "knife"));


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
