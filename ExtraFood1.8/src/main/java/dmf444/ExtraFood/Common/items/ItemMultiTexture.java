package dmf444.ExtraFood.Common.items;

import dmf444.ExtraFood.util.ConfigHandler;
import dmf444.ExtraFood.util.EFLog;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMultiTexture extends StanFood{

	public ItemMultiTexture(int foodBar, float saturation) {
		super(foodBar, saturation);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public ModelResourceLocation getModel(ItemStack stack, EntityPlayer player, int useRemaining)
    {
		for(int i = 0; i < 15; i++){
		EFLog.fatal(ConfigHandler.FeelLikeAure);
		}
		if(ConfigHandler.FeelLikeAure)
			return new ModelResourceLocation("extrafood:PotatoLava", "inventory");
		else
			return null;
    }

}
