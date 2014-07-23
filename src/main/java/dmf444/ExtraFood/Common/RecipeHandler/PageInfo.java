package dmf444.ExtraFood.Common.RecipeHandler;

import java.util.Dictionary;

public class PageInfo {

	public int type;
	public String name;
	
	public Dictionary<String, String> args;
	
	public PageInfo(int type, String name, Dictionary<String, String> args){
		this.type = type;
		this.name = name;
		this.args = args;
	}
	
	
}
