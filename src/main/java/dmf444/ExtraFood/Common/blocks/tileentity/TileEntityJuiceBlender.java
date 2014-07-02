package dmf444.ExtraFood.Common.blocks.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.FluidEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidTank;

public class TileEntityJuiceBlender extends TileEntity implements IFluidTank, IInventory{

	
	public ItemStack[] items;
	public FluidStack juice;
	
	public TileEntityJuiceBlender(){
		this.items = new ItemStack[3];
		this.juice = new FluidStack(FluidRegistry.WATER, 1325);
		this.juice.amount = 1324;
	}
	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return "Juice Blender";
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		// TODO Auto-generated method stub
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this &&
	            player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int par1_, ItemStack par2_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FluidStack getFluid() {
		// TODO Auto-generated method stub
		System.out.println(juice != null);
		return juice;
	}

	@Override
	public int getFluidAmount() {
		// TODO Auto-generated method stub
		return juice.amount;
	}

	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return 5000;
	}

	@Override
	public FluidTankInfo getInfo() {
		// TODO Auto-generated method stub
		return new FluidTankInfo(this);
	}

	@Override
	public int fill(FluidStack resource, boolean doFill) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FluidStack drain(int maxDrain, boolean doDrain) {
		// TODO Auto-generated method stub
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
