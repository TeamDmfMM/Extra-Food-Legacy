package dmf444.ExtraFood.Common.RecipeHandler;


import java.util.Dictionary;
import java.util.Hashtable;


import dmf444.ExtraFood.Common.fluids.FluidLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;


public class JuiceRegistry {




	public Dictionary<Item,Fluid > juices;
	public Dictionary<Fluid, String> juicenames;


	public static JuiceRegistry instance = null;


	public JuiceRegistry(){
		//TODO Registry jucies here
		juices = new Hashtable<Item, Fluid>();
		juicenames = new Hashtable<Fluid, String>();
		//System.out.println(FluidLoader.Fstrawberryjuice == null);
		registerJuice(FluidLoader.Fstrawberryjuice, ItemLoader.strawberry, "extrafood:textures/blocks/StrawberryJuice_flow.png");
		registerJuice(FluidLoader.Fbananajuice, ItemLoader.banana, "extrafood:textures/blocks/BananaJuice_flow.png");




	}
	public void registerJuice(Fluid fluid, Item item, String texture){
		juices.put(item, fluid);
		juicenames.put(fluid, texture);
	}
	public Fluid getJuiceFromItemStack(ItemStack is){
		try {
		return this.juices.get(is.getItem());}
		catch (Exception e) {
			return null;
		}
	}
	public String getTextureFromJuice(Fluid juice){
		try {
			return this.juicenames.get(juice);}
			catch (Exception e) {
				return null;
			}
	}




}
