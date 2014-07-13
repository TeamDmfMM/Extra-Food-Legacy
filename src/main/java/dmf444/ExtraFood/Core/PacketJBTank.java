package dmf444.ExtraFood.Core;

import net.minecraftforge.fluids.FluidStack;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.nbt.NBTTagCompound;

 public class PacketJBTank implements IMessage{
	
	private int liquidamount;
	private NBTTagCompound tag;
	private int FluidID;
	
	public PacketJBTank(){ 
		//DO NOTHING.....
	}
	
	public PacketJBTank(int liquidA, NBTTagCompound nbt, int fluidid){
		this.liquidamount = liquidA;
		this.tag = nbt;
		this.FluidID = fluidid;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		liquidamount = ByteBufUtils.readVarInt(buf, 128);
		tag = ByteBufUtils.readTag(buf);
		FluidID = ByteBufUtils.readVarInt(buf, 127);
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
    ByteBufUtils.writeVarInt(buf, liquidamount, 128);
    ByteBufUtils.writeTag(buf, tag);
    ByteBufUtils.writeVarInt(buf, FluidID, 127);
		
	}
	
	public static class Handler implements IMessageHandler<PacketJBTank, IMessage> {

		@Override
		public IMessage onMessage(PacketJBTank message, MessageContext ctx) {
		
			return null;
		}
	}
}


