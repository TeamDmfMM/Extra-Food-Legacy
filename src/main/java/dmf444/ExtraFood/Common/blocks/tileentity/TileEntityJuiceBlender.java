package dmf444.ExtraFood.Common.blocks.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.FluidEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidTank;


public class TileEntityJuiceBlender extends TileEntity implements IFluidTank, IInventory{




	public ItemStack[] items;
	public FluidStack juice;
	
    public TileEntityJuiceBlender(){
        items = new ItemStack[3];
}


	@Override
	public int getSizeInventory() {
		return 3;
	}


	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {

		return items[p_70301_1_];
	}


	@Override
    public ItemStack decrStackSize(int slot, int amt) {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
                if (stack.stackSize <= amt) {
                        setInventorySlotContents(slot, null);
                } else {
                        stack = stack.splitStack(amt);
                        if (stack.stackSize == 0) {
                                setInventorySlotContents(slot, null);
                        }
                }
        }
        return stack;
}




	 @Override
	    public ItemStack getStackInSlotOnClosing(int slot) {
	            ItemStack stack = getStackInSlot(slot);
	            if (stack != null) {
	                    setInventorySlotContents(slot, null);
	            }
	            return stack;
	    }


	@Override
	public String getInventoryName() {

		return "Juice Blender";
	}


	@Override
	public boolean hasCustomInventoryName() {

		return false;
	}


	@Override
	public int getInventoryStackLimit() {

		return 64;
	}


	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this &&
	            player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}


	@Override
	public void openInventory() {}


	@Override
	public void closeInventory() {}


	@Override
	public boolean isItemValidForSlot(int par1_, ItemStack par2_) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public FluidStack getFluid() {
		return juice;
	}


	@Override
	public int getFluidAmount() {
		return juice.amount;
	}


	@Override
	public int getCapacity() {
		return 5000;
	}


	@Override
	public FluidTankInfo getInfo() {
		return new FluidTankInfo(this);
	}


	@Override
	public int fill(FluidStack resource, boolean doFill) {
		return 0;
	}


	@Override
	public FluidStack drain(int maxDrain, boolean doDrain) {
		if (juice == null)
        {
            return null;
        }


        int drained = maxDrain;
        if (juice.amount < drained)
        {
            drained = juice.amount;
        }


        FluidStack stack = new FluidStack(juice, drained);
        if (doDrain)
        {
            juice.amount -= drained;
            if (juice.amount <= 0)
            {
                juice = null;
            }


            if (this != null)
            {
                FluidEvent.fireEvent(new FluidEvent.FluidDrainingEvent(juice, this.getWorldObj(), xCoord, yCoord, zCoord, this, drained));
            }
        }
        return stack;
	}


	  @Override
	    public void setInventorySlotContents(int slot, ItemStack stack) {


	            items[slot] = stack;
	            if (stack != null && stack.stackSize > getInventoryStackLimit()) {
	                    stack.stackSize = getInventoryStackLimit();
	            }               
	    }
}