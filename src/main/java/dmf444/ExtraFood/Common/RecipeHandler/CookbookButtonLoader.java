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
		buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 10, 1, new ItemStack(BlockLoader.cheesePress), "cheesepress"));
		buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 9, 3, new ItemStack(ItemLoader.cheeseWheel), "cheesewheel", "cheesepress"));
		buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 6, 5, new ItemStack(ItemLoader.cheeseSlice), "cheeseslice", "cheesewheel", "knife" ));
		buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 3, 4, new ItemStack(ItemLoader.knife), "knife"));
		buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 4, 7, new ItemStack(ItemLoader.sausage), "sausage", "knife"));
		
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
	/*public ArrayList<GreenLine> getLines(String pagename){
		ArrayList<GreenLine> lg = new ArrayList<GreenLine>();
		for (ArrayList<int[]> i : this.getXYCoordsOfLineForButton(pagename)){
			//get horiz
			int y = i.get(0)[1];
			int xy1 = i.get(0)[0];
			int xy2 = i.get(1)[0];
			GreenLine l = new GreenLine(xy1, xy2, 0, y);
			if (xy1 < xy2){
				y = xy2;
				xy1 = i.get(1)[1];
				xy2 = i.get(0)[1];
			}
			else {
				y = xy1;
				xy1 = i.get(0)[1];
				xy2 = i.get(1)[1];
			}


			lg.add(l);
			l = new GreenLine(xy1, xy2, 1, y);
			lg.add(l);

		}
		return lg;
	}*/
	public void drawLine(CookBookGUI g, String pagename){
		for (ArrayList<int[]> itt : this.getXYCoordsOfLineForButton(pagename)){
			// Get the horizontal line
			int y = itt.get(0)[1];


			// find the vertical line




		}
	}
	protected void drawHorizontalLine(int par1, int par2, int par3, int par4, CookBookGUI gui)
    {
        if (par2 < par1)
        {
            int i1 = par1;
            par1 = par2;
            par2 = i1;
        }


        gui.drawRect(par1, par3, par2 + 1, par3 + 1, par4);
    }


    protected void drawVerticalLine(int par1, int par2, int par3, int par4, CookBookGUI gui)
    {
        if (par3 < par2)
        {
            int i1 = par2;
            par2 = par3;
            par3 = i1;
        }


        gui.drawRect(par1, par2 + 1, par1 + 1, par3, par4);
    }







}
