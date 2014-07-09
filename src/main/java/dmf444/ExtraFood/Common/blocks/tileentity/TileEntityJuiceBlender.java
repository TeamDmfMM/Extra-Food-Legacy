package dmf444.ExtraFood.Common.blocks.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import dmf444.ExtraFood.Common.RecipeHandler.JuiceRegistry;


public class TileEntityJuiceBlender extends TileEntity implements IInventory {


	public FluidTank i;

	public ItemStack[] items;
	public FluidStack juice;
	
	public int ttime;
	public int complete;
	
	
    public TileEntityJuiceBlender(){
        items = new ItemStack[3];
        i = new FluidTank(5000);

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
	    public void setInventorySlotContents(int slot, ItemStack stack) {


	            items[slot] = stack;
	            if (stack != null && stack.stackSize > getInventoryStackLimit()) {
	                    stack.stackSize = getInventoryStackLimit();
	            }               
	    }
	  public boolean ok(){
		  if (JuiceRegistry.instance.getJuiceFromItemStack(this.items[0]) != null){
			  if (this.juice != null){
				  if (this.i.getFluid().getFluid() == JuiceRegistry.instance.getJuiceFromItemStack(this.items[0])){
					  return true;
				  }
			  }
			  else {
				  return true;
			  }
		  }
		  return false;
	  }
	  public void updateEntity(){
		  if (this.ok()){
			  this.ttime += 1;
			  if (this.ttime == 20){
				  this.ttime = 0;
				  this.complete += 1;
				  if (this.complete == 20){
					  this.do_thingy();
					  this.ttime = 0;
					  this.complete = 0;
				  }
			  }
		  }
	  }


	private void do_thingy() {
		// TODO Auto-generated method stub
		if (this.i.getFluid() == null){
			FluidStack juice = new FluidStack(JuiceRegistry.instance.getJuiceFromItemStack(this.items[0]), 100);
			this.i.setFluid(juice);
		}
		else {
			this.i.getFluid().amount += 100;
		}
		if (this.items[0].stackSize == 1){
			this.items[0] = null;
		}
		else {
			this.items[0].stackSize -= 1;
		}
		
	}
	public void writeToNBT(NBTTagCompound tag){
		NBTTagList t = new NBTTagList();
		int s = 0;
		for (ItemStack i : items){
			if (i != null){
				NBTTagCompound item = new NBTTagCompound();
				i.writeToNBT(item);
				item.setInteger("Slot", s);
				t.appendTag(item);
				
			}
			s += 1;
		}
		tag.setTag("Items", t);
		if (i.getFluid() != null){
		this.i.writeToNBT(tag);
		}
		super.writeToNBT(tag);
	}
	public void readFromNBT(NBTTagCompound tag){
		int s = 0;
		NBTTagList itl = tag.getTagList("Items", 10);
		
		for (s = 0; s < itl.tagCount(); s ++){
			NBTTagCompound t = itl.getCompoundTagAt(s);
			if (t != null){
				items[t.getInteger("Slot")] = ItemStack.loadItemStackFromNBT(t);
			}
		}
	    this.i.setFluid(FluidStack.loadFluidStackFromNBT(tag));
		super.readFromNBT(tag);
			
		
	}





	/*@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource,
			boolean doDrain) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		// TODO Auto-generated method stub
		if (from != ForgeDirection.UP){
			return true;
		}
		return false;
	}


	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		// TODO Auto-generated method stub
		return 0;
	}*/
}