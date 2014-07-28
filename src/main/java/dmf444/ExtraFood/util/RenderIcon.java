package dmf444.ExtraFood.util;

import gnu.trove.map.TMap;
import gnu.trove.map.hash.THashMap;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

/**
 * Convenient String to Icon map. Allows easy reuse of Icons.
 * 
 * @author King Lemming
 * 
 */

public class RenderIcon {
	
	private static TMap<String, IIcon> icons = new THashMap<String, IIcon>();
	
	private RenderIcon() {

	}


	public static void addIcon(String iconName, String iconLocation, IIconRegister ir) {


		icons.put(iconName, ir.registerIcon(iconLocation));
	}


	public static void addIcon(String iconName, IIcon icon) {


		icons.put(iconName, icon);
	}
	public static void addIcon(String iconName, Object obj){
		icons.put(iconName, (IIcon) obj);
	}


	public static IIcon getIcon(String iconName) {


		return icons.get(iconName);
	}


	public static IIcon getIcon(String iconName, int iconOffset) {


		return icons.get(iconName + iconOffset);
	}


}

