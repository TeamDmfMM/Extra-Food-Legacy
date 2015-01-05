package dmf444.ExtraFood.Core.init;

import dmf444.ExtraFood.Core.lib.ItemLib;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemTextureRegistry {
	
	
	public static void registerItemTextures(){
		register(ItemLib.iCW, 0);
		register(ItemLib.iBac, 0);
		register(ItemLib.iBan, 0);
		register(ItemLib.iBB, 0);
		register(ItemLib.iBC, 0);
		register(ItemLib.iBPW, 0);
		register(ItemLib.iBRS, 0);
		register(ItemLib.iBS, 0);
		register(ItemLib.iBSW, 0);
		register(ItemLib.iButter,0);
		register(ItemLib.iButterMilk, 0);
		register(ItemLib.iCB, 0);
		register(ItemLib.iCBac, 0);
		register(ItemLib.iCH, 0);
		register(ItemLib.iCho, 0);
		register(ItemLib.iChoIceCream, 0);
		register(ItemLib.iChoSandwich, 0);
		register(ItemLib.iChoSpread, 0);
		register(ItemLib.iCLS, 0);
		register(ItemLib.iCNF, 0);
		register(ItemLib.iCP, 0);
		register(ItemLib.iCS, 0);
		register(ItemLib.iCW, 0);
		register(ItemLib.iEgg,0);
		register(ItemLib.iFP, 0);
		register(ItemLib.iFrenchToast, 0);
		register(ItemLib.iGrater,0);
		register(ItemLib.iJ, 0);
		register(ItemLib.iK, 0);
		register(ItemLib.iLet, 0);
		register(ItemLib.iMB, 0);
		register(ItemLib.iMBP, 0);
		register(ItemLib.iNeoIceCream, 0);
		register(ItemLib.iP, 0);
		register(ItemLib.iPasta, 0);
		register(ItemLib.iPB, 0);
		register(ItemLib.iPC, 0);
		register(ItemLib.iPKeb, 0);
		register(ItemLib.iPopcicle, 0);
		register(ItemLib.iRH, 0);
		register(ItemLib.iS, 0);
		register(ItemLib.iSandBLT, 0);
		register(ItemLib.iSandCB, 0);
		register(ItemLib.iSandCheeseBurger, 0);
		register(ItemLib.iSandGC, 0);
		register(ItemLib.iSandH, 0);
		register(ItemLib.iSandPBJ, 0);
		register(ItemLib.iSandPBN, 0);
		register(ItemLib.iSandPeanutB, 0);
		register(ItemLib.iSandS, 0);
		register(ItemLib.iSandSupremeH, 0);
		register(ItemLib.iSKeb, 0);
		register(ItemLib.iST, 0);
		register(ItemLib.iStrawIceCream, 0);
		register(ItemLib.iStrawYogurt, 0);
		register(ItemLib.iSushi, 0);
		register(ItemLib.iToastS, 0);
		register(ItemLib.iTom, 0);
		register(ItemLib.iTS, 0);
		register(ItemLib.iULS, 0);
		register(ItemLib.iV, 0);
		register(ItemLib.iVanIceCream, 0);
		register(ItemLib.iVKeb, 0);
		register(ItemLib.iYogurt, 0);
		register(ItemLib.iFF(), 0);
	}
	
	
	
	
	
	
	
	private static void register(String blockName, int meta, String resource){
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		Item itemB = GameRegistry.findItem("extrafood", blockName);
		renderItem.getItemModelMesher().register(itemB, meta, new ModelResourceLocation(resource, "inventory"));
	}
	private static void register(String blockName, int meta){
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		Item itemB = GameRegistry.findItem("extrafood", blockName);
		renderItem.getItemModelMesher().register(itemB, meta, new ModelResourceLocation("extrafood:"+ blockName, "inventory"));
	}
}
