package dmf444.ExtraFood.Common.RecipeHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import net.minecraft.item.ItemStack;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.blocks.guis.ClickTab;
import dmf444.ExtraFood.Common.blocks.guis.CookBookGUI;
import dmf444.ExtraFood.Common.blocks.guis.GreenLine;
import dmf444.ExtraFood.Common.items.ItemLoader;

public class CookbookButtonLoader {

	public ArrayList<CookbookTab> buttons;
	public static CookbookButtonLoader bookButton = new CookbookButtonLoader();
	public Dictionary<String, Boolean> truth;
	public Dictionary<String, Integer> multiNum;

	public CookbookButtonLoader() {
		// TODO Auto-generated constructor stub
		this.buttons = new ArrayList<CookbookTab>();
		this.truth = new Hashtable<String, Boolean>();
		this.multiNum = new Hashtable<String, Integer>();
		CookbookTab t = new CookbookTab("generic");
		t.display = new ItemStack(BlockLoader.cheesePress);
		
		// TODO Add buttons here
		t.buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 8, 1, new ItemStack(BlockLoader.cheesePress), "cheesepress"));
		t.buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 9, 3, new ItemStack(ItemLoader.cheeseWheel), "cheesewheel", "cheesepress"));
		t.buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 6, 5, new ItemStack(ItemLoader.cheeseSlice), "cheeseslice", "cheesewheel", "knife" ));
		t.buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 3, 4, new ItemStack(ItemLoader.knife), "knife"));
		t.buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 4, 7, new ItemStack(ItemLoader.sausage), "sausage", "knife"));
		this.buttons.add(t);
		//TODO on add book page, add multi buttons
		  //this.truth.put("knife", true);
		t = new CookbookTab("autocutter");
		t.buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 3, 3, new ItemStack(BlockLoader.autoCutter), "autocutter"));
		t.display = new ItemStack(BlockLoader.autoCutter);
		this.buttons.add(t);
		


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
	
	public ArrayList<ArrayList<int[]>> getXYCoordsOfLineForButton(String name, String pagename){
		try {
		ArrayList<ArrayList<int[]>> xys = new ArrayList<ArrayList<int[]>>();
		ClickTab ctr = this.find(name, pagename);
		List<String> pre = Arrays.asList(ctr.pre);
		ArrayList<ClickTab> prectr = new ArrayList<ClickTab>();
		for (String p : pre){
			prectr.add(this.find(p, pagename));
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
	private ClickTab find(String name, String pagename){
		for (CookbookTab tabb : this.buttons){
		if (tabb.name == pagename){
		for (ClickTab tab : tabb.buttons){
			if (tab.pagename == name){
				return tab;
			}
		}}}
		return null;
	}
	
	
	protected void drawHorizontalLine(int p_73730_1_, int p_73730_2_, int p_73730_3_, int p_73730_4_, CookBookGUI g)
    {
        if (p_73730_2_ < p_73730_1_)
        {
            int i1 = p_73730_1_;
            p_73730_1_ = p_73730_2_;
            p_73730_2_ = i1;
        }

        g.drawRect(p_73730_1_, p_73730_3_, p_73730_2_ + 1, p_73730_3_ + 1, p_73730_4_);
    }

    protected void drawVerticalLine(int p_73728_1_, int p_73728_2_, int p_73728_3_, int p_73728_4_, CookBookGUI g)
    {
        if (p_73728_3_ < p_73728_2_)
        {
            int i1 = p_73728_2_;
            p_73728_2_ = p_73728_3_;
            p_73728_3_ = i1;
        }

        g.drawRect(p_73728_1_, p_73728_2_ + 1, p_73728_1_ + 1, p_73728_3_, p_73728_4_);
    }
    public ArrayList<ClickTab> getButtons(String tab){
    	for (CookbookTab tabb : this.buttons){
    		if (tabb.name == tab){
    			return tabb.buttons;
    		}
    	}

    	return null;






}}
